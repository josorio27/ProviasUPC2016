package pe.edu.cibertec.negocio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.model.Solicitud;
import pe.edu.cibertec.persistence.SolicitudDAO;

public class SolicitudService {
	
	SolicitudDAO solicitudDAO = new SolicitudDAO();
	
	 public void registrar(Solicitud solicitud) throws Exception {
		 solicitudDAO.insertar(solicitud);
     }
	 
	 public Solicitud generarNroSolicitud() throws Exception {
		 Solicitud solicitud = solicitudDAO.generarNroSolicitud();
		 return solicitud;
     }
	 public List<Solicitud> listarSolicitudes() throws Exception {
		 List<Solicitud> lista= new ArrayList<Solicitud>();
		 lista = solicitudDAO.listarSolicitudes();
		 return lista;
     }	 
	 public List<Solicitud> listarSolicitudesxNroSolicitud(String nroSolicitud) throws Exception {
		 List<Solicitud> lista= new ArrayList<Solicitud>();
		 lista = solicitudDAO.listarSolicitudesxNroSolicitud(nroSolicitud);
		 return lista;
     }	 
	 public List<Solicitud> listarSolicitudesxDni(String dni) throws Exception {
		 List<Solicitud> lista= new ArrayList<Solicitud>();
		 lista = solicitudDAO.listarSolicitudesxDni(dni);
		 return lista;
     }	 
	 public List<Solicitud> listarSolicitudesxEstado(String estado) throws Exception {
		 List<Solicitud> lista= new ArrayList<Solicitud>();
		 lista = solicitudDAO.listarSolicitudesxEstado(estado);
		 return lista;
     }	 
	 public Solicitud getSolicitudPorNro(String nroSolicitud) throws Exception {
		 Solicitud solicitud = SolicitudDAO.getSolicitudPorNro(nroSolicitud);
		 return solicitud;
     }	 
	 public Solicitud getSolicitudPorNroA(String nroSolicitud) throws Exception {
		 Solicitud solicitud = SolicitudDAO.getSolicitudPorNroA(nroSolicitud);
		 return solicitud;
     }	  
	 public void modificar(Solicitud solicitud) throws Exception {
		 SolicitudDAO.modificar(solicitud);
     }
	 
	 public void actualizarEstado(Solicitud solicitud) throws Exception {
		 SolicitudDAO.actualizarEstado(solicitud);
     }
	 
	 public void eliminar(String nroSolicitud) throws Exception {
		 SolicitudDAO.eliminar(nroSolicitud);
     }

	public void guardarFile(File revisionTecnica, String file, String filePath) throws Exception {
		solicitudDAO.guardarFile(revisionTecnica, file, filePath);
		
	}
	 
	 public void EnviarEmail(String email, Solicitud solicitud) throws Exception{
		 solicitudDAO.EnviarEmail(email, solicitud);
	 }

	public Solicitud consultarSolicitudFullxNro(String nroSolicitud) {
		 Solicitud solicitud = SolicitudDAO.consultarSolicitudFullxNro(nroSolicitud);
		 return solicitud;
	}


} 
