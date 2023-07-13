package com.backend.sistema.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.sistema.models.TblAsignacion;

public interface IAsignacionDao extends JpaRepository<TblAsignacion, Integer>{

}
