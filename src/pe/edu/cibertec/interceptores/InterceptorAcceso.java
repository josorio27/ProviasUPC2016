
package pe.edu.cibertec.interceptores;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterceptorAcceso extends AbstractInterceptor
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String actionsPublicos;
    private List<String> actionsSinFiltrar = new ArrayList<String>();
    
    @Override
    public void init()
    {
        actionsSinFiltrar = Arrays.asList(actionsPublicos.split(","));
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception
    {
        String result = Action.LOGIN;

        String actionActual = (String)ActionContext.getContext().get(ActionContext.ACTION_NAME);
        
        if (actionInvocation.getInvocationContext().getSession().containsKey("usuario") || actionsSinFiltrar.contains(actionActual))
        {
            result = actionInvocation.invoke();
        }

        
        return result;
    }

    public void setActionsPublicos(String actionsPublicos)
    {
        this.actionsPublicos = actionsPublicos;
    }
}
