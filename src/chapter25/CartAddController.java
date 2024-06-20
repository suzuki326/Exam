package chapter25;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import bean.Product;
import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter25/cart-add" })
public class CartAddController extends CommonServlet {

	@Override
	@SuppressWarnings("unchecked")
	protected void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();

		int id = Integer.parseInt(req.getParameter("id"));

		List<Item> cart = (List<Item>) session.getAttribute("session_cart");
		if (cart == null) {
			cart = new ArrayList<Item>();
			session.setAttribute("session_cart", cart);
		}

		for (Item i : cart) {
			if (i.getProduct().getId() == id) {
				i.setCount(i.getCount() + 1);
				resp.sendRedirect("cart");
				return;
			}
		}

		List<Product> list = (List<Product>) session.getAttribute("session_list");
		for (Product p : list) {
			if (p.getId() == id) {
				Item i = new Item();
				i.setProduct(p);
				i.setCount(1);
				cart.add(i);
			}
		}

		resp.sendRedirect("cart");
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
