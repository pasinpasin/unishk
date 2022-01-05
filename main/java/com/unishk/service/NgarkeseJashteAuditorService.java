package com.unishk.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unishk.entity.NgarkeseJashteAuditor;
import com.unishk.repository.NgarkeseJashteAuditorRepository;

@Service
@Transactional
public class NgarkeseJashteAuditorService {
	
	@Autowired private NgarkeseJashteAuditorRepository repo;

	public NgarkeseJashteAuditor save(NgarkeseJashteAuditor ngarkesePermbajtja) {
		return repo.save(ngarkesePermbajtja);
		
	}

	public  NgarkeseJashteAuditor GetById(Integer id) {
		 return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
		
	}

}
