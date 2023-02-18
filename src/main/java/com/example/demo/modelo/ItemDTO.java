package com.example.demo.modelo;

public class ItemDTO {
	
	private String codigoBarras;
	
	private Integer cantidad;
	
	
	public ItemDTO() {
		
	}

	public ItemDTO(String codigoBarras, Integer cantidad) {
		super();
		this.codigoBarras = codigoBarras;
		this.cantidad = cantidad;
	}

	//SET Y GET

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
