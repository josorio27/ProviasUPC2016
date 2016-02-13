package pe.edu.cibertec.action;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.model.Solicitante;
import pe.edu.cibertec.model.Vehiculo;
import pe.edu.cibertec.negocio.SolicitanteService;
import pe.edu.cibertec.negocio.VehiculoService;
import pe.edu.cibertec.util.Constantes;

public class VehiculoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vehiculo vehiculo;
	private Solicitante solicitante;
	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public String consultar() throws Exception {
		
		VehiculoService vehiculoService = new VehiculoService();
		SolicitanteService solicitanteService= new SolicitanteService();
		vehiculo= vehiculoService.consultar(vehiculo.getMatricula());
		solicitanteService.consultar(solicitante.getDni());
		if (vehiculo == null ){
			addActionError(getText(Constantes.MENSAJE_NO_VEHICULO));
			return ERROR;
			
		}
		else
	
			return SUCCESS;
			
	}
	
//	Usuario obtenerDatos(String idsession){
//		Usuario usuario=new Usuario();
//		LoginService loginService= new LoginService();
//		usuario=loginService.obtenerDatos(idsession);
//		return usuario; 
//		
//	}
	
	
}
