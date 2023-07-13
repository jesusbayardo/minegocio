package com.backend.sistema.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.sistema.models.TblCliente;

public interface IClienteDao extends JpaRepository<TblCliente, Integer> {

	@Query(value = "SELECT * FROM tbl_cliente as client WHERE "
			+ "(:tipo = 'numerodeidentidad' AND client.numero_identificacion like %:value%) OR "
			+ "(:tipo = 'nombre' AND client.nombres like %:value%)", nativeQuery = true)
	public List<TblCliente> getClient(String value, String tipo);

	
	
	@Query(value = "select * FROM tbl_cliente where numero_identificacion=?1",nativeQuery = true)
	public TblCliente getClientByIdentification(@Param("numero_identificacion") String dni_business);
	
	
}
