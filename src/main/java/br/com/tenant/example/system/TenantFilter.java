package br.com.tenant.example.system;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Felipe Adorno felipeadsc@gmail.com
 */
class TenantFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String tenantId = httpServletRequest.getHeader("tenantId");
        if(StringUtils.isEmpty(tenantId)) {
            TenantLocalStorage.setTenantName("db1");
        } else {
            TenantLocalStorage.setTenantName(tenantId);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
