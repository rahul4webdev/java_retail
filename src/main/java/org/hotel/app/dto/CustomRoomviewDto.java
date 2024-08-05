package org.hotel.app.dto;

import lombok.Data;

@Data
public class CustomRoomviewDto 
{
	private RoomTypeMas roomtypeMas;
	private String roomMas;
	
	public CustomRoomviewDto(RoomTypeMas roomtypeMas,String roomMas) {
		this.roomMas = roomMas;
		this.roomtypeMas = roomtypeMas;
	}
	
	
}
