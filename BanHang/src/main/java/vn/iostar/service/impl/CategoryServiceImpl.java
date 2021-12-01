package vn.iostar.service.impl;
import java.io.File;
import java.util.List;

import vn.iostar.service.CategoryService;
import vn.iotstar.dao.CategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.model.CategoryModel;

public class CategoryServiceImpl implements CategoryService{
	
	CategoryDao categoryDao = new CategoryDaoImpl();
	
	@Override
	public void insert(CategoryModel cate) {
		// TODO Auto-generated method stub
		categoryDao.insert(cate);
		
	}

	@Override
	public void edit(CategoryModel cate) {
		// TODO Auto-generated method stub
		CategoryModel oldCategory = categoryDao.get(cate.getCate_id());
		oldCategory.setCname(cate.getCname());
		if (cate.getIcon() != null) {
		// XOA ANH CU DI
		String fileName = oldCategory.getIcon();
		final String dir = "D:\\Upload";
		File file = new File(dir + "/Category" + fileName);
		if (file.exists()) {
		file.delete();
		}
		oldCategory.setIcon(cate.getIcon());
		}
		categoryDao.edit(oldCategory);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryDao.delete(id);
	}

	@Override
	public CategoryModel get(int id) {
		// TODO Auto-generated method stub
		return categoryDao.get(id);
	}

	@Override
	public CategoryModel get(String name) {
		// TODO Auto-generated method stub
		return categoryDao.get(name);
	}

	@Override
	public List<CategoryModel> getAll() {
		// TODO Auto-generated method stub
		return categoryDao.getAll();
	}

	@Override
	public List<CategoryModel> search(String cateName) {
		// TODO Auto-generated method stub
		return categoryDao.search(cateName);
	}

}
