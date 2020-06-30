package ec.edu.ups.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.dao.TelefonoRepository;
import ec.edu.ups.entity.Telefono;


@RestController
@RequestMapping("telefono")
@CrossOrigin("*")
public class TelefonoController {
	@Autowired
    private TelefonoRepository telefonoRepository;
	
	 @PostMapping("/crear")
	    public void crear(@RequestBody Telefono telefono){
		 telefonoRepository.save(telefono);
	    }

	    @GetMapping("/listar")
	    public List<Telefono> listar(){
	        return telefonoRepository.findAll();
	    }
	    
	    
	    @DeleteMapping("/eliminar/{id}")
	    public void eliminar(@PathVariable("id") Integer id) {
	    	telefonoRepository.deleteById(id);
	    }
	    
	    @PutMapping("/actualizar")
	    public void actualizar(@RequestBody Telefono telefono) {
	    	telefonoRepository.save(telefono);
	    }
	    
	    @GetMapping("/buscar/{id}")
	    public Optional<Telefono> buscar(@PathVariable("id") Integer id){
	        return telefonoRepository.findById(id);
	    }
}
