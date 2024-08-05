package org.hotel.app.dto;

import lombok.Data;

@Data
public class View_DTO 
{
	  private Object[] columns; 

	    public View_DTO(Object... columns) {
	        this.columns = columns;
	    }


}
