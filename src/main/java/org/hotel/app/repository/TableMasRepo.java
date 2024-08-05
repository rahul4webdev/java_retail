package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.TableMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
@Repository
public interface TableMasRepo extends JpaRepository<TableMas, Integer>
{
	
	@Query("select f from TableMas f where f.shopid = ?1 and f.tname like %?2%")
	List<TableMas> findNamebyshopSrch(long shopid, String keyword);
	
	@Query("select f from TableMas f where f.shopid = ?1")
	List<TableMas> findNamebyshop(long shopid);

	@Query("select f from TableMas f where f.shopid = ?1 and f.status in (?2)")
	List<TableMas> findtablebyshopStatus(long shopid,String status);

	@Transactional
	@Modifying
	@Query("update TableMas t set status = ?3 where t.shopid = ?1 and t.id =?2")
	void updatetable(long shopid,long tablecode,long status);
}
