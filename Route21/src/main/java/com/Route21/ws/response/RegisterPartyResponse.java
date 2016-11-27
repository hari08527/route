package com.Route21.ws.response;

import com.Route21.ws.bean.UserLogin;

public class RegisterPartyResponse extends Response {
	
	private UserLogin userLogin;

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	

}
