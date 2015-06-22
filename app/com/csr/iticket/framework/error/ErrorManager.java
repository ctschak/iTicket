package com.csr.iticket.framework.error;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import play.Logger;

import play.libs.F;

import play.mvc.Http;

import play.mvc.Results;

import play.mvc.Result;

import javax.annotation.PostConstruct;

import java.util.HashSet;

import java.util.Set;

/**
 * 
 * Error manager to be configured via GlobalSettings.onError() method.
 * 
 *
 * 
 * Manages the valid configured ErrorCodes provided by ErrorCodeProviders.
 * 
 * Handles each error from Play via the configured ErrorHandlers.
 */

@Component
public class ErrorManager {

	private static final Logger.ALogger LOGGER = Logger.of(ErrorManager.class);

	@Autowired(required = false)
	private Set<ErrorHandler> handlers = new HashSet<ErrorHandler>();

	@Autowired(required = false)
	private Set<ErrorCodeProvider> codeProviders = new HashSet<ErrorCodeProvider>();

	private Set<ErrorCode> errorCodes;

	private Set<Class<? extends Throwable>> handledExceptionTypes;

	@PostConstruct
	private void init() {

		/*
		 * 
		 * Get ErrorCodes from all configured ErrorCodeProviders and verify
		 * 
		 * there are no duplicate codes.
		 */

		if (errorCodes == null) {

			errorCodes = new HashSet<ErrorCode>();

			for (ErrorCodeProvider codeProvider : codeProviders) {

				for (ErrorCode code : codeProvider.getErrorCodes()) {

					if (errorCodes.contains(code)) {

						throw new RuntimeException(String.format(
								"Duplicate error code configured: [%s]",
								code.getValue()));

					}

					errorCodes.add(code);

				}

			}

		}

		/*
		 * 
		 * Verify that there is no overlap in the exception classes handled by
		 * the configured ErrorHandlers.
		 */

		if (handledExceptionTypes == null) {

			handledExceptionTypes = new HashSet<Class<? extends Throwable>>();

			for (ErrorHandler handler : handlers) {

				for (Class<? extends Throwable> newExceptionClass : handler
						.getHandledExceptionTypes()) {

					for (Class<? extends Throwable> alreadyHandled : handledExceptionTypes) {

						if (alreadyHandled.isAssignableFrom(newExceptionClass)) {

							throw new RuntimeException(
									String.format(
											"Multiple error handlers handle type: [%s]",
											newExceptionClass.getName()));

						}

					}

					handledExceptionTypes.add(newExceptionClass);

				}

			}

		}

	}

	/**
	 * 
	 * Handle errors generated from Play controllers.
	 * 
	 *
	 * 
	 * The ErrorManager has a spring-injected collection of ErrorHandlers,
	 * 
	 * and traverses the collection until a handler provides an ErrorResult
	 * 
	 * for the error. If no handler is able to handle the error, then a default
	 * result used.
	 * 
	 *
	 * 
	 * @param request
	 * 
	 * @param t
	 */

	public F.Promise<Result> handle(Http.RequestHeader request,
			Throwable t) {

		ErrorResult result = null;

		if (t != null) {

			for (ErrorHandler handler : handlers) {

				ErrorResult translatorResult = handler.handle(request, t);

				if (translatorResult != null) {

					// Log a warning if the result uses an invalid ErrorCode

					if (!errorCodes.contains(translatorResult.getErrorCode())) {

						logInvalidErrorCode(request, t, handler,
								translatorResult);

					}

					result = translatorResult;

					break;

				}

			}

			if (result == null) {

				result = new ErrorResult(t.getMessage());

			}

		} else {

			result = new ErrorResult();

		}

		return F.Promise.<Result> pure(Results.status(result.getHttpStatus(), result.getContent()));

	}

	private static void logInvalidErrorCode(Http.RequestHeader request,
			Throwable t, ErrorHandler handler, ErrorResult errorResult) {

		LOGGER.warn(
				String.format(
						"ErrorHandler[%s] generated invalid ErrorCode[%s] for request[%s]",

						handler.getClass().getName(),
						errorResult.getErrorCode(), request.toString()), t);

	}

}
