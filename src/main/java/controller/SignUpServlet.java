package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.BO;
import model.Bean.Account;


@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String re_pass = request.getParameter("repass");
		
		if (pass.equals(re_pass))
		{
			BO bo = new BO();
			Account a = bo.checkSingupBO(user);
			
			if (a == null) // chua co tai khoan trong CSDL
			{
				bo.signUpBO(user, pass);
				response.sendRedirect("home");
			}
			else
			{
				response.sendRedirect("Login.jsp");
			}
		}
		else
		{
			response.sendRedirect("Login.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
