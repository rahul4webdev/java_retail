package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.FloorMas;
import org.hotel.app.dto.TableMas;
import org.hotel.app.repository.TableMasRepo;
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
public class TableMasCont 
{
	@Autowired
	private TableMasRepo repo;
	
	@GetMapping("/table")
	List<TableMas> getAll()
	{
		return repo.findAll();
	}
	
	@GetMapping("{shopid}/table")
	List<TableMas> all(@PathVariable long shopid) {
	    return repo.findNamebyshop(shopid);
	}

	@GetMapping("{shopid}/table/{status}")
	List<TableMas> all(@PathVariable long shopid,@PathVariable String status) {
	    return repo.findtablebyshopStatus(shopid,status);
	}

	@GetMapping("{shopid}/table/search/{keyword}")
	List<TableMas> findNamebyshopSrch(@PathVariable long shopid, @PathVariable String keyword)
	{
		return repo.findNamebyshopSrch(shopid,keyword);
	}
	
	@PostMapping("/table")
	TableMas New(@RequestBody TableMas tableMas)
	{
		return repo.save(tableMas);
	}
	
	@PutMapping("/table")
	TableMas Edit(@RequestBody TableMas tableMas)
	{
		return repo.save(tableMas);
	}
	@GetMapping("/table/{id}")
	TableMas FindId(@PathVariable int id)
	{
		return repo.findById(id)
				.orElseThrow();
	}

	@DeleteMapping("/table/{id}")
	String Delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucessfull";
	}
	
	@PostMapping("/changestatustable/{shopid}/{tablecode}/{status}")
	String changestatus(@PathVariable long shopid, @PathVariable long tablecode, @PathVariable long status)
	{
		repo.updatetable(shopid, tablecode, status);
		return "Update Sucess";
	}
}
