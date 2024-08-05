package org.hotel.app.dto;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDetailsDTO {
    private int id;
    private String name;
    private double rent;
    private double extraRent;
    private String rtname;
    private String flname;
    private String stname;
    
}
