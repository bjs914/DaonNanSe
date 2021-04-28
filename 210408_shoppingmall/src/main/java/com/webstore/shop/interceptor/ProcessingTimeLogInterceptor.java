package com.webstore.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ProcessingTimeLogInterceptor implements HandlerInterceptor{
	private static final Logger LOGGER =
				Logger.getLogger(ProcessingTimeLogInterceptor.class);
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 웹 요청이 컨트롤러에 도착하기 전에 먼저 호출됨
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);//startTime속성을 request 객체에 추가
		return true;
		/*true의 의미 : 다음 인터셉터나 컨트롤러로 실행 진행을 허용, 
		 *false로 반환 할 경우, DispatcherServlet이 현재 인터셉터에 의해 response된 것으로 판단하게 된다.
		*/
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 웹 요청이 컨트롤러에서 처리된 후 호출됨
		String queryString = request.getQueryString() ==null ? "":"?"
			+request.getQueryString();	//삼항연산자 사용
		String path = request.getRequestURL()+queryString;
		
		long startTime = (long) request.getAttribute("startTime");	//preHandel에서 지정한 시간을 가져옴
		long endTime = System.currentTimeMillis();
		
		LOGGER.info(String.format("%s 요청 처리에 소요된 시간 (ms) : %s", path,
						(endTime-startTime)));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 웹 요청 사이클 전체가 종료된 후에 호출됨
		
	}
	
}
