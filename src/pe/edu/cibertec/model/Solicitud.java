package pe.edu.cibertec.model;

import java.io.File;
import java.io.Serializable;

public class Solicitud implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nroSolicitud;
	private String dni;
	private String matricula;
	private String estado;
	private String fechaSolicitud;
	//private String revisionTecnica;
	private File revisionTecnica;
	public String revisionTecnicaFileName;
	public String revisionTecnicaContentType;
	private String fechaModificacion;
	private Solicitante solicitante;
	private Vehiculo vehiculo;

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
	public File getRevisionTecnica() {
		return revisionTecnica;
	}
	public void setRevisionTecnica(File revisionTecnica) {
		this.revisionTecnica = revisionTecnica;
	}
	public String getRevisionTecnicaContentType() {
		return revisionTecnicaContentType;
	}
	public void setRevisionTecnicaContentType(String revisionTecnicaContentType) {
		this.revisionTecnicaContentType = revisionTecnicaContentType;
	}
	public String getNroSolicitud() {
		return nroSolicitud;
	}
	public void setNroSolicitud(String nroSolicitud) {
		this.nroSolicitud = nroSolicitud;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public String getRevisionTecnicaFileName() {
		return revisionTecnicaFileName;
	}
	public void setRevisionTecnicaFileName(String revisionTecnicaFileName) {
		this.revisionTecnicaFileName = revisionTecnicaFileName;
	}
	public String getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
}
