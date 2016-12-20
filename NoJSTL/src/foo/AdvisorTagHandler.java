package foo;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Servlet implementation class AdvisorTagHandler
 */
@WebServlet("/AdvisorTagHandler")
public class AdvisorTagHandler extends SimpleTagSupport implements Servlet {
       private String user;
       public void doTag() throws IOException{
    	   getJspContext().getOut().write("Hello"+user+"<br>");
    	   getJspContext().getOut().write("Your advice is:"+getAdvice());
       }
       public void setUser(String user){
    	   this.user= user;
       }
       String getAdvice(){
    	   String[] adviceStrings={"Working","Sick"};
    	   int random = (int)(Math.random()*adviceStrings.length);
    	   return adviceStrings[random];
    	   
       }
    /**
     * @see SimpleTagSupport#SimpleTagSupport()
     */
    public AdvisorTagHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
