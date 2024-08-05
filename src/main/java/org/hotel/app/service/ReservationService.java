package org.hotel.app.service;

import org.hotel.app.dto.ReservationMas;
import org.hotel.app.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

	private final ReservationRepo reservationRepo;

	@Autowired
	public ReservationService(ReservationRepo reservationRepo) {
		this.reservationRepo = reservationRepo;
	}

	public ReservationMas saveReservation(ReservationMas reservationMas) {
		Long maxShopResNo = reservationRepo.findMaxShopResNoByShopId(reservationMas.getShopid());

		long shopResNo = (maxShopResNo != null) ? maxShopResNo + 1 : 1;

		reservationMas.setShopresno(shopResNo);

		return reservationRepo.save(reservationMas);
	}
}
