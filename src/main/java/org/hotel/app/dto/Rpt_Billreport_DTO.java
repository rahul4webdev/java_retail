package org.hotel.app.dto;

import lombok.Data;

@Data
public class Rpt_Billreport_DTO 
{
    private Object[] columns; 

    public Rpt_Billreport_DTO(Object... columns) {
        this.columns = columns;
    }


	
}
