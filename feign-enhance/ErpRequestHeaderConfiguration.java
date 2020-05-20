package com.sunvalley.dop.finance.center.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: jackyu
 * @create: 2020-05-19 14:48
 **/

@ConfigurationProperties(prefix = "erp.auth.header")
@Data
public class ErpRequestHeaderConfiguration {

	private String name;
	private String value;

}
