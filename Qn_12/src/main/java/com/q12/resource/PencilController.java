package com.q12.resource;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.q12.model.Pencil;
import com.q12.service.PencilService;

@RestController
@RequestMapping("/")
public class PencilController {
	
	@Autowired
	PencilService service;

    
  

    @PostMapping("add")
    public String addPencilMethod(@RequestBody Pencil pencil) {
      service.addPencil(pencil);
        return "Hi " + pencil.getName() + " is added !";
    }
   

   

    @GetMapping("findall")
    public List<Pencil> getAllPencilMethod() {
        return service.findAllPencil();
    }

   
   
    @PutMapping("update")
    public Pencil updateuser( @RequestBody Pencil pencil )
	 {
		 return service.updatePencil(pencil);
	 	
	 }
    
    @DeleteMapping("/delete/{id}")
   public String deleteMyUserById(@PathVariable("id") int id)
    {
    	return service.deletePencilById(id);
    	
    }
    
    @GetMapping("/pencil/{id}")
   public Pencil getuser(@PathVariable int id)
	 		
	 {
		 return service.findPencilById(id);
		
	 }
    
 
    

}
