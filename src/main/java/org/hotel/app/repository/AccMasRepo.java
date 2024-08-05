package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.AccMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccMasRepo extends JpaRepository<AccMas, Integer>
{
	@Query("select f from AccMas f where f.shopid = ?1 and f.accname like %?2%")
	List<AccMas> findNamebyshopSrch(long shopid, String keyword);
	
	@Query("select f from AccMas f where f.shopid = ?1")
	List<AccMas> findNamebyshop(long shopid);

}
