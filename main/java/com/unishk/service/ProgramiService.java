package com.unishk.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unishk.entity.Departamenti;
import com.unishk.entity.ProgrameStudimi;

import com.unishk.repository.ProgrameStudimiRepository;

@Service
@Transactional
public class ProgramiService {
	
	@Autowired
	private ProgrameStudimiRepository programeRepo;
	
	public ProgrameStudimi save(ProgrameStudimi programi) {
		
	
	return programeRepo.save(programi);
	
	
}
	
	public ProgrameStudimi GetProgById(int id)
	 {
		 
		 return programeRepo.findById(id).get();
		 
	 }
	

}
