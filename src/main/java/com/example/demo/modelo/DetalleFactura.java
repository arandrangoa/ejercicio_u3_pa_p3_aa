package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="detalleFactura")

@NamedQueries({
	@NamedQuery(name="detalleFactura.buscarPorid",query = "select d from DetalleFactura d where d.id= :datoId")
})

@NamedNativeQueries({
	@NamedNativeQuery(name="detalleFactura.buscarPorIdNative",query = "select * from detalleFactura where deta_id= :datoId")
})


public class DetalleFactura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_deta")
	@SequenceGenerator(name="seq_deta",sequenceName = "seq_deta",allocationSize = 1)
	@Column(name="deta_id")
	private Integer id;
	
	@Column(name="deta_cantidad")
	private Integer cantidad;
	
	@Column(name="deta_precio_unitario")
	private BigDecimal precioUnitario;
	
	@Column(name="deta_subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name="deta_id_item")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="deta_id_factura")
	private Factura factura;

	
	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
	

}
