package model.BO;

import java.util.ArrayList;

import model.Bean.Account;
import model.Bean.Manufacturer;
import model.Bean.Product;
import model.DAO.DAO;

public class BO {
	DAO dao = new DAO();
	public ArrayList<Product> getAllProductBO()
	{
		return dao.getAllProductDAO();
	}
	
	public ArrayList<Manufacturer> getAllManufacturerBO()
	{
		return dao.getAllManufacturerDAO();
	}
	
	public Product getLatestProductBO()
	{
		return dao.getLatestProductDAO();
	}
	
	public ArrayList<Product> getProductBymIDBO(String mid)
	{
		return dao.getProductBymIDDAO(mid);
	}
	
	public Product getProductByIDBO(String id)
	{
		return dao.getProductByIDDAO(id);
	}
	
	public ArrayList<Product> getListSearchBO(String txtSearch)
	{
		return dao.getListSearchDAO(txtSearch);
	}
	
	public Account getAccountBO(String user, String pass)
	{
		return dao.getAccountDAO(user, pass);
	}
	
	public Account checkSingupBO(String user)
	{
		return dao.checkSingupDAO(user);
	}
	
	public void signUpBO(String user, String pass)
	{
		dao.signUpDAO(user, pass);
	}
	
	public ArrayList<Product> getProductBySellIDBO(int id)
	{
		return dao.getProductBySellIDDAO(id);
	}
	
	public void deleteProductBO(String pid)
	{
		dao.deleteProductDAO(pid);
	}
	
	public void addProductBO(String name, String image, String price, String title, String description, 
			String p_mid, int sell_id)
	{
		dao.addProductDAO(name, image, price, title, description, p_mid, sell_id);
	}
	
	public void editProductBO(String name, String image, String price, String title, String description, 
			String p_mid, String pid)
	{
		dao.editProductDAO(name, image, price, title, description, p_mid, pid);
	}
	
}
