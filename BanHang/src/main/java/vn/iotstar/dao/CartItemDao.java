package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.CartItemModel;

public interface CartItemDao {
	void insert(CartItemModel cartItem);
	 void edit(CartItemModel cartItem);
	 void delete(String id);
	 CartItemModel get(int id);
	 List<CartItemModel> getAll();
	 List<CartItemModel> search(String keyword);

}
