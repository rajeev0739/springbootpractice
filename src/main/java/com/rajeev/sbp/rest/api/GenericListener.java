package com.rajeev.sbp.rest.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



//replace productName with actual product Name
//@RequestMapping("dgott")
@RequestMapping("/dgott")
public interface GenericListener {
	final String productName="dgott";
	 
	@RequestMapping(value={"moReceiver"},method = {RequestMethod.GET, RequestMethod.POST})
	public  String processMO(HttpServletRequest request, HttpServletResponse response);
	
	@RequestMapping(value={"dnReceiver"},method = {RequestMethod.GET, RequestMethod.POST})
	public  String processDN(HttpServletRequest request, HttpServletResponse response);
	
	@RequestMapping(value={"jsonReceiver"},method = {RequestMethod.GET, RequestMethod.POST})
	public  String processJson(HttpServletRequest request, HttpServletResponse response,@RequestBody String jsonString);

}
