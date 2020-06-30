package ec.edu.ups.controller;

import javax.ejb.EJB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.entity.Usuario;
import ec.edu.ups.service.JPAUsuarioDAO;

@RestController
@RequestMapping("usuariospring")
@CrossOrigin("*")
public class UsuarioControllerSpring {
	@Autowired 
	public JPAUsuarioDAO jpaUsuarioDAO;
	
    @PostMapping("/crear")
    public void crear(@RequestBody Usuario usuario){
         jpaUsuarioDAO.create(usuario);
    }

}
