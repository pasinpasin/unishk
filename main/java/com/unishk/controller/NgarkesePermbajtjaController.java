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

import com.unishk.entity.Ngarkesa;
import com.unishk.entity.NgarkeseJashteAuditor;
import com.unishk.entity.NgarkesePermbajtja;
import com.unishk.entity.PlanPermbajtja;
import com.unishk.entity.PlanetMesimore;
import com.unishk.entity.User;
import com.unishk.security.UnishkUserDetails;
import com.unishk.service.NgarkesaService;
import com.unishk.service.NgarkesePermbajtjaService;
import com.unishk.service.UserService;

@Controller
public class NgarkesePermbajtjaController {
	
	@Autowired private NgarkesePermbajtjaService ngarkesePermbajtjaService;
	@Autowired private NgarkesaService  ngarkesaService;
	
	@Autowired private UserService service;
	
	
	@GetMapping("/ngarkesa/edit/{id}")
	public String NdertoNgarkesePermbajtje(Model model,  @AuthenticationPrincipal UnishkUserDetails userDetails,  @PathVariable(name = "id") int id)
			
	{
		
		
	
		
	
		
		String email=userDetails.getUsername();
		User user =service.getByEmail(email);
		Ngarkesa ngarkese= NgarkesaDTO(ngarkesaService.GetById(id),user);
		if (ngarkese !=null)
		{
		List<NgarkesePermbajtja> permbajtja= new ArrayList<>(ngarkese.getNgarkesePermbajtja());
		NgarkeseJashteAuditor  permbajtja2= ngarkese.getNgarkesejashteauditor();
		
		Double totAuditor = (ngarkese.getTotAuditor() == null ? 0.0: ngarkese.getTotAuditor());
		Double totJashteAuditor=ngarkese.getNgarkesejashteauditor() == null ? 0.0 : ngarkese.getNgarkesejashteauditor().getShuma() ;
		
		
		
		
						model.addAttribute("ngarkese", ngarkese);
						model.addAttribute("permbajtja", permbajtja);
						model.addAttribute("permbajtja2", permbajtja2);
						model.addAttribute("totAuditor", totAuditor);
						model.addAttribute("totJashteAuditor", totJashteAuditor);
						model.addAttribute("user", user);
						
						
		}		
				
		
	
		
		
	
		return "ngarkesepermbajtja2";	
	}
	
	   @GetMapping("/ngarkesepermbajtja/new/{id}")
		public String newPlanPermbajtjeRresht(Model model, @PathVariable(name = "id") int id)
		
		
		{
		
			
		Ngarkesa ngarkese=ngarkesaService.GetById(id);
        NgarkesePermbajtja ngarkesePermbajtja= new NgarkesePermbajtja();
        ngarkesePermbajtja.setNgarkese(ngarkese);
	
			
			model.addAttribute("ngarkesePermbajtja", ngarkesePermbajtja);
			//model.addAttribute("ngarkese", ngarkese);
		
			
		
			
			//model.addAttribute("pageTitle", "New user page");
			return "shto_ngarkesepermbajtje";
		}
	   
	   @PostMapping("/ngarkesepermbajtja/save")
		public String saveNgarkesePermbajtje(NgarkesePermbajtja ngarkesePermbajtja, RedirectAttributes redirectAttributes)
		
		
		{
		
			    
		   ngarkesePermbajtjaService.save(ngarkesePermbajtja);
			     int myid=ngarkesePermbajtja.getNgarkese().getId();
			   
				redirectAttributes.addFlashAttribute("message","Rreshti u ruajt!");
				return "redirect:/ngarkesa/edit/" + myid;
				
			
				
			}
	    
	    @GetMapping("/ngarkesepermbajtja/edit/{id}")
		public String editNgarkesePermbajtja(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
		{
			
				
				
	    	NgarkesePermbajtja ngarkesePermbajtja = ngarkesePermbajtjaService.GetById(id);
				
	    	model.addAttribute("ngarkesePermbajtja", ngarkesePermbajtja);
		
				//model.addAttribute("pageTitle", "Edit user page wth id" + " " + id);
				
				return "shto_ngarkesepermbajtje";
			
			
		}
		
		@GetMapping("/ngarkesepermbajtja/delete/{id}")
		public String DeleteNgarkesePermbajtja(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
		{
			
			
			int myid= ngarkesePermbajtjaService.GetById(id).getNgarkese().getId();
			
			
			
				ngarkesePermbajtjaService.delete(id);
				redirectAttributes.addFlashAttribute("message","Rreshti u fshi");
				
				
			
				return "redirect:/ngarkesepermbajtja/" + myid;
			
			
		}
		
		private Ngarkesa NgarkesaDTO(Ngarkesa ngarkese, User user) {
			
			//List<Ngarkesa> rezultati = new ArrayList<>();
			
			if(	user.getRoles().stream()
				.anyMatch(r -> r.getName().contains("dekan_role")))
			{ 
				
					 
					 
					 if (ngarkese.getDepartamenti_ngarkesa().getFakulteti().getId() == user.getFakulteti().getId() )
							 { 
						 
							
						 return ngarkese;
							 
						 }
					 
				
				
			}
			else
				
				if(	user.getRoles().stream()
						.anyMatch(r -> r.getName().contains("pergjdep_role")))
				{ 
					
						 
						 
						 if (ngarkese.getDepartamenti_ngarkesa().getId() == user.getDepartamenti().getId())
								 { 
							 
								
							 return ngarkese;
								 
							 }
						 
					
					
				}
			
				else
					
					if(	user.getRoles().stream()
							.anyMatch(r -> r.getName().contains("pedagog_role")))
					{ 
						
							 
							 
							 if  (user.getId() == ngarkese.getUser().getId())
							   
									
									 { 
								 
									
								return ngarkese;
									 
								 }
							 
					
						
					}
			
					else
						
						if(	user.getRoles().stream()
								.anyMatch(r -> r.getName().contains("kurrikula_role")))
						{ 
							
								 
								 
								 if  ( ngarkese.getStatus().equalsIgnoreCase("Perfunduar"))
								   
										
										 { 
									 
										
									 return ngarkese;
										 
									 }
								 
							
							
						}
						
					
				
				
				
			
				
				
				
			return null;
			
			
		}





}
