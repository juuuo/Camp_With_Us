// 인스타그램 연결관련 필터

//package team.project.camp.common.filter;
//
////cross domain 설정
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletResponse;
//
//public class CORSFilter implements Filter{
//
//@Override
//public void init(FilterConfig filterConfig) throws ServletException {}
//
//@Override
//public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//	HttpServletResponse response = (HttpServletResponse) res;
//
//	response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
//	response.setHeader("Access-Control-Allow-Method","POST,GET,OPTIONS,DELETE, PUT");
//	response.setHeader("Access-Control-Max-Age","3600");
//	response.setHeader("Access-Control-Allow-Headers","Content-Type,x-requested-with,Authorization,Axxess-Control-Allow-Origin");
//
//	chain.doFilter(req, res);
//}
//
//@Override
//public void destroy() {}
//}
