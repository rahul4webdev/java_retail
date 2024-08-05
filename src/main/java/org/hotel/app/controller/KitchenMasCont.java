package org.hotel.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.hotel.app.dto.Api;
import org.hotel.app.dto.KitchenMas;
import org.hotel.app.repository.KitchenMasRepo;

@RestController
@CrossOrigin(Api.ALLOWED_ORIGINS)

public class KitchenMasCont
{

	@Autowired
	private KitchenMasRepo repo;
	
	@GetMapping("{shopid}/kitchen")
	List<KitchenMas> all(@PathVariable long shopid) {
	    return repo.findNamebyshop(shopid);
	}

	@GetMapping("{shopid}/kitchen/search/{keyword}")
	List<KitchenMas> findNamebyshopSrch(@PathVariable long shopid, @PathVariable String keyword)
	{
		return repo.findNamebyshopSrch(shopid,keyword);
	}
	
	@PostMapping("/kitchen")
	KitchenMas New(@RequestBody KitchenMas Mas)
	{
            return repo.save(Mas);
	}

	@PutMapping("/kitchen")
	KitchenMas edit(@RequestBody KitchenMas Mas)
	{
		return repo.save(Mas);
	}
	
	
	@GetMapping("/kitchen/{id}")
	KitchenMas FindId(@PathVariable int id)
	{
		return repo.findById(id)
				.orElseThrow();
	}

	@DeleteMapping("/kitchen/{id}")
	String Delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucessfull";
	}
}
