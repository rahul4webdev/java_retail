package org.hotel.app.service;

import java.sql.Date;
import java.util.List;

import org.hotel.app.dto.View_DTO;
import org.hotel.app.repository.DishHeadMasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
@Service
public class Rpt_Dishhead_Serv 
{
	private final DishHeadMasRepo Repo;
	public Rpt_Dishhead_Serv(DishHeadMasRepo repo) {
		Repo = repo;
	}
	
	@Autowired
	private EntityManager entityManager;

	public List<View_DTO> Dishheadview(long shopid) {
		StringBuilder qr = new StringBuilder();
		qr.append("select dh,dt from DishHeadMas dh, DishTypeMas dt ");
		qr.append("where dh.dtcode = dt.id and dh.shopid = :shopid and dt.shopid = :shopid");
		Query query = entityManager.createQuery(qr.toString());
		query.setParameter("shopid", shopid);
		return query.getResultList();
	}

	public List<View_DTO> DishheadviewSearch(long shopid,String keyword) {
		StringBuilder qr = new StringBuilder();
		qr.append("select dh,dt from DishHeadMas dh, DishTypeMas dt ");
		qr.append("where dh.dtcode = dt.id and dh.shopid = :shopid and dt.shopid = :shopid ");
		qr.append(" AND dh.dhname LIKE :keyword ");
		Query query = entityManager.createQuery(qr.toString());
		query.setParameter("shopid", shopid);
		query.setParameter("keyword", "%" + keyword + "%"); 
		return query.getResultList();
	}

	
}
