package org.hotel.app.dto;

import java.sql.Date;
import java.sql.Time;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name = "reservationmas")
public class ReservationMas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date resdate;
    @CreationTimestamp
    private Time restime;
    private Date chdate;
    @Column(nullable = false)
    private long gmob;
    @Column(nullable = false)
    private String gname;
    @Column(nullable = false)
    private String add1;
    private String add2;
    private String email;
    @Column(nullable = false)
    private long rtype;
    @Column(nullable = false)
    private long rent;
    @Column(nullable = false)
    private long billamt;
    private long advance;
    private long discount;
    @Column(nullable = false)
    private int mg;
    @Column(nullable = false)
    private int fg;
    @Column(nullable = false)
    private int cg;
    @Column(nullable = false)
    private int stday;
    private String remarks;
    private String cname;
    private String paidby;
    private String gstno;
    private String documentno;
    @Column(nullable = false)
    private long shopid;
    @Column(nullable = false)
    private long shopresno;
    @Column(nullable = false, unique = true)
    private String narration;
    private String roomtypename;
    @Column(nullable = false)
    private long acccode;
    @Column(nullable = false)
    private long status;
}
