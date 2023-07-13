package com.backend.sistema.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.BeanPropertyBindingResult;
import com.backend.sistema.DAO.IAsignacionDao;
import com.backend.sistema.DAO.IClienteDao;
import com.backend.sistema.DAO.ISucursalDao;
import com.backend.sistema.DTO.clienteDTO;
import com.backend.sistema.DTO.clienteEntityDTO;
import com.backend.sistema.models.TblAsignacion;
import com.backend.sistema.models.TblCliente;
import com.backend.sistema.models.TblSucursal;
import com.backend.sistema.services.implement.IClienteServiceImplements;
import com.backend.sistema.utils.validations.clienteValidator;
import com.backend.sistema.utils.validations.sucursalValidator;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class clienteService implements IClienteServiceImplements {

	@Autowired
	private IClienteDao IClienteDao;

	@Autowired
	private ISucursalDao ISucursalDao;

	@Autowired
	private IAsignacionDao IAsignacionDao;

	@Autowired
	private clienteValidator clienteValidator;

	@PersistenceContext
	private EntityManager EntityManager;
	
	
	


	/*
	 * Funcion: Obtiene a los clientes por parametro de busqueda
	 * 
	 * @Param: numero de indentidad o nombre
	 * 
	 * @Return: list clientes
	 * 
	 * @autor: bayardo chandi <bayardojesus@gmail.com>
	 * 
	 * @version: 1.0
	 */

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> getClientes(String value, String tipo) {
		Map<String, Object> response = new HashMap<>();

		if (value.isEmpty() || value == null) {
			response.put("message", "EL valor no debe ser vacio o nulo");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (tipo.isEmpty() || tipo == null) {
			response.put("message", "El tipo no debe ser vacio o nulo");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			List<TblCliente> data = IClienteDao.getClient(value, tipo);
			response.put("message", "success");
			response.put("data", data);
		} catch (Exception e) {
			response.put("message", "error");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/*
	 * Funcion: Almacena el nuevo cliente
	 * 
	 * @Param: cliente DTO
	 * 
	 * @Return: Object client
	 * 
	 * @autor: bayardo chandi <bayardojesus@gmail.com>
	 * 
	 * @version: 1.0
	 */

	@Override
	@Transactional
	public ResponseEntity<?> SaveCliente(clienteDTO cliente) {
		Map<String, Object> response = new HashMap<>();

		Errors errors = new BeanPropertyBindingResult(cliente, "cliente");
		clienteValidator.validate(cliente, errors);

		if (errors.hasErrors()) {
			List<String> errorsuser = errors.getFieldErrors().stream().map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errorsuser);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {

			TblCliente cli = new TblCliente();

			cli.setTipoIdentificacion(cliente.getTipoIdentificacioncliente());
			cli.setNumeroIdentificacion(cliente.getNumeroIdentificacioncliente());
			cli.setNombres(cliente.getNombrescliente());
			cli.setCorreo(cliente.getCorreocliente());

			TblCliente dataCli = IClienteDao.save(cli);

			TblSucursal sucursal = new TblSucursal();
			sucursal.setProvincia(cliente.getProvinciasucursal());
			sucursal.setCiudad(cliente.getCiudadsucursal());
			sucursal.setDireccion(cliente.getDireccionsucursal());
			sucursal.setTipo("MATRIZ");
			TblSucursal dataSucursal = ISucursalDao.save(sucursal);

			TblAsignacion asignacion = new TblAsignacion();

			asignacion.setTblCliente(dataCli);
			asignacion.setTblSucursal(dataSucursal);
			IAsignacionDao.save(asignacion);

			EntityManager.refresh(dataCli);
			response.put("message", "success");
			response.put("data", dataCli);
		} catch (Exception e) {
			response.put("message", "error");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/*
	 * Funcion: Actualiza un cliente
	 * 
	 * @Param: object cliente
	 * 
	 * @Return: Object client
	 * 
	 * @autor: bayardo chandi <bayardojesus@gmail.com>
	 * 
	 * @version: 1.0
	 */

	@Override
	@Transactional
	public ResponseEntity<?> updateCliente(TblCliente cliente) {
		Map<String, Object> response = new HashMap<>();

		Errors errors = new BeanPropertyBindingResult(cliente, "cliente");
		clienteValidator.validateUpdate(cliente, errors);

		if (errors.hasErrors()) {
			List<String> errorsuser = errors.getFieldErrors().stream().map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errorsuser);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {

			TblCliente clienteUpdate = null;

			TblCliente ClienteActual = IClienteDao.findById(cliente.getIdCliente()).orElse(null);

			if (ClienteActual == null) {
				response.put("message", "El cliente no fue encontrado");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			ClienteActual.setTipoIdentificacion(cliente.getTipoIdentificacion());
			ClienteActual.setNumeroIdentificacion(cliente.getNumeroIdentificacion());
			ClienteActual.setNombres(cliente.getNombres());
			ClienteActual.setCorreo(cliente.getCorreo());

			clienteUpdate = IClienteDao.save(ClienteActual);

			clienteEntityDTO cliDTO = new clienteEntityDTO();
			cliDTO.setIdCliente(clienteUpdate.getIdCliente());
			cliDTO.setTipoIdentificacion(clienteUpdate.getTipoIdentificacion());
			cliDTO.setNumeroIdentificacion(clienteUpdate.getNumeroIdentificacion());
			cliDTO.setNombres(clienteUpdate.getNombres());
			cliDTO.setCorreo(clienteUpdate.getCorreo());

			response.put("message", "success");
			response.put("data", cliDTO);
		} catch (Exception e) {
			response.put("message", "error");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/*
	 * Funcion: elimina un cliente
	 * 
	 * @Param: id cliente
	 * 
	 * @Return: success
	 * 
	 * @autor: bayardo chandi <bayardojesus@gmail.com>
	 * 
	 * @version: 1.0
	 */

	@Override
	@Transactional
	public ResponseEntity<?> deleteCliente(Integer idCliente) {
		Map<String, Object> response = new HashMap<>();

		try {

			TblCliente ClienteActual = IClienteDao.findById(idCliente).orElse(null);

			if (ClienteActual == null) {
				response.put("message", "El cliente no fue encontrado");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			List<TblAsignacion> datasuc = ClienteActual.getTblAsignacions();

			List<TblSucursal> myList = new ArrayList<>();
			for (TblAsignacion tblAsignacion : datasuc) {
				myList.add(tblAsignacion.getTblSucursal());
			}

			ISucursalDao.deleteAll(myList);

			IClienteDao.deleteById(idCliente);

			response.put("message", "success");
			response.put("data", null);
		} catch (Exception e) {
			response.put("message", "error");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
