package org.hotel.app.repository;

import java.sql.Date;
import java.util.List;

import org.hotel.app.dto.BillMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface BillMasRepo extends JpaRepository<BillMas, Integer>
{

	 @Query("SELECT MAX(b.shopvno) FROM BillMas b WHERE b.shopid = ?1")
	 Long findMaxShopVnoByShopId(long shopid);
	
	@Transactional
	@Modifying
	@Query("update BillMas b set status = ?1 where b.id = ?2")
	void trashbill(int status,long id);


	@Query("select b from BillMas b where b.status = :status and b.shopid = :shopid and b.bldate between :frdate and :todate")
	List<BillMas> billview(@Param("shopid") long shopid, @Param("status") int status, @Param("frdate") Date frdate, @Param("todate") Date todate);

	@Query("select b from BillMas b where b.status = :status and b.shopid = :shopid and b.bldate between :frdate and :todate and (b.guestmob like %:keyword% or b.guestname like %:keyword% or b.guestroomname like %:keyword% or b.id like %:keyword%)")
	List<BillMas> billviewsearch(@Param("shopid") long shopid, @Param("status") int status, @Param("frdate") Date frdate, @Param("todate") Date todate, @Param("keyword") String keyword);


}
