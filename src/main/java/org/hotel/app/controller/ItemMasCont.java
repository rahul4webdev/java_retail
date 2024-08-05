package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.ItemMaster;
import org.hotel.app.repository.ItemMasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ItemMasCont 
{
	@Autowired
	private ItemMasRepo repo;
	
	
	@GetMapping("/item/search/{keyword}")
	List<ItemMaster> findName(@PathVariable String keyword)
	{
		return repo.findName(keyword);
	}
	
	
	@GetMapping("{shopid}/item")
	List<ItemMaster> all(@PathVariable long shopid) {
	    return repo.findNamebyshop(shopid);
	}

	@GetMapping("{shopid}/itemfavourate")
	List<ItemMaster> allfavourate(@PathVariable long shopid) {
	    return repo.findNamebyshopfavourate(shopid);
	}


	
	@GetMapping("ItemSearchBydtcode/{shopid}/{dtcode}")
	List<ItemMaster> all(@PathVariable long shopid,@PathVariable long dtcode) {
	    return repo.findNamebyshopDTItem(shopid,dtcode);
	}

	
	@GetMapping("{shopid}/item/search/{keyword}")
	List<ItemMaster> findNamebyshopSrch(@PathVariable long shopid, @PathVariable String keyword)
	{
		return repo.findNamebyshopSrch(shopid,keyword);
	}
	
	@PostMapping("/item")
	ItemMaster New(@RequestBody ItemMaster itemMaster)
	{
		return repo.save(itemMaster);
	}
	
	@PutMapping("/item")
	ItemMaster Edit(@RequestBody ItemMaster itemMaster)
	{
		return repo.save(itemMaster);
	}
	@GetMapping("/item/{id}")
	ItemMaster FindId(@PathVariable int id)
	{
		return repo.findById(id)
				.orElseThrow();
	}

	@DeleteMapping("/item/{id}")
	String Delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucessfull";
	}
}
