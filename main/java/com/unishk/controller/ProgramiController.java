package com.unishk.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import com.unishk.entity.Departamenti;
import com.unishk.entity.Fakulteti;
import com.unishk.entity.ProgrameStudimi;
import com.unishk.service.DepartamentiService;
import com.unishk.service.FakultetiService;
import com.unishk.service.ProgramiService;



@Controller
public class ProgramiController {
	
	@Autowired
	private ProgramiService programiService;
	
	@Autowired
	private DepartamentiService depService;
	
	
	

	
	
	@GetMapping("/programi/new/{id}")
	public String newProgram(Model model, @PathVariable(name = "id") int id)
	
	
	{
		
		ProgrameStudimi programi = new ProgrameStudimi();
	
 	   programi.setDepartamenti(depService.GetDepById(id));
	
		model.addAttribute("programi", programi);
	
		
		//model.addAttribute("pageTitle", "New user page");
		return "shto_program_form";
	}
	
	@PostMapping("/programi/save")
	public String saveProgram(ProgrameStudimi programi, RedirectAttributes redirectAttributes)
	
	
	{
	
		     programiService.save(programi);
		     int myid=programi.getDepartamenti().getId();
		   
			redirectAttributes.addFlashAttribute("message","programi u ruajt!");
			return "redirect:/departamenti/" + myid;
			
		
			
		}
	
	@GetMapping("/programi/edit/{id}")
	public String editProg(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
	{
		
			
		ProgrameStudimi programi = programiService.GetProgById(id);
			
			model.addAttribute("programi", programi);
			
			//model.addAttribute("pageTitle", "Edit user page wth id" + " " + id);
			
			return "shto_program_form";
		
		
	}
	
	@GetMapping("/programi/delete/{id}")
	public String DeleteDep(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
	{
		
		int myid=depService.GetDepById(id).getFakulteti().getId();
			depService.delete(id);
			redirectAttributes.addFlashAttribute("message","Departamenti u fshi");
			
			
		
			return "redirect:/fakultetet/" + myid;
		
		
	}
	
	@GetMapping("/programi/{id}")
	public String listPlanet(Model model, @PathVariable(name = "id") int id)
			
	{
		
		
		Departamenti depi = depService.GetDepById(id);
		List<ProgrameStudimi> programet= new ArrayList<>(depi.getProgrameStudimi());
		model.addAttribute("depi", depi);
		model.addAttribute("programet", programet);
		
		return "departamenti";	
	}
		
		
	
	

}
