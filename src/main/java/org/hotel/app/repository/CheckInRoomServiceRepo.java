package org.hotel.app.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.hotel.app.dto.CheckInRoomServiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
@Repository
public interface CheckInRoomServiceRepo extends JpaRepository<CheckInRoomServiceDetails, Integer>
{
	
	@Query("SELECT MAX(c.shopvno) FROM CheckInRoomServiceDetails c WHERE c.shopid = ?1")
	 Long findMaxShopVnoByShopId(long shopid);
	
	@Query("SELECT c FROM CheckInRoomServiceDetails c WHERE c.shopid = ?1 AND c.orddate = ?2 AND c.shopvno=?3 ")
	List<CheckInRoomServiceDetails> findone(long shopid, Date sdate, double shopvno);

	@Query("SELECT c FROM CheckInRoomServiceDetails c WHERE c.shopid = ?1 AND c.chid = ?2 group by c.totordamt,c.shopvno,c.shopid,c.chid")
	List<CheckInRoomServiceDetails> serviceTotalAmt(long shopid, long chid);
	
	@Transactional
	@Modifying
	@Query("delete from CheckInRoomServiceDetails c WHERE c.shopid = ?1 AND c.orddate = ?2 AND c.shopvno=?3 ")
	void findonedelete(long shopid, Date sdate, double shopvno);

}
