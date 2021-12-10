package com.unishk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.unishk.entity.PlanPermbajtja;
import com.unishk.entity.PlanetMesimore;
import com.unishk.repository.PlanPermbajtjaRepository;
import com.unishk.service.PlanetMesimoreService;

@RestController
public class PlanPermbajtjaRestController {
    
    @Autowired
    private PlanPermbajtjaRepository planpermbajtjarepo;
    
    @Autowired
    private PlanetMesimoreService planetMesimoreService;
    
    @PostMapping("/planpermbajtja2/save")
	public String save(@RequestBody PlanPermbajtja plani) {
	
		PlanPermbajtja savedplan= planpermbajtjarepo.save(plani);
		
		return String.valueOf(savedplan.getId());
	}
    
  

}
