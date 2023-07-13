package com.backend.sistema.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the tbl_asignacion database table.
 * 
 */
@Entity
@Table(name="tbl_asignacion")
@NamedQuery(name="TblAsignacion.findAll", query="SELECT t FROM TblAsignacion t")
public class TblAsignacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_asignacion")
	private Integer idAsignacion;

	//bi-directional many-to-one association to TblCliente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	@JsonIgnoreProperties({"tblAsignacions","hibernateLazyInitializer","handler"})
	private TblCliente tblCliente;

	//bi-directional many-to-one association to TblSucursal
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_sucursal")
	@JsonIgnoreProperties({"tblAsignacions","hibernateLazyInitializer","handler"})
	private TblSucursal tblSucursal;

	public TblAsignacion() {
	}

	public Integer getIdAsignacion() {
		return this.idAsignacion;
	}

	public void setIdAsignacion(Integer idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public TblCliente getTblCliente() {
		return this.tblCliente;
	}

	public void setTblCliente(TblCliente tblCliente) {
		this.tblCliente = tblCliente;
	}

	public TblSucursal getTblSucursal() {
		return this.tblSucursal;
	}

	public void setTblSucursal(TblSucursal tblSucursal) {
		this.tblSucursal = tblSucursal;
	}

}