package com.backend.sistema.auth;

import java.util.HashMap;

import java.util.Map;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.backend.sistema.DAO.IUserDao;
import com.backend.sistema.models.TblUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
@Component
public class addInfoToken implements TokenEnhancer {

	
	
	


	@Autowired
	private IUserDao usuarioDao;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
	
		Map<String, Object> info = new HashMap<>();
		System.out.println(authentication.getName());
		TblUser user=usuarioDao.findByUser(authentication.getName());
	
		info.put("SessionId", user.getIdUser());
		info.put("email", user.getUserLogin());
		info.put("role", user.getTblRol().getNameRole());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}
}
