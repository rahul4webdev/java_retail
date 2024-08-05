package org.hotel.app.dao;

import java.util.List;

import org.hotel.app.dto.RoomMas;
import org.hotel.app.repository.RoomMasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class RoomMasDao{
	@Autowired
	private RoomMasRepo repo;
	
	
	public List<RoomMas> getAll()
	{
		return repo.findAll();
	}
	
	public List<RoomMas> findName(String keyword)
	{
		return repo.findName(keyword);
	}
	

	public RoomMas New(RoomMas roomMas)
	{
		return repo.save(roomMas);
	}
	

	public RoomMas Edit(RoomMas roomMas)
	{
		return repo.save(roomMas);
	}

	public RoomMas FindId(@PathVariable int id)
	{
		return repo.findById(id)
				.orElseThrow();
	}
	
	public String Delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Delete Sucessfull";
	}
	
	
}
