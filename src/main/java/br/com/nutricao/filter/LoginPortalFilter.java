package br.com.nutricao.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nutricao.controller.UsuarioBean;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginPortalFilter implements Filter {
	@Inject
	UsuarioBean usuarioBean;

	/**
	 * Default constructor.
	 */
	public LoginPortalFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException
	{
		String contextPath = ((HttpServletRequest) request).getContextPath();
		if (usuarioBean == null || !usuarioBean.isLoggedIn()) {
			((HttpServletResponse) response).sendRedirect(contextPath + "/index.xhtml");
		} else if (usuarioBean.isLoggedIn() && !usuarioBean.isTipoAdmin()) {
			((HttpServletResponse) response).sendRedirect(contextPath + "/forbidden.xhtml");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
