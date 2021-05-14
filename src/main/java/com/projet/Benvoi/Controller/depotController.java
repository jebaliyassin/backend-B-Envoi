package com.projet.Benvoi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.Benvoi.Model.Depot;
//import com.projet.Benvoi.Model.Tarif;
//import com.projet.Benvoi.Model.Depot;
import com.projet.Benvoi.Service.DepotService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class depotController {
	@Autowired DepotService depotService;
	
	 
	 
	 
	 @GetMapping("/depots")
	    public List<Depot> list() {
		 System.out.println("Get all Depots...");
	             return depotService.getAll();
	   }
	 

	 @GetMapping("/depots/{code}")
	    public List<Depot> listDepot(@PathVariable String code) {
		 System.out.println("Get all Depots...");
	             return depotService.findAllByCode(code);
	   }
	 	 
	 @GetMapping("/depots/{id}")
	 public ResponseEntity<Depot> post(@PathVariable long id) {
		  Optional<Depot> cat = depotService.findById(id);
	        return cat.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                          .build());
	    }
	    
	 @PostMapping("/depots")
	    public void save(@RequestBody Depot Depot) {
		 System.out.println(Depot);
	         depotService.save(Depot);
	    }
	 @PutMapping("/depots/{id}")
	    public void update(@PathVariable long id, @RequestBody Depot Depot) {
	        Optional<Depot> cat =   depotService.findById(id);
	        if (cat.isPresent()) {
	        	  depotService.update(id,Depot);
	        } 
	    }

	  @DeleteMapping("/depots/{id}")
	    public void delete(@PathVariable long id) {
		  depotService.delete(id);
	    }
	     
	  
}