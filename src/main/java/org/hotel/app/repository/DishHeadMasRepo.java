package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.DishHeadMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface DishHeadMasRepo extends JpaRepository<DishHeadMas, Integer>
{
	@Query("select d from DishHeadMas d where d.dhname like %?1%")
	List<DishHeadMas> findName(String keyword);
	
	@Query("select d from DishHeadMas d where d.shopid = ?1")
	List<DishHeadMas> findbyshop(long shopid);

	@Query("select d from DishHeadMas d where d.shopid = ?1 and d.dhname like %?2%")
	List<DishHeadMas> findbyshopSrch(long shopid, String keyword);

	@Query("select d from DishHeadMas d where d.shopid = ?1 and d.dtcode = ?2")
	List<DishHeadMas> findbyshopDHDT(long shopid, long dtcode);

}
