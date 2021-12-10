package com.unishk.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unishk.entity.Departamenti;
import com.unishk.entity.PlanPermbajtja;
import com.unishk.entity.PlanetMesimore;
import com.unishk.repository.PlanPermbajtjaRepository;

@Service
@Transactional
public class PlanPermbajtjaService {
	
	
	@Autowired
	private PlanPermbajtjaRepository planrepo;
	
	
	public PlanPermbajtja save(PlanPermbajtja plani) {
		
		
	return planrepo.save(plani);
	
	
}
	
	
	 public PlanPermbajtja GetById(int id)
	 {
		 
		 return planrepo.findById(id).get();
		 
	 }
	 
	 
	 public void delete(Integer id)  {
			
			
			planrepo.deleteById(id);
		}
	
	

}
