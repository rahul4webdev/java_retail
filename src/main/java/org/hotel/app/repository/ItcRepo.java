package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.ItcMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ItcRepo extends JpaRepository<ItcMas, Integer>{
	@Query("select c from ItcMas c where c.itcname like %?1%")
	List<ItcMas> findName(String keyword);
}
