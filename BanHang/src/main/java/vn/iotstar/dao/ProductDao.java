package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.ProductModel;

public interface ProductDao {
	int countAll();
	int countCid(int cid);
	ProductModel getTopProduct();
	List<ProductModel> getTop4BestProduct();
	List<ProductModel> getAllProductByCID(String cid);
	List<ProductModel> getAllProduct();
	ProductModel getProductbyID(String id);
	List<ProductModel> searchProduct(String name);
	List<ProductModel> pagingProduct(int index);
	public List<ProductModel> getTop4Product();
	List<ProductModel> pagingProductByCid(int index, int cid);
}
