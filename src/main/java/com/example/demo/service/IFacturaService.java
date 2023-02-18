package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.ItemDTO;
import com.example.demo.repository.IFacturaRepo;

@Service
public interface IFacturaService {
	
	
	public void agregar(List<ItemDTO> items,String cedula,String numeroFactura);

}
