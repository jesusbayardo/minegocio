package com.backend.sistema.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the tbl_cliente database table.
 * 
 */
@Entity
@Table(name="tbl_cliente")
@NamedQuery(name="TblCliente.findAll", query="SELECT t FROM TblCliente t")
public class TblCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Integer idCliente;

	private String correo;

	private String nombres;

	@Column(name="numero_identificacion")
	private String numeroIdentificacion;

	@Column(name="tipo_identificacion")
	private String tipoIdentificacion;

	//bi-directional many-to-one association to TblAsignacion
	@OneToMany(mappedBy="tblCliente",fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"tblCliente","hibernateLazyInitializer","handler"})
	private List<TblAsignacion> tblAsignacions;

	public TblCliente() {
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public List<TblAsignacion> getTblAsignacions() {
		return this.tblAsignacions;
	}

	public void setTblAsignacions(List<TblAsignacion> tblAsignacions) {
		this.tblAsignacions = tblAsignacions;
	}

	public TblAsignacion addTblAsignacion(TblAsignacion tblAsignacion) {
		getTblAsignacions().add(tblAsignacion);
		tblAsignacion.setTblCliente(this);

		return tblAsignacion;
	}

	public TblAsignacion removeTblAsignacion(TblAsignacion tblAsignacion) {
		getTblAsignacions().remove(tblAsignacion);
		tblAsignacion.setTblCliente(null);

		return tblAsignacion;
	}

}