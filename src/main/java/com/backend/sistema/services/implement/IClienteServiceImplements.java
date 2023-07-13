package com.backend.sistema.services.implement;

import org.springframework.http.ResponseEntity;

import com.backend.sistema.DTO.clienteDTO;
import com.backend.sistema.models.TblCliente;
import com.backend.sistema.models.TblSucursal;

public interface IClienteServiceImplements {

	ResponseEntity<?> getClientes(String value, String tipo);

	ResponseEntity<?> SaveCliente(clienteDTO cliente);

	ResponseEntity<?> updateCliente(TblCliente cliente);

	ResponseEntity<?> deleteCliente(Integer idCliente);


}
