package pe.edu.cibertec.negocio;

import pe.edu.cibertec.model.CriteriosEvaluacion;
import pe.edu.cibertec.model.Vehiculo;
import pe.edu.cibertec.persistence.VehiculoDAO;

public class VehiculoService {
	
	public Vehiculo consultar (String matricula) throws Exception{

		VehiculoDAO vehiculoDAO=new VehiculoDAO();
		Vehiculo vehiculo=new Vehiculo();       
		vehiculo = vehiculoDAO.consultar(matricula);
		
		return vehiculo;

	}

	public void actualizarVehiculo(Vehiculo vehiculo) {
		VehiculoDAO vehiculoDAO=new VehiculoDAO();
		vehiculoDAO.actualizarVehiculo(vehiculo);
		
	}

	public CriteriosEvaluacion cargarXML() {
		CriteriosEvaluacion criterios=new CriteriosEvaluacion();
		VehiculoDAO vehiculoDAO=new VehiculoDAO();
		criterios=vehiculoDAO.cargarXml();
		return criterios;
	}
}
