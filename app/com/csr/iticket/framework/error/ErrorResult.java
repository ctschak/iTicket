package com.csr.iticket.framework.error;

import org.apache.http.HttpStatus;

import play.libs.Json;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;

/**
 * Error result object returned by the ErrorHandler to the client application.
 * 
 * For more complex errors, add more fields to the JSON response content via getContent().
 * @author Chakravarthy Ravichandran
 *
 */
public class ErrorResult {
	
	public static final String CODE_KEY = "code";
	public static final String MSG_KEY = "msg";
	
	public static final int DEFAULT_HTTP_STATUS = HttpStatus.SC_INTERNAL_SERVER_ERROR;
	public static final ErrorCode DEFAULT_ERROR_CODE = Errors.GENERAL_ERROR;
	public static final String DEFAULT_MESSAGE = "Internal Server Error";
	public static final ErrorResult DEFAULT_RESULT = new ErrorResult(DEFAULT_ERROR_CODE,DEFAULT_MESSAGE);

	private int httpstatus = DEFAULT_HTTP_STATUS;
	private ErrorCode errorCode;
	private ObjectNode content;
	
	public ErrorResult(){
		this(DEFAULT_MESSAGE);
	}
	public ErrorResult(String message){
		this(DEFAULT_ERROR_CODE,message);
	}
	public ErrorResult(ErrorCode errorCode , String message){
		Preconditions.checkNotNull(errorCode);
		Preconditions.checkNotNull(message);
		
		this.errorCode = errorCode;
		this.content = Json.newObject();
		this.content.put(CODE_KEY, errorCode.getValue());
		this.content.put(MSG_KEY, message);
	}
	/**
	 * HTTPstatus returned to the HTTPResponse
	 * @return
	 */
	public int getHttpStatus(){
		return this.httpstatus;
	}
	/**
	 * ErrorCodes are provided by ErrorCodeProviders which are , in turn manager by ErrorManager
	 * @return
	 */
	public ErrorCode getErrorCode(){
		return this.errorCode;
	
	}
	/**
	 * The error detail JSON Conent to be returned in the HTTP response body
	 * 
	 * At minimum, this JSON content tree will contain the ErrorCode and a message String.
	 * When contructing an ErrorResult, you can add more fields to this content JSON
	 * tree as needed for the specific ErrorCode
	 * @return
	 */
	public ObjectNode getContent(){
		return this.content;
	}
}
