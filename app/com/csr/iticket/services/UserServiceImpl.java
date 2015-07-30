package com.csr.iticket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csr.iticket.dao.UserDao;
import com.csr.iticket.dto.mongo.UserDto;
@Component
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserDto.Mapper dtoMapper;
	

		
	
	@Override
	public void saveOrUpdateCustomer(UserDto userDto) {
		userDao.saveOrUpdateCustomer(dtoMapper.newEntity(userDto));
		System.out.println("store sucess");
		
	}

}
