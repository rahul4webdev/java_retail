package org.hotel.app.controller;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.CheckInMas;
import org.hotel.app.dto.CustomCheckInViewDto;
import org.hotel.app.dto.Rpt_checkin_DTO;
import org.hotel.app.repository.CheckInRepo;
import org.hotel.app.service.Rpt_Checkin_Serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@CrossOrigin(Api.ALLOWED_ORIGINS)
public class CheckInCont 
{
	@Autowired
	private CheckInRepo repo;

	@Autowired
	private Rpt_Checkin_Serv checkin_Serv;
	
	@GetMapping("{shopid}/rptcheckin/{fromdate}/{todate}/{status}")
	List<Rpt_checkin_DTO> viewdata(@PathVariable long shopid,@PathVariable Date fromdate, @PathVariable Date todate, @PathVariable int status) {
	    return checkin_Serv.checkinview(shopid,fromdate, todate,status);
	}

	@GetMapping("{shopid}/rptcheckin/{status}")
	List<Rpt_checkin_DTO> viewdatachkout(@PathVariable long shopid, @PathVariable int status) {
	    return checkin_Serv.viewdatachkout(shopid, status);
	}

	@GetMapping("{shopid}/roomservice")
	List<Rpt_checkin_DTO> viewdatachkoutRoomName(@PathVariable long shopid) {
	    return checkin_Serv.viewdatachkoutRoomName(shopid);
	}

	
	
	@GetMapping("/checkin")
	List<CheckInMas> getall() {
		return repo.findAll();
	}

	@GetMapping("/checkinview")
	List<CustomCheckInViewDto> checkinview() 
	{
		List<Object[]> results = repo.checkinview();
		List<CustomCheckInViewDto> customCheckInViewList = new ArrayList<>();
		for (Object[] result : results) {
			CheckInMas checkInMas = (CheckInMas) result[0];
			String roomName = (String) result[1];
			String statusName = (String) result[2];
			CustomCheckInViewDto customCheckInViewDto = new CustomCheckInViewDto(checkInMas, roomName, statusName);
			customCheckInViewList.add(customCheckInViewDto);
		}
		return customCheckInViewList;
	}

	@GetMapping("/checkoutview")
	List<CustomCheckInViewDto> checkoutviewnew() 
	{
		List<Object[]> results = repo.checkoutview();
		List<CustomCheckInViewDto> customCheckInViewList = new ArrayList<>();
		for (Object[] result : results) {
			CheckInMas checkInMas = (CheckInMas) result[0];
			String roomName = (String) result[1];
			String statusName = (String) result[2];
			CustomCheckInViewDto customCheckInViewDto = new CustomCheckInViewDto(checkInMas, roomName, statusName);
			customCheckInViewList.add(customCheckInViewDto);
		}
		return customCheckInViewList;
	}

	@PostMapping("/checkin/statusbill/{id}")
	String updatecheckinstatusbill(@PathVariable int id) {
		repo.updatecheckinstatusbill(id);
		return "Update Sucess";
	}

	@PostMapping("/checkin/statusout/{id}")
	String updatecheckinstatuscheckout(@PathVariable int id) {
		repo.updatecheckinstatuscheckout(id);
		return "Update Sucess";
	}


	
	
	@PostMapping("/checkin/blno/{blno}/{id}")
	String updatecheckinstatuscheckoutBlno(@PathVariable int blno,@PathVariable int id) {
		repo.updatecheckinstatuscheckoutBlno(blno,id);
		return "Update Sucess";
	}

	@PostMapping("/checkin/uprname/{newroomname}/{id}")
	String updatecheckinroomnames(@PathVariable String newroomname,@PathVariable int id) {
		repo.updatecheckinroomnames(newroomname,id);
		return "Update Sucess";
	}

	

	@PostMapping("/checkin/bldate/{bldate}/{id}")
	String updatecheckinstatuscheckoutBlno(@PathVariable Date bldate, @PathVariable int id) {
	    repo.updateCheckinStatusCheckoutBldate(bldate, id);
	    return "Update Success";
	}

	
	@GetMapping("/checkin/search/{keyword}")
	List<CustomCheckInViewDto> findbyname(@PathVariable String keyword) {
		List<Object[]> results = repo.findbyname(keyword);
		List<CustomCheckInViewDto> customCheckInViewList = new ArrayList<>();
		for (Object[] result : results) {
			CheckInMas checkInMas = (CheckInMas) result[0];
			String roomName = (String) result[1];
			String statusName = (String) result[2];
			CustomCheckInViewDto customCheckInViewDto = new CustomCheckInViewDto(checkInMas, roomName, statusName);
			customCheckInViewList.add(customCheckInViewDto);
		}
		return customCheckInViewList;
	}



	
	@PostMapping("/checkin")
	public long saveCheckIn(@RequestBody CheckInMas Mas) {
		CheckInMas c = checkin_Serv.saveCheckIn(Mas);
		return c.getId();
	}
	
	
	@PutMapping("/checkin")
	CheckInMas edit(@RequestBody CheckInMas checkInMas) {
		return repo.save(checkInMas);
	}

	@GetMapping("/checkin/{id}")
	CheckInMas findbyid(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
	}

	@DeleteMapping("/checkin/{id}")
	String delete(@PathVariable int id) {
		repo.deleteById(id);
		return "Delete Sucesss";
	}

}
