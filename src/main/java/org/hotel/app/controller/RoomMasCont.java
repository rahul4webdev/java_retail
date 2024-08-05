package org.hotel.app.controller;

import java.util.Arrays;
import java.util.List;
import org.hotel.app.dto.Api;
import org.hotel.app.dto.RoomDetailsDTO;
import org.hotel.app.dto.RoomMas;
import org.hotel.app.repository.RoomMasRepo;
import org.hotel.app.service.RoomService;
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
public class RoomMasCont{
	
	@Autowired
	private RoomMasRepo repo;
	
	@Autowired
	private  RoomService roomMasService;

	@GetMapping("/{shopid}/roomstatus/{rtype}/{rcode}/{status}")
	List<RoomDetailsDTO> getstatus(@PathVariable long shopid, @PathVariable Integer rtype,@PathVariable Integer rcode,@PathVariable Integer status)
	{
	    return roomMasService.getRoomDetailsByCode(shopid,rtype,rcode,status);
	}

	@GetMapping("/{shopid}/roomstatus/{rtype}/{rcode}/{status}/{keyword}")
	List<RoomDetailsDTO> getstatus(@PathVariable long shopid, @PathVariable Integer rtype,@PathVariable Integer rcode,@PathVariable Integer status, @PathVariable String keyword)
	{
	    return roomMasService.getRoomDetailsByCodelike(shopid,rtype,rcode,status,keyword);
	}

	@GetMapping("/{shopid}/room")
	List<RoomMas> getallshop(@PathVariable long shopid) {
		return repo.findNamebyshop(shopid);
	}
	@GetMapping("/room")
	List<RoomMas> getall() {
		return repo.findAll();
	}
	

	
	@GetMapping("/room/search/{keyword}")
	List<RoomMas> findName(@PathVariable String keyword) {
		return repo.findName(keyword);
	}

	@GetMapping("/room/getnamebyid/{id}")
	List<RoomMas> getnamebyid(@PathVariable Integer id) {
		return repo.getnamebyid(id);
	}

	@PostMapping("/room")
	RoomMas New(@RequestBody RoomMas roomMas) {
		return repo.save(roomMas);
	}

	@PutMapping("/room")
	RoomMas Edit(@RequestBody RoomMas roomMas) {
		return repo.save(roomMas);
	}

	@GetMapping("/room/{id}")
	RoomMas find(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
	}

	@DeleteMapping("/room/{id}")
	String delete(@PathVariable int id) {
		repo.deleteById(id);
		return "Delete Sucess";
	}

	@PostMapping("/room/status/{id}")
	String updateroomstatus(@PathVariable int id) {
		repo.updateroomstatus(id);
		return "Update Sucess";
	}
	
	
	@PostMapping("/room/updateroombulk/{status}/{rcodes}")
	String updateroomstatusBulk(@PathVariable int status, @PathVariable List<Integer> rcodes) {
	    repo.updateroomstatusBulk(status, rcodes);
	    return "Update Success";
	}


	@PostMapping("/room/statusfree/{id}")
	String updateroomstatusfree(@PathVariable int id) {
		repo.updateroomstatusfree(id);
		return "Update Sucess";
	}

}
