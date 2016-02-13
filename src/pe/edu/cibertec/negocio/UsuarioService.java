package pe.edu.cibertec.negocio;
import java.util.List;

import pe.edu.cibertec.model.Usuario;
import pe.edu.cibertec.persistence.UsuarioDAO;

/*
 * ESTA CLASE
 * REPRESENTA EL CU: 
 * MANTENIMIENTO VENDEDOR
 */
public class UsuarioService{

	UsuarioDAO usuarioDAO=new UsuarioDAO();

	public List<Usuario> buscarUsuarios(Usuario usuario) throws Exception{
		return usuarioDAO.buscarUsuarios(usuario);
	}

	public Usuario buscarUsuarioById(Usuario usuario) throws Exception {
		return usuarioDAO.obtenerPorPK(usuario.getDni());
	}

	public void eliminar(Usuario usuario) throws Exception {
		usuarioDAO.eliminar(usuario.getDni());
	}
	
	public Usuario getUsuario(Usuario usuario) throws Exception{
		return usuarioDAO.getUsuario(usuario.getDni());
	}
	
	public void actualizar(Usuario usuario) throws Exception {
		usuarioDAO.actualizar(usuario);
	}

	public void registrar(Usuario usuario) throws Exception {
		usuarioDAO.insertar(usuario);
		
	}

}
