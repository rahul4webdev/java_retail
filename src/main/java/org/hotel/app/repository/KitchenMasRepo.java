package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.KitchenMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface KitchenMasRepo extends JpaRepository<KitchenMas, Integer>
{
	
	@Query("select f from KitchenMas f where f.shopid = ?1 and f.kitchenname like %?2%")
	List<KitchenMas> findNamebyshopSrch(long shopid, String keyword);
	
	@Query("select f from KitchenMas f where f.shopid = ?1")
	List<KitchenMas> findNamebyshop(long shopid);

}
