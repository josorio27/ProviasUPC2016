package pe.edu.cibertec.mybatis.factory;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 *
 * @author Administrador
 */
public class SessionFactory {
    
	 protected static final SqlSessionFactory FACTORY;
	     
	    static{
	        try{
	            Reader reader= Resources.getResourceAsReader(
	             "pe/edu/cibertec/mybatis/config/mybatis-config.xml");

	            FACTORY= new SqlSessionFactoryBuilder().build(reader);
	            
	        }catch(Exception e){
	            throw new RuntimeException("Error: " + e);
	        }
	    }
	 
	    
	    public static SqlSessionFactory getSqlSessionFactory(){
	        return FACTORY;
	    }
}

