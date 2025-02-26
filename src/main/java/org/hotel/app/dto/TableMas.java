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
@Table(name = "tablemas")
public class TableMas
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String tname;
	private int fcode;
	@Column(nullable = false)
	private long shopid;

	
	@Column(nullable = false, unique = true)
	private String narration;
	
	@Column(nullable = false)
	private int status;
	
}
