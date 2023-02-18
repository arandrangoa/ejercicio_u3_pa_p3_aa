package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="item")

@NamedQueries({
	@NamedQuery(name="Item.buscarporCodigo",query = "select i from Item i where i.codigoBarras= :datoCodigo")
})

@NamedNativeQueries({
	@NamedNativeQuery(name="Item.buscarporCodigoNative",query = "select * from item where item_codigoBarras= :datoCodigo")
})

public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_item")
	@SequenceGenerator(name="seq_item",sequenceName = "seq_item",allocationSize = 1)
	@Column(name="item_id")
	private Integer id;
	
	@Column(name="item_codigoBarras")
	private String codigoBarras;
	
	@Column(name="item_nombre")
	private String nombre;
	
	@Column(name="item_tipo")
	private String tipo;
	
	@Column(name="item_stock")
	private Integer stock;
	
	@Column(name="item_precio")
	private BigDecimal precio;
	
	
	@OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
	List<DetalleFactura> detalleFacturas;
	
	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}
	
	
	
	

}
