package org.hotel.app.service;

import java.sql.Date;
import java.util.List;

import org.hotel.app.dto.Api;
import org.hotel.app.dto.BillMas;
import org.hotel.app.dto.CheckInMas;
import org.hotel.app.dto.Rpt_Billreport_DTO;
import org.hotel.app.repository.BillMasRepo;
import org.hotel.app.repository.CheckInRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class Rpt_Billreport_Srv 
{

	
	private final BillMasRepo Repo;

	@Autowired
	public Rpt_Billreport_Srv(BillMasRepo Repo) {
		this.Repo = Repo;
	}

	public BillMas saveBill(BillMas Mas) {
		Long maxShopResNo = Repo.findMaxShopVnoByShopId(Mas.getShopid());

		long shopResNo = (maxShopResNo != null) ? maxShopResNo + 1 : 1;

		Mas.setShopvno(shopResNo);

		return Repo.save(Mas);
	}
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Rpt_Billreport_DTO> Billinview(long shopid,Date fromdate, Date todate, int status) {
		StringBuilder qr = new StringBuilder();
		qr.append("select b, Case when b.status=0 then 'Billed' when b.status=1 then 'Trash' When b.status=2 then 'Cancelled' end as statusname from BillMas b "); 
		qr.append("where b.bldate between :fromdate and :todate and b.shopid = :shopid ");

		if (status != 3) {
			qr.append(" AND b.status = :status ");
		} else {
			qr.append(" AND b.status not in (:status) ");
		}
		
		Query query = entityManager.createQuery(qr.toString());
		query.setParameter("shopid", shopid);
		query.setParameter("fromdate", fromdate);
		query.setParameter("todate", todate);
		query.setParameter("status", status);

		return query.getResultList();
	}


}
