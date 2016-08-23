package com.edrickrenan.startpoint.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class DAO<T> implements DAOInterface<T> {
	protected static EntityManager manager;


	public static void open(){
		if(manager==null){
			EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("manager");
			manager = factory.createEntityManager();
		}
	}
	public static synchronized void close(){
		if(manager != null)
			manager = null;
	}

	public void create(T obj){
		manager.persist(obj);
	}
	public void delete(T obj) {
		manager.remove(obj);
	}
	public T update(T obj){
		return manager.merge(obj);
	}
	public void refresh(T obj){
		 manager.refresh(obj);
	}
	
	
	@SuppressWarnings("unchecked")
	public T read(Object chaveprimaria){
		//determinar o tipo (a classe) da chave primaria
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
		return manager.find(type, chaveprimaria);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> readAll(){
		//determinar o tipo (a classe) de T
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x");
		return (List<T>) query.getResultList();
	}

	//----------------------- TRANSAÇÃO   ----------------------

	public static void begin(){
		if(!manager.getTransaction().isActive())  //evitar abrir duas transações
			manager.getTransaction().begin();
	}
	public static void commit(){
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
			manager.clear();		// esvaziar o cache de objetos
		}
	}
	public static void rollback(){
		if(manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}
	
	public static void flush(){	//commit local
		manager.flush();
	}
}