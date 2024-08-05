package org.hotel.app.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Table(name = "itgmas")
@Entity
public class ItgMas
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String groupname;
	@Column(nullable = false)
	private long shopid;
	@Column(nullable = false, unique = true)
	private String narration;

}
