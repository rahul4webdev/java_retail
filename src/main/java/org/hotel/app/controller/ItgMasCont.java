package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.ItgMas;
import org.hotel.app.repository.ItgRepo;
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
public class ItgMasCont{
	
	@Autowired
	private ItgRepo itemGroupRepository;
	
	@PostMapping("/ItemGroup")
	ItgMas New(@RequestBody ItgMas itemGroupMaster) {
		return itemGroupRepository.save(itemGroupMaster);
	}
	
	@GetMapping("/ItemGroup/search/{keyword}")
	List<ItgMas> findName(@PathVariable String keyword){
		return itemGroupRepository.findName(keyword);
	}

	@GetMapping("{shopid}/ItemGroup")
	List<ItgMas> findName(@PathVariable long shopid){
		return itemGroupRepository.finditgbyshop(shopid);
	}

	@GetMapping("{shopid}/ItemGroup/search/{keyword}")
	List<ItgMas> findName(@PathVariable long shopid, @PathVariable String keyword){
		return itemGroupRepository.finditgbyshopSrch(shopid,keyword);
	}

	
	
	@GetMapping("/ItemGroup")
	List<ItgMas> getAll(){
		return itemGroupRepository.findAll();
	}
	
	@DeleteMapping("/ItemGroup/{id}")
	String delete(@PathVariable int id)
	{
		 itemGroupRepository.deleteById(id);
		return "Delete Sucessfull ";
	}
	@GetMapping("/ItemGroup/{id}")
	ItgMas findbyid(@PathVariable int id)
	{
		return itemGroupRepository.findById(id)
		.orElseThrow();
	}
	
	@PutMapping("/ItemGroup")
	ItgMas edit(@RequestBody ItgMas itgMas) {
		return itemGroupRepository.save(itgMas);
	}
	
	@PostMapping("/ItemGroup/{id}")
	ItgMas Edit(@RequestBody ItgMas itemGroupMaster)
	{
		return itemGroupRepository.save(itemGroupMaster);
	}
	
	@GetMapping("/itg")
	public String test() {
		return "Connected";
	}
}
