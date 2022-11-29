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


@WebServlet("/loadproduct")
public class LoadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoadProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("pid");
		
		BO bo = new BO();
		
		Product p = bo.getProductByIDBO(id);
		ArrayList<Manufacturer> listM = bo.getAllManufacturerBO();
		
		request.setAttribute("detail", p);
		request.setAttribute("listM", listM);
		
		request.getRequestDispatcher("Edit.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
