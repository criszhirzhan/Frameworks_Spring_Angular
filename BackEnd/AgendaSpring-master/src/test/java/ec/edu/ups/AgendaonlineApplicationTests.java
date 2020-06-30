package ec.edu.ups;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ec.edu.ups.dao.TelefonoRepository;
import ec.edu.ups.dao.UsuarioRepository;
import ec.edu.ups.entity.Telefono;
import ec.edu.ups.entity.Usuario;

@SpringBootTest
class AgendaonlineApplicationTests {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TelefonoRepository telefonoRepository;
	
	@Test
	void almacenarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setCedula("1401069199");
		usuario.setNombre("Daniel");
		usuario.setApellido("Guzman");
		usuario.setCorreo("danielg99@hotmail.es");
		usuario.setContrasena("ASRnust89@");
		usuarioRepository.save(usuario);
		assertNotNull(usuarioRepository.findById("1401069199"));
	
	}
	
	@Test
	void eliminarUsuario() {
	List<Usuario> usuarios = usuarioRepository.findAll();
	usuarioRepository.deleteById("1401069199");
	List<Usuario> usuariosEsperados = usuarioRepository.findAll();
	assertEquals( usuarios.size()-1, usuariosEsperados.size());
	}
	
	@Test
	void actualizarUsuario() {	
		Usuario usuario =usuarioRepository.findById("1401069131").get();
		usuario.setApellido("Lopez");
		usuarioRepository.save(usuario);
		assertTrue(usuarioRepository.findById("1401069131").get().getApellido().equals(usuario.getApellido()));
	}
	@Test
	void listarUsuarios() {	
		assertNotNull(usuarioRepository.findAll());
	}

	
	@Test
	void almacenarTelefono() {
		Telefono telefono = new Telefono();
		telefono.setCodigo(2);
		telefono.setUsuario(usuarioRepository.findById("1401069131").get());
		telefono.setTipo("Fijo");
		telefono.setOperadora("Claro");
		telefono.setNumero("0958462322");
		assertNotNull(telefonoRepository.save(telefono));
	}
	@Test
	void eliminarTelefono() {
	List<Telefono> telefonosEsperados = telefonoRepository.findAll();
	telefonoRepository.deleteById(2);
	List<Telefono> telefonos = telefonoRepository.findAll();
	assertEquals( telefonosEsperados.size()-1, telefonos.size());
	}
	
	@Test
	void actualizarTelefono() {	
		Telefono telefono =telefonoRepository.findById(1).get();
		telefono.setOperadora("CNT");
		telefonoRepository.save(telefono);
		assertTrue(telefonoRepository.findById(1).get().getOperadora().equals(telefono.getOperadora()));
	}
	@Test
	void listarTelefonos() {	
		assertNotNull(telefonoRepository.findAll());
	}
	
}
