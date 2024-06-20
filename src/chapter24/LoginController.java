package chapter24;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import dao.CustomerDAO;
import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter24/login" })
public class LoginController extends CommonServlet {

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("login-in.jsp").forward(req, resp);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		String login = req.getParameter("login");
		String password = req.getParameter("password");

		CustomerDAO dao = new CustomerDAO();
		Customer customer = dao.search(login, password);

		if (customer != null) {
			session.setAttribute("session_customer", customer);
			resp.sendRedirect("login-out");
		} else {
			req.setAttribute("login", login);
			req.setAttribute("errorMessage", "ログイン名またはパスワードが違います");
			req.getRequestDispatcher("login-in.jsp").forward(req, resp);
		}
	}

}
