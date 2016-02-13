package pe.edu.cibertec.negocio;

import pe.edu.cibertec.model.Solicitante;
import pe.edu.cibertec.persistence.SolicitanteDAO;



public class SolicitanteService {
	
	public Solicitante consultar (String dni) throws Exception{

		SolicitanteDAO solicitanteDAO=new SolicitanteDAO();
	    Solicitante solicitante=new Solicitante();       
		solicitante= solicitanteDAO.consultar(dni);
		
		return solicitante;

	}
	
	 public void actualizarSolicitante(Solicitante solicitante) throws Exception {
		 SolicitanteDAO.actualizarSolicitante(solicitante);
     }
	
	public Solicitante obtenerMailxDni(String dni) {
		Solicitante solicitante=new Solicitante();  
		solicitante= SolicitanteDAO.obtenerMailxDni(dni);
		return solicitante;
	}
}
