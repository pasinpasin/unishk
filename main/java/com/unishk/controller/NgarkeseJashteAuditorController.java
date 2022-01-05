package com.unishk.controller;



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
import com.unishk.service.NgarkeseJashteAuditorService;
import com.unishk.service.NgarkesePermbajtjaService;
import com.unishk.service.UserService;

@Controller
public class NgarkeseJashteAuditorController {
	
	@Autowired private NgarkeseJashteAuditorService ngarkesePermbajtjaService;
	@Autowired private NgarkesaService  ngarkesaService;
	
	@Autowired private UserService service;
	
	
	@GetMapping("/ngarkesejashteauditor/edit/{id}")
	public String NdertoNgarkesePermbajtje(Model model,  @AuthenticationPrincipal UnishkUserDetails userDetails,  @PathVariable(name = "id") int id)
			
	{
		
		
	
		Ngarkesa ngarkese= ngarkesaService.GetById(id);
	
		
		String email=userDetails.getUsername();
		User user =service.getByEmail(email);
		//List<NgarkesePermbajtja> permbajtja= new ArrayList<>(ngarkese.getNgarkesePermbajtja());
		NgarkeseJashteAuditor  permbajtja2= ngarkese.getNgarkesejashteauditor();
		
		
		
		
						model.addAttribute("ngarkese", ngarkese);
					//	model.addAttribute("permbajtja", permbajtja);
						model.addAttribute("permbajtja2", permbajtja2);
						
					
				
		
	
		
		
		model.addAttribute("user", user);
		
		return "shto_ngarkesejashteauditor";	
	}
	
	   @GetMapping("/ngarkesejashteauditor/new/{id}")
		public String newPlanPermbajtjeRresht(Model model, @PathVariable(name = "id") int id)
		
		
		{
		
			
		Ngarkesa ngarkese=ngarkesaService.GetById(id);
        NgarkeseJashteAuditor ngarkesejashteauditorit= new NgarkeseJashteAuditor();
        ngarkesejashteauditorit.setNgarkesejashteauditor(ngarkese);
	
			
			model.addAttribute("ngarkesejashteauditorit", ngarkesejashteauditorit);
			//model.addAttribute("ngarkese", ngarkese);
		
			
		
			
			//model.addAttribute("pageTitle", "New user page");
			return "shto_ngarkesejashtauditor";
		}
	   
	   @PostMapping("/ngarkesejashteauditor/save")
		public String saveNgarkesePermbajtje(NgarkeseJashteAuditor ngarkesePermbajtja, RedirectAttributes redirectAttributes)
		
		
		{
		
			    
		   ngarkesePermbajtjaService.save(ngarkesePermbajtja);
			     int myid=ngarkesePermbajtja.getNgarkesejashteauditor().getId();
			   
				redirectAttributes.addFlashAttribute("message","Rreshti u ruajt!");
				return "redirect:/ngarkesa/edit/" + myid;
				
			
				
			}
	    
			
			  @GetMapping("/ngarkesejashteauditor/modifiko/{id}") 
			  public String ModifikoNgarkeseJashteAuditor(@PathVariable(name="id") Integer id,
			  RedirectAttributes redirectAttributes, Model model) {
			  
			  
			  
			  NgarkeseJashteAuditor ngarkesejashteauditorit =ngarkesePermbajtjaService.GetById(id);
			  
			  model.addAttribute("ngarkesejashteauditorit", ngarkesejashteauditorit);
			  
			  //model.addAttribute("pageTitle", "Edit user page wth id" + " " + id);
			  
			  return "shto_ngarkesejashtauditor";
			  
			  
			  }
			 
		
		@GetMapping("/ngarkesejashteauditor/delete/{id}")
		public String DeleteNgarkesePermbajtja(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
		{
			
			
			int myid= ngarkesePermbajtjaService.GetById(id).getNgarkesejashteauditor().getId();
			
			
			
			ngarkesePermbajtjaService.delete(id);
				redirectAttributes.addFlashAttribute("message","Rreshti u fshi");
				
				
			
				
					return "redirect:/ngarkesa/edit/" + myid;
			
			
		}





}
