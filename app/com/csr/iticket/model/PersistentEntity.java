package com.csr.iticket.model;

import javax.persistence.*;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

/**
 * 
 * Base functionality for persistent @Entity classes.
 */

@MappedSuperclass
public abstract class PersistentEntity {

	public static final String VERSION_FIELD = "entityVersion";

	/**
	 * 
	 * Force hibernate to initialize a possible lazy proxy.
	 * Whether the input arg is an entity or a lazy proxy for an entity, this
	 * method guarantees to return the actual entity, and not a proxy.
	 * @param entityOrProxy
	 * 
	 * @param <T>
	 */

	public static <T extends PersistentEntity> T forceProxyInitialization(
			T entityOrProxy) {

		Hibernate.initialize(entityOrProxy);

		if (entityOrProxy instanceof HibernateProxy) {

			return (T) ((HibernateProxy) entityOrProxy)
					.getHibernateLazyInitializer().getImplementation();

		}

		return entityOrProxy;

	}

	/*
	 * 
	 * Hibernate optimistic locking field
	 */

	/*@Version
	@Column(name = "OPTMSTC_LOCK_ID")
	private Integer entityVersion = 1;*/

	/*
	 * 
	 * Used in EntityDao.remove() method to indicate we are in the process of
	 * deleting the entity.
	 * 
	 * This flag is then checked in any reciprocalRemove() methods on the
	 * entity, and no-op those
	 * 
	 * methods while in the process of being deleted.
	 * 
	 * 
	 * 
	 * This is to work around hibernate bug HHH-7935, where a
	 * ConcurrentModificationExcption is thrown
	 * 
	 * by hibernate while processing cascaded deletes where child objects then
	 * call reciprocalRemove()
	 * 
	 * methods, which attempt to modify the collection that hibernate is already
	 * using to traverse the
	 * 
	 * children and delete them.
	 * 
	 * 
	 * 
	 * https://hibernate.atlassian.net/browse/HHH-7935
	 */

	@Transient
	private boolean beingRemoved = false;

	protected boolean isBeingRemoved() {

		return this.beingRemoved;

	}

	@PreRemove
	public void basePreRemove() {

		this.beingRemoved = true;

		this.preRemove();

	}

	/*
	 * 
	 * Provide subclasses with an opportunity to perform PreRemove tasks
	 */

	protected void preRemove() {

		// Default is to do nothing, subclasses can override

	}

	/**
	 * 
	 * Return the identity object for this persistent entity
	 */

	public abstract Object getId();

}
