package com.unishk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unishk.service.PlanetMesimoreService;
import com.unishk.service.ProgramiService;

import com.unishk.entity.PlanetMesimore;
import com.unishk.entity.ProgrameStudimi;

@Controller
public class PlanetMesimoreController {
	
	
	@Autowired
	private ProgramiService programiservice;	
	
	@Autowired
	private PlanetMesimoreService planetService;
	
	@GetMapping("/planetmesimore/{id}")
	public String listPlanet(Model model, @PathVariable(name = "id") int id)
	
	{
		
		
	    ProgrameStudimi programi=  programiservice.GetProgById(id);
		
		List<PlanetMesimore> planet= new ArrayList<>(programi.getPlanetmesimore());

		
		model.addAttribute("programi", programi);
		model.addAttribute("planet", planet);
		
		return "planetmesimore";	
	}
	
	@GetMapping("/planetmesimore/new/{id}")
	public String newPlanMesimor(Model model, @PathVariable(name = "id") int id)
	
	
	{
		
		
		PlanetMesimore plani = new PlanetMesimore();
		
		plani.setProgrami(programiservice.GetProgById(id));
		
	
 	 
	
		model.addAttribute("plani", plani);
		
	
		
		//model.addAttribute("pageTitle", "New user page");
		return "shto_plan_form";
	}
	
	@PostMapping("/planetmesimore/save")
	public String savePlanMesimor(PlanetMesimore plani, RedirectAttributes redirectAttributes)
	
	
	{
	
		   
		     
		     planetService.save(plani);
		     int myid=plani.getProgrami().getId();
		   
			redirectAttributes.addFlashAttribute("message","plani u ruajt!");
			return "redirect:/planetmesimore/" + myid;
			
		
			
		}
	
	
	@GetMapping("/planetmesimore/edit/{id}")
	public String editPlanMesimor(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
	{
		
			
		
		
		PlanetMesimore plani = planetService.GetPlanById(id);
			
			model.addAttribute("plani", plani);
			
			//model.addAttribute("pageTitle", "Edit user page wth id" + " " + id);
			
			return "shto_plan_form";
		
		
	}
	

	


}
