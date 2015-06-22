package com.csr.iticket.framework.error;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * Base ErrorCodes provided for iride-web module
 * @author Chakravarthy Ravichandran
 *
 */
@Component
public class Errors implements ErrorCodeProvider{

	public static final ErrorCode GENERAL_ERROR = addErrorCode("GENERAL_ERROR");
	public static final ErrorCode STALE_DATA = addErrorCode("STALE_DATA");
	
	
	private static Set<ErrorCode> codes;
	
	private static Set<ErrorCode> getCodes(){
		if(codes == null){
			codes = new HashSet<ErrorCode>();
		}
		return codes;
	}
	
	private static ErrorCode addErrorCode(String value){
		ErrorCode errorCode = new ErrorCode(value);
		getCodes().add(errorCode);
		return errorCode;
	}
	
	@Override
	public Set<ErrorCode> getErrorCodes(){
		return Collections.unmodifiableSet(getCodes());
	}
}
