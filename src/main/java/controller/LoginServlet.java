package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BO.BO;
import model.Bean.Account;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		
		BO bo = new BO();
		
		Account a = bo.getAccountBO(username, password);
		
		if (a != null)
		{
//			request.getRequestDispatcher("home").forward(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("acc", a);
			response.sendRedirect("home"); // chuyen trang khong chuyen du lieu
		}
		else
		{
			request.setAttribute("mess", "Sai tài khoản hoặc mật khẩu");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
