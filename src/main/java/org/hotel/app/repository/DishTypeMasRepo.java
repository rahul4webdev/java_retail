package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.DishTypeMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface DishTypeMasRepo extends JpaRepository<DishTypeMas, Integer>{
	@Query("select d from DishTypeMas d where d.dtname like %?1%")
	List<DishTypeMas> findName(String keyword);
	
	@Query("select d from DishTypeMas d where d.shopid = ?1")
	List<DishTypeMas> findbyshop(long shopid);

	@Query("select d from DishTypeMas d where d.shopid = ?1 and d.dtname like %?2%")
	List<DishTypeMas> findbyshopSrch(long shopid, String keyword);
}
