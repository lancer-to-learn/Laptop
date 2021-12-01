package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.CategoryDao;
import vn.iotstar.model.CategoryModel;

public class CategoryDaoImpl implements CategoryDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(CategoryModel cate) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Category(CategoryName, icon) VALUES (?,?)";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cate.getCname());
			ps.setString(2, cate.getIcon());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(CategoryModel cate) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Category SET CategoryName = ?, icon=? WHERE CategoryId = ?";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cate.getCname());
			ps.setString(2, cate.getIcon());
			ps.setInt(3, cate.getCate_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Category WHERE CategoryId = ?";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public CategoryModel get(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from Category where CategoryID=?";
		try {

			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCate_id(rs.getInt(1));
				category.setCname(rs.getString(2));
				category.setIcon(rs.getString(3));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public CategoryModel get(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from Category where CategoryName=?";
		try {

			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCate_id(rs.getInt(1));
				category.setCname(rs.getString(2));
				category.setIcon(rs.getString(3));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<CategoryModel> getAll() {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM Category";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCate_id(rs.getInt(1));
				category.setCname(rs.getString(2));
				category.setIcon(rs.getString(3));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<CategoryModel> search(String cateName) {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM Category where CategoryName like N'%?%'";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cateName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCate_id(rs.getInt(1));
				category.setCname(rs.getString(2));
				category.setIcon(rs.getString(3));
				categories.add(category);
				return categories;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
