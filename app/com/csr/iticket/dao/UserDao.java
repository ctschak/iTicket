package com.csr.iticket.dao;


import com.csr.iticket.entities.mongo.User;
import com.csr.iticket.framework.MorphiaObject;

public class UserDao {
	
	
	public User findById(int id){
		if (MorphiaObject.datastore != null) {
			return MorphiaObject.datastore.find(User.class, "userr_id", id).get();
		}
		return null;
	}
	
	
	public void saveOrUpdateCustomer(User user) {
		User usr = MorphiaObject.datastore.find(User.class)
				.field("user_id").equal(user.getUser_id()).get();
		if (usr == null) {
			MorphiaObject.datastore.save(usr);
		}else{
			usr.setId(usr.getId());
			MorphiaObject.datastore.save(usr);
		}		
	}

}
