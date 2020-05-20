package com.sunvalley.dop.finance.center.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author: jackyu
 * @create: 2020-05-19 14:40
 **/
@Component
@Aspect
@EnableConfigurationProperties(ErpRequestHeaderConfiguration.class)
public class HttpHeader {
	@Autowired
	ErpRequestHeaderConfiguration erpRequestHeaderConfiguration;

	@Before("@annotation(com.sunvalley.dop.finance.center.config.EnableErpHeaders)")
	public void enhanceHeaders(JoinPoint point) {
		CustRequestHeader custRequestHeader = new CustRequestHeader();
		Optional.ofNullable(erpRequestHeaderConfiguration.getName()).ifPresent(custRequestHeader::setName);
		Optional.ofNullable(erpRequestHeaderConfiguration.getValue()).ifPresent(custRequestHeader::setValue);
		RequestContextHolders.setCustRequestHeader(custRequestHeader);
	}




}
