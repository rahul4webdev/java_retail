package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.UnitMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitMasRepo extends JpaRepository<UnitMas, Integer> {
	
	@Query("select u from UnitMas u where u.unitname like %?1%")
	List<UnitMas> findName(String keyword);

	
	@Query("select u from UnitMas u where u.shopid  = ?1")
	List<UnitMas> findNameByShop(long shopid);
	

	@Query("select u from UnitMas u where u.shopid  = ?1 and u.unitname like %?2%")
	List<UnitMas> findNameByShoplike(long shopid,String keyword);

}
