package com.backend.sistema.services.implement;

import com.backend.sistema.models.TblUser;

public interface IUsuarioServiceImplements {
	public TblUser findByUserEmail(String username);

	TblUser findUserByEmail(String email);

}
