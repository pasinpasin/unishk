package com.unishk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unishk.entity.Departamenti;
import com.unishk.entity.PlanPermbajtja;
import com.unishk.entity.PlanetMesimore;
import com.unishk.entity.ProgrameStudimi;

import com.unishk.service.PlanPermbajtjaService;
import com.unishk.service.PlanetMesimoreService;

import net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reducing;

@Controller
public class PlanPermbajtjaController {
    
@Autowired
private PlanetMesimoreService planetMesimoreService;

@Autowired
private PlanPermbajtjaService planPermbajtjaService;




    
    @GetMapping("/planpermbajtja/{id}")
	public String listPlanPermbajtja(Model model, @PathVariable(name = "id") int id)
			
	{
		
		
	PlanetMesimore planimesimor =	planetMesimoreService.GetPlanById(id);
	
		
		List<PlanPermbajtja> planPermbajtja = new ArrayList<>(planimesimor.getPlanPermbajtja());
		
		 Map<String,PlanPermbajtja> transform =
			        planPermbajtja.stream()
			           .collect(Collectors.toMap(PlanPermbajtja::getViti,
			                                     Function.identity(),
			                                     (b1,b2)->{ return new PlanPermbajtja( ("m".equals(b1.getTipi_veprimtarise())  ? 0.0 : b1.getKredite() )  + ("m".equals(b2.getTipi_veprimtarise())  ? 0.0 : b2.getKredite() ),
			                                    		 b1.getTotSem1Rresht()+ b2.getTotSem1Rresht(),
			                                    		 b1.getTotSem2Rresht()+ b2.getTotSem2Rresht()
			                                    		 
			                                    		 );
			                                    		 
			                                    		 }));
			        // End of Eran's code
			        transform.entrySet().forEach(e -> { 
			           System.out.println(e.getKey() + " : " + e.getValue()); 
			        });
			        
	        
			        
	       
	     
		  
		
		  
		 
		  
		  
		
		  
	        
	    
	        
		
		model.addAttribute("planimesimor", planimesimor);
		model.addAttribute("planPermbajtja",planPermbajtja);
		model.addAttribute("transform",transform);
		
		return "planpermajtja2";	
	}
    
    
    @GetMapping("/planpermbajtja/new/{id}/{viti}")
	public String newPlanPermbajtjeRresht(Model model, @PathVariable(name = "id") int id
		, @PathVariable(name = "viti") String viti)
	
	
	{
	
		
	PlanPermbajtja planPermbajtja = new PlanPermbajtja();	
	planPermbajtja.setViti(viti);
	//PlanetMesimore planimesimor =	planetMesimoreService.GetPlanById(id);
		
		
		
		planPermbajtja.setPlaniMesimor(planetMesimoreService.GetPlanById(id));
		model.addAttribute("planPermbajtja", planPermbajtja);
	
		
	
		
		//model.addAttribute("pageTitle", "New user page");
		return "shto_planpermbajtje";
	}
    
    @PostMapping("/planpermbajtja/save")
	public String savePlanPermbajtje(PlanPermbajtja plani, RedirectAttributes redirectAttributes)
	
	
	{
	
		    
    	planPermbajtjaService.save(plani);
		     int myid=plani.getPlaniMesimor().getId();
		   
			redirectAttributes.addFlashAttribute("message","planpermbajtja u ruajt!");
			return "redirect:/planpermbajtja/" + myid;
			
		
			
		}
    
    @GetMapping("/planpermbajtja/edit/{id}")
	public String editPlanPermbajtja(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
	{
		
			
			
    	PlanPermbajtja planPermbajtja = planPermbajtjaService.GetById(id);
			
    	model.addAttribute("planPermbajtja", planPermbajtja);
	
			//model.addAttribute("pageTitle", "Edit user page wth id" + " " + id);
			
			return "shto_planpermbajtje";
		
		
	}
	
	@GetMapping("/planpermbajtja/delete/{id}")
	public String DeletePlaPermbajtja(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
	{
		
		int myid= planPermbajtjaService.GetById(id).getPlaniMesimor().getId();
		
		
		
			planPermbajtjaService.delete(id);
			redirectAttributes.addFlashAttribute("message","Rreshti u fshi");
			
			
		
			return "redirect:/planpermbajtja/" + myid;
		
		
	}
    
    

}
