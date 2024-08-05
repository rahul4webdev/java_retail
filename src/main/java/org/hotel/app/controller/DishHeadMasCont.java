package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.DishHeadMas;
import org.hotel.app.dto.View_DTO;
import org.hotel.app.repository.DishHeadMasRepo;
import org.hotel.app.service.Rpt_Dishhead_Serv;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DishHeadMasCont 
{
	@Autowired
	private DishHeadMasRepo repo;
	
	@Autowired
	private Rpt_Dishhead_Serv serv;
	
	@GetMapping("/dhmas")
	List<DishHeadMas> getAll()
	{
		return repo.findAll();
	}
	
	@GetMapping("/dhmas/search/{keyword}")
	List<DishHeadMas> findName(@PathVariable String keyword)
	{
		return repo.findName(keyword);
	}

	@GetMapping("/finddishtype/{shopid}/{dtcode}")
	List<DishHeadMas> findNametype(@PathVariable long shopid,@PathVariable long dtcode)
	{
		return repo.findbyshopDHDT(shopid,dtcode);
	}

	
	@GetMapping("{shopid}/dhmas")
	List<View_DTO> all(@PathVariable long shopid) {
	    return serv.Dishheadview(shopid);
	}

	@GetMapping("{shopid}/dhmas/search/{keyword}")
	List<View_DTO> findNamebyshopSrch(@PathVariable long shopid, @PathVariable String keyword)
	{
		return serv.DishheadviewSearch(shopid,keyword);
	}
	
	@PostMapping("/dhmas")
	DishHeadMas New(@RequestBody DishHeadMas dishHeadMas)
	{
		return repo.save(dishHeadMas);
	}
	@PutMapping("/dhmas")
	DishHeadMas Edit(@RequestBody DishHeadMas dishHeadMas)
	{
		return repo.save(dishHeadMas);
	}
	@GetMapping("/dhmas/{id}")
	DishHeadMas FindId(@PathVariable int id)
	{
		return repo.findById(id)
		.orElseThrow();
	}
	@DeleteMapping("/dhmas/{id}")
	String Delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucess";
	}
	
}
