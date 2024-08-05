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
@Table(name = "logbookmas")
public class LogbookMas
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@CreationTimestamp
	private Date logdate;
	@CreationTimestamp
	private Time logtime;
	private String onform;
	private String operation;
	private String newdesc;
	private String olddesc;
	private String usercode;
	private String computername;
	@Column(nullable = false)
    private long shopid;
}
