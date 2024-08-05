package org.hotel.app.service;

import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.RoomDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class RoomService {
	@Autowired
	private EntityManager entityManager;

	public List<RoomDetailsDTO> getRoomDetailsByCode(long shopid,int rtype, int rcode, int status) {
		StringBuilder qry = new StringBuilder();
		qry.append("SELECT new org.hotel.app.dto.RoomDetailsDTO(r.id, r.rname, r.rent, r.exrent, rt.rtname, f.flname,");
		qry.append("CASE WHEN r.status = 0 THEN 'Available' ELSE 'Booked' END as stname ) ");
		qry.append("FROM RoomMas r,RoomTypeMas rt,FloorMas f WHERE r.rtcode = rt.id And r.fcode = f.id  And r.shopid= :shopid ");

		if (rtype != 0) {
			qry.append(" AND r.rtcode = :rtype ");
		} else {
			qry.append(" AND r.rtcode not in (:rtype) ");
		}

		if (rcode != 0) {
			qry.append(" AND r.id = :rcode ");
		} else {
			qry.append(" AND r.id not in (:rcode) ");
		}

		if (status != 3) {
			qry.append(" AND r.status = :status ");
		} else {
			qry.append(" AND r.status not in (:status) ");
		}

		Query query = entityManager.createQuery(qry.toString());

		query.setParameter("shopid", shopid);
		query.setParameter("rtype", rtype);
		query.setParameter("rcode", rcode);
		query.setParameter("status", status);
		
		System.out.println(qry.toString());
		
		
		return query.getResultList();
	}
	public List<RoomDetailsDTO> getRoomDetailsByCodelike(long shopid,int rtype, int rcode, int status, String keyword) {
		StringBuilder qry = new StringBuilder();
		qry.append("SELECT new org.hotel.app.dto.RoomDetailsDTO(r.id, r.rname, r.rent, r.exrent, rt.rtname, f.flname,");
		qry.append("CASE WHEN r.status = 0 THEN 'Available' ELSE 'Booked' END as stname ) ");
		qry.append("FROM RoomMas r,RoomTypeMas rt,FloorMas f WHERE r.rtcode = rt.id And r.fcode = f.id And r.shopid= :shopid ");

		if (rtype != 0) {
			qry.append(" AND r.rtcode = :rtype ");
		} else {
			qry.append(" AND r.rtcode not in (:rtype) ");
		}

		if (rcode != 0) {
			qry.append(" AND r.id = :rcode ");
		} else {
			qry.append(" AND r.id not in (:rcode) ");
		}

		if (status != 3) {
			qry.append(" AND r.status = :status ");
		} else {
			qry.append(" AND r.status not in (:status) ");
		}

			qry.append("AND r.rname LIKE :keyword ");
		
		Query query = entityManager.createQuery(qry.toString());

		query.setParameter("rtype", rtype);
		query.setParameter("rcode", rcode);
		query.setParameter("status", status);
		query.setParameter("shopid", shopid);
		query.setParameter("keyword", "%" + keyword + "%"); 

		
		System.out.println(qry.toString());
		return query.getResultList();
	}

}
