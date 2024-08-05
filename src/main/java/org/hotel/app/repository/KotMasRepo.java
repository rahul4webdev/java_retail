package org.hotel.app.repository;

import java.sql.Date;
import java.util.List;

import org.hotel.app.dto.KotMasDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface KotMasRepo extends JpaRepository<KotMasDTO, Integer>
{

	 @Query("SELECT MAX(t.shopvno) FROM KotMasDTO t WHERE t.shopid = ?1")
	 Long findMaxShopVnoByShopId(long shopid);

    @Query("select b, Case when b.status=0 then 'No' when b.status=1 then 'Yes' When b.status=2 then 'Cancel' end as statusname,Case when b.kottype=0 then 'Dine-in' when b.kottype=2 then 'Delivery' When b.kottype=3 then 'Pickup' end as KottypeName,(SELECT t.tname FROM TableMas t WHERE t.id = b.tablecode AND t.shopid = b.shopid) AS tname from KotMasDTO b where b.shopid = :shopid and b.kotdate between :frdate and :todate group by b.shopid, b.shopvno order by b.id desc")
	List<Object[]> Kotview(@Param("shopid") long shopid, @Param("frdate") Date frdate, @Param("todate") Date todate);

    @Query("select b, Case when b.status=0 then 'No' when b.status=1 then 'Yes' When b.status=2 then 'Cancel' end as statusname,Case when b.kottype=0 then 'Dine-in' when b.kottype=2 then 'Delivery' When b.kottype=3 then 'Pickup' end as KottypeName,(SELECT t.tname FROM TableMas t WHERE t.id = b.tablecode AND t.shopid = b.shopid) AS tname from KotMasDTO b where b.shopid = :shopid and b.shopvno =:shopvno order by b.id")
	List<Object[]> KotviewOne(@Param("shopid") long shopid, @Param("shopvno") long shopvno);

	
	@Query("select b, Case when b.status=0 then 'No' when b.status=1 then 'Yes' When b.status=2 then 'Cancel' end as statusname,Case when b.kottype=0 then 'Dine-in' when b.kottype=2 then 'Delivery' When b.kottype=3 then 'Pickup' end as KottypeName,(SELECT t.tname FROM TableMas t WHERE t.id = b.tablecode AND t.shopid = b.shopid) AS tname from KotMasDTO b where b.shopid = :shopid and b.kotdate between :frdate and :todate and (b.tablename like %:keyword% or b.shopvno like %:keyword% or b.itname like %:keyword%) group by b.shopid, b.shopvno order by b.id desc")
	List<Object[]> Kotviewsearch(@Param("shopid") long shopid, @Param("frdate") Date frdate, @Param("todate") Date todate, @Param("keyword") String keyword);
    

	@Query("select b from KotMasDTO b where b.shopid = :shopid and b.tablecode = :tablecode and b.status = 0 order by id")
	List<KotMasDTO> findtableitem(@Param("shopid") long shopid, @Param("tablecode") long tablecode);

	
	@Transactional
	@Modifying
	@Query("delete from KotMasDTO c WHERE c.shopid = ?1 AND c.shopvno = ?2")
	void findonedelete(long shopid, double shopvno);
	
	@Transactional
	@Modifying
	@Query("update KotMasDTO k set k.blno = ?2 WHERE k.shopid = ?1 AND k.status = 0 AND k.tablecode = ?3")
	void UpdateblnoDinein(long shopid, double shopvno,long tablecode);
	
	@Transactional
	@Modifying
	@Query("update KotMasDTO k set k.blno = ?3 WHERE k.shopid = ?1 AND k.shopvno = ?2")
	void UpdateblnoDTBillNo(long shopid, double shopvno,long blno);
	
	@Transactional
	@Modifying
	@Query("update KotMasDTO k set k.status = 1 WHERE k.shopid = ?1 AND k.shopvno = ?2")
	void UpdateblnoDTStatus(long shopid, double shopvno);
	
	
	
	@Transactional
	@Modifying
	@Query("update KotMasDTO k set k.status =1 WHERE k.shopid = ?1 AND k.status = 0 AND k.tablecode = ?3 AND k.blno = ?2")
	void UpdateStatusDinein(long shopid, double shopvno,long tablecode);

}
