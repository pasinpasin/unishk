package com.unishk.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.unishk.entity.NgarkesePermbajtja;
import com.unishk.repository.NgarkesePermbajtjaRepository;

@Service
@Transactional
public class NgarkesePermbajtjaService {
	
	@Autowired private NgarkesePermbajtjaRepository repo;
	
	public NgarkesePermbajtja save(NgarkesePermbajtja ngarkesa) {
		
		
	return repo.save(ngarkesa);
	
	
}
	
public void delete(Integer id)  {
		
		
		repo.deleteById(id);
	}
	
public NgarkesePermbajtja GetById(int id)
{
	 
	 return repo.findById(id).get();
	 
}

public List<NgarkesePermbajtja> GetPermbajtjaById(int id)
{
	 
	 return (List<NgarkesePermbajtja>) repo.findNgarkesePermbajtjaById(id);
	 
}




}
