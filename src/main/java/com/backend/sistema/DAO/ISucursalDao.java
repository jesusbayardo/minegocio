package com.backend.sistema.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.sistema.models.TblCliente;
import com.backend.sistema.models.TblSucursal;

public interface ISucursalDao extends JpaRepository<TblSucursal, Integer>{

	
	
	

	@Query(value = "select * FROM tbl_sucursal,tbl_cliente,tbl_asignacion where tbl_cliente.id_cliente=tbl_asignacion.id_cliente and tbl_sucursal.id_sucursal=tbl_asignacion.id_sucursal and  tbl_cliente.id_cliente=?1",nativeQuery = true)
	public List<TblSucursal> getAllWarehousesByClient(@Param("id_cliente") Integer id_cliente);
	
	
}
