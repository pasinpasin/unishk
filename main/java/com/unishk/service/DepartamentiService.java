package com.unishk.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.unishk.entity.Departamenti;
import com.unishk.repository.DepartamentiRepository;

@Service
@Transactional
public class DepartamentiService {
	
	
	@Autowired
	private DepartamentiRepository depRepository;
	
	public Departamenti save(Departamenti dep) {
		
	
	return depRepository.save(dep);
	
	
}
	
	
	
 public Departamenti GetDepById(int id)
 {
	 
	 return depRepository.findById(id).get();
	 
 }
 
 
 public void delete(Integer id)  {
		
		
		depRepository.deleteById(id);
	}
 
	
	

}
