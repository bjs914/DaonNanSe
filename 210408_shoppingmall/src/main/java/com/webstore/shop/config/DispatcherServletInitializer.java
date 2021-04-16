package com.webstore.shop.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//SpringMVC 프레임워크가 제공하는 DispatcherServlet 클래스를 AACDInitializer로 초기화, 
//DispatcherSerlvet이 모든 request를 처리
public class DispatcherServletInitializer 
		extends AbstractAnnotationConfigDispatcherServletInitializer {
		/* AACDSInitializer : AbstractContextLoaderInitializer 클래스에서 생성되는 
		 * root WebApplicationContext의 구현체
		 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		//MariaDB 연결과 관련된 클래스 연결
		return new Class[] {
				RootApplicationContextConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//컨트롤러 클래스와 뷰 파일을 알려줌
		return new Class[] { WebApplicationContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override	//한글인코딩방법
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        
        return new Filter[] { characterEncodingFilter };
    }
}