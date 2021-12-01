package vniotstar.controller.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iostar.service.ProductService;
import vn.iostar.service.impl.ProductServiceImpl;
import vn.iotstar.model.CartItemModel;
import vn.iotstar.model.ProductModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/member/cart-add" })
public class CartAddController extends HttpServlet{
	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html");
		 resp.setCharacterEncoding("UTF-8");
		 req.setCharacterEncoding("UTF-8");
		 String pId = req.getParameter("pId");
		 String quantity = req.getParameter("quantity");
		 ProductModel product = productService.getProductbyID(pId);
		 CartItemModel cartItem = new CartItemModel();
		 cartItem.setQuantity(Integer.parseInt(quantity));
		 cartItem.setUnitPrice(product.getPrice());
		 cartItem.setProduct(product);
		 HttpSession httpSession = req.getSession();
		 Object obj = httpSession.getAttribute("cart");
		 if (obj == null) {
			 Map<Integer, CartItemModel> map = new HashMap<Integer, CartItemModel>();
			 map.put(cartItem.getProduct().getpID(), cartItem);
			 httpSession.setAttribute("cart", map);
		 } 
		 else {
			 Map<Integer, CartItemModel> map = extracted(obj);
			 CartItemModel existedCartItem = map.get(Integer.valueOf(pId));
			 if (existedCartItem == null) {
				 map.put(product.getpID(), cartItem);
			 }
			 else {
				 existedCartItem.setQuantity(existedCartItem.getQuantity() + Integer.parseInt(quantity));
			 }
			 httpSession.setAttribute("cart", map);
		 }
		 resp.sendRedirect(req.getContextPath() + "/member/cart");
	}
	@SuppressWarnings("unchecked")
	private Map<Integer, CartItemModel> extracted(Object obj) {
		return (Map<Integer, CartItemModel>) obj;
	}
}


