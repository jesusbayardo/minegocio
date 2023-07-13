package com.backend.sistema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.backend.sistema.DTO.clienteDTO;
import com.backend.sistema.models.TblCliente;
import com.backend.sistema.services.implement.IClienteServiceImplements;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ClientesController {

	
	@Autowired
	private IClienteServiceImplements IClienteServiceImplements;
	
	
	

	@RequestMapping(value = "/cliente/{value}/{tipoBusqueda}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getClientesByParam(@PathVariable String value,@PathVariable String tipoBusqueda) {
		return IClienteServiceImplements.getClientes(value,tipoBusqueda);
	}
	
	
	
	
	
	@RequestMapping(value = "/cliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveCliente(@RequestBody clienteDTO cliente) {
		return IClienteServiceImplements.SaveCliente(cliente);
	}
	
	
	@RequestMapping(value = "/cliente", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCliente(@RequestBody TblCliente cliente) {
		return IClienteServiceImplements.updateCliente(cliente);
	}
	
	
	
	@RequestMapping(value = "/cliente/{idCliente}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteCliente(@PathVariable Integer idCliente) {
		return IClienteServiceImplements.deleteCliente(idCliente);
	}
	
	
	
	
	
	
}
