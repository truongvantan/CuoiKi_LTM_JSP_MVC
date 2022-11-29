package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BO.BO;
import model.Bean.Account;
import model.Bean.Manufacturer;
import model.Bean.Product;


@WebServlet("/managerp")
public class ManagerProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ManagerProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		Account a = (Account)session.getAttribute("acc");
		
		int id = a.getId();
		BO bo = new BO();
		ArrayList<Product> list = bo.getProductBySellIDBO(id);
		ArrayList<Manufacturer> listM = bo.getAllManufacturerBO();
		
		request.setAttribute("listProduct", list);
		request.setAttribute("listM", listM);
		request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
