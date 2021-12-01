package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.service.CartService;
import vn.iostar.service.ProductService;
import vn.iostar.service.impl.CartServiceImpl;
import vn.iostar.service.impl.ProductServiceImpl;
import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.CartItemDao;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.AccountModel;
import vn.iotstar.model.CartItemModel;
import vn.iotstar.model.CartModel;
import vn.iotstar.model.ProductModel;

public class CartItemDaoImpl extends DBConnect implements CartItemDao{

	CartService cartService = new CartServiceImpl();
	ProductService productService = new ProductServiceImpl();
	UserDao userDao = new UserDaoImpl();

	@Override
	public void insert(CartItemModel cartItem) {
		String sql = "INSERT INTO CartItem(id, cat_id, pro_id, quantity, unitPrice) VALUES (?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cartItem.getId());
			ps.setString(2, cartItem.getCart().getId());
			ps.setInt(3, cartItem.getProduct().getpID());
			ps.setInt(4, cartItem.getQuantity());
			ps.setDouble(5, cartItem.getUnitPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CartItemModel cartItem) {
		String sql = "UPDATE CartItem SET cat_id = ?, pro_id = ?, quantity = ?, unitPrice=? WHERE id = ?";
			try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cartItem.getCart().getId());
			ps.setInt(2, cartItem.getProduct().getpID());
			ps.setInt(3, cartItem.getQuantity());
			ps.setDouble(4, cartItem.getUnitPrice());
			ps.setString(5, cartItem.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM CartItem WHERE id = ?";
		try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public CartItemModel get(int id) {
		String sql = "SELECT " + "CartItem.id, " + "CartItem.quantity, " + "CartItem.unitPrice, " + "cart.u_id, "
				+ "cart.buyDate, " + "product.name, " + "product.price " + "FROM CartItem " + "INNER JOIN Cart "
				+ "ON CartItem.cart_id = cart.id " + "INNER JOIN Product " + "ON CartItem.pro_id = Product.id "
				+ "WHERE CartItem.id = ?";
				try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userDao.get(rs.getInt("u_id"));
				CartModel cart = new CartModel();
				cart.setBuyer(user);
				cart.setBuyDate(rs.getDate("buyDate"));
				ProductModel product = new ProductModel();
				product.setpName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				CartItemModel cartItem = new CartItemModel();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getLong("unitPrice"));
				return cartItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartItemModel> getAll() {
		List<CartItemModel> cartItemList = new ArrayList<CartItemModel>();
		String sql = "SELECT " + "CartItem.id, " + "CartItem.quantity, " + "CartItem.unitPrice, " + "cart.u_id, "
				+ "cart.buyDate, " + "product.name, " + "product.price " + "FROM CartItem " + "INNER JOIN Cart "
				+ "ON CartItem.cat_id = Cart.id " + "INNER JOIN Product " + "ON CartItem.pro_id = Product.id ";
	
		try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userDao.get(rs.getInt(1));
				CartModel cart = new CartModel();
				cart.setBuyer(user);
				cart.setBuyDate(rs.getDate("buyDate"));
				ProductModel product = new ProductModel();
				product.setpName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				CartItemModel cartItem = new CartItemModel();
				cartItem.setId(rs.getString("id"));
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getLong("unitPrice"));
				cartItemList.add(cartItem);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItemList;
	}

	public List<CartItemModel> search(String name) {
		return null;
	}


}
