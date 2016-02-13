package pe.edu.cibertec.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pe.edu.cibertec.model.Usuario;

public interface UsuarioMapper {
	void obtenerTipoUsuario(String username);

	Usuario obtenerDatos(String dni);

	Usuario validarUsuario(Usuario usuario);
	
    @Select(" SELECT dni, username,nombres, apellidos" +
   		 " FROM TB_usuario " +
   		 " WHERE nombres LIKE #{nombres}")
	@ResultMap("rmUsuarioDatosBase")
	List<Usuario> getUsuariosByCriteria(String dni);

   
   @Select("SELECT dni, username,nombres, apellidos," +
		    " fechaNacimiento, estadoCivil, distrito, correoElectronico, tipo " +
			" FROM TB_usuario" +
			" WHERE dni=#{dni}")
   @ResultMap("rmUsuarioModels")
   Usuario getUsuarioByPK(String dni);
   
   @Select(" SELECT u.dni, u.username, u.nombres, u.apellidos, u.fechaNacimiento," +
		    " d.descripcion des_dis, e.descripcion des_estCiv, u.correoElectronico, tp.descripcion des_tipUsu " +
			" FROM TB_usuario u, tb_distrito d, tb_estado_civil e, tb_tipousuario tp" +
			" WHERE u.distrito = d.codigo " +
			" and u.estadoCivil = e.codigo " +
			" and u.tipo = tp.tipo " +
			" and u.dni=#{dni} ")
	@ResultMap("rmUsuarioFull")
   Usuario getUsuarioByPKFull(String dni);

   
   @Insert(" INSERT INTO TB_USUARIO(dni, username, password, nombres, apellidos, fechaNacimiento," +
			" estadoCivil, distrito, correoElectronico, tipo) " +
			" values(#{dni},#{username},#{password},#{nombres},#{apellidos},#{fechaNacimiento}," +
			" #{estadoCivil.codigo},#{distrito.codigo},#{correoElectronico},#{tipoUsuario.tipo})")
   void registrar(Usuario usuario); 
   
   

   @Delete(" DELETE FROM TB_usuario WHERE dni=#{dni} ")
   void eliminar(String dni);

   
   @Update(" UPDATE TB_usuario " +
   		" SET username=#{username}, nombres=#{nombres}, password=#{password}, " +
		    " apellidos=#{apellidos}, fechaNacimiento=#{fechaNacimiento}," +
		    " distrito=#{distrito.codigo},estadoCivil=#{estadoCivil.codigo}," +
		    " correoElectronico=#{correoElectronico}, tipo=#{tipoUsuario.tipo}" +
		    " WHERE dni=#{dni} ")
   void actualizar(Usuario usuario); 
	
	
}
