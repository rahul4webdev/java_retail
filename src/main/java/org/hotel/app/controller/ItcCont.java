package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.ItcMas;
import org.hotel.app.repository.ItcRepo;
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
public class ItcCont{
	@Autowired
	private ItcRepo repo;
	
	@GetMapping("/Itcomp")
	List<ItcMas> getAll()
	{
		return repo.findAll();
	}
	@GetMapping("/Itcomp/search/{keyword}")
	List<ItcMas> findName(@PathVariable String keyword)
	{
		return repo.findName(keyword);
	}
	@PostMapping("/Itcomp")
	ItcMas New(@RequestBody ItcMas itcMas)
	{
		return repo.save(itcMas);
	}
	
	@PutMapping("/Itcomp")
	ItcMas Edit(@RequestBody ItcMas itcMas)
	{
		return repo.save(itcMas);
	}
	@GetMapping("/Itcomp/{id}")
	ItcMas FindId(@PathVariable int id)
	{
		return repo.findById(id)
				.orElseThrow();
	}

	@DeleteMapping("/Itcomp/{id}")
	String Delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucessfull";
	}
}
