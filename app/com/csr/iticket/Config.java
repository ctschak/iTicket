package com.csr.iticket;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import play.db.jpa.JPA;
import play.db.jpa.TransactionalAction;

import com.csr.iticket.model.EntityManagerProvider;

@Configuration
public class Config {

	public Config() {

	}

	@Bean
	public EntityManagerProvider entityManager() {

		return new EntityManagerProvider() {

			@Override
			public EntityManager get() {

				return JPA.em();

			}

		};

	}

	/*
	 * @Bean
	 * 
	 * public PropertyProvider propertyProvider() {
	 * 
	 * return new PropertyProvider() {
	 * 
	 * @Override
	 * 
	 * public String getString(String propertyName) {
	 * 
	 * return play.Play.application().configuration().getString(propertyName);
	 * 
	 * }
	 * 
	 * @Override
	 * 
	 * public Long getLong(String propertyName) {
	 * 
	 * return play.Play.application().configuration().getLong(propertyName);
	 * 
	 * }
	 * 
	 * };
	 * 
	 * }
	 */

	/**
	 * 
	 * Needs to be prototype scope instead of singleton, in the spring context.
	 * 
	 *
	 * 
	 * If not, we can get some bad multi-threaded behavior from Play, routing
	 * requests to the wrong
	 * 
	 * controller when many requests come in at the same time. This is because
	 * all of our controller
	 * 
	 * entry methods are annotated with the Play @Transactional annotation. We
	 * need this TransactionalAction
	 * 
	 * object to be prototype instead of singleton so that each controller
	 * method gets its own
	 * 
	 * TransactionalAction object.
	 * 
	 * @return
	 */

	@Bean
	@Scope(value = "prototype")
	public TransactionalAction getTransactionalAction() {

		return new TransactionalAction();

	}

	/*
	 * @Bean
	 * 
	 * @Scope(value = "prototype")
	 * 
	 * public LoggerAction getLoggableAction(){
	 * 
	 * return new LoggerAction();
	 * 
	 * }
	 */
}