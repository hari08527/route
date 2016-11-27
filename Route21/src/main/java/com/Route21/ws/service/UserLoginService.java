package com.Route21.ws.service;

import com.Route21.ws.request.LoginRequest;
import com.Route21.ws.response.RegisterPartyResponse;

public interface UserLoginService {

	public RegisterPartyResponse userLogin(LoginRequest request);

}
