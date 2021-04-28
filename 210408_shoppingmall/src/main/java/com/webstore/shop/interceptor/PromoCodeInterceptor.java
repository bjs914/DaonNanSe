package com.webstore.shop.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PromoCodeInterceptor extends HandlerInterceptorAdapter{
	private String promoCode;
	private String errorRedirect;
	private String offerRedirect;

	// 웹 요청이 올바르면 설정된 특별 제안페이지로 이동, 그렇지않으면 오류 페이지로 방향전환
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {
		String givenPromoCode = request.getParameter("promo");
		if (promoCode.equals(givenPromoCode)) {
			response.sendRedirect(request.getContextPath() + "/" + offerRedirect);
		} else {
			response.sendRedirect(errorRedirect);
		}
		return false;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public void setErrorRedirect(String errorRedirect) {
		this.errorRedirect = errorRedirect;
	}

	public void setOfferRedirect(String offerRedirect) {
		this.offerRedirect = offerRedirect;
	}
}