package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.FloorMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface FloorMasRepo extends JpaRepository<FloorMas, Integer>{
	
	@Query("select f from FloorMas f where f.flname like %?1%")
	List<FloorMas> findName(String keyword);

	@Query("select f from FloorMas f where f.shopid = ?1 and f.flname like %?2%")
	List<FloorMas> findNamebyshopSrch(long shopid, String keyword);
	
	@Query("select f from FloorMas f where f.shopid = ?1")
	List<FloorMas> findNamebyshop(long shopid);

	
}
