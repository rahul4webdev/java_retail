package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.ItemMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ItemMasRepo extends JpaRepository<ItemMaster, Integer>
{
	@Query("select i from ItemMaster i where i.itname like %?1%")
	List<ItemMaster> findName(String keyword);
	
	@Query("select f from ItemMaster f where f.shopid = ?1 and f.itname like %?2%")
	List<ItemMaster> findNamebyshopSrch(long shopid, String keyword);
	
	@Query("select f from ItemMaster f where f.shopid = ?1 and f.dtcode = ?2")
	List<ItemMaster> findNamebyshopDTItem(long shopid, long dtcode);
	
	@Query("select f from ItemMaster f where f.shopid = ?1")
	List<ItemMaster> findNamebyshop(long shopid);

	@Query("select f from ItemMaster f where f.shopid = ?1 and isfav=1 order by itname")
	List<ItemMaster> findNamebyshopfavourate(long shopid);


	
	
}

