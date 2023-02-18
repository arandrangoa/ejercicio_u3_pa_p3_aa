package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.DetalleFactura;
import com.example.demo.modelo.Factura;
import com.example.demo.modelo.ItemDTO;
import com.example.demo.repository.IFacturaRepo;

@Service
public class FacturaServiceImpl implements IFacturaService{
	
	@Autowired
	private IFacturaRepo facturaRepo;

	@Override
	public void agregar(List<ItemDTO> items, String cedula, String numeroFactura) {
		// TODO Auto-generated method stub
		BigDecimal subtotal;
		BigDecimal preciounitario;
		int cantidad;
		
		DetalleFactura det=new DetalleFactura();
		preciounitario=det.getPrecioUnitario();
		cantidad=det.getCantidad();
		subtotal=preciounitario.valueOf(cantidad);
		
		Factura factura=new Factura();
		factura.setTotalVenta(subtotal);
		
		
		this.facturaRepo.insertar(items, cedula, numeroFactura);
		
		
	}

}
