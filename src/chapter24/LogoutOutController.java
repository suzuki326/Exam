package chapter24;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter24/logout-out" })
public class LogoutOutController extends CommonServlet {

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();

		if (session.getAttribute("session_customer") != null) {
			session.removeAttribute("session_customer");
			req.getRequestDispatcher("logout-out.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("logout-error");
		}
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
