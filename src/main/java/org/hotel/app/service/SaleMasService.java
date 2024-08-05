package org.hotel.app.service;
import java.util.List;
import org.hotel.app.dto.SaleMasDTO;
import org.hotel.app.repository.SaleMasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleMasService {

	private final SaleMasRepo Repo;

	@Autowired
	public SaleMasService(SaleMasRepo Repo) {
		this.Repo = Repo;
	}

	public List<SaleMasDTO> saveBill(List<SaleMasDTO> mas) {
	    Long maxShopResNo = Repo.findMaxShopVnoByShopId(mas.get(0).getShopid());
	    long shopResNo = (maxShopResNo != null) ? maxShopResNo + 1 : 1;

	    for (SaleMasDTO details : mas) {
	        details.setShopvno(shopResNo);
	    }
	    return Repo.saveAll(mas);
	}
}
