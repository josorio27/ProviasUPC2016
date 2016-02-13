package pe.edu.cibertec.mybatis.mapper;

import pe.edu.cibertec.model.Solicitante;


public interface SolicitanteMapper {

	Solicitante getSolicitante(String dni);
	
	void actualizarSolicitante(Solicitante solicitante);
	public Solicitante obtenerMailxDni(String dni);
}
