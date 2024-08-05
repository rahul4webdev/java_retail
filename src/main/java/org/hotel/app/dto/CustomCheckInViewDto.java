package org.hotel.app.dto;

import lombok.Data;

@Data
public class CustomCheckInViewDto 
{
	private CheckInMas checkInMas;
    private RoomMas roomMas;
	private String roomName;
	private String statusName;


    public CustomCheckInViewDto(CheckInMas checkInMas, String roomName, String statusName) {
        this.checkInMas = checkInMas;
        this.roomName = roomName;
        this.statusName = statusName;
    }

} 
