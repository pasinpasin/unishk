package com.unishk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unishk.entity.Ngarkesa;

import com.unishk.repository.NgarkesaRepository;


@Service
@Transactional
public class NgarkesaService {
	
	@Autowired private NgarkesaRepository repo;
	
	
	
	
	public Ngarkesa save(Ngarkesa ngarkesa) {
		
		
	return repo.save(ngarkesa);
	
	
}
	
	public void delete(Integer id)  {
		
		
		repo.deleteById(id);
	}
	
	 public Ngarkesa GetById(int id)
	 {
		 
		 return repo.findById(id).get();
		 
	 }
	 
	 public List<Ngarkesa> ListAll()
	 {
		 
		 return (List<Ngarkesa>) repo.findAll();
		 
	 }
	 
	
	 
	 

}
