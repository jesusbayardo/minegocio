package com.backend.sistema.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_users database table.
 * 
 */
@Entity
@Table(name="tbl_users")
@NamedQuery(name="TblUser.findAll", query="SELECT t FROM TblUser t")
public class TblUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private Integer idUser;

	@Column(name="user_login")
	private String userLogin;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	//bi-directional many-to-one association to TblRol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private TblRol tblRol;

	public TblUser() {
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public TblRol getTblRol() {
		return this.tblRol;
	}

	public void setTblRol(TblRol tblRol) {
		this.tblRol = tblRol;
	}

}