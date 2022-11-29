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


@WebServlet("/addp")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String image = request.getParameter("image");
		String price = request.getParameter("price");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String p_mid = request.getParameter("manufacturer");
		
		HttpSession session = request.getSession();
		
		Account a = (Account)session.getAttribute("acc");
		
		int sell_id = a.getId();
		
		BO bo = new BO();
		
		bo.addProductBO(name, image, price, title, description, p_mid, sell_id);
		response.sendRedirect("managerp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
