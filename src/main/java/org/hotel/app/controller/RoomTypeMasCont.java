package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.RoomTypeMas;
import org.hotel.app.repository.RoomTypeMasRepo;
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
public class RoomTypeMasCont
{
	@Autowired
	private RoomTypeMasRepo repo;
	
	@GetMapping("/{shopid}/rtmas")
	List<RoomTypeMas> getall(@PathVariable long shopid){
		return repo.findNamebyshop(shopid);
	}
	
	@GetMapping("/{shopid}/rtmas/search/{keyword}")
	List<RoomTypeMas> getall(@PathVariable long shopid, @PathVariable String keyword){
		return repo.findNamebyshopSrch(shopid,keyword);
	}

	
	@PostMapping("/rtmas")
	RoomTypeMas New(@RequestBody RoomTypeMas roomTypeMas)
	{
		return repo.save(roomTypeMas);
	}
	
	@PutMapping("/rtmas")
	RoomTypeMas Edit(@RequestBody RoomTypeMas roomTypeMas)
	{
		return repo.save(roomTypeMas);
	}
	
	@GetMapping("/rtmas/{id}")
	RoomTypeMas Find(@PathVariable int id)
	{
		return repo.findById(id)
				.orElseThrow();
	}
	
	@DeleteMapping("/rtmas/{id}")
	String delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucess";
	}
}
