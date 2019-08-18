package com.jxau.bank.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {
    private String encoding;
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        //String contentType = request.getHeader("Accept");
        HttpServletResponse response = (HttpServletResponse)resp;
        request.setCharacterEncoding(this.encoding);
        //response.setCharacterEncoding(this.encoding);
        response.setContentType("text/html;charset=" + this.encoding);
        //response.setContentType(contentType == null?"text/html;charset=" + this.encoding : contentType + ";charset=" + this.encoding);
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        this.encoding = config.getInitParameter("encoding");
    }

}
