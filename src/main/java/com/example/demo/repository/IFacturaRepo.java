package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Item;
import com.example.demo.modelo.ItemDTO;

public interface IFacturaRepo {
	
	public void insertar(List<ItemDTO> items,String cedula,String numeroFactura);
	

}
