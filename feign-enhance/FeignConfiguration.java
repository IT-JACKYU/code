package com.sunvalley.dop.finance.center.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Optional;

/**
 * @author: jackyu
 * @create: 2020-05-19 14:59
 **/
@Configuration
public class FeignConfiguration {

	/**
	 * 创建Feign请求拦截器
	 *
	 * @return
	 */
	@Bean
	public FeignBasicAuthRequestInterceptor requestInterceptor() {
		return new FeignBasicAuthRequestInterceptor();
	}

}

/**
 * Feign请求拦截器
 *
 * @author jackyu
 **/
class FeignBasicAuthRequestInterceptor implements RequestInterceptor {

	public FeignBasicAuthRequestInterceptor() {

	}

	@Override
	public void apply(RequestTemplate template) {
		CustRequestHeader custRequestHeader = RequestContextHolders.getCustRequestHeader();
		Optional.ofNullable(custRequestHeader).ifPresent(h -> {
			template.header(h.getName(), h.getValue());
		});
		RequestContextHolders.remove();
	}
}

