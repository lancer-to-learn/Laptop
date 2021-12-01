package vniotstar.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.impl.CategoryDao;
import vn.iotstar.dao.impl.ProductDao;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;


@WebServlet(urlPatterns = {"/home","/trang-chu"})
public class HomeController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//Khởi tạo DAO
		ProductDao pDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		//Sử dụng đối tượng list để chứa ds từ productDao
		List<ProductModel> list = pDao.getTop4Product();
		//List<ProductModel> pro = pDao.getTopProduct();
		ProductModel pro = pDao.getTopProduct();
		
		List<ProductModel> best = pDao.getTop4BestProduct();
		
		List<CategoryModel> listC = cateDao.getAllCategory();
		//bước 3: Thiết lập dữ liệu lên JSP
		req.setAttribute("list4product", list);
		req.setAttribute("topproduct", pro);
		req.setAttribute("bestproduct", best);
		req.setAttribute("listcate", listC);
		//bước 4: trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/home.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doPost(req, resp);
	}
}
