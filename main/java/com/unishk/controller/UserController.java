package com.unishk.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
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

import com.unishk.entity.Fakulteti;
import com.unishk.entity.Role;
import com.unishk.entity.User;
import com.unishk.exception.UserNotFoundException;
import com.unishk.service.FakultetiService;
import com.unishk.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired FakultetiService fakultetiService;
	
	
	@GetMapping("/users")
	public String listFirstPage(Model model)
	
	{
		return listByPage(model, 1,"firstName","asc",null);
	}
	
	@GetMapping("/users/page/{pageNum}")
	public String listByPage(Model model, @PathVariable(name = "pageNum") int pageNum, 
			@Param("sortField") String sortField,
			@Param("sorDir") String sortDir, 
	        @Param("keyword") String keyword)
	      
	{
		 System.out.println(pageNum + sortField + sortDir + keyword);
		
		 
		
		
		//LOGGER.info("UserController | listByPage is started");
		Page<User> page= userService.listByPage(pageNum, sortField, sortDir, keyword);
		List<User> listUsers= page.getContent();
		
		long startCount= (pageNum - 1) * userService.USERS_PER_PAGE + 1;
		long endCount= startCount + userService.USERS_PER_PAGE - 1;
		if (endCount > page.getTotalElements())
		{
			endCount = page.getTotalElements();
					
		
		}
		
		String reverseSortDir= sortDir.equalsIgnoreCase("asc") ? "desc" : "asc";
		
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("startCount", startCount);
		model.addAttribute("endCount", endCount);
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", reverseSortDir);
		model.addAttribute("keyword", keyword);
		model.addAttribute("entityName", "Perdorues");
		
		
		

		return "users";	
	}
	
	@GetMapping("/users/new")
	public String newUser(Model model)
	
	
	{
		User user = new User();
		List<Fakulteti> fakultetet = fakultetiService.listFakultete();
		
		model.addAttribute("user", user);
		List<Role> listRoles = userService.ListRole();
		
		model.addAttribute("listRoles", listRoles);
		model.addAttribute("fakultetet", fakultetet);
		model.addAttribute("pageTitle", "New user page");
		return "userform";
	}
	
	
	@PostMapping("/users/save")
	public String saveUser(User user, RedirectAttributes redirectAttributes)
	
	
	{
		
		userService.save(user);
		redirectAttributes.addFlashAttribute("message","The user was saved sucessfully");
		return "redirect:/users";
		
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
	{
		try {
			User user= userService.get(id);
			List<Fakulteti> fakultetet = fakultetiService.listFakultete();
			model.addAttribute("user", user);
			model.addAttribute("pageTitle", "Edit user page wth id" + " " + id);
			model.addAttribute("fakultetet", fakultetet);
			List<Role> listRoles = userService.ListRole();
			model.addAttribute("listRoles", listRoles);
			return "userform";
		} catch (UserNotFoundException e) {
			redirectAttributes.addFlashAttribute("messageError",e.getMessage());
			return "redirect:/users";
		}
		
		
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable(name="id") Integer id, RedirectAttributes redirectAttributes, Model model)
	{
		try {
			 userService.delete(id);
				redirectAttributes.addFlashAttribute("message","The user was deleted sucessfully");
			
		
			
		
		} catch (UserNotFoundException e) {
			redirectAttributes.addFlashAttribute("message",e.getMessage());
			
		}
		
		return "redirect:/users";
	}
	

	

}
