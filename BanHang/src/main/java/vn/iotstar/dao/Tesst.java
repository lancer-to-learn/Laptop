package vn.iotstar.dao;

import vn.iotstar.dao.impl.ProductDao;

//import java.util.ArrayList;
//import java.util.List;

import vn.iotstar.model.ProductModel;

public class Tesst {
public static void main(String[] args) {
	//List<ProductModel> p = new ArrayList<ProductModel>();
	
	ProductDao dao = new ProductDao();
	ProductModel p = dao.getTopProduct();
	System.out.println(p.toString());
}
}
