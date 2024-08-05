package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.Setting;
import org.hotel.app.repository.SettingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(Api.ALLOWED_ORIGINS)
public class SettingCont 
{
	@Autowired
	private SettingRepo repo;
	@GetMapping("/setting")
	List<Setting> getall()
	{
		return repo.findAll();
	}
	
	@GetMapping("/setting/{id}")
	Setting findid(@PathVariable int id)
	{
		return repo.findById(id)
				.orElseThrow();
	}
	
	@PostMapping("/setting")
	Setting addnew(@RequestBody Setting setting)
	{
		return repo.save(setting);
	}
}
