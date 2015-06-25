package com.csr.iticket.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import play.Logger;

import com.csr.iticket.entities.mongo.Customer;
import com.csr.iticket.framework.MorphiaObject;

@Component
public class CustomerDao {

	public List<Customer> findAll() {
		Logger.debug("** CustomerDao findAll**"+MorphiaObject.datastore); 
		if (MorphiaObject.datastore != null) {
			Logger.debug("Invoke	"+MorphiaObject.datastore.find(Customer.class).asList());
			return MorphiaObject.datastore.find(Customer.class).asList();
		}
		return new ArrayList<Customer>();
	}
	
	public Customer findById(int id){
		if (MorphiaObject.datastore != null) {
			return MorphiaObject.datastore.find(Customer.class, "customer_id", id).get();
		}
		return null;
	}

	public void saveOrUpdateCustomer(Customer customer) {
		Customer retrive = MorphiaObject.datastore.find(Customer.class)
				.field("ticket_id").equal(customer.getTicket_id()).get();
		if (retrive == null) {
			MorphiaObject.datastore.save(customer);
		}else{
			customer.setId(retrive.getId());
			MorphiaObject.datastore.save(customer);
		}
	}

	public void deleteCustomer(String id) {
		ObjectId target = new ObjectId(id);
		Customer toDelete = MorphiaObject.datastore.find(Customer.class)
				.field("_id").equal(target).get();
		if (toDelete != null) {
			Logger.info("toDelete:" + toDelete);
			MorphiaObject.datastore.delete(toDelete);
		} else {
			Logger.debug("ID Not Found:" + id);
		}
	}

}
