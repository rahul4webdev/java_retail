package org.hotel.app.repository;

import java.sql.Date;
import java.util.List;

import org.hotel.app.dto.LogbookMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogBookRepo extends JpaRepository<LogbookMas, Integer>
{
	@Query("select l from LogbookMas l where l.logdate between ?1 and ?2 and l.shopid = ?3 order by l.id desc")
	List<LogbookMas> getAlldesc(Date fromdate, Date todate, long shopid);
}

