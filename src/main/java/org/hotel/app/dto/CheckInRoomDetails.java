package org.hotel.app.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "checkinroomdetails")
public class CheckInRoomDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date chdate;
	private Date choutdate;
	private long rtype;
	private long rcode;
	private double rent;
	private double exbed;
	private double exbedch;
	private String Roomtypeview;
	private String Roomnoview;
	private long chid;
	private int status;
	@Column(nullable = false)
	private long shopid;

}
