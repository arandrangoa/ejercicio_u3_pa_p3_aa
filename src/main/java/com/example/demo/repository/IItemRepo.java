package com.example.demo.repository;

import com.example.demo.modelo.Item;

public interface IItemRepo {
	
	public void insertar(Item item);
	
	public Item buscarPorCodigoCriteria(String codigoBarras);

}
