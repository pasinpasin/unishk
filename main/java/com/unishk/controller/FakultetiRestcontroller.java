package com.unishk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.unishk.entity.Departamenti;
import com.unishk.entity.Fakulteti;
import com.unishk.exception.DepartmentNotFoundException;
import com.unishk.exception.DepartmentNotFoundRestException;
import com.unishk.service.FakultetiService;

@RestController
public class FakultetiRestcontroller {
	
	@Autowired private FakultetiService fakultetiService;
	
	@GetMapping("/users/fakulteti/{id}/departamenti")
	public  List<DepartamentiDTO> listDepSipasFakultetit(@PathVariable(name = "id") Integer FId) throws DepartmentNotFoundRestException
	{
		List<DepartamentiDTO> listDep = new ArrayList<>();
	
			
			
			Fakulteti fakulteti= fakultetiService.getFakultetById(FId);
			Set<Departamenti> depList= fakulteti.getDepartamentet();
			for (Departamenti dep : depList) {
				DepartamentiDTO dto = new DepartamentiDTO(dep.getId(), dep.getEmertimi());
				listDep.add(dto);
			}

			return listDep;
	
			
			
			
		}
		
		
		}

		
			
		
		
	


