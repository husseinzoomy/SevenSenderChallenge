package com.ss.challenge.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.challenge.config.FeignConfig;



@FeignClient(name="XKCD", url="https://xkcd.com/info.0.json", configuration = FeignConfig.class)
public interface XKCDCClient {
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getComic(); 
}
