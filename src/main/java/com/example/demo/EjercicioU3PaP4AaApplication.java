package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.DetalleFactura;
import com.example.demo.modelo.Item;
import com.example.demo.service.IItemService;

@SpringBootApplication
public class EjercicioU3PaP4AaApplication implements CommandLineRunner{
	
	@Autowired
	private IItemService iItemService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioU3PaP4AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Item i1=new Item();
		i1.setCodigoBarras("BRO1");
		i1.setNombre("Broca");
		i1.setPrecio(new BigDecimal(5));
		i1.setTipo("Cemento");
		i1.setStock(1);
		
		
		DetalleFactura det1=new DetalleFactura();
		det1.setCantidad(1);
		det1.setItem(i1);
		det1.setPrecioUnitario(new BigDecimal(5));
		det1.setSubtotal(new BigDecimal(0));
		
		
		List<DetalleFactura> detalles=new ArrayList<>();
		detalles.add(det1);
		
		i1.setDetalleFacturas(detalles);
		
		
		this.iItemService.agregar(i1);
	}

}
