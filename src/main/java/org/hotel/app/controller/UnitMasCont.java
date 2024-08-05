package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.UnitMas;
import org.hotel.app.repository.UnitMasRepo;
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
public class UnitMasCont {
	@Autowired
	private UnitMasRepo unitMasterRepository;

	@GetMapping("/unit/search/{keyword}")
	List<UnitMas> findName(@PathVariable String keyword) {
		return unitMasterRepository.findName(keyword);
	}

	@GetMapping("{shopid}/unit")
	List<UnitMas> findNameByShop(@PathVariable long shopid) {
		return unitMasterRepository.findNameByShop(shopid);
	}


	@GetMapping("{shopid}/unit/search/{keyword}")
	List<UnitMas> findName(@PathVariable long shopid, @PathVariable String keyword) {
		return unitMasterRepository.findNameByShoplike(shopid, keyword);
	}

	
	@DeleteMapping("/unit/{id}")
	String delete(@PathVariable int id) {
		unitMasterRepository.deleteById(id);
		return "Delete Sucessfull";
	}

	@GetMapping("/unit/{id}")
	UnitMas unitByid(@PathVariable int id) {
		return unitMasterRepository.findById(id).orElseThrow();
	}

	@GetMapping("/unit")
	List<UnitMas> getAllUnit() {
		return unitMasterRepository.findAll();
	}

	@PostMapping("/unit")
	UnitMas New(@RequestBody UnitMas unitMaster) {
		return unitMasterRepository.save(unitMaster);
	}

	@PutMapping("/unit")
	UnitMas edit(@RequestBody UnitMas unitMaster) {
		return unitMasterRepository.save(unitMaster);
	}

}
