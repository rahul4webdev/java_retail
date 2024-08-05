package org.hotel.app.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.CheckInRoomServiceDetails;
import org.hotel.app.dto.View_DTO;
import org.hotel.app.repository.CheckInRoomServiceRepo;
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
public class CheckInRoomServiceCont {
	@Autowired
	private CheckInRoomServiceRepo repo;

	@Autowired
	private CheckINRoomService checkin_Serv;

	@GetMapping("getchehinroomservice/{shopid}/{fromdate}/{todate}")
	List<View_DTO> viewdata(@PathVariable long shopid, @PathVariable Date fromdate, @PathVariable Date todate) {
		return checkin_Serv.ServiceView(shopid, fromdate, todate);
	}

	@GetMapping("getchehinroomservicePrint/{shopid}/{shopvno}")
	List<View_DTO> viewdataOnePrint(@PathVariable long shopid, @PathVariable long shopvno) {
		return checkin_Serv.viewdataOnePrint(shopid, shopvno);
	}

	
	@GetMapping("getchehinroomservice/search/{shopid}/{fromdate}/{todate}/{keyword}")
	List<View_DTO> ServiceViewSearch(@PathVariable long shopid, @PathVariable Date fromdate, @PathVariable Date todate,
			@PathVariable String keyword) {
		return checkin_Serv.ServiceViewSearch(shopid, fromdate, todate, keyword);
	}

	@GetMapping("getchehinroomservicefindone/{shopid}/{sdate}/{shopvno}")
	List<CheckInRoomServiceDetails> findone(@PathVariable long shopid, @PathVariable Date sdate,
			@PathVariable double shopvno) {
		return repo.findone(shopid, sdate, shopvno);
	}

	@GetMapping("getchehinroomserviceTotalAmt/{shopid}/{chid}")
	List<CheckInRoomServiceDetails> findoneTotalRoomServAmt(@PathVariable long shopid, @PathVariable long chid) {
		return repo.serviceTotalAmt(shopid, chid);
	}

	@DeleteMapping("getchehinroomservicefindonedelete/{shopid}/{sdate}/{shopvno}")
	String findonedelete(@PathVariable long shopid, @PathVariable Date sdate, @PathVariable double shopvno) {
		repo.findonedelete(shopid, sdate, shopvno);
		return "Delete Sucess";
	}

	@PostMapping("/getchehinroomservice")
	public double add(@RequestBody List<CheckInRoomServiceDetails> checkInRoomDetails) {
		Long maxShopResNo = repo.findMaxShopVnoByShopId(checkInRoomDetails.get(0).getShopid());
		long shopResNo = (maxShopResNo != null) ? maxShopResNo + 1 : 1;
		for (CheckInRoomServiceDetails details : checkInRoomDetails) {
			details.setShopvno(shopResNo);
		}
		checkin_Serv.saveCheckIn(checkInRoomDetails);
		return checkInRoomDetails.get(0).getShopvno(); 
	}

	@PutMapping("/getchehinroomservice")
	CheckInRoomServiceDetails edit(@RequestBody CheckInRoomServiceDetails checkInRoomDetails) {
		return repo.save(checkInRoomDetails);
	}

	@GetMapping("/getchehinroomservice/{id}")
	CheckInRoomServiceDetails findid(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
	}

	@DeleteMapping("/getchehinroomservice/{id}")
	String deletebyid(@PathVariable int id) {
		repo.deleteById(id);
		return "Delete Sucess..";
	}

}
