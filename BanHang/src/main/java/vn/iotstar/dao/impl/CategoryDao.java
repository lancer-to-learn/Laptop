package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.model.CategoryModel;

public class CategoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public CategoryModel getCategoryByID(String cid) {
		CategoryModel cate = null;
		String sql = "select * from Category where CategoryID=?";
		try {
			//mở kết nối
			conn = new DBConnect().getConnection();
			//Đưa câu sql vào sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			//Lấy kết quả 
			rs = ps.executeQuery();
			//Thêm kết quả vào list
			while (rs.next()) {
				cate = new CategoryModel(rs.getInt(1),
						rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cate;
	}
	
	public List<CategoryModel> getAllCategory(){
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "select * from Category";
		try {
			//mở kết nối
			conn = new DBConnect().getConnection();
			//Đưa câu sql vào sql
			ps = conn.prepareStatement(sql);
			//Lấy kết quả 
			rs = ps.executeQuery();
			//Thêm kết quả vào list
			while (rs.next()) {
				list.add(new CategoryModel(rs.getInt(1),
						rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
