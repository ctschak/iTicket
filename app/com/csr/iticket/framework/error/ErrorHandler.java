package com.csr.iticket.framework.error;

import java.util.Set;

import play.mvc.Http;
/**
 * Translate a Play Controller error to HTTP Response
 * the opportunity to translate each error into an HTTP status code and message 
 * to be returned to the client application.
 * @author Chakravarthy Ravichandran
 *
 */
public interface ErrorHandler {

	/**
	 * Returns distinct error
	 */
	Set<Class<? extends Throwable>> getHandledExceptionTypes();
	/**
	 * If specific error, then contruct and return appropriate ErrorResult object,
	 * else null
	 * @param request
	 * @param t
	 * @return
	 */
	ErrorResult handle(Http.RequestHeader request, Throwable t);
}
