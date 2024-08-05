package org.hotel.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "accmas")
@Data
public class AccMas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String accname;
	private String add1;
	private String add2;
	private long pcode;
	private String gstno;
	private long mobno;
	private String email;
	@Column(nullable = false)
	private long shopid;
	@Column(nullable = false, unique = true)
	private String narration;
}
