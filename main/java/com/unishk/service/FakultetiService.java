package com.unishk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unishk.entity.Departamenti;
import com.unishk.entity.Fakulteti;
import com.unishk.repository.FakultetiRepository;

@Service
public class FakultetiService {
	
	
	@Autowired
	private FakultetiRepository repoFakulteti;

	public List<Fakulteti> listAll() {
		
		
		return  (List<Fakulteti>) repoFakulteti.findAll();
		
	}
	
	
public List<Fakulteti> listFakultete() {
		
		
		return   repoFakulteti.getFakultete();
		
	}

	public Fakulteti getFakultetById(int id) {
		
		return repoFakulteti.findById(id).get();
		
	}

	



	
	
	

}
