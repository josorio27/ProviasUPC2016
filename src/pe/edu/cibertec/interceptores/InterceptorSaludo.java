/*
 * InterceptorSaludo.java
 *
 * Creada el 20/06/2012, 11:14:10 PM
 *
 * Clase Java desarrollada por Alex para el blog http://javatutoriales.com/ el día 20/06/2012
 *
 * Para informacion sobre el uso de esta clase, asi como bugs, actualizaciones, o mejoras enviar un mail a
 * programadorjavablog@gmail.com
 *
 * No olviden hacerse fans del grupo de Java Tutoriales en facebook  http://www.facebook.com/pages/Java-Tutoriales/121935157864634
 *
 */

package pe.edu.cibertec.interceptores;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
//import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.text.DateFormat;
import java.util.Date;


public class InterceptorSaludo implements Interceptor
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void destroy()
    {
    }

    @Override
    public void init()
    {
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception
    {
        System.out.println("Bienvenido Proyecto Dawi");
        String actionName = (String)ActionContext.getContext().get(ActionContext.ACTION_NAME);
        String tiempoActual = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date());
        
        System.out.println("Ejecutando " + actionName + " a las " + tiempoActual);
        
        String resultado = actionInvocation.invoke();
        
        System.out.println("Gracias, regresa pronto :)");
        
        return resultado;
    }    
}
