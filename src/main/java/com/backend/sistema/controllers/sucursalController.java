package com.backend.sistema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.sistema.DTO.clienteDTO;
import com.backend.sistema.models.TblSucursal;
import com.backend.sistema.services.implement.ISucursalServiceImplements;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class sucursalController {

	
	
	@Autowired
	private ISucursalServiceImplements ISucursalServiceImplements;
	
	@RequestMapping(value = "/sucursal/{idCliente}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveCliente(@RequestBody TblSucursal sucursal,@PathVariable Integer idCliente) {
		return ISucursalServiceImplements.saveNewWarehouse(sucursal,idCliente);
	}
	
	
	
	
	@RequestMapping(value = "/sucursal/{idCliente}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSucusalesByClient(@PathVariable Integer idCliente) {
		return ISucursalServiceImplements.getSucusalesByClient(idCliente);
	}
	
	
}
