package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.ShopMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface ShopMasRepo extends JpaRepository<ShopMas, Integer> {
	@Query("select s from ShopMas s where s.email = ?1 and s.password = ?2")
	List<ShopMas> findusernamepass(String username, String password);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO floormas (flname, narration, shopid) VALUES (?1,?2, ?3)", nativeQuery = true)
	void insertFloorMas(String flName, String narration, int shopId);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO rtmas (rtname, narration, shopid) VALUES (?1,?2, ?3)", nativeQuery = true)
	void insertRoomTypeMas(String Name, String narration, int shopId);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO roommas (rname, narration, rent, exrent, shopid, fcode,rtcode,status) VALUES (?1,?2, ?3, ?4, ?5, (select id from floormas where shopid = ?5 limit 1),(select id from rtmas where shopid = ?5 LIMIT 1 OFFSET ?6),0)", nativeQuery = true)
	void insertRoomMas(String Name, String narration, double rent, double exrent, int shopId, int top);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO tablemas (tname, narration, shopid, fcode ,status) VALUES (?1,?2, ?3, (select id from floormas where shopid = ?3 limit 1),0)", nativeQuery = true)
	void insertTableMas(String Name, String narration, int shopId, int top);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO kitchenmas (kitchenname, narration, shopid) VALUES (?1,?2, ?3)", nativeQuery = true)
	void insertKitchenMas(String Name, String narration, int shopId);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO accmas (accname, narration, shopid,mobno,pcode) VALUES (?1,?2, ?3,0,0)", nativeQuery = true)
	void insertAccMas(String Name, String narration, int shopId);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO unitmas (unitname, narration, shopid) VALUES (?1,?2, ?3)", nativeQuery = true)
	void insertUnitMas(String Name, String narration, int shopId);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO itgmas (groupname, narration, shopid) VALUES (?1,?2, ?3)", nativeQuery = true)
	void insertItgMas(String Name, String narration, int shopId);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO dishtypemas (dtname, narration, shopid) VALUES (?1,?2, ?3)", nativeQuery = true)
	void insertDishTypeMas(String Name, String narration, int shopId);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO dishheadmas (dhname, narration, shopid,dtcode) VALUES (?1,?2, ?3,  (select id from dishtypemas where shopid = ?3 LIMIT 1 OFFSET ?4))", nativeQuery = true)
	void insertDishHeadMas(String Name, String narration, int shopId, int type);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO itemmas (itname, narration, narration2,barcode,shopid,dtcode,cess,dlvrate,gst,hsncode,mrp,onlinerate,opstock,purcrate,restrate,takerate,discperc,itg,itc,kcode) VALUES (?1,?2, ?3,?4,?5,(select id from dishheadmas where shopid = ?5 LIMIT 1 OFFSET ?6),0,?7,5,?8,?7,?7,0,?7,?7,?7,0,(select id from itgmas where shopid = ?5 limit 1),0,(select id from kitchenmas where shopid = ?5 limit 1))", nativeQuery = true)
	void insertItemMas(String Name, String narration, String narration2, String barcode, int shopId, int type,
			double drate, String hsncode);

}
