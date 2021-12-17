package com.unishk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.unishk.entity.Departamenti;
import com.unishk.entity.Ngarkesa;
import com.unishk.entity.PlanPermbajtja;
import com.unishk.entity.PlanetMesimore;
import com.unishk.entity.ProgrameStudimi;
import com.unishk.entity.User;
import com.unishk.security.UnishkUserDetails;
import com.unishk.service.NgarkesaService;
import com.unishk.service.UserService;

@Controller
public class NgarkesaController {
	
	@Autowired private NgarkesaService ngarkesaService;
	
	@Autowired private UserService service;
	
	
	@GetMapping("/ngarkesat")
	public String listNagrkesat(Model model,  @AuthenticationPrincipal UnishkUserDetails userDetails)
			
	{
		
		
		
	
		String email=userDetails.getUsername();
		User user =service.getByEmail(email);
		List<Ngarkesa> ngarkesat= NgarkesaDTO(new ArrayList<>(ngarkesaService.ListAll()), user);
		
		
	
		
		model.addAttribute("ngarkesat", ngarkesat);
		model.addAttribute("user", user);
		
		return "ngarkesa";	
	}


	private List<Ngarkesa> NgarkesaDTO(ArrayList arrayList, User user) {
		
		List<Ngarkesa> rezultati = new ArrayList<>();
		
		if(	user.getRoles().stream()
			.anyMatch(r -> r.getName().equals("dekan_role")))
		{ 
			for(int i = 0 ; i < arrayList.size() ; i++){
				 Ngarkesa  ngark = (Ngarkesa) arrayList.get(i);
				 
				 
				 if (ngark.getDepartamenti_ngarkesa().getFakulteti().getId() == user.getFakulteti().getId() )
						 { 
					 
						
					 rezultati.add(ngark);
						 
					 }
				 
			}
			
		}
		else
			
			if(	user.getRoles().stream()
					.anyMatch(r -> r.getName().equals("pergjdep_role")))
			{ 
				for(int i = 0 ; i < arrayList.size() ; i++){
					 Ngarkesa  ngark = (Ngarkesa) arrayList.get(i);
					 
					 
					 if (ngark.getDepartamenti_ngarkesa().getId() == user.getDepartamenti().getId())
							 { 
						 
							
						 rezultati.add(ngark);
							 
						 }
					 
				}
				
			}
		
			else
				
				if(	user.getRoles().stream()
						.anyMatch(r -> r.getName().equals("user_role")))
				{ 
					for(int i = 0 ; i < arrayList.size() ; i++){
						 Ngarkesa  ngark = (Ngarkesa) arrayList.get(i);
						 
						 
						 if (
								 ngark.getDepartamenti_ngarkesa().getId() == user.getDepartamenti().getId()
						   &&
						   ngark.getDepartamenti_ngarkesa().getFakulteti().getId() == user.getFakulteti().getId()
								 )
								 { 
							 
								
							 rezultati.add(ngark);
								 
							 }
						 
					}
					
				}
					
				
			
			
			
		
			
			
			
		return rezultati;
		
		
	}


	

}
