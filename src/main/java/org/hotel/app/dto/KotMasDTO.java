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
@Table(name = "kotmas")
public class KotMasDTO 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private long shopid;
	@Column(nullable = false)
    private long shopvno;
	@CreationTimestamp
	private Date kotdate;
	@CreationTimestamp
	private Time kottime;
	private int kottype;
	@Column(nullable = false)
	private long rawcode;
	@Column(nullable = false)
	private double qty;
	@Column(nullable = false)
    private long status;
	@Column(nullable = false)
    private long blno;
	@Column(nullable = false)
    private long tablecode;
	private String tablename;
	@Column(nullable = false)
	private String itname;
	@Column(nullable = false)
	private String barcode;
	private String itemview;
	@Column(nullable = false)
	private double discperc;
	@Column(nullable = false)
	private double rate;
	@Column(nullable = false)
	private double gst;
	@Column(nullable = false)
	private double gstamt;
	@Column(nullable = false)
	private double ittotal;
	@Column(nullable = false)
	private double discamt;
	@Column(nullable = false)
	private double totqty;
	@Column(nullable = false)
	private double totgst;
	@Column(nullable = false)
	private double totdiscamt;
	@Column(nullable = false)
	private double roundoff;
	@Column(nullable = false)
	private double totordamt;
	
	@Column(nullable = false)
	private double cess;
	@Column(nullable = false)
	private double cessamt;

	@Column(nullable = false)
	private double servicechperc;
	@Column(nullable = false)
	private double servicechamt;
	@Column(nullable = false)
	private double totalservicechamt;

	@Column(nullable = false)
	private double taxableamt;
	@Column(nullable = false)
	private double totaltaxableamt;

	
	@Column(nullable = false)
	private double bldiscperc;
	@Column(nullable = false)
	private double bldiscamt;


	@Column(nullable = false)
	private double bldlvchperc;
	@Column(nullable = false)
	private double bldlvchamt;

	@Column(nullable = false)
	private double bldlvchamount;
	
	@Column(nullable = false)
	private double flatdiscount;

	
	
}
