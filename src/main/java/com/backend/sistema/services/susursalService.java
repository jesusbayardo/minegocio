package com.backend.sistema.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.backend.sistema.DAO.IAsignacionDao;
import com.backend.sistema.DAO.IClienteDao;
import com.backend.sistema.DAO.ISucursalDao;
import com.backend.sistema.models.TblAsignacion;
import com.backend.sistema.models.TblCliente;
import com.backend.sistema.models.TblSucursal;
import com.backend.sistema.services.implement.ISucursalServiceImplements;
import com.backend.sistema.utils.validations.sucursalValidator;

@Service
public class susursalService implements ISucursalServiceImplements {

	@Autowired
	private sucursalValidator sucursalValidator;

	@Autowired
	private ISucursalDao ISucursalDao;

	@Autowired
	private IClienteDao IClienteDao;

	@Autowired
	private IAsignacionDao IAsignacionDao;

	/*
	 * Funcion: Almacena una nuevo SUCURSAL
	 * 
	 * @Param: OBJECT tblSucursal, Integer idCliente
	 * 
	 * @Return: SUCCESS
	 * 
	 * @autor: bayardo chandi <bayardojesus@gmail.com>
	 * 
	 * @version: 1.0
	 */

	@Override
	@Transactional
	public ResponseEntity<?> saveNewWarehouse(TblSucursal sucursal, Integer IdCliente) {
		Map<String, Object> response = new HashMap<>();

		Errors errors = new BeanPropertyBindingResult(sucursal, "sucursal");
		sucursalValidator.validate(sucursal, errors);

		if (errors.hasErrors()) {
			List<String> errorsuser = errors.getFieldErrors().stream().map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errorsuser);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			
			
			
			
			
			TblCliente data = IClienteDao.findById(IdCliente).orElse(null);

			if (data == null) {

				response.put("message", "El cliente no fue encontrado");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			
			

			TblCliente cli = new TblCliente();

			cli.setIdCliente(IdCliente);

			TblSucursal dataSucursal = ISucursalDao.save(sucursal);

			TblAsignacion asignacion = new TblAsignacion();

			asignacion.setTblCliente(cli);
			asignacion.setTblSucursal(dataSucursal);
			IAsignacionDao.save(asignacion);

			response.put("message", "success");
			response.put("data", null);
		} catch (Exception e) {
			response.put("message", "error");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/*
	 * Funcion: Obtiene todas las sucursales por idcliente
	 * 
	 * @Param: idCliente
	 * 
	 * @Return: list sucursales
	 * 
	 * @autor: bayardo chandi <bayardojesus@gmail.com>
	 * 
	 * @version: 1.0
	 */

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> getSucusalesByClient(Integer idClient) {
		Map<String, Object> response = new HashMap<>();

		TblCliente data = IClienteDao.findById(idClient).orElse(null);

		if (data == null) {

			response.put("message", "El cliente no fue encontrado");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			
		List<TblSucursal> sucuralesList = ISucursalDao.getAllWarehousesByClient(idClient);
			
			

			response.put("message", "success");
			response.put("data", sucuralesList);
		} catch (Exception e) {
			response.put("message", "error");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
