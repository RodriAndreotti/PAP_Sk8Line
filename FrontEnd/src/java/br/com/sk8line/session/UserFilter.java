/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.session;

import br.com.sk8line.usuario.model.Usuario;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Filtra as requisições feitas pelo usuário e verifica se o mesmo encontra-se
 * logado
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Faz a verificação se existe usuário logado
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Usuario user = null;
        HttpSession sessao = ((HttpServletRequest) request).getSession(false);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (sessao != null) {
            user = (Usuario) sessao.getAttribute("usuario");
        }


        if (user == null) {
            String contextPath = req.getContextPath();
            String redirectPath = contextPath + "/";
            resp.sendRedirect(redirectPath);
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
