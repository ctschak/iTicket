package com.csr.iticket.model;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.beans.factory.annotation.Autowired;

 

public abstract class EntityDao<T extends PersistentEntity> {

 

    @Autowired
    private EntityManagerProvider em;

 

    /**

     * Attach a new entity to the JPA persistence context

     * @param entity

     */

    public void persist(T entity) {

        em.get().persist(entity);

    }

 

    /**

     * Replace all fields of a persistent entity with the field values from the provided

     * copy of the entity, including null values.

     *

     * This method should be used rarely. Instead prefer to load the entity and replace

     * specific fields which have been modified.

     *

     * @param entity

     * @return a copy of the provided entity, and the copy is now attached to the persistence

     * context so the copy should now be used for further work, instead of the original copy.

     */

    public T merge(T entity) {

        return em.get().merge(entity);

    }

 

    /**

     * Logical deletion of the specified entity. May be physical deletion or soft delete only,

     * as controlled by the DAO for this entity type.

     *

     * The default is for logical deletion to be physical deletion. Individual DAO classes can

     * override for entity types where soft delete is implemented.

     *

     * @param entity

     */

    public void delete(T entity) {

        remove(entity);

    }

 

    /**

     * Physical deletion of the specified entity, regardless of whether or not the DAO supports

     * soft delete for this entity type.

     *

     * This method should be used rarely. Instead prefer to call delete() where the DAO decides

     * what sort of logical deletion is implemented for this entity type.

    *

     * @param entity

     */

    public void remove(T entity) {

        em.get().remove(entity);

    }

 

    public void flush() {

        em().flush();

    }

 

    protected EntityManager em() {

        return em.get();

    }

 

    /**

     * Return the underlying hibernate Session object

     */

    protected Session session() {

        return em().unwrap(Session.class);

    }

 

    /**

     * While using native SQL queries it is advisable to use this method to get the DB schema name instead of

     * manually typing the schema name in the query since it is possible that the application could use multiple schemas.

     * TODO: remove this method once we set default schema on all connections in the connection pool via US16813

     */

    protected String getDefaultSchema() {

        SessionFactoryImplementor sfi = (SessionFactoryImplementor) session().getSessionFactory();

        return sfi.getSettings().getDefaultSchemaName();

    }

 

}