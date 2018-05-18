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

public class LoginIndexFilter implements Filter {
	@Inject
	UsuarioBean usuarioBean;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (usuarioBean != null && usuarioBean.isLoggedIn()) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			if (usuarioBean.isTipoAdmin()) {
				contextPath += "/portal/index.xhtml";
			} else {
				contextPath += "/site/index.xhtml";
			}
			((HttpServletResponse) response).sendRedirect(contextPath);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
