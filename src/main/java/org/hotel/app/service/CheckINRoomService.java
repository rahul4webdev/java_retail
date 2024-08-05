package org.hotel.app.service;

import java.sql.Date;
import java.util.List;

import org.hotel.app.dto.CheckInRoomServiceDetails;
import org.hotel.app.dto.View_DTO;
import org.hotel.app.repository.CheckInRoomServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
@Service
public class CheckINRoomService 
{
	private final CheckInRoomServiceRepo Repo;
	
	@Autowired
	public CheckINRoomService(CheckInRoomServiceRepo Repo) {
		this.Repo = Repo;
	}

	public List<CheckInRoomServiceDetails> saveCheckIn(List<CheckInRoomServiceDetails> checkInRoomServiceDetails) {
	    Long maxShopResNo = Repo.findMaxShopVnoByShopId(checkInRoomServiceDetails.get(0).getShopid());
	    long shopResNo = (maxShopResNo != null) ? maxShopResNo + 1 : 1;

	    for (CheckInRoomServiceDetails details : checkInRoomServiceDetails) {
	        details.setShopvno(shopResNo);
	    }

	    return Repo.saveAll(checkInRoomServiceDetails);
	}



	@Autowired
	private EntityManager entityManager;
	
	public List<View_DTO> ServiceView(long shopid, Date fromdate, Date todate) {
	    StringBuilder qr = new StringBuilder();
	    qr.append("select s.roomnoview,s.chid,s.itemview,s.guestname,s.guestmob,s.orddate,MAX(s.ordtime) as ordtime,s.totordamt,s.totqty,s.totordamt,s.shopvno,s.partyblno,s.partybldate from CheckInRoomServiceDetails s where s.shopid = :shopid ");
	    qr.append(" and s.orddate between :fromdate and :todate");
	    qr.append(" group by s.roomnoview,s.chid,s.itemview,s.guestname,s.guestmob,s.orddate,s.totordamt,s.totqty,s.shopvno order by s.id desc");
	    Query query = entityManager.createQuery(qr.toString());
	    System.out.println(qr.toString());
	    query.setParameter("shopid", shopid);
	    query.setParameter("fromdate", fromdate);
	    query.setParameter("todate", todate);
	    return query.getResultList();
	}

	public List<View_DTO> viewdataOnePrint(long shopid, long shopvno) {
	    StringBuilder qr = new StringBuilder();
	    qr.append("select s.roomnoview,s.rawname,s.qty,s.chid,s.itemview,s.guestname,s.guestmob,s.orddate,s.ordtime,s.totordamt,s.totqty,Case when c.status=0 then 'Check-In' when c.status=1 then 'Check-Out' When c.status=2 then 'Billed' end as statusname,s.totordamt,s.shopvno from CheckInRoomServiceDetails s inner join CheckInMas c on c.id = s.chid where s.shopid = :shopid and c.shopid = :shopid ");
	    qr.append(" and s.shopvno =:shopvno ");
	    qr.append(" order by s.id");
	    Query query = entityManager.createQuery(qr.toString());
	    System.out.println(qr.toString());
	    query.setParameter("shopid", shopid);
	    query.setParameter("shopvno", shopvno);
	    return query.getResultList();
	}
	
	public List<View_DTO> ServiceViewSearch(long shopid, Date fromdate, Date todate, String keyword) {
	    StringBuilder qr = new StringBuilder();
	    qr.append("select s.roomnoview,s.chid,s.itemview,s.guestname,s.guestmob,s.orddate,MAX(s.ordtime) as ordtime,s.totordamt,s.totqty,Case when c.status=0 then 'Check-In' when c.status=1 then 'Check-Out' When c.status=2 then 'Billed' end as statusname,s.totordamt,s.shopvno from CheckInRoomServiceDetails s inner join CheckInMas c on c.id = s.chid where s.shopid = :shopid and c.shopid = :shopid");
	    qr.append(" and s.orddate between :fromdate and :todate");
	    qr.append(" and s.roomnoview LIKE :keyword ");
	    qr.append(" group by s.roomnoview,s.chid,s.itemview,s.guestname,s.guestmob,s.orddate,s.totordamt,s.totqty,s.shopvno order by s.id desc");
	    Query query = entityManager.createQuery(qr.toString());
	    System.out.println(qr.toString());
	    query.setParameter("shopid", shopid);
	    query.setParameter("fromdate", fromdate);
	    query.setParameter("todate", todate);
	    query.setParameter("keyword", "%" + keyword + "%");
	    return query.getResultList();
	}

	public List<View_DTO> ServiceViewTotalBYID(long shopid, Date fromdate, Date todate) {
	    StringBuilder qr = new StringBuilder();
	    qr.append("select s.roomnoview,s.chid,s.itemview,s.guestname,s.guestmob,s.orddate,MIN(s.ordtime) as ordtime,s.totordamt,s.totqty,Case when c.status=0 then 'Check-In' when c.status=1 then 'Check-Out' When c.status=2 then 'Billed' end as statusname from CheckInRoomServiceDetails s inner join CheckInMas c on c.id = s.chid where s.shopid = :shopid and c.shopid = :shopid");
	    qr.append(" and s.orddate between :fromdate and :todate");
	    
	    qr.append(" group by s.roomnoview,s.chid,s.itemview,s.guestname,s.guestmob,s.orddate,s.totordamt,s.totqty");
	    Query query = entityManager.createQuery(qr.toString());
	    System.out.println(qr.toString());
	    query.setParameter("shopid", shopid);
	    query.setParameter("fromdate", fromdate);
	    query.setParameter("todate", todate);
	    return query.getResultList();
	}
}
