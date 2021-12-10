package com.unishk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unishk.entity.PlanetMesimore;
import com.unishk.entity.ProgrameStudimi;
import com.unishk.repository.PlanetMesimoreRepository;
import com.unishk.repository.ProgrameStudimiRepository;


@Service
@Transactional
public class PlanetMesimoreService {
	
	@Autowired
	private  PlanetMesimoreRepository planetrepo;
	
	
	public PlanetMesimore GetPlanById(int id)
	 {
		 
		 return  planetrepo.findById(id).get();
		 
	 }
	
	public PlanetMesimore save(PlanetMesimore plani) {
		
		
	return planetrepo.save(plani);
	
	
}
	

}
