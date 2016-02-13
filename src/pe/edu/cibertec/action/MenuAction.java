package pe.edu.cibertec.action;
import pe.edu.cibertec.model.Usuario;
import pe.edu.cibertec.negocio.LoginService;

import com.opensymphony.xwork2.ActionSupport;

public class MenuAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String validarRegistrar(){
		if(Usuario.getSession().equals("2") || Usuario.getSession().equals("1")){
		return SUCCESS;	
		}
		else
		return ERROR;
	}
	
	public String validarConsultar(){
		if(Usuario.getSession().equals("3") || Usuario.getSession().equals("1")){
			return SUCCESS;	
		}
		else
			return ERROR;
}
	public String validarActualizar(){
		if(Usuario.getSession().equals("4") || Usuario.getSession().equals("1")){
			return SUCCESS;	
		}
		else
			return ERROR;
}
	public String validarModificar(){
		if(Usuario.getSession().equals("1")){
			return SUCCESS;	
		}
		else
			return ERROR;
	}
	public String validarMantenimiento(){
		if(Usuario.getSession().equals("1")){
			return SUCCESS;	
		}
		else
			return ERROR;
	}
	
	public String validarIndex(){
		obtenerDatos(Usuario.getIdsession());
			return SUCCESS;	
	}
	
	Usuario obtenerDatos(String tipo){
		LoginService loginService= new LoginService();
		usuario=loginService.obtenerDatos(Usuario.getIdsession() );
		return usuario; 
	}
	
	public String obtenerDatosU(){
		obtenerDatos(Usuario.getIdsession());
		System.out.println("sesion: " + Usuario.getSession());
		return SUCCESS; 
	}
	
}
