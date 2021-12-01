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

@WebServlet(urlPatterns = {"/productdetail"})
public class ProductDetailController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//lấy tham số từ Jsp
		String pid = req.getParameter("pid");
		//String cid = req.getParameter("cid");
		//Khởi tạo DAO
		ProductDao pDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		//Sử dụng đối tượng list để chứa ds từ productDao
		ProductModel prodetail =  pDao.getProductbyID(pid);
		
		List<ProductModel> best = pDao.getTop4BestProduct();
		
		List<CategoryModel> listC = cateDao.getAllCategory();
		List<ProductModel> listPBC = null;
		String cid = String.valueOf(prodetail.getCategoryID());
		CategoryModel cate = cateDao.getCategoryByID(cid);
		
		//CategoryModel cate = cateDao.getCategoryByID(cid);
		//String category = cate.getCname();
		//lấy sản phẩm theo loại hoặc tất cả
		//bước 3: Thiết lập dữ liệu lên JSP
		req.setAttribute("product", prodetail);
		req.setAttribute("bestproduct", best);
		req.setAttribute("listcate", listC);
		req.setAttribute("listproductbycid", listPBC);
		req.setAttribute("category", cate);
		
		//bước 4: trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/productdetail.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doPost(req, resp);
	}

}
