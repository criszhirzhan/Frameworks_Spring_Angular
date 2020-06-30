package ec.edu.ups.controller;

import ec.edu.ups.entity.Usuario;
import ec.edu.ups.dao.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/crear")
    public void crear(@RequestBody Usuario usuario){
         usuarioRepository.save(usuario);
    }

    @GetMapping("/listar")
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
    
    @GetMapping("/buscar/{cedula}")
    public Optional<Usuario> buscar(@PathVariable("cedula") String cedula){
        return usuarioRepository.findById(cedula);
    }
    
    @GetMapping()
    
    @DeleteMapping("/eliminar/{cedula}")
    public void eliminar(@PathVariable("cedula") String cedula) {
    	usuarioRepository.deleteById(cedula);
    }
    
    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Usuario usuario) {
    	usuarioRepository.save(usuario);
    }
    
    @GetMapping("/autentificar")
    @ResponseBody
    public Usuario autenficar(@RequestParam(name ="correo") String correo, @RequestParam(name = "contrasena") String contrasena) {
    	return usuarioRepository.buscarUsuario(correo, contrasena);
    }


}
