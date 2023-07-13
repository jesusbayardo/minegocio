package com.backend.sistema.DTO;



public class clienteEntityDTO {
	private Integer idCliente;

	private String correo;

	private String nombres;


	private String numeroIdentificacion;


	private String tipoIdentificacion;


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}


	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}


	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	
	
	
	
	
}
