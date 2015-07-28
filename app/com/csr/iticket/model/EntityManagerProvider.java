package com.csr.iticket.model;

import javax.persistence.EntityManager;

/**
 * Provides a JPA EntityManager.
 * 
 * @author Aboo Salimon
 *
 */
public interface EntityManagerProvider {
	EntityManager get();
}
