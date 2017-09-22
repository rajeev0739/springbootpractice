package com.rajeev.sbp.rest.api.impl;

import java.io.BufferedReader;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajeev.sbp.rest.api.GenericListener;

@RestController
public class GenericListenerImpl implements GenericListener {

	private static final Logger logger = LoggerFactory.getLogger(GenericListenerImpl.class);
	 
	public String processMO(HttpServletRequest request, HttpServletResponse response) {
		
		String requestName=productName+" MO";
		
		logger.error("*****received "+requestName+" request *****");
		String dlrReceiverResponse=null;
		try{
			printRequestHeaders(request);
			printRequestParams(request);
			printRequestBody(request);
			dlrReceiverResponse = getReceiverResponseBodyString();
		}catch(Exception e){
			logger.error("Error occured while processing "+requestName+" request :: "+e.getMessage(),e);
		}
		
		logger.error("Sending resposne in "+requestName+" Response body :: "+dlrReceiverResponse);
		
		logger.error("*****  "+requestName+" response sent ***** ");
		return dlrReceiverResponse;

	}
	
	
	@RequestMapping(value={"dnReceiver"},method = {RequestMethod.GET, RequestMethod.POST})
	public  String processDN(HttpServletRequest request, HttpServletResponse response) {
		String requestName=productName+" DN ";
		
		logger.error("***** received "+requestName+" request *****");
		String receiverResponse=null;
		try{
			printRequestHeaders(request);
			printRequestParams(request);
			printRequestBody(request);
			
			receiverResponse = getReceiverResponseBodyString();
		}catch(Exception e){
			logger.error("Error occured while processing "+requestName+" request :: "+e.getMessage(),e);
		}
		
		logger.error("Sending resposne in "+requestName+" Response body :: "+receiverResponse);
		
		logger.error("*****  "+requestName+" response sent *****");
		return receiverResponse;
	}
	
	
	@Override
	public  String processJson(HttpServletRequest request, HttpServletResponse response,@RequestBody String jsonString) {
		
		String requestName=productName+" DN ";
		
		logger.error("***** received "+requestName+" request ***** ");
		String receiverResponse=null;
		try{
			printRequestHeaders(request);
			printRequestParams(request);
			printDNReceiverString(jsonString);
			printRequestBody(request);
			
			receiverResponse = getReceiverResponseBodyString();
		}catch(Exception e){
			logger.error("Error occured while processing "+requestName+" request :: "+e.getMessage(),e);
		}
		
		logger.error("Sending resposne in "+requestName+" Response body :: "+receiverResponse);
		
		logger.error("*****  "+requestName+" response sent ***** ");
		return receiverResponse;

	}
	
	public void printDNReceiverString(HttpServletRequest request){
		logger.error("***** Starting to print Received  DN Json details *****");
		logger.error(extractPostRequestBody(request));
		logger.error("***** printing  DN Json details completed *****");
	}
	
	public void printDNReceiverString(String jsonString){
		logger.error("***** Starting to print Received  DN Json details *****");
		logger.error(jsonString);
		logger.error("***** printing  DN Json details completed *****");
	}
	
	public void printRequestHeaders(HttpServletRequest request){
		
		try{
				logger.error("***** Starting to print  Request_Headers details *****");
				Enumeration headerNames = request.getHeaderNames();
				if (headerNames != null) {
					while (headerNames.hasMoreElements()) {
						String key = (String) headerNames.nextElement();
						String value = request.getHeader(key);
						logger.error("header-name ::" + key + "\t header-value ::" + value);
					}
				} else {
					logger.error("Nothing is present in header ");
				}
		}catch(Exception e){
			
				logger.error("Exception occured while printing Request_Headers"+e.getMessage(),e);
		}
		
		
		logger.error("***** printing  Request_Headers completed *****");
		
	}
	
	public void printRequestParams(HttpServletRequest request){
		
		try{
			logger.error("***** Starting to print  Request_Parameters *****");
			Enumeration<String> requestParameters = request.getParameterNames();
			if (requestParameters != null) {
				while (requestParameters.hasMoreElements()) {
					String paramName = (String) requestParameters.nextElement();
					logger.error("request-param name is ::" + paramName + "\t request-param value is ::"
							+ request.getParameter(paramName));
	
				}
			} else {
				logger.error("Nothing is present in requestParameters ");
			}
		
		}catch(Exception e){
			
			logger.error("Exception occured while printing Request_Parameters"+e.getMessage(),e);
		}
		logger.error("***** printing  Request_Parameters completed *****");
	}
	
	public void printRequestBody(HttpServletRequest request){
		try{
			logger.error("***** Starting to print  Request_Body ***** ");
			
			logger.error("Data Received from  in request body :: \n "+extractPostRequestBody(request));
		}catch(Exception e){
			
			logger.error("Exception occured while printing Request_Body"+e.getMessage(),e);
		}
		
		logger.error("***** printing  Request_Body completed ***** ");
	}
	
	

	static String extractPostRequestBody(HttpServletRequest request) {
		StringBuffer jb = new StringBuffer();
  	  	String line = null;
	    if ("POST".equalsIgnoreCase(request.getMethod())) {
	    	  
	    	  try {
	    	    BufferedReader reader = request.getReader();
	    	    while ((line = reader.readLine()) != null)
	    	      jb.append(line);
	    	  } 
	    	  catch (Exception e) {
	    	}
	    }
	    return jb.toString();
	}
	
	public String getReceiverResponseBodyString(){
		String rep=null;
		try{
			rep="ok";
		}catch(Exception e){
			logger.error("Exception occured while creating  Response_Body"+e.getMessage(),e);
			
		}
		return rep;
	}


}
