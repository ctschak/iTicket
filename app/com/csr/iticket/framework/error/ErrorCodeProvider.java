package com.csr.iticket.framework.error;

import java.util.Set;



/**
 * A provider of ErrorCodes for the ErrorManager and ErrorHandleers
 * 
 * ErrorCodeProviders are configured in the spring context to define the valid ErrorCodes
 * Each ErrorCode should only be provided by a single ErrorCodeProvider. The ErrorManager
 * verifies the uniqueness of ErrorCodes across configured providers.
 * 
 * @author Chakravarthy Ravichandran
 *
 */
public interface ErrorCodeProvider {
	Set<ErrorCode> getErrorCodes();
}
