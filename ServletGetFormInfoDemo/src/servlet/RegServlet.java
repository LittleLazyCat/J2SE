package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entity.Users;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Users u =new Users();
		String username,gender,flag;
		String[] favourites;
		Date birthday;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try
		{
			username = request.getParameter("username");
			gender = request.getParameter("gender");
			favourites = request.getParameterValues("favourite");
			birthday = sdf.parse(request.getParameter("birthday"));
			flag = request.getParameter("isAccept");
			u.setUsername(username);
			u.setGender(gender);
			u.setFavourites(favourites);
			u.setFlag("true".equals(flag)?true:false);
			u.setBirthday(birthday);
			
			//把注册成功的用户对象保存在session中
			request.getSession().setAttribute("regUser", u);
			RequestDispatcher view = request.getRequestDispatcher("userinfo.jsp");
			view.forward(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
