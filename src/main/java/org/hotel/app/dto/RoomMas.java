package org.hotel.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roommas")
public class RoomMas
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String rname;
	private int fcode;
	private int rtcode;
	@Column(nullable = false)
	private double rent;
	@Column(nullable = false)
	private double exrent;
	@Column(nullable = false)
	private int status;
	@Column(nullable = false)
	private long shopid;
	@Column(nullable = false, unique = true)
	private String narration;



}
