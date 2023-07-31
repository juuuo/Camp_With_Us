package team.project.camp.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "initFilter", urlPatterns = "/*")
// -> /* :����θ� �ǹ�
public class InitFilter extends HttpFilter implements Filter {
	//Logger / Debug Mode ����ϱ�

	//Logger��ü ����(�ش�Ŭ������ ���� log�� ����ϴ� ��ü)
	private Logger logger = LoggerFactory.getLogger(InitFilter.class);
	// LoggerFactory.getLogger(Ŭ�����̸�);

	//���Ͱ� ������ �� ����
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		logger.info("�ʱ�ȭ ���� ����");
		//logger�� �̿��� ����ϴ� ���
		//trace-debug-info-warn-error
		//-> �ַ� debug, info, error ���

		//debug :������ �帧�� �ľ��� ��(�ش��ڵ尡 ���������, �Ķ���Ͱ� ���� ���������� Ȯ���� ��)
		//info :�޼ҵ� ���� �ľ�

	}

	//���Ͱ� �ı��� �� ����(������ �����ִµ� �鿣�� �ڵ� �������� ��)
	@Override
	public void destroy() {

		logger.info("�ʱ�ȭ ���� �ı�");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// application ���� ��ü ������
				ServletContext application = request.getServletContext();

				// �ֻ��� �ּ� ������
				String contextPath =  ( (HttpServletRequest)request ).getContextPath();
											// �ٿ�ĳ����
				// ����
				application.setAttribute("contextPath", contextPath);

		chain.doFilter(request, response);
	}

}


















