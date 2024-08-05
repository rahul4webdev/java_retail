package org.hotel.app.controller;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.hotel.app.dto.Api;
import org.hotel.app.dto.BillMas;
import org.hotel.app.dto.Rpt_Billreport_DTO;
import org.hotel.app.repository.BillMasRepo;
import org.hotel.app.service.Rpt_Billreport_Srv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(Api.ALLOWED_ORIGINS)
public class BillMasCont 
{
	@Autowired
	private BillMasRepo repo;
	
	@Autowired
	private Rpt_Billreport_Srv billreport_Srv;
	
	@GetMapping("/bill")
	List<BillMas> getAll()
	{
		return repo.findAll();
	}
	
	@GetMapping("{shopid}/rptbill/{fromdate}/{todate}/{status}")
	List<Rpt_Billreport_DTO> viewdata(@PathVariable long shopid,@PathVariable Date fromdate, @PathVariable Date todate, @PathVariable int status) {
	    return billreport_Srv.Billinview(shopid, fromdate, todate,status);
	}

	
	@GetMapping("{shopid}/billview/{status}/{frdate}/{todate}")
	List<BillMas> billview(@PathVariable long shopid,@PathVariable int status, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate frdate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate todate) {
	    Date fromDate = Date.valueOf(frdate);
	    Date toDate = Date.valueOf(todate);
	    return repo.billview(shopid, status, fromDate, toDate);
	}

	@GetMapping("{shopid}/billview/{status}/{frdate}/{todate}/{keyword}")
	List<BillMas> billviewsearch(@PathVariable long shopid,@PathVariable int status, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate frdate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate todate,@PathVariable String keyword) {
	    Date fromDate = Date.valueOf(frdate);
	    Date toDate = Date.valueOf(todate);
	    return repo.billviewsearch(shopid, status, fromDate, toDate, keyword);
	}

	@PostMapping("/bill")
	public long saveNew(@RequestBody BillMas Mas) {
		BillMas save = billreport_Srv.saveBill(Mas);
		return save.getShopvno();
	}
	
	@PutMapping("/bill")
	BillMas EditBill(@RequestBody BillMas billMas)
	{
		return repo.save(billMas);
	}
	@GetMapping("/bill/{id}")
	BillMas getbill(@PathVariable int id)
	{
		return repo.findById(id)
			.orElseThrow();
	}
	
	@DeleteMapping("/bill/{id}")
	String delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucess";
	}
	
	@PostMapping("/bill/{status}/{id}")
	String forTrash(@PathVariable int status,@PathVariable long id) {
		repo.trashbill(status,id);
		return "Update Sucess";
	}
	
	
	
}
