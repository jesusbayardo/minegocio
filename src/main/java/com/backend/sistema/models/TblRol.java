package com.backend.sistema.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_rol database table.
 * 
 */
@Entity
@Table(name="tbl_rol")
@NamedQuery(name="TblRol.findAll", query="SELECT t FROM TblRol t")
public class TblRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Integer idRol;

	@Column(name="name_role")
	private String nameRole;

	//bi-directional many-to-one association to TblUser
	@OneToMany(mappedBy="tblRol")
	private List<TblUser> tblUsers;

	public TblRol() {
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNameRole() {
		return this.nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public List<TblUser> getTblUsers() {
		return this.tblUsers;
	}

	public void setTblUsers(List<TblUser> tblUsers) {
		this.tblUsers = tblUsers;
	}

	public TblUser addTblUser(TblUser tblUser) {
		getTblUsers().add(tblUser);
		tblUser.setTblRol(this);

		return tblUser;
	}

	public TblUser removeTblUser(TblUser tblUser) {
		getTblUsers().remove(tblUser);
		tblUser.setTblRol(null);

		return tblUser;
	}

}