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
@Table(name = "checkinroomservicedetails")
public class CheckInRoomServiceDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private long chid;
	@Column(nullable = false)
	private long rcode;
	private String roomnoview;
	@CreationTimestamp
	private Date orddate;
	@CreationTimestamp
	private Time ordtime;
	@Column(nullable = false)
	private double rawcode;
	@Column(nullable = false)
	private String rawname;
	private String barcode;
	@Column(nullable = false)
	private double qty;
	@Column(nullable = false)
	private String partyblno;
	private Date partybldate;
	private double rate;
	private double gst;
	private double gstamt;
	@Column(nullable = false)
	private double discperc;
	@Column(nullable = false)
	private double discamt;
	@Column(nullable = false)
	private double roundoff;
	@Column(nullable = false)
	private double totdiscamt;
	private double ittotal;
	private double totqty;
	private double totgst;
	private double totordamt;
	private double shopvno;
	private String guestname;
	private String guestmob;
	private String guestadd;
	private String itemview;
	@Column(nullable = false)
	private long shopid;
	
}
