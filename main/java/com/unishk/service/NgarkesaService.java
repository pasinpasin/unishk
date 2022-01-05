package com.unishk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unishk.entity.Ngarkesa;
import com.unishk.entity.NgarkesePermbajtja;
import com.unishk.repository.NgarkesaRepository;
import com.unishk.repository.NgarkesePermbajtjaRepository;


@Service
@Transactional
public class NgarkesaService {
	
	@Autowired private NgarkesaRepository repo;
	
	@Autowired private NgarkesePermbajtjaRepository repo2;
	
	
	
	
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
	 
	 public List<NgarkesePermbajtja> ListPermbajtje(int id)
	 {
		 
		 return  (List<NgarkesePermbajtja>) repo2.findNgarkesePermbajtjaById(id);
	 }
	 
	 public void updateStatus(Integer id, String newstatus) 
	 {
		 
		repo.setNgarkesaStatus(id, newstatus);
		 
	 }
	 
	 
	
	 
	 

}
