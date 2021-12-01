package vn.iotstar.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.ProductDao;
import vn.iotstar.model.ProductModel;

public class ProductDaoImpl implements ProductDao {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public int countAll() {
		String sql = "select count(productID) from Product";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public ProductModel getTopProduct() {
		ProductModel pro = null;
		String sql = "select Top 1 * from Product order by Amount Desc";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				pro = new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return pro;
	}

	@Override
	public List<ProductModel> getTop4BestProduct() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select Top 4 * from Product order by Amount Desc";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public List<ProductModel> getAllProductByCID(String cid) {
		// Khai báo List để lưu danh sách sp
				List<ProductModel> list = new ArrayList<ProductModel>();
				// Khai báo chuỗi truy vấn
				String sql = "select * from product\r\n" + "where CategoryID = ?";
				try {
					// mở kết nối database
					conn = new DBConnect().getConnection();
					// Ném câu query qua sql
					ps = conn.prepareStatement(sql);
					// gán giá trị cho dấu hỏi
					ps.setString(1, cid);
					// chạy query và nhận kết quả
					rs = ps.executeQuery();
					// lấy ResultSet đổ vào List
					while (rs.next()) {
						list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
								rs.getInt(6), rs.getInt(7), rs.getInt(8)));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return list;
	}

	@Override
	public List<ProductModel> getAllProduct() {
		// Khai báo List để lưu danh sách sp
				List<ProductModel> list = new ArrayList<ProductModel>();
				// Khai báo chuỗi truy vấn
				String sql = "select * from Product \r\n" + "order by price ASC";
				try {
					// mở kết nối database
					conn = new DBConnect().getConnection();
					// Ném câu query qua sql
					ps = conn.prepareStatement(sql);
					// chạy query và nhận kết quả
					rs = ps.executeQuery();
					// lấy ResultSet đổ vào List
					while (rs.next()) {
						list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
								rs.getInt(6), rs.getInt(7), rs.getInt(8)));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return list;
	}

	@Override
	public ProductModel getProductbyID(String id) {
		String sql = "select * from product\r\n" + "where ProductID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<ProductModel> searchProduct(String name) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product where ProductName like N'%?%'";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> pagingProduct(int index) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product order by ProductID offset ? row fetch next 4 row only";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index-1)*3);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> getTop4Product() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select Top 4 * from Product order by ProductID Desc";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public int countCid(int cid) {
		String sql = "select count(productID) from Product where CategoryID=?";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<ProductModel> pagingProductByCid(int index, int cid) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product where CategoryID=? order by ProductID offset ? row fetch next 4 row only";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, (index-1)*3);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
