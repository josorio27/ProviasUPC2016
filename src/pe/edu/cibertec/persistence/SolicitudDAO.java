package pe.edu.cibertec.persistence;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;

import pe.edu.cibertec.model.Solicitud;
import pe.edu.cibertec.mybatis.factory.SessionFactory;
import pe.edu.cibertec.mybatis.mapper.SolicitudMapper;

public class SolicitudDAO {
	public void insertar(Solicitud solicitud) throws Exception {
		
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
		
		solicitudMapper.registrar(solicitud);
		sqlSession.commit();
		
		sqlSession.close();
		
	}
	
	@SuppressWarnings("finally")
	public List<Solicitud> listarSolicitudes() throws Exception {
		List<Solicitud> lista = null;
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		try {
			SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
			lista=solicitudMapper.listarSolicitudes();
			
			
			sqlSession.commit();			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		finally{
			if(sqlSession != null){
				sqlSession.close();
				return lista;
			}
			else
				return null;
			}
		
	}	
	@SuppressWarnings("finally")
	public List<Solicitud> listarSolicitudesxNroSolicitud(String nroSolicitud) throws Exception {
		List<Solicitud> lista = null;
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		try {
			SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
			lista=solicitudMapper.listarSolicitudesxNroSolicitud(nroSolicitud);
			
			
			sqlSession.commit();			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		finally{
			if(sqlSession != null){
				sqlSession.close();
				return lista;
			}
			else
				return null;
			}
	}
	@SuppressWarnings("finally")
	public List<Solicitud> listarSolicitudesxDni(String dni) throws Exception {
		List<Solicitud> lista = null;
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		try {
			SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
			lista=solicitudMapper.listarSolicitudesxDni(dni);
			
			
			sqlSession.commit();			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		finally{
			if(sqlSession != null){
				sqlSession.close();
				return lista;
			}
			else
				return null;
			}
		
	}	
	
	@SuppressWarnings("finally")
	public List<Solicitud> listarSolicitudesxEstado(String estado) throws Exception {
		List<Solicitud> lista = null;
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		try {
			SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
			lista=solicitudMapper.listarSolicitudesxEstado(estado);
			
			
			sqlSession.commit();			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		finally{
			if(sqlSession != null){
				sqlSession.close();
				return lista;
			}
			else
				return null;
			}
		
	}	
	public static void modificar(Solicitud solicitud) throws Exception {
		
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
		
		solicitudMapper.modificar(solicitud);
		sqlSession.commit();
		
		sqlSession.close();
	}
	public static void actualizarEstado(Solicitud solicitud) throws Exception {
		
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
		
		solicitudMapper.actualizarEstado(solicitud);
		sqlSession.commit();
		
		sqlSession.close();
	}
	public static void eliminar(String nroSolicitud) throws Exception {
		
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
		
		solicitudMapper.eliminar(nroSolicitud);
		sqlSession.commit();
		
		sqlSession.close();
	}


	@SuppressWarnings("finally")
	public Solicitud generarNroSolicitud() throws Exception {
		
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		Solicitud solicitud=null;
		try {
			SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
			solicitud=solicitudMapper.generarNroSolicitud();
			sqlSession.commit();			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		finally{
			if(sqlSession != null){
				sqlSession.close();
				return solicitud;
			}
			else
				return null;
			}


	}
	
	@SuppressWarnings("finally")
	public static Solicitud getSolicitudPorNro(String nroSolicitud) throws Exception {
		
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		Solicitud solicitud=null;
		try {
			SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
			solicitud=solicitudMapper.getSolicitudPorNro(nroSolicitud);
			sqlSession.commit();			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		finally{
			if(sqlSession != null){
				sqlSession.close();
				return solicitud;
			}
			else
				return null;
			}
	}
	@SuppressWarnings("finally")
	public static Solicitud getSolicitudPorNroA(String nroSolicitud) throws Exception {
		
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		Solicitud solicitud=null;
		try {
			SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
			solicitud=solicitudMapper.getSolicitudPorNroA(nroSolicitud);
			sqlSession.commit();			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		finally{
			if(sqlSession != null){
				sqlSession.close();
				return solicitud;
			}
			else
				return null;
			}
	}	
	public String guardarFile(File revisionTecnica, String file, String filePath) throws Exception{ 
        try {             
            
        	//String filePath = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");   
        	String concatenar = file + "/";
        	String FinalArchivo=filePath.concat(concatenar);   
        	System.out.println("rev" + FinalArchivo);
            File fileToCreate = new File(FinalArchivo);   
            FileUtils.copyFile(revisionTecnica , fileToCreate);  
        }  
        catch (Exception e) {             
            e.printStackTrace();             
                  }        
        return "OK"; 
           
 
   } 
	
	public void EnviarEmail(String email, Solicitud solicitud) throws Exception{

		Properties properties = System.getProperties(); 
		Session ses  = Session.getInstance(properties); 
		Transport tr = ses.getTransport("smtps"); 
		MimeMessage msg = new MimeMessage(ses); 
        String server = "smtp.gmail.com"; 
        String userName = "provias2013@gmail.com"; 
        String password = "dawi123456"; 
        String fromAddres = "provias2013@gmail.com"; 
        String toAddres = email; 
        String cc = "gbchavarry@gmail.com"; 
        String bcc = ""; 
        boolean htmlFormat = false; 
        String subject = "Provias Notificación"; 
		
        String body = "Nro Solicitud: " + solicitud.getNroSolicitud() + ". " + "Estado de la solicitud: " + solicitud.getEstado() + ". " + "Provias" ; 
        
        properties.put("mail.smtps.host", server); 
        properties.put("mail.smtps.auth", "true"); 
        

        ses.setDebug(true); 

        try{ 

            msg.setFrom(new InternetAddress(fromAddres)); 
     
            if (toAddres != null) 
            { 
               msg.addRecipients(Message.RecipientType.TO, toAddres); 
            } 
     
            if (cc != null) 
            { 
                msg.setRecipients(Message.RecipientType.CC 
                        ,InternetAddress.parse(cc, false)); 
            } 
     
            if (bcc != null) 
            { 
                msg.setRecipients(Message.RecipientType.BCC 
                        ,InternetAddress.parse(bcc, false)); 
            } 
     
            if (htmlFormat) 
            { 
                msg.setContent(body, "text/html"); 
            } 
            else 
            { 
                msg.setContent(body, "text/plain"); 
            } 
     
            msg.setSubject(subject); 
            msg.saveChanges(); 
     
            
            tr.connect(server,userName, password); 
            tr.sendMessage(msg, msg.getAllRecipients()); 
            tr.close(); 
        } 
        catch(MessagingException e) 
        { 
            e.printStackTrace(); 
            System.out.println("Error Mail" + e);
        } 
        finally{
        	tr.close(); 
        }
         
         

    }

	@SuppressWarnings("finally")
	public static Solicitud consultarSolicitudFullxNro(String nroSolicitud) {
		SqlSession sqlSession=SessionFactory.getSqlSessionFactory().openSession();
		Solicitud solicitud=null;
		try {
			SolicitudMapper solicitudMapper=sqlSession.getMapper(SolicitudMapper.class);
			solicitud=solicitudMapper.consultarSolicitudFullxNro(nroSolicitud);
			sqlSession.commit();			 
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		finally{
			if(sqlSession != null){
				sqlSession.close();
				return solicitud;
			}
			else
				return null;
			}
	} 


}



