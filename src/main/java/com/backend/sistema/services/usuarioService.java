package com.backend.sistema.services;


import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.backend.sistema.DAO.IUserDao;
import com.backend.sistema.models.TblUser;
import com.backend.sistema.services.implement.IUsuarioServiceImplements;


@Service
public class usuarioService implements IUsuarioServiceImplements, UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(IUsuarioServiceImplements.class);

	@Autowired
	private IUserDao usuarioDao;



	/*
	 * Funcion: consulta la existencia de usuario
	 * 
	 * @Param: email
	 * 
	 * @Return: user authority
	 * 
	 * @autor: bayardo chandi <bayardojesus@gmail.com>
	 * 
	 * @version: 1.0
	 */

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		TblUser usuario = usuarioDao.findByUser(email);
		if (usuario == null) {
			System.out.println("asdasd");
			logger.error("Error en el login-: no existe el usuario '" + email + "' en el sistema!");
			throw new UsernameNotFoundException(
					"Error en el login--: no existe el usuario '" + email + "' en el sistema!");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(usuario.getTblRol().getNameRole()));
		return new User(usuario.getUserLogin(), usuario.getUserPassword(), true, true, true, true, authorities);
	}

	/*
	 * Funcion: obtiene usuario por email
	 * 
	 * @Param: email
	 * 
	 * @Return: data user
	 * 
	 * @autor: bayardo chandi <bayardojesus@gmail.com>
	 * 
	 * @version: 1.0
	 */

	@Override
	@Transactional(readOnly = true)
	public TblUser findByUserEmail(String email) {
		return usuarioDao.findByUser(email);
	}

	
	/*
	 * Funcion: encuentra al usuario por email
	 * 
	 * @Param: email
	 * 
	 * @Return: data user
	 * 
	 * @autor: bayardo chandi <bayardojesus@gmail.com>
	 * 
	 * @version: 1.0
	 */

	@Override
	@Transactional(readOnly = true)
	public TblUser findUserByEmail(String email) {
		TblUser reponse = null;

		try {
			reponse = usuarioDao.findByUser(email);
		} catch (DataAccessException e) {
			logger.error("No se realizo la consulta");
		}
		return reponse;
	}

	

	

	
	
	
	

	

}
