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
import org.hotel.app.dto.AccMas;
import org.hotel.app.dto.Api;
import org.hotel.app.repository.AccMasRepo;

@RestController
@CrossOrigin(Api.ALLOWED_ORIGINS)

public class AccMasCont
{

	@Autowired
	private AccMasRepo repo;
	
	@GetMapping("{shopid}/accmas")
	List<AccMas> all(@PathVariable long shopid) {
	    return repo.findNamebyshop(shopid);
	}

	@GetMapping("{shopid}/accmas/search/{keyword}")
	List<AccMas> findNamebyshopSrch(@PathVariable long shopid, @PathVariable String keyword)
	{
		return repo.findNamebyshopSrch(shopid,keyword);
	}
	
	@PostMapping("/accmas")
	AccMas New(@RequestBody AccMas Mas)
	{
            return repo.save(Mas);
	}

	@PutMapping("/accmas")
	AccMas edit(@RequestBody AccMas Mas)
	{
		return repo.save(Mas);
	}
	
	
	@GetMapping("/accmas/{id}")
	AccMas FindId(@PathVariable int id)
	{
		return repo.findById(id)
				.orElseThrow();
	}

	@DeleteMapping("/accmas/{id}")
	String Delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucessfull";
	}
}
