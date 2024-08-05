package org.hotel.app.dto;

import lombok.Data;

@Data
public class Rpt_checkin_DTO {
    private Object[] columns; 

    public Rpt_checkin_DTO(Object... columns) {
        this.columns = columns;
    }
}
