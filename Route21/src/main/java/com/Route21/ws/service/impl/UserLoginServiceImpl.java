package com.Route21.ws.service.impl;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Route21.ws.bean.UserLogin;
import com.Route21.ws.exception.LoginCredentialNotMatchedException;
import com.Route21.ws.repository.UserLoginRepository;
import com.Route21.ws.request.LoginRequest;
import com.Route21.ws.response.RegisterPartyResponse;
import com.Route21.ws.service.UserLoginService;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	protected UserLoginRepository userLoginRepository;
	
	@Override
	public RegisterPartyResponse userLogin(LoginRequest request) {
		RegisterPartyResponse response = new RegisterPartyResponse();
		UserLogin userlogin = userLoginRepository.findUserLogin(request.getLoginId(),request.getLoginPwd());
		if(userlogin != null)
		{
			UUID cookie = UUID.randomUUID();
			userlogin.setCookie(cookie.toString());
			userLoginRepository.save(userlogin);
			
			response.setStatusCode(200);
			response.setStatusMessage("Login Successful");
			response.setUserLogin(userlogin);
		}
		else		
			throw new LoginCredentialNotMatchedException("Either Userid or password is not Correct");
	
		return response;
	}

}
