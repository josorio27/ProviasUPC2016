package pe.edu.cibertec.action;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pe.edu.cibertec.model.Usuario;

import pe.edu.cibertec.negocio.UsuarioService;

import com.opensymphony.xwork2.ActionSupport;

public class UsuarioAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UsuarioService usuarioService=new UsuarioService();
	private List<Usuario> usuarios;
	private Usuario usuario;
	private String dni;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	public String buscarUsuarios() throws Exception{
		usuarios=usuarioService.buscarUsuarios(usuario);
		
		if (usuarios.size()==0 ){
			addActionError(getText("No existen usuarios"));
			return ERROR;

		}
		else
			return "listUsuario";

	}
	//	VER DETALLE
	public String buscarUsuarioById() throws Exception{
		usuario=new Usuario();
		usuario.setDni(dni);
		usuario=usuarioService.buscarUsuarioById(usuario);
		
		return "detailUsuario";

	}
	
	
	public String eliminar() throws Exception{
		usuario=new Usuario();
		usuario.setDni(dni);
		usuarioService.eliminar(usuario);
		 addActionMessage(getText("Registro Eliminado",new String[]{dni}));

			return "listUsuario";
	}
	
	public String cargarUsuario() throws Exception{
		usuario=new Usuario();
		usuario.setDni(dni);
		
		usuario=usuarioService.getUsuario(usuario);

		return "editUsuario";
	}
	
	public String save() throws Exception{
		
		if (usuario.getDni().equals("")){
			addActionError(getText(" Ingrese el DNI"));
			return ERROR;					
		}
		if (isNumeric(usuario.getDni())==false){
			addActionError(getText(" Ingrese caracteres numéricos en el DNI"));
			return ERROR;					
		}	
		if (usuario.getDni().length()<8){
			addActionError(getText(" Ingrese el DNI correctamente"));
			return ERROR;					
		}	
		if(usuario.getUsername().equals("")){
			addActionError(getText(" Ingrese Username"));
			return ERROR;					
		}
		if(usuario.getPassword().equals("")){
			addActionError(getText(" Ingrese Password"));
			return ERROR;					
		}
		if(usuario.getNombres().equals("")){
			addActionError(getText(" Ingrese Nombres"));
			return ERROR;					
		}
		
		if(usuario.getApellidos().equals("")){
			addActionError(getText(" Ingrese Apellidos"));
			return ERROR;				
		}
		
		if(usuario.getFechaNacimiento().equals("")){
			addActionError(getText(" Ingrese Fecha de Nacimiento"));
			return ERROR;				
		}
			
		if(usuario.getCorreoElectronico().equals("")){
			addActionError(getText(" Ingrese el correo electrónico"));
			return ERROR;	

		}

		if(!isEmail(usuario.getCorreoElectronico())) {
			
			addActionError(getText(" Ingrese el correo electrónico correctamente"));
			return ERROR;	
		}
		
		else
		{
			usuarioService.registrar(usuario);
			addActionMessage(getText("Registro Exitoso"));
		}
		return "listUsuario";
	}
	
	public String update() throws Exception{
			usuarioService.actualizar(usuario);
			addActionMessage(getText("Usuario Actualizado"));

		return "listUsuario";
	}
	
//	Usuario obtenerDatos(){
//		LoginService loginService= new LoginService();
//		usuario=loginService.obtenerDatos(Usuario.getIdsession());
//		return usuario; 
//		
//	}
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }        
    }
    
    private static boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
}
