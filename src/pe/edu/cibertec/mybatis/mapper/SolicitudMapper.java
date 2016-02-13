package pe.edu.cibertec.mybatis.mapper;

import java.util.List;

import pe.edu.cibertec.model.Solicitud;


public interface SolicitudMapper {

	void registrar(Solicitud solicitud);
	
	void modificar(Solicitud solicitud);
	
	void actualizarEstado(Solicitud solicitud);
	
	void eliminar(String nroSolicitud);	
	
	public Solicitud generarNroSolicitud();
	
	public List<Solicitud> listarSolicitudes();
	public List<Solicitud> listarSolicitudesxNroSolicitud(String nroSolicitud);
	public List<Solicitud> listarSolicitudesxDni(String dni);
	public List<Solicitud> listarSolicitudesxEstado(String estado);
	
	public Solicitud getSolicitudPorNro(String nroSolicitud);
	public Solicitud getSolicitudPorNroA(String nroSolicitud);

	Solicitud consultarSolicitudFullxNro(String nroSolicitud);


}

