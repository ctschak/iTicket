package com.csr.iticket.model;

import javax.persistence.EntityManager;

/**
 * Provides a JPA EntityManager.
 * 
 * @author Chakravarthy Ravichandran
 *
 */
public interface EntityManagerProvider {
	EntityManager get();
}
