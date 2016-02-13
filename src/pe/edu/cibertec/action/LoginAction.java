package pe.edu.cibertec.action;

import java.util.Map;
import pe.edu.cibertec.negocio.LoginService;
import pe.edu.cibertec.model.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//atributos I/O
		private Usuario usuario;
		public Map<String, Object> session;
		
		public Map<String, Object> getSession() {
			return session;
		}

		public void setSession(Map<String, Object> session) {
			this.session = session;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		//procesamiento de la petición: validar credenciales
		public String execute(){
		
			String vista="";
			
			try{
				LoginService loginService=new LoginService();
				boolean r=loginService.isUsuarioAutorizado(usuario);
				
				if(r){//caso exitoso
					session=ActionContext.getContext().getSession();
					session.put("usuario", getUsuario());
					obtenerTipoUsuario(usuario.getUsername());
					obtenerDatos(Usuario.getIdsession());
					vista=SUCCESS;
					
					
					
				}else{//caso credenciales incorrectas
					vista=LOGIN;
				}
			}catch (Exception e) {//caso error
				System.out.println("error: " + e);
				vista=ERROR;
			}
			
			//retorna result
			return vista;
		}
		
		public String inicializar() throws Exception{

			return LOGIN;
			
		}
		
		public void obtenerTipoUsuario(String username) throws Exception {
			
			LoginService loginService=new LoginService();
			
			loginService.obtenerTipoUsuario(username);
			
		}		
		
		public String cerrarSesion(){
			Usuario.setSession("");
			return SUCCESS;
			
			
		}
		Usuario obtenerDatos(String dni){
			LoginService loginService= new LoginService();
			usuario=loginService.obtenerDatos(dni);
			return usuario; 
			
		}
	
}
