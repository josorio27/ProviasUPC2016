package pe.edu.cibertec.mybatis.mapper;

import pe.edu.cibertec.model.Vehiculo;




public interface VehiculoMapper {
	Vehiculo getVehiculo(String matricula);

	void actualizarVehiculo(Vehiculo vehiculo);
}
