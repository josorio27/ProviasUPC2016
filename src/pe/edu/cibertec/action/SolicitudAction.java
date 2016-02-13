package pe.edu.cibertec.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pe.edu.cibertec.model.CriteriosEvaluacion;
import pe.edu.cibertec.model.Solicitante;
import pe.edu.cibertec.model.Solicitud;
import pe.edu.cibertec.model.Vehiculo;
import pe.edu.cibertec.negocio.SolicitanteService;
import pe.edu.cibertec.negocio.SolicitudService;
import pe.edu.cibertec.negocio.VehiculoService;
import pe.edu.cibertec.util.Constantes;


import com.opensymphony.xwork2.ActionSupport;


public class SolicitudAction extends ActionSupport {
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private Solicitud solicitud;
	private Vehiculo vehiculo;
	private Solicitante solicitante;
	private List<Solicitud> lista;
	
	private boolean checkMe;
	
	public boolean isCheckMe() {
		return checkMe;
	}

	public void setCheckMe(boolean checkMe) {
		this.checkMe = checkMe;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public List<Solicitud> getLista() {
		return lista;
	}

	public void setLista(List<Solicitud> lista) {
		this.lista = lista;
	}

	public String insertar() throws Exception {
		
		SolicitudService solicitudService = new SolicitudService();
		SolicitanteService solicitanteService= new SolicitanteService();
		VehiculoService vehiculoService= new VehiculoService();
		CriteriosEvaluacion criterios= new CriteriosEvaluacion();
		String filePath = "C:\\ProviasRevisionTecnica\\";
		Double alturaCriterio;
		Double pesoCriterio;
		Double longitudCriterio;
		Double alturaSol;
		Double pesoSol;
		Double longitudSol;
		
		//String filePath = "C:\\Users\\suite-701\\Documents\\ProviasRevisionTecnica\\";
		
		if (solicitante.getDni().equals("")){
			addActionError(getText(" Ingrese el DNI"));
			return ERROR;					
		}
		if (isNumeric(solicitante.getDni())==false){
			addActionError(getText(" Ingrese caracteres numéricos en el DNI"));
			return ERROR;					
		}	
		if (solicitante.getDni().length()<8){
			addActionError(getText(" Ingrese el DNI correctamente"));
			return ERROR;					
		}		
		if(vehiculo.getMatricula().equals("")){
			addActionError(getText(" Ingrese la matrícula"));
			return ERROR;					
		}
		
		if(solicitante.getDireccion().equals("")){
			addActionError(getText(" Ingrese la dirección"));
			return ERROR;					
		}

		if(solicitante.getTelefono().equals("")){
			addActionError(getText(" Ingrese un teléfono"));
			return ERROR;				
		}
		if (isNumeric(solicitante.getTelefono())==false){
			addActionError(getText(" Ingrese caracteres numéricos en el Teléfono"));
			return ERROR;					
		}		
		if (isNumeric(solicitante.getDni())==false){
			addActionError(getText(" Ingrese caracteres numéricos en el DNI"));
			return ERROR;					
		}		
		if(solicitante.getCorreoElectronico().equals("")){
			addActionError(getText(" Ingrese el correo electrónico"));
			return ERROR;	

		}
		
		if(!isEmail(solicitante.getCorreoElectronico())) {
			
			addActionError(getText(" Ingrese el correo electrónico correctamente"));
			return ERROR;	
		}
		if(solicitud.getRevisionTecnicaFileName()==null){
			addActionError(getText(" Adjunte la revisión técnica"));
			return ERROR;					
		}
		
		else
		{
		String file= solicitud.getRevisionTecnicaFileName();
		File rev=solicitud.getRevisionTecnica();
		
		String estadoPendiente="1";
		SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MM'/'yyyy", new Locale("es_ES"));
		Date fechaDate = new Date();
		String fechaActual = formateador.format(fechaDate);

	
		solicitud =generarNroSolicitud();
		String nroSol="";
		String nro;
		int nroSolicitud = 0;	
		
		if(solicitud == null) {
			nroSol= "0001";
		}
		else{
		nro=generarNroSolicitud().getNroSolicitud();
		
		nroSolicitud = Integer.parseInt(nro);
		
		if(nroSolicitud < 9){
		 nroSol= "000"+ (nroSolicitud + 1);
		}
		if(nroSolicitud >=9 ){
		 nroSol= "00"+ (nroSolicitud + 1);
		}
		if(nroSolicitud >= 99){
		 nroSol= "0"+ (nroSolicitud + 1);
		}
		}
		solicitud.setNroSolicitud(nroSol);
		solicitud.setEstado(estadoPendiente);
		solicitud.setFechaSolicitud(fechaActual);
		solicitud.setDni(solicitante.getDni());
		solicitud.setMatricula(vehiculo.getMatricula());	
		solicitud.setRevisionTecnicaFileName(filePath + file);
		
		
		criterios=vehiculoService.cargarXML();
		
		alturaCriterio= Double.parseDouble(criterios.getAltura());
		pesoCriterio= Double.parseDouble(criterios.getPeso());
		longitudCriterio= Double.parseDouble(criterios.getLongitud());
		
		alturaSol= Double.parseDouble(vehiculo.getAltura());
		pesoSol= Double.parseDouble(vehiculo.getPeso());
		longitudSol= Double.parseDouble(vehiculo.getLongitud());
		
//		System.out.println("alturaCriterio:" + alturaCriterio);
//		System.out.println("pesoriterio:" + pesoCriterio);
//		System.out.println("longitudriterio:" + longitudCriterio);
//		System.out.println("alturaSol:" + alturaSol);
//		System.out.println("pesoSol:" + pesoSol);
//		System.out.println("longitudSol:" + longitudSol);
		
		if(alturaSol>alturaCriterio){
			addActionError(getText(" No cumple con los requisitos, altura max: " + alturaCriterio));
			return ERROR;	
		}
		if(pesoSol>pesoCriterio){
			addActionError(getText(" No cumple con los requisitos, peso max: " + pesoCriterio));
			return ERROR;	
		}
		if(longitudSol>longitudCriterio){
			addActionError(getText(" No cumple con los requisitos, longitud max: " + longitudCriterio));
			return ERROR;	
		}
		
		solicitudService.guardarFile(rev, file, filePath);
		solicitudService.registrar(solicitud);
		
		solicitanteService.actualizarSolicitante(solicitante);
		
		addActionMessage(getText(" Se Generó la Solicitud Número: " + nroSol));
		
		return "success";
		
		}
	}
	
	public String  modificar() throws Exception{
		
		SolicitudService solicitudService = new SolicitudService();
		SolicitanteService solicitanteService= new SolicitanteService();
		VehiculoService vehiculoService= new VehiculoService();
		String filePath = "C:\\ProviasRevisionTecnica\\";
//		CriteriosEvaluacion criterios= new CriteriosEvaluacion();
//		Double alturaCriterio;
//		Double pesoCriterio;
//		Double longitudCriterio;
//		Double alturaSol;
//		Double pesoSol;
//		Double longitudSol;

		if (solicitud.getNroSolicitud().equals("")){
			addActionError(getText(" Ingrese Nro Solicitud"));
			return ERROR;					
		}

		if (solicitud.getSolicitante().getDireccion().equals("")){
			addActionError(getText(" Ingrese dirección"));
			return ERROR;					
		}
		if (solicitud.getSolicitante().getTelefono().equals("")){
			addActionError(getText(" Ingrese el teléfono"));
			return ERROR;					
		}
		if (isNumeric(solicitante.getTelefono())==false){
			addActionError(getText(" Ingrese caracteres numéricos en el Teléfono"));
			return ERROR;					
		}	
		if (solicitud.getSolicitante().getCorreoElectronico().equals("")){
			addActionError(getText(" Ingrese el correo electrónico"));
			return ERROR;					
		}
		if (solicitud.getVehiculo().getModelo().equals("")){
			addActionError(getText(" Ingrese el modelo del vehículo"));
			return ERROR;					
		}
		if (solicitud.getVehiculo().getPeso().equals("")){
			addActionError(getText(" Ingrese el peso del vehículo"));
			return ERROR;					
		}
		if (solicitud.getVehiculo().getLongitud().equals("")){
			addActionError(getText(" Ingrese la longitud del vehículo"));
			return ERROR;					
		}

		
		String file= solicitud.getRevisionTecnicaFileName();
		File rev=solicitud.getRevisionTecnica();
		

		String estadoReenvio="5";
		SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MM'/'yyyy", new Locale("es_ES"));
		Date fechaDate = new Date();
		if(file==null){
			addActionError(getText(" Adjunte la revisión técnica"));
			return ERROR;					
		}

		
		String fechaActual = formateador.format(fechaDate);
		
		try {
			
//		criterios=vehiculoService.cargarXML();
			
//		alturaCriterio= Double.parseDouble(criterios.getAltura());
//		pesoCriterio= Double.parseDouble(criterios.getPeso());
//		longitudCriterio= Double.parseDouble(criterios.getLongitud());
//			
//		alturaSol= Double.parseDouble(vehiculo.getAltura());
//		pesoSol= Double.parseDouble(vehiculo.getPeso());
//		longitudSol= Double.parseDouble(vehiculo.getLongitud());	
//		
//		System.out.println("alturaCriterio:" + alturaCriterio);
//		System.out.println("pesoriterio:" + pesoCriterio);
//		System.out.println("longitudriterio:" + longitudCriterio);
//		System.out.println("alturaSol:" + alturaSol);
//		System.out.println("pesoSol:" + pesoSol);
//		System.out.println("longitudSol:" + longitudSol);
		
//		if(alturaSol>alturaCriterio){
//			addActionError(getText(" No cumple con los requisitos, altura max: " + alturaCriterio));
//			return ERROR;	
//		}
//		if(pesoSol>pesoCriterio){
//			addActionError(getText(" No cumple con los requisitos, peso max: " + pesoCriterio));
//			return ERROR;	
//		}
//		if(longitudSol>longitudCriterio){
//			addActionError(getText(" No cumple con los requisitos, longitud max: " + longitudCriterio));
//			return ERROR;	
//		}			
			
		solicitud.setFechaModificacion(fechaActual);
		solicitud.setEstado(estadoReenvio);
		
		solicitud.setRevisionTecnicaFileName(filePath + file);
	
		solicitudService.guardarFile(rev, file, filePath);
		
		solicitudService.modificar(solicitud);
		solicitanteService.actualizarSolicitante(solicitante);
		vehiculoService.actualizarVehiculo(vehiculo);

		addActionMessage(getText(" Se Modificó la Solicitud"));
		
		
		} catch (Exception e) {
			System.out.println("error: "+ e.getMessage() );
		}
		
		return "success";
	}
	
	public String  actualizarEstado() throws Exception{
		if (solicitud.getNroSolicitud().equals("")){
			addActionError(getText(" Ingrese Nro Solicitud"));
			return ERROR;					
		}
		String mensaje;
		SolicitudService solicitudService = new SolicitudService();
		SolicitanteService solicitanteService = new SolicitanteService();
		String estado = solicitud.getEstado();
	
		if(!estado.equals("") || !estado.equals("-1")){
			
			solicitudService.actualizarEstado(solicitud);
			solicitante = solicitanteService.obtenerMailxDni(solicitud.getDni());
			System.out.println("correo: " + solicitante.getCorreoElectronico());
			
		/////////////////////////////////
		//Aca se envia la notificacion
		/////////////////////////////////			
			
			if(checkMe){
				System.out.println("check: " + checkMe  );
				solicitudService.EnviarEmail(solicitante.getCorreoElectronico(), solicitud);
				mensaje=" Se actualizó el estado y se envió una notifiación al solicitante";
			}	
			
			mensaje=" Se actualizó el estado de la solicitud";
			addActionMessage(getText(mensaje));
			
			return "success";

		}
		else
			addActionError(getText(" Seleccione un Estado"));
			return ERROR;

				
	}
	
	
	Solicitud generarNroSolicitud() throws Exception{
		SolicitudService solicitudService = new SolicitudService();
		Solicitud solicitud = solicitudService.generarNroSolicitud();
		return solicitud;
	}
	public String  getSolicitudPorNro() throws Exception{
		if (solicitud.getNroSolicitud().equals("")){
			addActionError(getText(" Ingrese Nro Solicitud"));
			return ERROR;					
		}
		if (isNumeric(solicitud.getNroSolicitud())==false){
			addActionError(getText(" Las solicitudes son entre 0 a 9999"));
			return ERROR;					
		}	
		else{
		SolicitudService solicitudService = new SolicitudService();
		solicitud = solicitudService.getSolicitudPorNro(solicitud.getNroSolicitud());
		if (solicitud == null ){
			addActionError(getText(" Nro Solicitud no Existe"));
			return ERROR;
			
		}
		}
		return "success";
	}
	public String  consultarSolicitudFullxNro() throws Exception{
	
		if (solicitud.getNroSolicitud().equals("")){
			addActionError(getText(" Ingrese Nro Solicitud"));
			return ERROR;					
		}
		if (isNumeric(solicitud.getNroSolicitud())==false){
			addActionError(getText(" Las solicitudes son entre 0 a 9999"));
			return ERROR;					
		}	
		else{
		SolicitudService solicitudService = new SolicitudService();
		solicitud = solicitudService.consultarSolicitudFullxNro(solicitud.getNroSolicitud());
		if (solicitud == null ){
			addActionError(getText(" Nro Solicitud no Existe"));
			return ERROR;
			
		}
		
		}

		return "success";
	}
	
	
	public String  getSolicitudPorNroA() throws Exception{
		if (solicitud.getNroSolicitud().equals("")){
			addActionError(getText(" Ingrese Nro Solicitud"));
			return ERROR;					
		}
		if (isNumeric(solicitud.getNroSolicitud())==false){
			addActionError(getText(" Las solicitudes son entre 0 a 9999"));
			return ERROR;					
		}	

		else{
		SolicitudService solicitudService = new SolicitudService();
		solicitud = solicitudService.getSolicitudPorNroA(solicitud.getNroSolicitud());
		if (solicitud == null ){
			addActionError(getText(" Nro Solicitud no Existe"));
			return ERROR;
			
		}
		}

			return "success";
	}
	
	public String  listarSolicitudes() throws Exception{
		
		SolicitudService solicitudService = new SolicitudService();
		lista = solicitudService.listarSolicitudes();
		if (lista.size()==0){
			addActionError(getText(Constantes.MENSAJE_NO_LISTA_SOLICITUD));
			return ERROR;
		}
		else

		return "success";
	}
		
	public String  listarSolicitudesxDni() throws Exception{
		if (solicitud.getDni().equals("")){
			addActionError(getText(" Ingrese el Nro de DNI"));
			return ERROR;					
		}
		if (isNumeric(solicitud.getDni())==false){
			addActionError(getText(" Ingrese caracteres numéricos en el DNI"));
			return ERROR;					
		}
		if (solicitud.getDni().length()<8){
			addActionError(getText(" Ingrese el DNI correctamente"));
			return ERROR;					
		}		
		
		SolicitudService solicitudService = new SolicitudService();
		lista = solicitudService.listarSolicitudesxDni(solicitud.getDni());
		if (lista.size()==0){
			addActionError(getText(Constantes.MENSAJE_NO_LISTA_SOLICITUD));
			return ERROR;
		}
		else
			
		return "success";
	}	
		
	public String  listarSolicitudesxNroSolicitud() throws Exception{
		if (isNumeric(solicitud.getNroSolicitud())==false){
			addActionError(getText(" Las solicitudes son entre 0 a 9999"));
			return ERROR;					
		}	
		if (solicitud.getNroSolicitud().equals("")){
			addActionError(getText(" Ingrese Nro Solicitud"));
			return ERROR;					
		}
		SolicitudService solicitudService = new SolicitudService();
		lista = solicitudService.listarSolicitudesxNroSolicitud(solicitud.getNroSolicitud());

		if (lista.size()==0){
			addActionError(getText(Constantes.MENSAJE_NO_LISTA_SOLICITUD));
			return ERROR;
		}
		else
	
		return "success";
	}		
		
	public String  listarSolicitudesxEstado() throws Exception{
		if (solicitud.getEstado().equals("")){
			addActionError(getText(" Ingrese un estado"));
			return ERROR;					
		}
		SolicitudService solicitudService = new SolicitudService();
		lista = solicitudService.listarSolicitudesxEstado(solicitud.getEstado());
		if (lista.size()==0){
			addActionError(getText(Constantes.MENSAJE_NO_LISTA_SOLICITUD));
			return ERROR;
		}
		else

		return "success";
	}			

	

	public void eliminar() throws Exception{
		SolicitudService solicitudService = new SolicitudService();
		solicitudService.eliminar(solicitud.getNroSolicitud());

	}
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
    
	public String consultar(){
		return SUCCESS;
	}
//	Usuario obtenerDatos(String tipo){
//		Usuario usuario=new Usuario();
//		LoginService loginService= new LoginService();
//		usuario=loginService.obtenerDatos(tipo);
//		return usuario; 
//		
//	}

    private static boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }

}
