package com.unishk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.unishk.entity.Ngarkesa;
import com.unishk.entity.NgarkesePermbajtja;
import com.unishk.entity.User;
import com.unishk.security.UnishkUserDetails;
import com.unishk.service.NgarkesePermbajtjaService;
import com.unishk.service.UserService;

@Controller
public class NgarkesePermbajtjaController {
	
	@Autowired private NgarkesePermbajtjaService ngarkesaService;
	
	@Autowired private UserService service;
	
	
	@GetMapping("/ngarkesat/{id}")
	public String listNgarkesat(Model model,  @AuthenticationPrincipal UnishkUserDetails userDetails, Integer id)
			
	{
		
		
		
	
		String email=userDetails.getUsername();
		User user =service.getByEmail(email);
		List<NgarkesePermbajtja> ngarkesat= new ArrayList<>(ngarkesaService.GetPermbajtjaById(id));
		if(	user.getRoles().stream()
				.anyMatch(r -> r.getName().equals("dekan_role")))
			{ 
				for(int i = 0 ; i < ngarkesat.size() ; i++){
					 
					 NgarkesePermbajtja  ngark = (NgarkesePermbajtja) ngarkesat.get(i);
					 
					 if (ngark.getNgarkese().getDepartamenti_ngarkesa().getFakulteti().getId() == user.getFakulteti().getId() )
							 { 
						 
							
						 model.addAttribute("ngarkesat", ngarkesat);
						 }
					 
				}
				
			}
			else
				
				if(	user.getRoles().stream()
						.anyMatch(r -> r.getName().equals("pergjdep_role")))
				{ 
					for(int i = 0 ; i < ngarkesat.size() ; i++){
						NgarkesePermbajtja  ngark = (NgarkesePermbajtja) ngarkesat.get(i);
						 
						 
						 if (ngark.getNgarkese().getDepartamenti_ngarkesa().getId() == user.getDepartamenti().getId())
								 { 
							 
								
							 model.addAttribute("ngarkesat", ngarkesat);
								 
							 }
						 
					}
					
				}
			
				else
					
					if(	user.getRoles().stream()
							.anyMatch(r -> r.getName().equals("user_role")))
					{ 
						for(int i = 0 ; i < ngarkesat.size() ; i++){
							NgarkesePermbajtja  ngark = (NgarkesePermbajtja) ngarkesat.get(i);
							 
							 
							 if 
									  (ngark.getNgarkese().getDepartamenti_ngarkesa().getId() == user.getDepartamenti().getId()
							   &&
							   ngark.getNgarkese().getDepartamenti_ngarkesa().getFakulteti().getId() == user.getFakulteti().getId())
									 
									 { 
								 
									
								 model.addAttribute("ngarkesat", ngarkesat);
									 
								 }
							 
						}
						
					}
					else
					{
						model.addAttribute("ngarkesat", ngarkesat);
					}
						
					
				
		
	
		
		
		model.addAttribute("user", user);
		
		return "ngarkesepermabjtja";	
	}





}
