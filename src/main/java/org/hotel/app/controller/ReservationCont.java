package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.FloorMas;
import org.hotel.app.dto.ReservationMas;
import org.hotel.app.dto.RoomMas;
import org.hotel.app.repository.ReservationRepo;
import org.hotel.app.service.ReservationService;
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
public class ReservationCont {
	@Autowired
	private ReservationRepo repo;

	@Autowired
	private ReservationService reservationService;

	@GetMapping("{shopid}/reservation")
	List<ReservationMas> all(@PathVariable long shopid) {
		return repo.findNamebyshop(shopid);
	}

	@GetMapping("{shopid}/reservation/search/{keyword}")
	List<ReservationMas> findNamebyshopSrch(@PathVariable long shopid, @PathVariable String keyword) {
		return repo.findNamebyshopSrch(shopid, keyword);
	}

	@PostMapping("/reservation")
	public long saveReservation(@RequestBody ReservationMas reservationMas) {
		ReservationMas r = reservationService.saveReservation(reservationMas);
		return r.getShopresno();
	}

	@PutMapping("/reservation")
	int Edit(@RequestBody ReservationMas reservationMas) {
		ReservationMas r = repo.save(reservationMas);
		return r.getId();
	}

	@GetMapping("/reservationsingle/{id}")
	ReservationMas find(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
	}

	@GetMapping("{shopid}/reservation/{id}")
	ReservationMas findNamebyshopShopresno(@PathVariable long shopid, @PathVariable int id) {
		return repo.findFirstByShopIdAndShopResNo(shopid, id);
	}

	@DeleteMapping("/reservation/{id}")
	String delete(@PathVariable int id) {
		repo.deleteById(id);
		return "Delete Sucess";
	}

}
