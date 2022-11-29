package model.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dbconfig.DBConfig;
import model.Bean.Account;
import model.Bean.Manufacturer;
import model.Bean.Product;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<Product> getAllProductDAO()
	{
		ArrayList<Product> list = new ArrayList();
		String query = "SELECT * FROM product";
		
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next())
			{
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getInt(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public ArrayList<Manufacturer> getAllManufacturerDAO()
	{
		ArrayList<Manufacturer> list = new ArrayList();
		String query = "SELECT * FROM manufacturer";
		
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next())
			{
				list.add(new Manufacturer(rs.getInt(1), 
						rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public Product getLatestProductDAO()
	{
		String query = "SELECT * FROM product\r\n"
				+ "ORDER BY id desc\r\n"
				+ "LIMIT 1";
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next())
			{
				return new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getInt(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public ArrayList<Product> getProductBymIDDAO(String mid)
	{
		ArrayList<Product> list = new ArrayList();
		String query = "SELECT * FROM product\r\n"
				+ "WHERE mID = ?";
		
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			while (rs.next())
			{
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getInt(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public Product getProductByIDDAO(String id)
	{
		String query = "SELECT * FROM product\r\n"
				+ "WHERE id = ?";
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next())
			{
				return new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getInt(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public ArrayList<Product> getListSearchDAO(String txtSearch)
	{
		ArrayList<Product> list = new ArrayList();
		String query = "SELECT * FROM product\r\n"
				+ "WHERE name LIKE ? OR price LIKE ? OR title LIKE ? OR describtion LIKE ?";
		
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, "%"+ txtSearch +"%");
			ps.setString(2, "%"+ txtSearch +"%");
			ps.setString(3, "%"+ txtSearch +"%");
			ps.setString(4, "%"+ txtSearch +"%");
			rs = ps.executeQuery();
			while (rs.next())
			{
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getInt(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public Account getAccountDAO(String user, String pass)
	{
		String query = "SELECT * FROM account\r\n"
				+ "WHERE user = ? AND pass = ?";
		
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			while (rs.next())
			{
				return new Account(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public Account checkSingupDAO(String user)
	{
		String query = "SELECT * FROM account\r\n"
				+ "WHERE user = ?";
		
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			
			while (rs.next())
			{
				return new Account(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public void signUpDAO(String user, String pass)
	{
		String query = "INSERT INTO account VALUES(0,?,?,0,0)";
		
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public ArrayList<Product> getProductBySellIDDAO(int id)
	{
		ArrayList<Product> list = new ArrayList();
		String query = "SELECT * FROM product WHERE sell_ID = ?";
		
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next())
			{
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getInt(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public void deleteProductDAO(String pid)
	{
		String query = "DELETE FROM product WHERE id = ?";
		
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, pid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void addProductDAO(String name, String image, String price, String title, String description, 
			String p_mid, int sell_id)
	{
		String query = "INSERT INTO product VALUES(0,?,?,?,?,?,?,?)";
		
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, p_mid);
			ps.setInt(7, sell_id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void editProductDAO(String name, String image, String price, String title, String description, 
			String p_mid, String pid)
	{
		String query = "UPDATE product  \r\n"
				+ "SET name = ?,\r\n"
				+ "image = ?,\r\n"
				+ "price = ?,\r\n"
				+ "title = ?,\r\n"
				+ "describtion = ?,\r\n"
				+ "mID = ?\r\n"
				+ "WHERE id = ?";
		
		try {
			conn = new DBConfig().getConnection(); // mo ket noi CSDL
			ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, p_mid);
			ps.setString(7, pid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		DAO dao = new DAO();
//		ArrayList<Product> list = dao.getAllProductDAO();
//		ArrayList<Manufacturer> listM = dao.getAllManufacturerDAO();
//		for (Product o : list) {
//			System.out.println(o);
//		}
		
//		System.out.println(dao.getLatestProductDAO());
		
//		ArrayList<Product> list = dao.getProductBymIDDAO("1");
//		for (Product o : list) {
//			System.out.println(o);
//		}
		
//		ArrayList<Product> listSearch = dao.getListSearchDAO("2490000");
//		for (Product o : listSearch) {
//			System.out.println(o);
//		}
		
//		System.out.println(dao.getAccountDAO("user1", "123456"));
		
//		System.out.println(dao.checkSingupDAO("user1"));
		
//		dao.signUpDAO("tan", "999");
		
//		ArrayList<Product> listSellID = dao.getProductBySellIDDAO("7");
//		for (Product o : listSellID) {
//			System.out.println(o);
//		}
		
//		dao.deleteProductDAO("1");
		
//		dao.addProductDAO("name111", "image111", "123.123", "title", "describtion111", "1", 1);
		
//		dao.editProductDAO("name111", "image111", "999", "title111", "describtion111", "2", "1");
	}
}
