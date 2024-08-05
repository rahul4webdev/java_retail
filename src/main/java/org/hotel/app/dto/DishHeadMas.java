package org.hotel.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "dishheadmas")
@Data
public class DishHeadMas
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String dhname;
	private int dtcode;
	@Column(nullable = false)
	private long shopid;

	@Column(nullable = false, unique = true)
	private String narration;
}
