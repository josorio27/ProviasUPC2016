package pe.edu.cibertec.persistence;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pe.edu.cibertec.model.Usuario;
import pe.edu.cibertec.mybatis.factory.SessionFactory;
import pe.edu.cibertec.mybatis.mapper.UsuarioMapper;

public class UsuarioDAO {
	

	@SuppressWarnings("finally")
	public boolean validarUsuario (Usuario usuario) throws Exception {
		
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
//		Usuario user=new Usuario();
		try {
			
			UsuarioMapper usuarioMapper=sqlSession.getMapper(UsuarioMapper.class);
			usuarioMapper.validarUsuario(usuario);
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		finally{
			if(Usuario.getSession().equals("1")){
				return true;
			}
			else
				return false;
			}
	}
	public void obtenerTipoUsuario(String username) {
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		
		UsuarioMapper usuarioMapper=sqlSession.getMapper(UsuarioMapper.class);
		
		usuarioMapper.obtenerTipoUsuario(username);
		sqlSession.commit();
		
		sqlSession.close();
		
	}

	public Usuario obtenerDatos(String dni) {
		Usuario usuario = new Usuario();
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		
		UsuarioMapper usuarioMapper=sqlSession.getMapper(UsuarioMapper.class);
		
		usuario=usuarioMapper.obtenerDatos(dni);
		sqlSession.commit();
		
		sqlSession.close();
		
		return usuario;
	}
	
	
	
	public Usuario getUsuario(String dni) throws Exception {
		
		SqlSession session = SessionFactory.getSqlSessionFactory().openSession();

		UsuarioMapper usuariorMapper=session.getMapper(UsuarioMapper.class);
        Usuario usuario=usuariorMapper.getUsuarioByPK(dni);

        session.close();

        return usuario;
		
	}
	
	public List<Usuario> buscarUsuarios(Usuario usuario) throws Exception {
		
		SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
	
	    UsuarioMapper usuarioMapper=session.getMapper(UsuarioMapper.class);
	    List<Usuario> usuarios=usuarioMapper.getUsuariosByCriteria(usuario.getNombres().concat("%"));
	
	    session.close();
	
	    return usuarios;
	}
	
	//ver detalle
	public Usuario obtenerPorPK(String dni) throws Exception {
	
		SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
	
		UsuarioMapper usuariorMapper=session.getMapper(UsuarioMapper.class);
	    Usuario usuario=usuariorMapper.getUsuarioByPKFull(dni);
	
	    session.close();
	
	    return usuario;
	}
	
	
	public void insertar(Usuario bean) throws Exception {
		
		SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
	
		UsuarioMapper usuariorMapper=session.getMapper(UsuarioMapper.class);
		usuariorMapper.registrar(bean);
	    session.commit();
	
	    session.close();
		
	}
	
	public void eliminar(String dni) throws Exception {
		SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
	
		UsuarioMapper usuariorMapper=session.getMapper(UsuarioMapper.class);
		usuariorMapper.eliminar(dni);
	    session.commit();
	    session.close();
		
	}
	
	public void actualizar(Usuario bean) throws Exception {
		SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
	
	    UsuarioMapper usuariorMapper=session.getMapper(UsuarioMapper.class);
	    usuariorMapper.actualizar(bean);
	    session.commit();
	
	    session.close();
	}


}
