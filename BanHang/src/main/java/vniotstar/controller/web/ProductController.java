package vniotstar.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iostar.service.ProductService;
import vn.iostar.service.impl.ProductServiceImpl;
import vn.iotstar.dao.impl.CategoryDao;
import vn.iotstar.dao.impl.ProductDao;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;

@WebServlet(urlPatterns = { "/product", "/san-pham" })
public class ProductController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3899223021687054389L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lấy tham số từ Jsp
		String cid = req.getParameter("cid");
		String indexPage = req.getParameter("index");
		ProductService productService = new ProductServiceImpl();
		// Khởi tạo DAO
		ProductDao pDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		// Sử dụng đối tượng list để chứa ds từ productDao
		// List<ProductModel> list = productService.getTop4Product();
		// List<ProductModel> pro = pDao.getTopProduct();
		ProductModel pro = productService.getTopProduct();

		List<ProductModel> best = productService.getTop4BestProduct();

		List<CategoryModel> listC = cateDao.getAllCategory();
		List<ProductModel> listPBC = null;

		// khởi tạo trang đầu
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		 int cid1 = Integer.parseInt(cid);
		/*
		 * chia trang cho count int endPage = count/3; if (count%3!=0) { endPage ++; }
		 * List<ProductModel> listp = productService.pagingProduct(index);
		 * req.setAttribute("listpage", listp); req.setAttribute("endP", endPage); //lấy
		 * sản phẩm theo loại hoặc tất cả if (cid.equals("0")) { listPBC =
		 * pDao.getAllProduct(); } else { listPBC = pDao.getAllProductByCID(cid); }
		 */
		if ("0".equals(cid)) { // All product
			int count = productService.countAll();
			// chia trang cho count
			int endPage = count / 3;
			if (count % 3 != 0) {
				endPage++;
			}
			List<ProductModel> list = productService.pagingProduct(index);
			req.setAttribute("endP", endPage);
			req.setAttribute("listAllproduct", list);
		} else {
			int count = productService.countCid(cid1);
			int endPage = count / 3;
			if (count % 3 != 0) {
				endPage++;
			}
			List<ProductModel> listPC = productService.pagingProductByCid(index, cid1);
			req.setAttribute("listAllproduct", listPC);
			req.setAttribute("endP", endPage);
		}
		// bước 3: Thiết lập dữ liệu lên JSP
		req.setAttribute("lastproduct", pro);
		req.setAttribute("bestproduct", best);
		req.setAttribute("listcate", listC);
		req.setAttribute("listproductbycid", listPBC);
		req.setAttribute("tagactive", cid);
		req.setAttribute("tag", index);
		// bước 4: trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/product.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
