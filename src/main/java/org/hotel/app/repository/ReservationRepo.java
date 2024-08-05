package org.hotel.app.repository;

import java.util.List;

import org.hotel.app.dto.ReservationMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepo extends JpaRepository<ReservationMas, Integer> {

    @Query("select f from ReservationMas f where f.shopid = ?1 and f.gmob like %?2%")
    List<ReservationMas> findNamebyshopSrch(long shopid, String keyword);
    
    @Query("select f from ReservationMas f where f.shopid = ?1")
    List<ReservationMas> findNamebyshop(long shopid);

    @Query("SELECT MAX(f.shopresno) FROM ReservationMas f WHERE f.shopid = ?1")
    Long findMaxShopResNoByShopId(long shopid);


    @Query("SELECT f FROM ReservationMas f WHERE f.shopid = ?1 AND f.shopresno = ?2")
    ReservationMas findFirstByShopIdAndShopResNo(long shopid, int shopresno);


}
