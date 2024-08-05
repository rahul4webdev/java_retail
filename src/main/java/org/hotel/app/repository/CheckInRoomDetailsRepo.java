package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.CheckInRoomDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface CheckInRoomDetailsRepo  extends JpaRepository<CheckInRoomDetails, Integer>
{
	
	 
	
	@Query("select c from CheckInRoomDetails c where chid = ?1")
	List<CheckInRoomDetails> getroomdetbyidch(int id);

	@Transactional
	@Modifying
	@Query("delete from CheckInRoomDetails c where c.chid = ?1 and c.rcode = ?2")
	void getchehinroomdelete(int id,int rcode);

	@Transactional
	@Modifying
	@Query("delete from CheckInRoomDetails c where c.chid = ?1")
	void getchehinroomdeletechdetail(int id);

}
