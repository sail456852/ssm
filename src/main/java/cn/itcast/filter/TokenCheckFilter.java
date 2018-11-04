package cn.itcast.filter;

import cn.itcast.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import java.io.IOException;
// for demo purpose only
public class TokenCheckFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(TokenCheckFilter.class);

    @Autowired
    private CustomerService customerService;

    public void destroy() {
        System.out.println("TokenCheckFilter.destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        customerService.getById(1L);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("TokenCheckFilter.init");
    }

}
