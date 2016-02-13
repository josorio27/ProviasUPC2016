package pe.edu.cibertec.negocio;

import pe.edu.cibertec.negocio.LoginService;
import pe.edu.cibertec.model.Usuario;
import pe.edu.cibertec.persistence.UsuarioDAO;;

public class LoginService{
	
	public boolean isUsuarioAutorizado(Usuario usuario) throws Exception{
		
		boolean resultado=false;
		UsuarioDAO usuarioDAO=new UsuarioDAO();
	           

		if (usuarioDAO.validarUsuario(usuario)) {
    	  resultado = true;
      	}

	          
		return resultado;
	}

	public void obtenerTipoUsuario(String username) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();
		usuarioDAO.obtenerTipoUsuario(username);
		
	}

	public Usuario obtenerDatos( String dni) {
		Usuario usuario=new Usuario();
		UsuarioDAO usuarioDAO=new UsuarioDAO();
		usuario=usuarioDAO.obtenerDatos(dni);
		
		return usuario;
	}


}
