//package mk.ukim.finki.wp.lab.web.filter;
//
//import org.apache.catalina.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter
//public class CourseFIlter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        String courseId = (String)request.getSession().getAttribute("courseId");
//
//        String path = request.getServletPath();
//
//        if (!"/listCourses".equals(path) && !"/main.css".equals(path) && courseId==null) {
//            response.sendRedirect("/listCourses");
//        } else {
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//
//
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
