package pe.edu.cibertec.action;

import pe.edu.cibertec.model.Solicitante;

import pe.edu.cibertec.negocio.SolicitanteService;
import pe.edu.cibertec.util.Constantes;

import com.opensymphony.xwork2.ActionSupport;

public class SolicitanteAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Solicitante solicitante;

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}
	
	public String consultar() throws Exception {
		
		SolicitanteService solicitanteService = new SolicitanteService();
		
		if (isNumeric(solicitante.getDni())==false){
			addActionError(getText(" Ingrese caracteres numéricos en el DNI"));
			return ERROR;					
		}
		solicitante= solicitanteService.consultar(solicitante.getDni());
	
		if (solicitante == null ){
			addActionError(getText(Constantes.MENSAJE_NO_SOLICITANTE));
			return ERROR;
			
		}
		else

			return SUCCESS;
			
	}
	
	
    private static boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
	
	
	
//	Usuario obtenerDatos(String tipo){
//		Usuario usuario=new Usuario();
//		LoginService loginService= new LoginService();
//		usuario=loginService.obtenerDatos(Usuario.getIdsession() );
//		return usuario; 
//		
//	}
	

}
