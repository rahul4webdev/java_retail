package org.hotel.app.controller;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.ShopMas;
import org.hotel.app.repository.ShopMasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(Api.ALLOWED_ORIGINS)
public class ShopMasCont {
	@Autowired
	private ShopMasRepo repo;

	@GetMapping("/shopmas")
	List<ShopMas> getall() {
		return repo.findAll();
	}

	@GetMapping("/shopmas/{id}")
	ShopMas findbyid(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
	}

	@PostMapping("/shopmas")
	long addnew(@RequestBody ShopMas shopmas) {
		ShopMas s = repo.save(shopmas);
		repo.insertFloorMas("MAIN", s.getId() + "1st Floor", s.getId()); // FloorMas
		repo.insertRoomTypeMas("Normal", s.getId() + "Normal", s.getId()); // Room Type
		repo.insertRoomTypeMas("Deluxe", s.getId() + "Deluxe", s.getId());
		repo.insertRoomTypeMas("Cemi Deluxe", s.getId() + "Cemi Deluxe", s.getId());
		repo.insertRoomTypeMas("Super Deluxe", s.getId() + "Super Deluxe", s.getId());
		repo.insertRoomTypeMas("Standard twin room", s.getId() + "Standard twin room", s.getId());
		repo.insertRoomTypeMas("Deluxe double room", s.getId() + "Deluxe double room", s.getId());
		repo.insertRoomTypeMas("Studio room or apartment", s.getId() + "Studio room or apartment", s.getId());
		repo.insertRoomTypeMas("Junior suite", s.getId() + "Junior suite", s.getId());
		repo.insertRoomTypeMas("Executive suite", s.getId() + "Executive suite", s.getId());
		repo.insertRoomTypeMas("Presidential suite", s.getId() + "Presidential suite", s.getId());
		
//		repo.insertRoomMas("101", s.getId() + "101", 1000, 500, s.getId(), 0); // Room
//		repo.insertRoomMas("102", s.getId() + "102", 2000, 600, s.getId(), 0);
//		repo.insertRoomMas("103", s.getId() + "103", 3000, 700, s.getId(), 0);
//		repo.insertRoomMas("104", s.getId() + "104", 4000, 800, s.getId(), 0);
//		repo.insertRoomMas("106", s.getId() + "106", 6000, 1000, s.getId(), 1);
//		repo.insertRoomMas("107", s.getId() + "107", 7000, 1100, s.getId(), 1);
//		repo.insertRoomMas("108", s.getId() + "108", 8000, 1200, s.getId(), 1);
//		repo.insertRoomMas("109", s.getId() + "109", 9000, 1300, s.getId(), 1);
//		repo.insertRoomMas("110", s.getId() + "110", 10000, 1400, s.getId(), 1);
//		repo.insertTableMas("T-1", s.getId() + "T-1", s.getId(), 0); // Table
//		repo.insertTableMas("T-2", s.getId() + "T-2", s.getId(), 0);
//		repo.insertTableMas("T-3", s.getId() + "T-3", s.getId(), 0);
//		repo.insertTableMas("T-4", s.getId() + "T-4", s.getId(), 0);
//		repo.insertTableMas("T-5", s.getId() + "T-5", s.getId(), 0);
//		repo.insertTableMas("T-6", s.getId() + "T-6", s.getId(), 0);
//		repo.insertTableMas("T-7", s.getId() + "T-7", s.getId(), 0);
//		repo.insertTableMas("T-8", s.getId() + "T-8", s.getId(), 0);
//		repo.insertTableMas("T-9", s.getId() + "T-9", s.getId(), 0);
//		repo.insertTableMas("T-10", s.getId() + "T-10", s.getId(), 0);
		repo.insertKitchenMas("MAIN", s.getId() + "MAIN", s.getId()); // Kitchen Name
		repo.insertAccMas("UPI", s.getId() + "UPI", s.getId()); // Account
		repo.insertAccMas("CASH", s.getId() + "CASH", s.getId());
		repo.insertUnitMas("NOS", s.getId() + "NOS", s.getId()); // Unit
		repo.insertItgMas("FINISHED GOODS", s.getId() + "FINISHED GOODS", s.getId()); // ITG
//		repo.insertDishTypeMas("Lunch", s.getId() + "Lunch", s.getId()); // DishType
		repo.insertDishTypeMas("Breakfast", s.getId() + "Breakfast", s.getId()); // DishType HEAD
//		repo.insertDishTypeMas("Mix", s.getId() + "Mix", s.getId()); // DishType HEAD
		repo.insertDishHeadMas("Bread", s.getId() + "Paratha", s.getId(),0); // DishType HEAD
//		repo.insertDishHeadMas("Dosa", s.getId() + "Dosa", s.getId(), 1); // 
//		repo.insertDishHeadMas("Rice", s.getId() + "Rice", s.getId(),0); // DishType HEAD
//		repo.insertDishHeadMas("Mix", s.getId() + "Mix", s.getId(),2); // 
//		
//		repo.insertItemMas("Paneer Paratha", s.getId() + "Paneer Paratha", s.getId() + "1001", "1001", s.getId(), 1, 300, "HSN001"); //
//		repo.insertItemMas("Biriyani", s.getId() + "Biriyani", s.getId() + "1002", "1002", s.getId(), 0, 200, "HSN002"); //
//		repo.insertItemMas("Kulfi", s.getId() + "Kulfi", s.getId() + "1003", "1003", s.getId(), 2, 100, "HSN003"); //
//		repo.insertItemMas("Ras Malai", s.getId() + "Ras Malai", s.getId() + "1004", "1004", s.getId(), 2, 400, "HSN004"); //
//		repo.insertItemMas("Barfi", s.getId() + "Barfi", s.getId() + "1005", "1005", s.getId(), 2, 500, "HSN005"); //
//		repo.insertItemMas("Pani Puri", s.getId() + "Pani Puri", s.getId() + "1006", "1006", s.getId(), 2, 600, "HSN006"); //
//		repo.insertItemMas("Tikka Masala", s.getId() + "Tikka Masala", s.getId() + "1007", "1007", s.getId(), 2, 700, "HSN007"); //
//		repo.insertItemMas("Lassi", s.getId() + "Lassi", s.getId() + "1008", "1008", s.getId(), 2, 150, "HSN008"); //
//		repo.insertItemMas("Pongal", s.getId() + "Pongal", s.getId() + "1009", "1001", s.getId(), 0, 250, "HSN009"); //
//		repo.insertItemMas("Dhokla", s.getId() + "Dhokla", s.getId() + "1010", "1010", s.getId(), 1, 350, "HSN010"); //
//		repo.insertItemMas("Papaya", s.getId() + "Papaya", s.getId() + "1011", "1011", s.getId(), 2, 450, "HSN011"); //
//		
//		
//	        repo.insertItemMas("it-01", s.getId() + "it-01", s.getId() + "it-01", "it-01", s.getId(), 2, 100, "it-01"); //
//			repo.insertItemMas("it-02", s.getId() + "it-02", s.getId() + "it-02", "it-02", s.getId(), 2, 100, "it-02"); //
//			repo.insertItemMas("it-03", s.getId() + "it-03", s.getId() + "it-03", "it-03", s.getId(), 2, 100, "it-03"); //
//			repo.insertItemMas("it-04", s.getId() + "it-04", s.getId() + "it-04", "it-04", s.getId(), 2, 100, "it-04"); //
//			repo.insertItemMas("it-05", s.getId() + "it-05", s.getId() + "it-05", "it-05", s.getId(), 2, 100, "it-05"); //
//			repo.insertItemMas("it-06", s.getId() + "it-06", s.getId() + "it-06", "it-06", s.getId(), 2, 100, "it-06"); //
//			repo.insertItemMas("it-07", s.getId() + "it-07", s.getId() + "it-07", "it-07", s.getId(), 2, 100, "it-07"); //
//			repo.insertItemMas("it-08", s.getId() + "it-08", s.getId() + "it-08", "it-08", s.getId(), 2, 100, "it-08"); //
//			repo.insertItemMas("it-09", s.getId() + "it-09", s.getId() + "it-09", "it-09", s.getId(), 2, 100, "it-09"); //
//			repo.insertItemMas("it-10", s.getId() + "it-10", s.getId() + "it-10", "it-10", s.getId(), 2, 100, "it-10"); //
//			repo.insertItemMas("it-11", s.getId() + "it-11", s.getId() + "it-11", "it-11", s.getId(), 2, 100, "it-11"); //
//			repo.insertItemMas("it-12", s.getId() + "it-12", s.getId() + "it-12", "it-12", s.getId(), 2, 100, "it-12"); //
//			repo.insertItemMas("it-13", s.getId() + "it-13", s.getId() + "it-13", "it-13", s.getId(), 2, 100, "it-13"); //
//			repo.insertItemMas("it-14", s.getId() + "it-14", s.getId() + "it-14", "it-14", s.getId(), 2, 100, "it-14"); //
//			repo.insertItemMas("it-15", s.getId() + "it-15", s.getId() + "it-15", "it-15", s.getId(), 2, 100, "it-15"); //
//			repo.insertItemMas("it-16", s.getId() + "it-16", s.getId() + "it-16", "it-16", s.getId(), 2, 100, "it-16"); //
//			repo.insertItemMas("it-17", s.getId() + "it-17", s.getId() + "it-17", "it-17", s.getId(), 2, 100, "it-17"); //
//			repo.insertItemMas("it-18", s.getId() + "it-18", s.getId() + "it-18", "it-18", s.getId(), 2, 100, "it-18"); //
//			repo.insertItemMas("it-19", s.getId() + "it-19", s.getId() + "it-19", "it-19", s.getId(), 2, 100, "it-19"); //
//			repo.insertItemMas("it-20", s.getId() + "it-20", s.getId() + "it-20", "it-20", s.getId(), 2, 100, "it-20"); //
//			repo.insertItemMas("it-21", s.getId() + "it-21", s.getId() + "it-21", "it-21", s.getId(), 2, 100, "it-21"); //
//			repo.insertItemMas("it-22", s.getId() + "it-22", s.getId() + "it-22", "it-22", s.getId(), 2, 100, "it-22"); //
//			repo.insertItemMas("it-23", s.getId() + "it-23", s.getId() + "it-23", "it-23", s.getId(), 2, 100, "it-23"); //
//			repo.insertItemMas("it-24", s.getId() + "it-24", s.getId() + "it-24", "it-24", s.getId(), 2, 100, "it-24"); //
//			repo.insertItemMas("it-25", s.getId() + "it-25", s.getId() + "it-25", "it-25", s.getId(), 2, 100, "it-25"); //
//			repo.insertItemMas("it-26", s.getId() + "it-26", s.getId() + "it-26", "it-26", s.getId(), 2, 100, "it-26"); //
//			repo.insertItemMas("it-27", s.getId() + "it-27", s.getId() + "it-27", "it-27", s.getId(), 2, 100, "it-27"); //
//			repo.insertItemMas("it-28", s.getId() + "it-28", s.getId() + "it-28", "it-28", s.getId(), 2, 100, "it-28"); //
//			repo.insertItemMas("it-29", s.getId() + "it-29", s.getId() + "it-29", "it-29", s.getId(), 2, 100, "it-29"); //
//			repo.insertItemMas("it-30", s.getId() + "it-30", s.getId() + "it-30", "it-30", s.getId(), 2, 100, "it-30"); //
//			repo.insertItemMas("it-31", s.getId() + "it-31", s.getId() + "it-31", "it-31", s.getId(), 2, 100, "it-31"); //
//			repo.insertItemMas("it-32", s.getId() + "it-32", s.getId() + "it-32", "it-32", s.getId(), 2, 100, "it-32"); //


		
		return s.getId();
	}

	@PutMapping("/shopmas")
	ShopMas Editdata(@RequestBody ShopMas shopmas) {
		return repo.save(shopmas);
	}

	@GetMapping("/shopmas/{username}/{password}")
	List<ShopMas> finduser(@PathVariable String username, @PathVariable String password) {
		System.out.println(username);
		System.out.println(password);
		return repo.findusernamepass(username, password);
	}
}
