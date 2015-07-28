package com.csr.iticket.services;

import com.csr.iticket.dto.mongo.UserDto;

public interface UserService {
	
	void saveOrUpdateCustomer(UserDto userDto);

}
