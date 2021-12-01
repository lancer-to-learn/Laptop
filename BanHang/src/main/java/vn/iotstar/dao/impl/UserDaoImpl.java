package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.AccountModel;


public class UserDaoImpl implements UserDao{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public void insert(AccountModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountModel get(int id) {
		String sql = "select * from Users where UserID=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getInt(5));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	

}
