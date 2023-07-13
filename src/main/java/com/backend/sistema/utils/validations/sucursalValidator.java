package com.backend.sistema.utils.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.sistema.DAO.IClienteDao;
import com.backend.sistema.DTO.clienteDTO;
import com.backend.sistema.models.TblCliente;
import com.backend.sistema.models.TblSucursal;

@Component
public class sucursalValidator implements Validator {

	

	@Override
	public boolean supports(Class<?> clazz) {
		return TblSucursal.class.equals(clazz);
	}

	

	@Override
	public void validate(Object target, Errors errors) {
	
		TblSucursal sucursal = (TblSucursal) target;

		

		if (sucursal.getProvincia() == null || sucursal.getProvincia().isEmpty()) {
			errors.rejectValue("Provincia", "Provincia",
					"El campo Provincia es requerido.");
		}

		if (sucursal.getCiudad() == null || sucursal.getCiudad().isEmpty()) {
			errors.rejectValue("Ciudad", "Ciudad", "El campo Ciudad es requerido.");
		}

		if (sucursal.getDireccion() == null || sucursal.getDireccion().isEmpty()) {
			errors.rejectValue("Direccion", "Direccion", "El campo Direccion es requerido.");
		}

		

	

		if (sucursal.getProvincia() != null && !sucursal.getProvincia().isEmpty()
				&& !sucursal.getProvincia().matches("[a-zA-áéíóúÁÉÍÓÚ ]+")) {
			errors.rejectValue("Provincia", "Provincia",
					"El campo Provincia solo permite ingresar caracteres alfabetico.");
		}
		
		
		
		if (sucursal.getCiudad() != null && !sucursal.getCiudad().isEmpty()
				&& !sucursal.getCiudad().matches("[a-zA-áéíóúÁÉÍÓÚ ]+")) {
			errors.rejectValue("Ciudad", "Ciudad",
					"El campo Ciudad solo permite ingresar caracteres alfabetico.");
		}

	}


}
