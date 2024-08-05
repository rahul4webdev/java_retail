package org.hotel.app.service;

import java.util.List;

import org.hotel.app.dto.CheckInRoomServiceDetails;
import org.hotel.app.dto.KotMasDTO;
import org.hotel.app.repository.KotMasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KotMasService {
	private final KotMasRepo repo;

	@Autowired
	private KotMasService(KotMasRepo repo) {
		this.repo = repo;
	}

	public List<KotMasDTO> saveorder(List<KotMasDTO> kotmas) {
		Long maxShopResNo = repo.findMaxShopVnoByShopId(kotmas.get(0).getShopid());
		long shopResNo = (maxShopResNo != null) ? maxShopResNo + 1 : 1;

		for (KotMasDTO details : kotmas) {
			details.setShopvno(shopResNo);
		}

		return repo.saveAll(kotmas);
	}
}
