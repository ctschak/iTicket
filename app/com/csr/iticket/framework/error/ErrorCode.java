package com.csr.iticket.framework.error;

import com.google.common.base.Preconditions;

/**
 * Returns a unique error code to the client application. 
 * The ErrorManager defines the set of valid ErrorCodes provided by Configured ErrorCodeProviders
 * @author Chakravarthy Ravichandran
 *
 */
public class ErrorCode {
	
	private String value;
	
	public ErrorCode(String value){
		Preconditions.checkNotNull(value);
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	@Override
	public boolean equals(Object object){
		if(object == null || object instanceof ErrorCode){
			return false;
		}
		if(object == this){
			return true;
		}
		ErrorCode other = (ErrorCode) object;
		return this.value.equals(other.value);
	}
	public int hashCode(){
		return this.value.hashCode();
	}
}
