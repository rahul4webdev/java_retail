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
@Table(name = "salemas")
public class SaleMasDTO
{
//	Restaurant Bill
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@CreationTimestamp
	private Date entrydate;
	@CreationTimestamp
	private Time entrytime;
	@CreationTimestamp
	private Date bldate;
	@Column(nullable = false)
	private long bltype;
	private long custmob;
	private String custname;
	private String custadd1;
	private String custadd2;
	private String custgstno;
	private String tablename;
	private long tablecode;
	@Column(nullable = false)
	private double rawcode;
	@Column(nullable = false)
	private String itname;
	private String itemview;
	private String barcode;
	@Column(nullable = false)
	private double qty;
	@Column(nullable = false)
	private double rate;
	@Column(nullable = false)
	private double gst;
	@Column(nullable = false)
	private double gstamt;
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
	
	@Column(nullable = false)
	private double discperc;
	@Column(nullable = false)
	private double discamt;
	@Column(nullable = false)
	private double ittotal;
	private double roundoff;
	@Column(nullable = false)
	private double totdiscamt;
	@Column(nullable = false)
	private double totbldiscamt;
	@Column(nullable = false)
	private double totqty;
	@Column(nullable = false)
	private double totgst;
	@Column(nullable = false)
	private double totcess;
	@Column(nullable = false)
	private double totblamt;
    private long shopid;
    @Column(nullable = false)
    private long shopvno;
    private String narration;
    private long acccode;
    private long status;
    @Column(nullable = false)
    private long pay1code;
    @Column(nullable = false)
    private long pay1amt;
    
}
