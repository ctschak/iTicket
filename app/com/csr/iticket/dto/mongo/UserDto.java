package com.csr.iticket.dto.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.csr.iticket.dao.UserDao;
import com.csr.iticket.dto.DtoMapper;
import com.csr.iticket.entities.mongo.User;


public class UserDto {
	
	public Integer user_id;
	public String first_name;	
	public String last_name;	
	public String email;	
	public String pass_word;
	
	

	@Component
    public static class Mapper extends DtoMapper<User, UserDto>{
		
		@Autowired
		UserDao userDao;
		
		@Override
		public UserDto newDto(){
			return new UserDto();
		}
		
		public User fromDto(UserDto userDto){
			User user = userDao.findById(userDto.user_id);
    		mapDtoToEntity(userDto,user);
    		return user;
    	}
    	
    	public User newEntity(UserDto userDto){
    		User user = new User();
    		mapDtoToEntity(userDto,user);
    		return user;
    	}
    	
    	public void mapDtoToEntity(UserDto userDto, User user){
    		user.setEmail(userDto.email);
    		user.setUser_id(userDto.user_id);
    		user.setFirst_name(userDto.first_name);
    		user.setLast_name(userDto.last_name);
    		user.setPass_word(userDto.pass_word);
    	
    	}
    	
    	@Override
    	public void mapEntityToDto(User user,UserDto dto){
    		
    		dto.first_name = user.getFirst_name();
    		dto.last_name = user.getLast_name();
    		dto.email = user.getEmail();
    		dto.pass_word = user.getPass_word();
    		dto.user_id = user.getUser_id();
    		
    	}

		
	}
	
	
	
	
	

}
