package com.backend.sistema.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the tbl_sucursal database table.
 * 
 */
@Entity
@Table(name="tbl_sucursal")
@NamedQuery(name="TblSucursal.findAll", query="SELECT t FROM TblSucursal t")
public class TblSucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sucursal")
	private Integer idSucursal;

	private String ciudad;

	private String direccion;

	private String provincia;
	
	private String tipo;

	//bi-directional many-to-one association to TblAsignacion
	@OneToMany(mappedBy="tblSucursal",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TblAsignacion> tblAsignacions;

	public TblSucursal() {
	}

	public Integer getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<TblAsignacion> getTblAsignacions() {
		return this.tblAsignacions;
	}

	public void setTblAsignacions(List<TblAsignacion> tblAsignacions) {
		this.tblAsignacions = tblAsignacions;
	}

	public TblAsignacion addTblAsignacion(TblAsignacion tblAsignacion) {
		getTblAsignacions().add(tblAsignacion);
		tblAsignacion.setTblSucursal(this);

		return tblAsignacion;
	}

	public TblAsignacion removeTblAsignacion(TblAsignacion tblAsignacion) {
		getTblAsignacions().remove(tblAsignacion);
		tblAsignacion.setTblSucursal(null);

		return tblAsignacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	

}