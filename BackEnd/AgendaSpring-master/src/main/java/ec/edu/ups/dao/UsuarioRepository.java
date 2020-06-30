package ec.edu.ups.dao;

import ec.edu.ups.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    @Query("FROM Usuario WHERE correo = ?1 AND contrasena=?2")
    Usuario buscarUsuario(String correo, String contrasena);
    @Query( "FROM Usuario WHERE cedula = ?1 or correo=?1 ")
    List<Usuario> buscarPorCorreoCedula(String context);
}
