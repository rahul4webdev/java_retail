package org.hotel.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "itemmas")
public class ItemMaster
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String itname;
	@Column(nullable = false)
	private String barcode;
	private String hsncode;
	private String picture;
	private double takerate;
	private double restrate;
	private double dlvrate;
	private double onlinerate;
	private double purcrate;
	private double mrp;
	private double opstock;
	@Column(nullable = false)
	private double discperc;
	@Column(nullable = false)
	private double isfav;
	private int itg;
	private int itc;
	private int dtcode;
	private int kcode;
	private int gst;
	private int cess;
	@Column(nullable = false)
	private long shopid;

	@Column(nullable = false, unique = true)
	private String narration;
	
	@Column(nullable = false, unique = true)
	private String narration2;
}
