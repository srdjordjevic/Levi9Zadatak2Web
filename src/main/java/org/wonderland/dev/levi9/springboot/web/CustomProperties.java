package org.wonderland.dev.levi9.springboot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomProperties {

	@Value("${levi9.middleappurl=http://localhost:9001/}")
	private String middleAppURL;
	
	public CustomProperties() {
		
	}
	
	public CustomProperties(String middleAppURL) {
		this.middleAppURL = middleAppURL;
	}

	public String getMiddleAppURL() {
		return middleAppURL;
	}

	public void setMiddleAppURL(String middleAppURL) {
		this.middleAppURL = middleAppURL;
	}

	@Override
	public String toString() {
		return "CustomProperties [middleAppURL=" + middleAppURL + "]";
	}
	
	
}
