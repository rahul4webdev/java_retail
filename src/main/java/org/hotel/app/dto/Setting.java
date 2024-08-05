package org.hotel.app.dto;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "config")
public class Setting
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private long gst5;
	@Column(nullable = false)
	private long gst12;
	@Column(nullable = false)
	private long gst18;
	@Column(nullable = false)
	private long gst28;


}
