package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.RoomTypeMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeMasRepo extends JpaRepository<RoomTypeMas, Integer>
{
	@Query("select r from RoomTypeMas r where r.shopid = ?1")
	List<RoomTypeMas> findNamebyshop(long shopid);

	
	@Query("select r from RoomTypeMas r where r.shopid = ?1 and r.rtname like %?2%")
	List<RoomTypeMas> findNamebyshopSrch(long shopid, String keyword);

}
