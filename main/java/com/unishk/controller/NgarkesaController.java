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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unishk.entity.Departamenti;
import com.unishk.entity.Ngarkesa;
import com.unishk.entity.PlanPermbajtja;
import com.unishk.entity.PlanetMesimore;
import com.unishk.entity.ProgrameStudimi;
import com.unishk.entity.User;
import com.unishk.exception.UserNotFoundException;
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
			.anyMatch(r -> r.getName().contains("dekan_role")))
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
					.anyMatch(r -> r.getName().contains("pergjdep_role")))
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
						.anyMatch(r -> r.getName().contains("pedagog_role")))
				{ 
					for(int i = 0 ; i < arrayList.size() ; i++){
						 Ngarkesa  ngark = (Ngarkesa) arrayList.get(i);
						 
						 
						 if  (user.getId() == ngark.getUser().getId())
						   
								
								 { 
							 
								
							 rezultati.add(ngark);
								 
							 }
						 
					}
					
				}
		
				else
					
					if(	user.getRoles().stream()
							.anyMatch(r -> r.getName().contains("kurrikula_role")))
					{ 
						for(int i = 0 ; i < arrayList.size() ; i++){
							 Ngarkesa  ngark = (Ngarkesa) arrayList.get(i);
							 
							 
							 if  ( ngark.getStatus()=="Perfunduar")
							   
									
									 { 
								 
									
								 rezultati.add(ngark);
									 
								 }
							 
						}
						
					}
					
				
			
			
			
		
			
			
			
		return rezultati;
		
		
	}
	
	@GetMapping("/ngarkesa/new/")
	public String newPlanMesimor(Model model, @AuthenticationPrincipal UnishkUserDetails userDetails)
	
	
	{
		
		
	
		Ngarkesa ngarkese= new Ngarkesa();
		
		String email=userDetails.getUsername();
		User user =service.getByEmail(email);
		List<User> pedagoget = service.listPedagogByDep(user.getDepartamenti());
		
model.addAttribute("ngarkese", ngarkese);
model.addAttribute("pedagoget", pedagoget);
model.addAttribute("user",user);
		
	
		
		//model.addAttribute("pageTitle", "New user page");
		return "shto_ngarkese_form";
	}
	
	@PostMapping("/ngarkese/save")
	public String savePlanMesimor(Ngarkesa ngarkese, RedirectAttributes redirectAttributes,Model model)
	
	
	{
	
		   
		     
		ngarkesaService.save(ngarkese);
		    // int myid=plani.getProgrami().getId();
		model.addAttribute("ngarkesat", ngarkese);
		   
			redirectAttributes.addFlashAttribute("message","ngarkesa u ruajt!");
			return "redirect:/ngarkesat/";
			
		
			
		}


	

}
