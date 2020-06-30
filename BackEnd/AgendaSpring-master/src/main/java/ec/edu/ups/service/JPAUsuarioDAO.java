package ec.edu.ups.service;

import org.springframework.stereotype.Repository;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entity.Usuario;

@Repository
public class JPAUsuarioDAO extends AbstractJpaDAO<Usuario, String> implements UsuarioDAO {

}
