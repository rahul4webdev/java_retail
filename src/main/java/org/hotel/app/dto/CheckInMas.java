package org.hotel.app.dto;

import java.sql.Date;
import java.sql.Time;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "checkinmas")
public class CheckInMas
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String gname;
	private String cname;
	@Column(nullable = false)
	private String add1;
	private String add2;
	private String documentno;
	private String documentpath;
	@Column(nullable = false)
	private long mobno;
	private String gstno;
	private String email;
	private Date indate;
	@CreationTimestamp
	private Time intime;
	@Column(nullable = false)
	private int mg;
	@Column(nullable = false)
	private int fg;
	@Column(nullable = false)
	private int cg;
	@Column(nullable = false)
	private int stday;
	@Column(nullable = false)
	private double discount;
	@Column(nullable = false)
	private double advance;
	private String paidby;
	private String remarks;
	private String resvno;
	private String roomdescription;
	private String roomdescriptioncode;
	@Column(nullable = false)
	private int status;
	private Date outdate;
	private double blno;
    @Column(nullable = false)
    private long shopid;
    @Column(nullable = false)
    private long shopvno;
    @Column(nullable = false, unique = true)
    private String narration;
    @Column(nullable = false)
    private long acccode;
}
