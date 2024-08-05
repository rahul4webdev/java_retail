package org.hotel.app.controller;

import java.sql.Date;
import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.LogbookMas;
import org.hotel.app.repository.LogBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(Api.ALLOWED_ORIGINS)
public class LogbookCont 
{
	@Autowired
	private LogBookRepo repo;
	
	@PostMapping("/logbook")
	LogbookMas New(@RequestBody LogbookMas logbookMas)
	{
		return repo.save(logbookMas);
	}

	@GetMapping("/logbook")
	List<LogbookMas> getAll()
	{
		return repo.findAll();
	}
	@GetMapping("{shopid}/logbookview/{fromdate}/{todate}")
	List<LogbookMas> getAlldesc(@PathVariable long shopid,@PathVariable Date fromdate, @PathVariable Date todate)
	{
		return repo.getAlldesc(fromdate,todate,shopid);
	}

}
