package vn.iotstar.api.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import vn.iostar.service.CategoryService;
import vn.iostar.service.impl.CategoryServiceImpl;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-category" })
public class CategoryAPIController extends HttpServlet{
	
	CategoryService categoryService = new CategoryServiceImpl();
	private static final long serialVersionUID = -2543933433199922718L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 ObjectMapper mapper = new ObjectMapper();
		 req.setCharacterEncoding("UTF-8");
		 resp.setContentType("application/json");
		 List<CategoryModel> cateModel =  HttpUtil.of(req.getReader()).listModel(CategoryModel.class);
		 cateModel = categoryService.getAll();
		 mapper.writeValue(resp.getOutputStream(), cateModel);
	}
	
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 ObjectMapper mapper = new ObjectMapper();
	 req.setCharacterEncoding("UTF-8");
	 resp.setContentType("application/json");
	 CategoryModel cateModel =  HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
	 categoryService.insert(cateModel);
	 mapper.writeValue(resp.getOutputStream(), "{Đã thêm thành công}");
	 }

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		 req.setCharacterEncoding("UTF-8");
		 resp.setContentType("application/json");
		 CategoryModel cateModel =  HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		 categoryService.edit(cateModel);
		 mapper.writeValue(resp.getOutputStream(), "{Đã sửa thành công}");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		 req.setCharacterEncoding("UTF-8");
		 resp.setContentType("application/json");
		 CategoryModel cateModel =  HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		 categoryService.delete(cateModel.getCate_id());
		 mapper.writeValue(resp.getOutputStream(), "{Đã xóa thành công}");
	}
}
