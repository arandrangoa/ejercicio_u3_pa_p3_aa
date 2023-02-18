package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ItemRepoImpl implements IItemRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Item item) {
		// TODO Auto-generated method stub
		this.entityManager.persist(item);
	}

	@Override
	public Item buscarPorCodigoCriteria(String codigoBarras) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Item> myQuery=myBuilder.createQuery(Item.class);
		Root<Item> myTableFrom=myQuery.from(Item.class);
		
		Predicate condicion=myBuilder.equal(myTableFrom.get("codigoBarras"), codigoBarras);
		
		myQuery.select(myTableFrom).where(condicion);
		
		TypedQuery<Item> myTyped=this.entityManager.createQuery("select i from Item i where i.codigoBarras= :datoCodigo",Item.class);
		myTyped.setParameter("datoCodigo", codigoBarras);
		
		return myTyped.getSingleResult();
	}
	
	

}
