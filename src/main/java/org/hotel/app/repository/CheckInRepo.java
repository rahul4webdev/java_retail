package org.hotel.app.repository;

import java.sql.Date;

import java.util.List;

import org.hotel.app.dto.CheckInMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Repository
public interface CheckInRepo extends JpaRepository<CheckInMas, Integer> {

	 @Query("SELECT MAX(c.shopvno) FROM CheckInMas c WHERE c.shopid = ?1")
	 Long findMaxShopVnoByShopId(long shopid);
	 
	@Query("select c, Case when c.status=0 then 'Check-IN' when c.status=1 then 'Check-OUT' When c.status=2 then 'Billed' end as statusname from CheckInMas c where 1=1 and (c.mobno like %?1% or c.gname like %?1% or c.gname like %?1%)")
	List<Object[]> findbyname(String keyword);

	@Query("select c, Case when c.status=0 then 'Check-IN' when c.status=1 then 'Check-OUT' When c.status=2 then 'Billed' end as statusname from CheckInMas c")
	List<Object[]> checkinview();

	@Query("select c, Case when c.status=0 then 'Check-IN' when c.status=1 then 'Check-OUT' When c.status=2 then 'Billed' end as statusname from CheckInMas c where c.status = 0")
	List<Object[]> checkoutview();

	@Transactional
	@Modifying
	@Query("update CheckInMas c set c.status = 2 where c.id = ?1")
	void updatecheckinstatusbill(int id);
	
	@Transactional
	@Modifying
	@Query("update CheckInMas c set c.status = 1 where c.id = ?1")
	void updatecheckinstatuscheckout(int id);

	
	@Transactional
	@Modifying
	@Query("update CheckInMas c set c.blno = ?1 where c.id = ?2")
	void updatecheckinstatuscheckoutBlno(int blno, int id);


	@Transactional
	@Modifying
	@Query("update CheckInMas c set c.roomdescription = ?1 where c.id = ?2")
	void updatecheckinroomnames(String newroomname, int id);

	
	@Transactional
	@Modifying
	@Query("update CheckInMas c set c.outdate = :outdate where c.id = :id")
	void updateCheckinStatusCheckoutBldate(@Param("outdate") Date outdate, @Param("id") int id);


}
