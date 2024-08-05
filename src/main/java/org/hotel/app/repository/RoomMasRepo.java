package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.RoomMas;
import org.hotel.app.dto.RoomTypeMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
@Repository
public interface RoomMasRepo extends JpaRepository<RoomMas, Integer> 
{
	
	
	@Query("select r from RoomMas r where r.shopid = ?1")
	List<RoomMas> findNamebyshop(long shopid);

	
	@Query("select r from RoomMas r where r.shopid = ?1 and r.rname like %?2%")
	List<RoomMas> findNamebyshopSrch(long shopid, String keyword);

	
	@Query("select r from RoomMas r where r.rname like %?1%")
	List<RoomMas> findName(String keyword);

	
	
	@Query("select r from RoomMas r where status = 0 and r.rtcode = ?1")
	List<RoomMas> getnamebyid(Integer id);
	
	@Transactional
	@Modifying
	@Query("update RoomMas r set r.status = 1 where r.id = ?1")
	void updateroomstatus(int id);
	
	
	@Transactional
	@Modifying
	@Query("update RoomMas r set r.status = 0 where r.id = ?1")
	void updateroomstatusfree(int id);

	@Transactional
	@Modifying
	@Query("update RoomMas r set r.status = :status where r.id in :rcodes")
	void updateroomstatusBulk(@Param("status") int status, @Param("rcodes") List<Integer> rcodes);


}
