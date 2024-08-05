package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.ItgMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItgRepo extends JpaRepository<ItgMas, Integer>{

	@Query("select itg from ItgMas itg where itg.groupname like %?1%")
	List<ItgMas> findName(String keyword);

	@Query("select itg from ItgMas itg where itg.shopid = ?1")
	List<ItgMas> finditgbyshop(long shopid);

	@Query("select itg from ItgMas itg where itg.shopid = ?1 and itg.groupname like %?2%")
	List<ItgMas> finditgbyshopSrch(long shopid, String keyword);

}
