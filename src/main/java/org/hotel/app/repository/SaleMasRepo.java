package org.hotel.app.repository;

import java.sql.Date;
import java.util.List;

import org.hotel.app.dto.BillMas;
import org.hotel.app.dto.SaleMasDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface SaleMasRepo extends JpaRepository<SaleMasDTO, Integer> {
	@Query("SELECT MAX(b.shopvno) FROM SaleMasDTO b WHERE b.shopid = ?1")
	Long findMaxShopVnoByShopId(long shopid);

	@Query("select b,(SELECT t.tname FROM TableMas t WHERE t.id = b.tablecode AND t.shopid = b.shopid) AS tname,Case when b.bltype=1 then 'Dine-in' when b.bltype=2 then 'Delivery' When b.bltype=3 then 'Pickup' end as bltypename from SaleMasDTO b where b.status = :status and b.shopid = :shopid and b.bldate between :frdate and :todate group by b.shopvno")
	List<Object[]> billview(@Param("shopid") long shopid, @Param("status") int status, @Param("frdate") Date frdate,
			@Param("todate") Date todate);
	
	
//	@Query("select b.shopvno, b.status, b.shopid, b.bldate, (SELECT t.tname FROM TableMas t WHERE t.id = b.tablecode AND t.shopid = b.shopid) AS tname, Case when b.bltype=1 then 'Dine-in' when b.bltype=2 then 'Delivery' When b.bltype=3 then 'Pickup' end as bltypename from SaleMasDTO b where b.status = :status and b.shopid = :shopid and b.bldate between :frdate and :todate group by b.shopvno, b.status, b.shopid, b.bldate, tname, bltypename")
//	List<Object[]> billview(@Param("shopid") long shopid, @Param("status") int status, @Param("frdate") Date frdate, @Param("todate") Date todate);

	
	@Query("select b,(SELECT t.tname FROM TableMas t WHERE t.id = b.tablecode AND t.shopid = b.shopid) AS tname,Case when b.bltype=1 then 'Dine-in' when b.bltype=2 then 'Delivery' When b.bltype=3 then 'Pickup' end as bltypename,r from SaleMasDTO b,ItemMaster r where r.id = b.rawcode and b.shopid = :shopid and b.shopvno =:shopvno order by b.id")
	List<Object[]> RestbillviewOne(@Param("shopid") long shopid, @Param("shopvno") long shopvno);

	@Query("select b,(SELECT t.tname FROM TableMas t WHERE t.id = b.tablecode AND t.shopid = b.shopid) AS tname,Case when b.bltype=1 then 'Dine-in' when b.bltype=2 then 'Delivery' When b.bltype=3 then 'Pickup' end as bltypename from SaleMasDTO b where b.shopid = :shopid and b.pay1code =0 group by b.shopvno order by b.id desc")
	List<Object[]> RestbillviewPayment(@Param("shopid") long shopid);


	@Query("SELECT SUM(s.qty) AS TOTQTY, it FROM SaleMasDTO s,ItemMaster it WHERE s.shopid = :shopid and it.id=s.rawcode and s.shopid = it.shopid GROUP BY s.rawcode order by TOTQTY desc")
	List<Object[]> calculateTotalQuantity(@Param("shopid") long shopid);


	
	@Query("select b,(SELECT t.tname FROM TableMas t WHERE t.id = b.tablecode AND t.shopid = b.shopid) AS tname,Case when b.bltype=1 then 'Dine-in' when b.bltype=2 then 'Delivery' When b.bltype=3 then 'Pickup' end as bltypename from SaleMasDTO b where b.status = :status and b.shopid = :shopid and b.bldate between :frdate and :todate and (b.custmob like %:keyword% or b.custname like %:keyword% or b.custadd1 like %:keyword% or b.shopvno like %:keyword%) group by b.shopvno order by b.id desc")
	List<SaleMasDTO> billviewsearch(@Param("shopid") long shopid, @Param("status") int status,
			@Param("frdate") Date frdate, @Param("todate") Date todate, @Param("keyword") String keyword);

	@Transactional
	@Modifying
	@Query("update SaleMasDTO b set status = ?3 where b.shopid = ?1 AND b.shopvno = ?2")
	void updateSaleStatus(long shopid, long shopvno, int status);

	@Transactional
	@Modifying
	@Query("update SaleMasDTO b set pay1code = ?3 where b.shopid = ?1 AND b.shopvno = ?2")
	void updateBillPaymentStatus(long shopid, long shopvno, int paycode);

	
	@Transactional
	@Modifying
	@Query("delete from SaleMasDTO b where b.shopid = ?1 AND b.shopvno = ?2")
	void deleteSaleRestBill(long shopid, long shopvno);
	

}
