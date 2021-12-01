package vn.iostar.service;

import java.util.List;

import vn.iotstar.model.CategoryModel;

public interface CategoryService {
	void insert(CategoryModel cate);
	void edit(CategoryModel cate);
	void delete(int id);
	CategoryModel get(int id);
	CategoryModel get(String name);
	List<CategoryModel> getAll();
	List<CategoryModel> search(String cateName);

}
