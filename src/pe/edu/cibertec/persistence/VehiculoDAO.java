package pe.edu.cibertec.persistence;

import org.apache.ibatis.session.SqlSession;

import pe.edu.cibertec.model.CriteriosEvaluacion;
import pe.edu.cibertec.model.Vehiculo;
import pe.edu.cibertec.mybatis.factory.SessionFactory;
import pe.edu.cibertec.mybatis.mapper.VehiculoMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |

public class VehiculoDAO {
	@SuppressWarnings("finally")
	public Vehiculo consultar(String matricula) throws Exception {
		
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		Vehiculo vehiculo=null;
		try {
			VehiculoMapper vehiculoMapper=sqlSession.getMapper(VehiculoMapper.class);
			
			vehiculo =vehiculoMapper.getVehiculo(matricula);
			
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		finally{
			if(sqlSession != null){
				sqlSession.close();
				return vehiculo;
			}
			else
				return null;
			}
	}

	public void actualizarVehiculo(Vehiculo vehiculo) {
			SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
			VehiculoMapper vehiculoMapper=sqlSession.getMapper(VehiculoMapper.class);
					
			vehiculoMapper.actualizarVehiculo(vehiculo);
			sqlSession.commit();
			
			sqlSession.close();
	}
	public CriteriosEvaluacion cargarXml()
	{
	    SAXBuilder builder = new SAXBuilder();
	    CriteriosEvaluacion criterios = new CriteriosEvaluacion();
	    System.out.println("Leyendo XML");
	    File xmlFile = new File( "C:\\provias.xml" );
	    try
	    {
	        Document document = (Document) builder.build( xmlFile );
	        Element rootNode = document.getRootElement();
	        @SuppressWarnings("rawtypes")
			List list = rootNode.getChildren( "tabla" );
	        for ( int i = 0; i < list.size(); i++ )
	        {
	            Element tabla = (Element) list.get(i);
//	            String nombreTabla = tabla.getAttributeValue("altura");
//	 	            System.out.println( "Tabla: " + nombreTabla );
	            @SuppressWarnings("rawtypes")
				List lista_campos = tabla.getChildren();
//	 	            System.out.println( "\tAltura\t\tPeso\t\tLongitud" );

	            for ( int j = 0; j < lista_campos.size(); j++ )
	            {
	                Element campo = (Element)lista_campos.get( j );
	                criterios.setAltura(campo.getChildTextTrim("altura"));
	                criterios.setPeso(campo.getChildTextTrim("peso"));
	                criterios.setLongitud(campo.getChildTextTrim("longitud"));

//	                System.out.println( "\t"+altura+"\t\t"+peso+"\t\t"+longitud);
	            }
	        }
	    }catch ( IOException io ) {
	        System.out.println( io.getMessage() );
	        System.out.println("Error xml: "+ io.getMessage());
	    }catch ( JDOMException jdomex ) {
	        System.out.println( jdomex.getMessage() );
	        System.out.println("Error xml: "+ jdomex.getMessage());
	    }
		return criterios;
	}
}
