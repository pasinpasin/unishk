package com.unishk.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.unishk.entity.User;
import com.unishk.security.UnishkUserDetails;
import com.unishk.security.UnishkUserDetailsService;
import com.unishk.service.DepartamentiService;
import com.unishk.service.FakultetiService;
import com.unishk.service.UserService;



@Controller
public class DepartamentiController {
	
	@Autowired
	private FakultetiService fakultetiService;
	
	@Autowired
	private DepartamentiService depService;
	
	@Autowired private UserService service;
	
	
	

	
	
	@GetMapping("/fakultet/newdep/{id}")
	public String newUser(Model model, @PathVariable(name = "id") int id)
	
	
	{
		Departamenti depi = new Departamenti() ;
		Fakulteti  fakultet = fakultetiService.getFakultetById(id);
		
		depi.setFakulteti(fakultet);
		System.out.println(fakultet.getEmertimi());
		//depi.getFakulteti().getEmertimi()
		model.addAttribute("depi", depi);
		System.out.println(depi.getFakulteti().getEmertimi());
		
		//model.addAttribute("pageTitle", "New user page");
		return "dep_form";
	}
	
	@PostMapping("/departamenti/save")
	public String saveUser(Departamenti depi, RedirectAttributes redirectAttributes)
	
	
	{
	
		     depService.save(depi);
		     int myid=depi.getFakulteti().getId();
		     System.out.println(myid);
			redirectAttributes.addFlashAttribute("message","Departamenti u ruajt!");
			return "redirect:/fakultetet/" + myid;
			
		
			
		}
	
	@GetMapping("/departamenti/edit/{id}")
	public String editUser(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
	{
		
			
			Departamenti depi = depService.GetDepById(id);
			
			model.addAttribute("depi", depi);
			System.out.println(depi.getFakulteti().getEmertimi());
			//model.addAttribute("pageTitle", "Edit user page wth id" + " " + id);
			
			return "edit_dep_form";
		
		
	}
	
	@GetMapping("/departamenti/delete/{id}")
	public String DeleteDep(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
	{
		
		int myid=depService.GetDepById(id).getFakulteti().getId();
			depService.delete(id);
			redirectAttributes.addFlashAttribute("message","Departamenti u fshi");
			
			
		
			return "redirect:/fakultetet/" + myid;
		
		
	}
	
	@GetMapping("/departamenti/{id}")
	public String listProgramet(Model model, @PathVariable(name = "id") int id, @AuthenticationPrincipal UnishkUserDetails userDetails)
			
	{
		
		
		Departamenti depi = depService.GetDepById(id);
	
		String email=userDetails.getUsername();
		User user =service.getByEmail(email);
		List<ProgrameStudimi> programet= ProgrameStudimiDTO(new ArrayList<>(depi.getProgrameStudimi()), user);
		
		
	
		model.addAttribute("depi", depi);
		model.addAttribute("programet", programet);
		model.addAttribute("user", user);
		
		return "departamenti";	
	}

	private List<ProgrameStudimi> ProgrameStudimiDTO(ArrayList arrayList, User user) {
		
		List<ProgrameStudimi> rezultati = new ArrayList<>();
		
	if(	user.getRoles().stream()
		.anyMatch(r -> r.getName().equals("dekan_role")))
	{ 
		for(int i = 0 ; i < arrayList.size() ; i++){
			 ProgrameStudimi prog = (ProgrameStudimi) arrayList.get(i);
			 
			 
			 if (prog.getDepartamenti().getFakulteti().getId() == user.getFakulteti().getId() )
					 { 
				 
					
				 rezultati.add(prog);
					 
				 }
			 
		}
		
	}
	else
		
		if(	user.getRoles().stream()
				.anyMatch(r -> r.getName().equals("pergjdep_role")))
		{ 
			for(int i = 0 ; i < arrayList.size() ; i++){
				 ProgrameStudimi prog = (ProgrameStudimi) arrayList.get(i);
				 
				 
				 if (prog.getDepartamenti().getId() == user.getDepartamenti().getId())
						 { 
					 
						
					 rezultati.add(prog);
						 
					 }
				 
			}
			
		}
	
		else
			
			if(	user.getRoles().stream()
					.anyMatch(r -> r.getName().equals("user_role")))
			{ 
				for(int i = 0 ; i < arrayList.size() ; i++){
					 ProgrameStudimi prog = (ProgrameStudimi) arrayList.get(i);
					 
					 
					 if (
					    prog.getDepartamenti().getId() == user.getDepartamenti().getId()
					   &&
					    prog.getDepartamenti().getFakulteti().getId() == user.getFakulteti().getId()
							 )
							 { 
						 
							
						 rezultati.add(prog);
							 
						 }
					 
				}
				
			}
				
			
		
		
		
	
		
		
		
	return rezultati;
	

}
}
