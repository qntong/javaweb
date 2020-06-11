package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * 编码过滤器
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	/**
	 * 销毁方法
	 */
	public void destroy() {
	}

	/**
	 * 过滤方法
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 执行请求之前处理字符集  设为utf-8
		request.setCharacterEncoding("UTF-8");
		// 处理返回数据的编码集  设为utf-8
		response.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);// 放行
	}

	/**
	 * 初始化方法
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
