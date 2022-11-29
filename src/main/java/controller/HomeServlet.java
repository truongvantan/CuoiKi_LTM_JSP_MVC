package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.BO;
import model.Bean.Manufacturer;
import model.Bean.Product;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		BO bo = new BO();
		
		ArrayList<Product> list = bo.getAllProductBO();
		ArrayList<Manufacturer> listM = bo.getAllManufacturerBO();
		Product latestProduct = bo.getLatestProductBO();
		
		request.setAttribute("listProduct", list);
		request.setAttribute("listManufacturer", listM);
		request.setAttribute("latestProduct", latestProduct);
		request.getRequestDispatcher("Home.jsp").forward(request, response); // chuyen trang cung voi du lieu
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
