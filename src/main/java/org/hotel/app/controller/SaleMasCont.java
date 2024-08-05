package org.hotel.app.controller;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.BillMas;
import org.hotel.app.dto.ItemMaster;
import org.hotel.app.dto.KotMasDTO;
import org.hotel.app.dto.SaleMasDTO;
import org.hotel.app.repository.KotMasRepo;
import org.hotel.app.repository.SaleMasRepo;
import org.hotel.app.repository.TableMasRepo;
import org.hotel.app.service.SaleMasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(Api.ALLOWED_ORIGINS)
public class SaleMasCont 
{
//	Restaurant Bill
	@Autowired
	private SaleMasRepo repo;
	
	
	
	@Autowired
	private SaleMasService saleserv;
	
	@Autowired
	private KotMasRepo kotrepo;
	
	@Autowired
	private TableMasRepo tablerepo;

	
	@GetMapping("{shopid}/Restbillview/{status}/{frdate}/{todate}")
	List<Map<String, Object>> billview(@PathVariable long shopid,@PathVariable int status, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate frdate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate todate) {
	    Date fromDate = Date.valueOf(frdate);
	    Date toDate = Date.valueOf(todate);
	    List<Object[]> result = repo.billview(shopid, status, fromDate, toDate);
		List<Map<String, Object>> response = new ArrayList();
		for (Object[] objArray : result) {
			Map<String, Object> map = new HashMap();
			SaleMasDTO data = (SaleMasDTO) objArray[0];
			String tablename = (String) objArray[1];
			String bltype = (String) objArray[2];
			map.put("SaleMasDTO", data);
			map.put("tablename", tablename);
			map.put("bltype", bltype);
			
			response.add(map);
		}
		return response;
	}
	
	@GetMapping("RestbillviewOne/{shopid}/{shopvno}")
	List<Map<String, Object>> RestbillviewOne(@PathVariable long shopid,@PathVariable long shopvno) {
	    List<Object[]> result = repo.RestbillviewOne(shopid, shopvno);
		List<Map<String, Object>> response = new ArrayList();
		for (Object[] objArray : result) {
			Map<String, Object> map = new HashMap();
			SaleMasDTO data = (SaleMasDTO) objArray[0];
			String tablename = (String) objArray[1];
			String bltype = (String) objArray[2];
			ItemMaster itdata = (ItemMaster) objArray[3];
			map.put("SaleMasDTO", data);
			map.put("tablename", tablename);
			map.put("bltype", bltype);
			map.put("ItemMaster", itdata);
			response.add(map);
		}
		return response;
	}
	
	@GetMapping("RestbillviewPayment/{shopid}")
	List<Map<String, Object>> RestbillviewPayment(@PathVariable long shopid) {
	    List<Object[]> result = repo.RestbillviewPayment(shopid);
		List<Map<String, Object>> response = new ArrayList();
		for (Object[] objArray : result) {
			Map<String, Object> map = new HashMap();
			SaleMasDTO data = (SaleMasDTO) objArray[0];
			String tablename = (String) objArray[1];
			String bltype = (String) objArray[2];
			map.put("SaleMasDTO", data);
			map.put("tablename", tablename);
			map.put("bltype", bltype);
			response.add(map);
		}
		return response;
	}

	@GetMapping("RestbillTopSaleItem/{shopid}")
	List<Map<String, Object>> RestbillTopSaleItem(@PathVariable long shopid) {
	    List<Object[]> result = repo.calculateTotalQuantity(shopid);
	    
	    // Prepare the response
	    List<Map<String, Object>> response = new ArrayList<>();
	    for (Object[] objArray : result) {
	        Map<String, Object> map = new HashMap<>();
	        Double totalQuantity = (Double) objArray[0]; // Get the sum of quantities
	        String itemInfo = objArray[1].toString(); // Assuming the third element is a string, adjust accordingly if not
	        map.put("TotalQuantity", totalQuantity);
	        map.put("itemInfo", itemInfo);
	        response.add(map);
	    }
	    return response;
	}



	
	@GetMapping("{shopid}/Restbillview/{status}/{frdate}/{todate}/{keyword}")
	List<SaleMasDTO> billviewsearch(@PathVariable long shopid,@PathVariable int status, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate frdate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate todate,@PathVariable String keyword) {
	    Date fromDate = Date.valueOf(frdate);
	    Date toDate = Date.valueOf(todate);
	    return repo.billviewsearch(shopid, status, fromDate, toDate, keyword);
	
	}
	
	
	@PostMapping("/KotBill")
	public double add(@RequestBody List<SaleMasDTO> mas) {
		Long maxShopResNo = repo.findMaxShopVnoByShopId(mas.get(0).getShopid());
		long shopResNo = (maxShopResNo != null) ? maxShopResNo + 1 : 1;
		for (SaleMasDTO details : mas) {
			details.setShopvno(shopResNo);
		}
		saleserv.saveBill(mas);
		kotrepo.UpdateblnoDinein(mas.get(0).getShopid(), mas.get(0).getShopvno(), mas.get(0).getTablecode());
		kotrepo.UpdateStatusDinein(mas.get(0).getShopid(), mas.get(0).getShopvno(), mas.get(0).getTablecode());
		tablerepo.updatetable(mas.get(0).getShopid(), mas.get(0).getTablecode(), 0);
		return mas.get(0).getShopvno(); 
	}
	
	@PostMapping("/KotBillDT/{shopvno}")
	public double KotBillDT(@RequestBody List<SaleMasDTO> mas, @PathVariable double shopvno) {
		Long maxShopResNo = repo.findMaxShopVnoByShopId(mas.get(0).getShopid());
		long shopResNo = (maxShopResNo != null) ? maxShopResNo + 1 : 1;
		for (SaleMasDTO details : mas) {
			details.setShopvno(shopResNo);
		}
		saleserv.saveBill(mas);
		kotrepo.UpdateblnoDTBillNo(mas.get(0).getShopid(), shopvno, mas.get(0).getShopvno());
		kotrepo.UpdateblnoDTStatus(mas.get(0).getShopid(), shopvno);
		return mas.get(0).getShopvno(); 
	}

	@PostMapping("Restbillview/{shopid}/{shopvno}/{status}")
	String updateRestbillstatus(@PathVariable long shopid,@PathVariable long shopvno,@PathVariable int status) {
		repo.updateSaleStatus(shopid, shopvno, status);
		return "Update Sucess";
	}

	@PostMapping("RestbillPayment/{shopid}/{shopvno}/{paycode}")
	String updateBillPaymentStatus(@PathVariable long shopid,@PathVariable long shopvno,@PathVariable int paycode) {
		repo.updateBillPaymentStatus(shopid, shopvno, paycode);
		return "Payment Update Sucess";
	}


	@DeleteMapping("Restbillviewdelete/{shopid}/{shopvno}")
	String deleteSaleRestBill(@PathVariable long shopid,@PathVariable long shopvno) {
		repo.deleteSaleRestBill(shopid, shopvno);
		return "Update Sucess";
	}

}
