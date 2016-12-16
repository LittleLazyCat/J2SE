package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELServlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		foo.Person p = new foo.Person();
		p.setName("Leelu");
		foo.Dog d = new foo.Dog();
		d.setName("Clyde");
		foo.Toy t1 =new foo.Toy();
		t1.setName("stick");
		foo.Toy t2 =new foo.Toy();
		t2.setName("neighbor's cat");
		foo.Toy t3 =new foo.Toy();
		t3.setName("Barbie doll head");
		d.setToys(new foo.Toy[]{t1,t2,t3});
		p.setDog(d);
		request.setAttribute("person", p);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	}

}
