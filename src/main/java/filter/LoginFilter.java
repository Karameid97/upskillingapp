package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.mb.MBScurityLogin;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// If you have any <init-param> in web.xml, then you could get them
		// here by config.getInitParameter("name") and assign it as field.

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Cach-Control", "no-Cach,no-store-must-revalidate");

		MBScurityLogin loginBean = (MBScurityLogin) ((HttpServletRequest) request).getSession()
				.getAttribute("mbLog");
		if (loginBean == null || !loginBean.isLogin()) {
			response.sendRedirect(request.getContextPath() + "/home.xhtml"); // No logged-in user found, so redirect to
																				// login page.
		} else {
			System.out.println(req.getLocalAddr() + " " + req.getLocalName() + req.getLocalPort());
			chain.doFilter(req, res); // Logged-in user found, so just continue request.
		}

	}

	@Override
	public void destroy() {
		// If you have assigned any expensive resources as field of
		// this Filter class, then you could clean/close them here.

	}

}
