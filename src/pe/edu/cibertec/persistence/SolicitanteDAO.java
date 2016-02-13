package pe.edu.cibertec.persistence;
import org.apache.ibatis.session.SqlSession;
import pe.edu.cibertec.model.Solicitante;
import pe.edu.cibertec.mybatis.factory.SessionFactory;
import pe.edu.cibertec.mybatis.mapper.SolicitanteMapper;



public class SolicitanteDAO {
	
	@SuppressWarnings("finally")
	public Solicitante consultar(String dni) throws Exception {
		
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		Solicitante solicitante = null;
		try {
			
			SolicitanteMapper solicitanteMapper=sqlSession.getMapper(SolicitanteMapper.class);
			
			solicitante=solicitanteMapper.getSolicitante(dni);
			
			sqlSession.commit();
			
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		finally{
		if(sqlSession != null){
			sqlSession.close();
			return solicitante;
		}
		else
			return null;
		}
	
	}
	
	public static void actualizarSolicitante(Solicitante solicitante) throws Exception {
		
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		SolicitanteMapper solicitanteMapper=sqlSession.getMapper(SolicitanteMapper.class);
				
		solicitanteMapper.actualizarSolicitante(solicitante);
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	public static Solicitante obtenerMailxDni(String dni) {
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		Solicitante solicitante=null;
		try {
			SolicitanteMapper solicitanteMapper=sqlSession.getMapper(SolicitanteMapper.class);
			solicitante=solicitanteMapper.obtenerMailxDni(dni);
			
			sqlSession.commit();			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return solicitante;

	}	
}






