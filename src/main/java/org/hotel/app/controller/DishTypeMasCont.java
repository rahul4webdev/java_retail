package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.DishTypeMas;
import org.hotel.app.repository.DishTypeMasRepo;
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
public class DishTypeMasCont 
{
	@Autowired
	private DishTypeMasRepo repo;
	
	@GetMapping("/Dishtype")
	List<DishTypeMas> getAll()
	{
		return repo.findAll();
	}

	@GetMapping("/Dishtype/search/{keyword}")
	List<DishTypeMas> findName(@PathVariable String keyword)
	{
		return repo.findName(keyword);
	}
	
	@GetMapping("{shopid}/Dishtype")
	List<DishTypeMas> all(@PathVariable long shopid) {
	    return repo.findbyshop(shopid);
	}

	@GetMapping("{shopid}/Dishtype/search/{keyword}")
	List<DishTypeMas> findNamebyshopSrch(@PathVariable long shopid, @PathVariable String keyword)
	{
		return repo.findbyshopSrch(shopid,keyword);
	}
	
	@PostMapping("/Dishtype")
	DishTypeMas New(@RequestBody DishTypeMas dishTypeMas)
	{
		return repo.save(dishTypeMas);
	}
	
	@PutMapping("/Dishtype")
	DishTypeMas Edit(@RequestBody DishTypeMas dishTypeMas)
	{
		return repo.save(dishTypeMas);
	}
	@GetMapping("/Dishtype/{id}")
	DishTypeMas FindId(@PathVariable int id)
	{
		return repo.findById(id)
				.orElseThrow();
	}

	@DeleteMapping("/Dishtype/{id}")
	String Delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucessfull";
	}
	
}
