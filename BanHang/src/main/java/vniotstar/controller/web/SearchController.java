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

@WebServlet(urlPatterns = { "/search" })
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 2663367006258617424L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String txt = req.getParameter("txt");
		String cid = req.getParameter("cid");
		// bước 1: Khỏi tạo DAO
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		// Bước 2: Sử dụng đối tượng list để chứa danh sách từ ProductDAO
		// List<ProductModel> list = productDao.getAllProduct();
		ProductModel list1 = productDao.getTopProduct();
		List<ProductModel> list2 = productDao.getTop4Product();
		List<CategoryModel> listC = cateDao.getAllCategory();
		List<ProductModel> list = productDao.searchProduct(txt);
		// bước 3: Thiết lập dữ liệu lên JSP
		req.setAttribute("listAllproduct", list);
		req.setAttribute("listcate", listC);
		req.setAttribute("txtS", txt);
		req.setAttribute("list1BestSellerAndNew", list1);
		req.setAttribute("list4BestSeller", list2);
		req.setAttribute("listcate1", listC);
		req.setAttribute("tagactive", cid);
		// bước 4: Trả về trang JSP nào
		req.getRequestDispatcher("/views/product.jsp").forward(req, resp);
	}

}
