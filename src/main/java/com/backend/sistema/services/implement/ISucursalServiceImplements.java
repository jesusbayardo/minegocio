package com.backend.sistema.services.implement;

import org.springframework.http.ResponseEntity;

import com.backend.sistema.models.TblSucursal;

public interface ISucursalServiceImplements {

	ResponseEntity<?> saveNewWarehouse(TblSucursal sucursal, Integer IdCliente);

	ResponseEntity<?> getSucusalesByClient(Integer idClient);

}
