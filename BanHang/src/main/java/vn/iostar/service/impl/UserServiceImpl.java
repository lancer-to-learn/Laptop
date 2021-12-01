package vn.iostar.service.impl;

import vn.iostar.service.UserService;
import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.model.AccountModel;

public class UserServiceImpl implements UserService{

	UserDao users = new UserDaoImpl();
	@Override
	public void insert(AccountModel user) {
		// TODO Auto-generated method stub
		users.insert(user);
	}
	@Override
	public AccountModel get(int id) {
		// TODO Auto-generated method stub
		return users.get(id);
	}
	

}
