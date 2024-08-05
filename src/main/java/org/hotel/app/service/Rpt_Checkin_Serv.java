package org.hotel.app.service;

import java.sql.Date;
import java.util.List;

import org.hotel.app.dto.CheckInMas;
import org.hotel.app.dto.Rpt_checkin_DTO;
import org.hotel.app.repository.CheckInRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class Rpt_Checkin_Serv {

	private final CheckInRepo Repo;

	@Autowired
	public Rpt_Checkin_Serv(CheckInRepo Repo) {
		this.Repo = Repo;
	}

	public CheckInMas saveCheckIn(CheckInMas Mas) {
		Long maxShopResNo = Repo.findMaxShopVnoByShopId(Mas.getShopid());

		long shopResNo = (maxShopResNo != null) ? maxShopResNo + 1 : 1;

		Mas.setShopvno(shopResNo);

		return Repo.save(Mas);
	}

	@Autowired
	private EntityManager entityManager;

	public List<Rpt_checkin_DTO> checkinview(long shopid, Date fromdate, Date todate, int status) {
		StringBuilder qr = new StringBuilder();
		qr.append("select c, Case when c.status=0 then 'Check-In' when c.status=1 then 'Check-Out' When c.status=2 then 'Billed' end as statusname from CheckInMas c ");
		qr.append("where c.indate between :fromdate and :todate and shopid = :shopid");

		if (status != 3) {
			qr.append(" AND c.status = :status ");
		} else {
			qr.append(" AND c.status not in (:status) ");
		}
		Query query = entityManager.createQuery(qr.toString());
		query.setParameter("shopid", shopid);
		query.setParameter("fromdate", fromdate);
		query.setParameter("todate", todate);
		query.setParameter("status", status);

		return query.getResultList();
	}

	public List<Rpt_checkin_DTO> viewdatachkout(long shopid, int status) {
		StringBuilder qr = new StringBuilder();
		qr.append(
				"select c, Case when c.status=0 then 'Check-In' when c.status=1 then 'Check-Out' When c.status=2 then 'Billed' end as statusname from CheckInMas c where 1=1 and c.shopid = :shopid ");
		if (status != 3) {
			qr.append(" AND c.status = :status ");
		} else {
			qr.append(" AND c.status not in (:status) ");
		}
		Query query = entityManager.createQuery(qr.toString());
		query.setParameter("shopid", shopid);
		query.setParameter("status", status);
		return query.getResultList();
	}

	public List<Rpt_checkin_DTO> viewdatachkoutRoomName(long shopid) {
	    StringBuilder qr = new StringBuilder();
	    qr.append("select ch.Roomnoview as roomname, ch.chid as checkinid,c.gname as gname,c.mobno as mobno,c.add1 as add1,ch.rcode as roomcode from CheckInMas c, CheckInRoomDetails ch ");
	    qr.append("where c.id = ch.chid and c.status = 0 and c.shopid = ch.shopid and c.shopid = :shopid ");
	    qr.append("group by ch.Roomnoview, ch.chid");
	    Query query = entityManager.createQuery(qr.toString());
	    query.setParameter("shopid", shopid);
	    return query.getResultList();
	}
}
