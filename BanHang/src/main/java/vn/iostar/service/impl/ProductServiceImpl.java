package vn.iostar.service.impl;

import java.util.List;

import vn.iostar.service.ProductService;
import vn.iotstar.dao.ProductDao;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.ProductModel;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = new ProductDaoImpl();
	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return productDao.countAll();
	}
	@Override
	public ProductModel getTopProduct() {
		// TODO Auto-generated method stub
		return productDao.getTopProduct();
	}
	@Override
	public List<ProductModel> getTop4BestProduct() {
		// TODO Auto-generated method stub
		return productDao.getTop4BestProduct();
	}
	@Override
	public List<ProductModel> getAllProductByCID(String cid) {
		// TODO Auto-generated method stub
		return productDao.getAllProductByCID(cid);
	}
	@Override
	public List<ProductModel> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}
	@Override
	public ProductModel getProductbyID(String id) {
		// TODO Auto-generated method stub
		return productDao.getProductbyID(id);
	}
	@Override
	public List<ProductModel> searchProduct(String name) {
		// TODO Auto-generated method stub
		return productDao.searchProduct(name);
	}
	@Override
	public List<ProductModel> pagingProduct(int index) {
		// TODO Auto-generated method stub
		return productDao.pagingProduct(index);
	}
	@Override
	public List<ProductModel> getTop4Product() {
		// TODO Auto-generated method stub
		return productDao.getTop4Product();
	}
	@Override
	public int countCid(int cid) {
		// TODO Auto-generated method stub
		return productDao.countCid(cid);
	}
	@Override
	public List<ProductModel> pagingProductByCid(int index, int cid) {
		// TODO Auto-generated method stub
		return productDao.pagingProductByCid(index, cid);
	}

}
