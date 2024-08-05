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
import org.hotel.app.dto.FloorMas;
import org.hotel.app.repository.FloorMasRepo;

@RestController
@CrossOrigin(Api.ALLOWED_ORIGINS)

public class FloorMasCont
{

	@Autowired
	private FloorMasRepo repo;
	
	@GetMapping("{shopid}/floor")
	List<FloorMas> all(@PathVariable long shopid) {
	    return repo.findNamebyshop(shopid);
	}

	@GetMapping("{shopid}/floor/search/{keyword}")
	List<FloorMas> findNamebyshopSrch(@PathVariable long shopid, @PathVariable String keyword)
	{
		return repo.findNamebyshopSrch(shopid,keyword);
	}
	
	@PostMapping("/floor")
	FloorMas New(@RequestBody FloorMas floorMas)
	{
            return repo.save(floorMas);
	}

	@PutMapping("/floor")
	FloorMas edit(@RequestBody FloorMas floorMas)
	{
		return repo.save(floorMas);
	}
	
	
	@GetMapping("/floor/{id}")
	FloorMas FindId(@PathVariable int id)
	{
		return repo.findById(id)
				.orElseThrow();
	}

	@DeleteMapping("/floor/{id}")
	String Delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucessfull";
	}
}
