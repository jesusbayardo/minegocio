package com.backend.sistema.utils.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.sistema.DAO.IClienteDao;
import com.backend.sistema.DTO.clienteDTO;
import com.backend.sistema.models.TblCliente;

@Component
public class clienteValidator implements Validator {

	@Autowired
	private IClienteDao IClienteDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return TblCliente.class.equals(clazz);
	}

	public void validateGet(Object target, Errors errors) {

		TblCliente client = (TblCliente) target;

	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("here");
		clienteDTO client = (clienteDTO) target;

		TblCliente getListClient = IClienteDao.getClientByIdentification(client.getNumeroIdentificacioncliente());

		if (getListClient != null) {
			errors.rejectValue("numeroIdentificacioncliente", "numeroIdentificacioncliente",
					"El usuario con la identificacion ingresada ya existe.");
		}

		if (client.getTipoIdentificacioncliente() == null || client.getTipoIdentificacioncliente().isEmpty()) {
			errors.rejectValue("TipoIdentificacioncliente", "TipoIdentificacioncliente",
					"El campo TipoIdentificacioncliente es requerido.");
		}

		if (client.getNombrescliente() == null || client.getNombrescliente().isEmpty()) {
			errors.rejectValue("Nombrescliente", "Nombrescliente", "El campo Nombrescliente es requerido.");
		}

		if (client.getCorreocliente() == null || client.getCorreocliente().isEmpty()) {
			errors.rejectValue("Correocliente", "Correocliente", "El campo Correocliente es requerido.");
		}

		if (client.getProvinciasucursal() == null || client.getProvinciasucursal().isEmpty()) {
			errors.rejectValue("Provinciasucursal", "CorreProvinciasucursalocliente",
					"El campo Provinciasucursal es requerido.");
		}

		if (client.getCiudadsucursal() == null || client.getCiudadsucursal().isEmpty()) {
			errors.rejectValue("Ciudadsucursal", "Ciudadsucursal", "El campo Ciudadsucursal es requerido.");
		}

		if (client.getDireccionsucursal() == null || client.getDireccionsucursal().isEmpty()) {
			errors.rejectValue("Direccionsucursal", "Direccionsucursal", "El campo Direccionsucursal es requerido.");
		}

		if (client.getCorreocliente() != null && !client.getCorreocliente().isEmpty()
				&& !client.getCorreocliente().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			errors.rejectValue("Correocliente", "Correocliente", "El formato de email es incorrecto.");
		}

		if (client.getNumeroIdentificacioncliente() != null && !client.getNumeroIdentificacioncliente().isEmpty()
				&& !client.getNumeroIdentificacioncliente().matches("[0-9]+")) {
			errors.rejectValue("NumeroIdentificacioncliente", "NumeroIdentificacioncliente",
					"El campo TipoIdentificacioncliente debe ser numerico.");
		}

		if (client.getTipoIdentificacioncliente() != null && !client.getTipoIdentificacioncliente().isEmpty()) {

			if (client.getTipoIdentificacioncliente().equals("DNI")) {
				if (!client.getNumeroIdentificacioncliente().matches(".{10}")) {
					errors.rejectValue("NumeroIdentificacioncliente", "NumeroIdentificacioncliente",
							"El campo Identificacioncliente debe tener 10 dígitos.");
				}
			}

			if (client.getTipoIdentificacioncliente().equals("RUC")) {
				if (!client.getNumeroIdentificacioncliente().matches(".{13}")) {
					errors.rejectValue("NumeroIdentificacioncliente", "NumeroIdentificacioncliente",
							"El campo Identificacioncliente debe tener 13 dígitos.");
				}
			}

		}

		if (client.getNombrescliente() != null && !client.getNombrescliente().isEmpty()
				&& !client.getNombrescliente().matches("[a-zA-áéíóúÁÉÍÓÚ ]+")) {
			errors.rejectValue("Nombrescliente", "Nombrescliente",
					"El campo Nombrescliente solo permite ingresar caracteres alfabetico.");
		}

	}

	public void validateUpdate(Object target, Errors errors) {

		TblCliente client = (TblCliente) target;

		TblCliente getClient = IClienteDao.getClientByIdentification(client.getNumeroIdentificacion());

		if (getClient != null) {

			if (getClient.getIdCliente() != client.getIdCliente()) {
				errors.rejectValue("numeroIdentificacion", "numeroIdentificacio",
						"No se puede realizar la actualizacion porque va a duplicar el numero de registro.");
			}

		}

		if (client.getTipoIdentificacion() == null || client.getTipoIdentificacion().isEmpty()) {
			errors.rejectValue("TipoIdentificacion", "TipoIdentificacion", "El campo TipoIdentificacion es requerido.");
		}

		if (client.getNombres() == null || client.getNombres().isEmpty()) {
			errors.rejectValue("Nombres", "Nombres", "El campo Nombres es requerido.");
		}

		if (client.getCorreo() == null || client.getCorreo().isEmpty()) {
			errors.rejectValue("Correocliente", "Correocliente", "El campo Correo es requerido.");
		}

		if (client.getCorreo() != null && !client.getCorreo().isEmpty()
				&& !client.getCorreo().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			errors.rejectValue("Correo", "Correo", "El formato de email es incorrecto.");
		}

		if (client.getNumeroIdentificacion() != null && !client.getNumeroIdentificacion().isEmpty()
				&& !client.getNumeroIdentificacion().matches("[0-9]+")) {
			errors.rejectValue("NumeroIdentificacion", "NumeroIdentificacion",
					"El campo TipoIdentificacion debe ser numerico.");
		}

		if (client.getTipoIdentificacion() != null && !client.getTipoIdentificacion().isEmpty()) {

			if (client.getTipoIdentificacion().equals("DNI")) {
				if (!client.getNumeroIdentificacion().matches(".{10}")) {
					errors.rejectValue("NumeroIdentificacion", "NumeroIdentificacion",
							"El campo Identificacion debe tener 10 dígitos.");
				}
			}

			if (client.getTipoIdentificacion().equals("RUC")) {
				if (!client.getNumeroIdentificacion().matches(".{13}")) {
					errors.rejectValue("NumeroIdentificacion", "NumeroIdentificacion",
							"El campo Identificacion debe tener 13 dígitos.");
				}
			}

		}

		if (client.getNombres() != null && !client.getNombres().isEmpty()
				&& !client.getNombres().matches("[a-zA-áéíóúÁÉÍÓÚ ]+")) {
			errors.rejectValue("Nombres", "Nombres", "El campo Nombressolo permite ingresar caracteres alfabetico.");
		}

	}

}
