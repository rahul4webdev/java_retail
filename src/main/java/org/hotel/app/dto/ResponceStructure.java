package org.hotel.app.dto;


import lombok.Data;

@Data
public class ResponceStructure<T>
{
	public boolean status;
	public int statusCode;
	public String msg;
	public String desc;
	public T data;
	public long id;
	
}
