package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@Table(name="factura")

@NamedQueries({
	@NamedQuery(name="Factura.buscarPorNumero",query = "select f from Factura f where f.numero= :datoNumero")
})

@NamedNativeQueries({
	@NamedNativeQuery(name="Factura.buscarPorNumeroNative",query = "select * from Factura where Factura_numero= :datoNumero")
})


public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_fact")
	@SequenceGenerator(name="seq_fact",sequenceName = "seq_fact",allocationSize = 1)
	@Column(name="fact_id")
	private Integer id;
	
	@Column(name="fact_numero")
	private String numero;
	
	@Column(name="fact_fecha")
	private LocalDateTime fecha;
	
	@Column(name="fact_cedula_cliente")
	private String cedulaCliente;
	
	@Column(name="fact_total_venta")
	private BigDecimal totalVenta;
	
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
	private List<DetalleFactura> detallefacturas;
	
	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<DetalleFactura> getDetallefacturas() {
		return detallefacturas;
	}

	public void setDetallefacturas(List<DetalleFactura> detallefacturas) {
		this.detallefacturas = detallefacturas;
	}
	
	
	

}
