package org.hotel.app.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.KotMasDTO;
import org.hotel.app.repository.KotMasRepo;
import org.hotel.app.repository.TableMasRepo;
import org.hotel.app.service.KotMasService;
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
public class KotMasCont {
	@Autowired
	private KotMasRepo repo;

	@Autowired
	private KotMasService kotserv;

	@Autowired
	private TableMasRepo tablerepo;
	
	@PostMapping("/DineinKOT")
	public double add(@RequestBody List<KotMasDTO> kotmas) {
		Long maxShopResNo = repo.findMaxShopVnoByShopId(kotmas.get(0).getShopid());
		long shopResNo = (maxShopResNo != null) ? maxShopResNo + 1 : 1;
		for (KotMasDTO details : kotmas) {
			details.setShopvno(shopResNo);
		}
		kotserv.saveorder(kotmas);
		tablerepo.updatetable(kotmas.get(0).getShopid(), kotmas.get(0).getTablecode(), 1);
		return kotmas.get(0).getShopvno();
	}

	@GetMapping("/kotview/{shopid}/{frdate}/{todate}")
	List<Map<String, Object>> kotview(@PathVariable long shopid,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate frdate,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate todate) {
		Date fromDate = Date.valueOf(frdate);
		Date toDate = Date.valueOf(todate);
		List<Object[]> result = repo.Kotview(shopid, fromDate, toDate);
		List<Map<String, Object>> response = new ArrayList();
		for (Object[] objArray : result) {
			Map<String, Object> map = new HashMap();
			KotMasDTO kotMasDTO = (KotMasDTO) objArray[0];
			String statusname = (String) objArray[1];
			String KottypeName = (String) objArray[2];
			String tablename = (String) objArray[3];
			map.put("kotMasDTO", kotMasDTO);
			map.put("statusname", statusname);
			map.put("KottypeName", KottypeName);
			map.put("tablename", tablename);
			response.add(map);
		}
		return response;
	}
	
	@GetMapping("/KotviewOne/{shopid}/{shopvno}")
	List<Map<String, Object>> kotview(@PathVariable long shopid,@PathVariable long shopvno) {
		List<Object[]> result = repo.KotviewOne(shopid, shopvno);
		List<Map<String, Object>> response = new ArrayList();
		for (Object[] objArray : result) {
			Map<String, Object> map = new HashMap();
			KotMasDTO kotMasDTO = (KotMasDTO) objArray[0];
			String statusname = (String) objArray[1];
			String KottypeName = (String) objArray[2];
			String tablename = (String) objArray[3];
			map.put("kotMasDTO", kotMasDTO);
			map.put("statusname", statusname);
			map.put("KottypeName", KottypeName);
			map.put("tablename", tablename);
			response.add(map);
		}
		return response;
	}

	@GetMapping("/kotviewsearch/{shopid}/{frdate}/{todate}/{keyword}")
	List<Map<String, Object>> kotviewsearch(@PathVariable long shopid,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate frdate,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate todate, @PathVariable String keyword) {
		Date fromDate = Date.valueOf(frdate);
		Date toDate = Date.valueOf(todate);
		List<Object[]> result = repo.Kotviewsearch(shopid, fromDate, toDate, keyword);
		List<Map<String, Object>> response = new ArrayList();
		for (Object[] objArray : result) {
			Map<String, Object> map = new HashMap();
			KotMasDTO kotMasDTO = (KotMasDTO) objArray[0];
			String statusname = (String) objArray[1];
			String KottypeName = (String) objArray[2];
			String tablename = (String) objArray[3];
			map.put("kotMasDTO", kotMasDTO);
			map.put("statusname", statusname);
			map.put("KottypeName", KottypeName);
			map.put("tablename", tablename);
			response.add(map);
		}
		return response;
	}
	
	@GetMapping("/findtableitem/{shopid}/{tablecode}")
	List<KotMasDTO> findtableitem(@PathVariable long shopid, @PathVariable long tablecode) {
		return repo.findtableitem(shopid, tablecode);
	}
	
	@DeleteMapping("/kotdelete/{shopid}/{shopvno}")	
	String deleteVno(@PathVariable long shopid, @PathVariable double shopvno)
	{
		 repo.findonedelete(shopid, shopvno);
		 return "Delete Sucess";
	}

	
	@DeleteMapping("/UpdateDineIn/{shopid}/{shopvno}/{tablecode}")	
	String UpdateTableandblno(@PathVariable long shopid, @PathVariable double shopvno,@PathVariable long tablecode)
	{
		 repo.UpdateblnoDinein(shopid, shopvno, tablecode);
		 repo.UpdateStatusDinein(shopid, shopvno, tablecode);
		 
		 return "Delete Sucess";
	}

}
