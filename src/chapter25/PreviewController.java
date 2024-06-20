package chapter25;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import dao.PurchaseDAO;
import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter25/preview" })
public class PreviewController extends CommonServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		if (session.getAttribute("session_customer") == null) {
			req.getRequestDispatcher("preview-error-login.jsp").forward(req, resp);
			return;
		}

		List<Item> cart = (List<Item>) session.getAttribute("session_cart");
		if (cart == null || cart.size() == 0) {
			req.getRequestDispatcher("preview-error-cart.jsp").forward(req, resp);
			return;
		}

		req.getRequestDispatcher("purchase-in.jsp").forward(req, resp);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session=req.getSession();

		String name=req.getParameter("name");
		String address=req.getParameter("address");
		if (name.isEmpty() || address.isEmpty()) {
			req.setAttribute("error", "名前と住所を正しく入力してください。");
			req.getRequestDispatcher("purchase-in.jsp").forward(req, resp);
			return;
		}

		PurchaseDAO dao=new PurchaseDAO();
		List<Item> cart=(List<Item>)session.getAttribute("session_cart");
		if (cart==null || !dao.insert(cart, name, address)) {
			resp.sendRedirect("purchase-error-insert");
			return;
		}

		session.removeAttribute("session_cart");

		resp.sendRedirect("puchase");
	}

}
