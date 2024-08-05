package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.CheckInMas;
import org.hotel.app.dto.CheckInRoomDetails;
import org.hotel.app.repository.CheckInRoomDetailsRepo;
import org.hotel.app.service.CheckINRoomService;
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
public class CheckInRoomDetailsCont 
{
	@Autowired
	private CheckInRoomDetailsRepo repo;
	
	private CheckINRoomService checkinrserv;
	

	@GetMapping("/getchehinroom")
	List<CheckInRoomDetails> getall()
	{
		return repo.findAll();
	}
	

	@GetMapping("/getchehinroomDetail/{id}")
	List<CheckInRoomDetails> getall(@PathVariable int id)
	{
		return repo.getroomdetbyidch(id);
	}

	
	
	
	@PutMapping("/getchehinroom")
	CheckInRoomDetails edit(@RequestBody CheckInRoomDetails checkInRoomDetails )
	{
		return repo.save(checkInRoomDetails);
	}

	
	@PostMapping("/getchehinroom")
	List<CheckInRoomDetails> newdata(@RequestBody List<CheckInRoomDetails> checkInRoomDetails )
	{
		return repo.saveAll(checkInRoomDetails);
	}

	
	@GetMapping("/getchehinroom/{id}")
	CheckInRoomDetails findid(@PathVariable int id)
	{
		return repo.findById(id)
				.orElseThrow();
	}
	@DeleteMapping("/getchehinroom/{id}")
	String deletebyid(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucess..";
	}
	
	@DeleteMapping("/getchehinroomdelete/{id}/{rcode}")
	String deletebyChid(@PathVariable int id,@PathVariable int rcode)
	{
		repo.getchehinroomdelete(id, rcode);
		return "Delete Sucess..";
	}

	@DeleteMapping("/getchehinroomdeletechdetail/{id}")
	String deletebyChid(@PathVariable int id)
	{
		repo.getchehinroomdeletechdetail(id);
		return "Delete Sucess..";
	}

}
