package com.unishk.controller;

import java.io.IOException;
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
import com.unishk.service.DepartamentiService;
import com.unishk.service.FakultetiService;



@Controller
public class FakultetiController {
	
	@Autowired
	private FakultetiService fakultetiService;
	
	@Autowired
	private DepartamentiService depService;
	
	
	
	@GetMapping("/fakultetet/{id}")
	public String listDepartamentet(Model model, @PathVariable(name = "id") int id)
			
	{
		
		Fakulteti fakultet= fakultetiService.getFakultetById(id);
		List<Departamenti> departamentet= new ArrayList<>(fakultet.getDepartamentet());
		model.addAttribute("fakultet", fakultet);
		model.addAttribute("departamentet", departamentet);
		
		
		

		return "fakulteti";	
	}
	
	
	
		
		
	
	

}
