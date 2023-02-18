package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Item;
import com.example.demo.repository.IItemRepo;

@Service
public class ItemServiceImpl implements IItemService{
	
	@Autowired
	private IItemRepo iItemRepo;
	

	@Override
	public void agregar(Item item) {
		// TODO Auto-generated method stub
		int stockActual=item.getStock();
		int stockActualizado=0;
		
		Item i=new Item();
		i.setNombre(i.getNombre());
		i.setStock(stockActualizado);
		
		if(item.getNombre()==i.getNombre()) {
			if(item.getStock()!=null) {
				stockActualizado=stockActual+stockActualizado;
				item.setStock(stockActualizado);
			}
		}
		i.setStock(stockActualizado);
		
		this.iItemRepo.insertar(item);
	}

}
