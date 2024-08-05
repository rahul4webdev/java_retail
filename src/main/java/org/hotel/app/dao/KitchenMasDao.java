//package org.hotel.app.dao;
//
//import java.io.Serial;
//import java.util.List;
//
//import org.hotel.app.dto.KitchenMas;
//import org.hotel.app.repository.KitchenMasRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import lombok.Data;
//@Repository
//@Data
//public class KitchenMasDao 
//{
//	
//	@Autowired
//	private KitchenMasRepo repo;
//	
//	public List<KitchenMas> getAll()
//	{
//		return repo.findAll();
//	}
//	
//	public KitchenMas New(KitchenMas kitchenMas)
//	{
//		return repo.save(kitchenMas);
//	}
//	
//	public KitchenMas FindById(Integer id)
//	{
//		return repo.findById(id)
//				.orElseThrow();
//	}
//	
//	public KitchenMas Edit(KitchenMas kitchenMas)
//	{
//		return repo.save(kitchenMas);
//	}
//	
//	public String delete(@PathVariable Integer id)
//	{
//		  repo.deleteById(id);
//		return "delete Sucessfull";		
//	}
//	
//	public List<KitchenMas> findByName(String keyword)
//	{
//		 return repo.findName(keyword);
//	}
//	
//	public List<KitchenMas> findOne(String key)
//	{
//		return repo.findOne(key);
//	}
//
//}
