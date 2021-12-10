package com.unishk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.unishk.entity.Fakulteti;
import com.unishk.service.FakultetiService;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private FakultetiService fakultetiService;
	
	@ModelAttribute
	public void listFakultete(Model model)
	
	{
		List<Fakulteti> listFakultetet= fakultetiService.listFakultete();
		
		model.addAttribute("listFakultetet", listFakultetet);
		
		//return "index";
	}


}
