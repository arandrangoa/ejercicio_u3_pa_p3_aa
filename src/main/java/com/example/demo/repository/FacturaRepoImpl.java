package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.ItemDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(List<ItemDTO> items, String cedula, String numeroFactura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(numeroFactura);
	}
	
	

}
