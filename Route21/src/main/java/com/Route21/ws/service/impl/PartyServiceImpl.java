package com.Route21.ws.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Route21.ws.bean.Party;
import com.Route21.ws.bean.PartyType;
import com.Route21.ws.bean.UserLogin;
import com.Route21.ws.repository.PartyRepository;
import com.Route21.ws.repository.UserLoginRepository;
import com.Route21.ws.request.RegisterPartyRequest;
import com.Route21.ws.response.RegisterPartyResponse;
import com.Route21.ws.response.Response;
import com.Route21.ws.service.PartyService;

@Service
@Transactional
public class PartyServiceImpl implements PartyService{
	
	@Autowired
	protected UserLoginRepository userLoginRepository;
	
	@Autowired
	protected PartyRepository partyRepository;
	
	@Override
	public RegisterPartyResponse regiterParty(RegisterPartyRequest request) {
		RegisterPartyResponse response = new RegisterPartyResponse();
		
		PartyType ptype = new PartyType();
		ptype.setId(2);
		
		Party pty = new Party();
		pty.setName(request.getName());
		pty.setLastName(request.getLastName());
		pty.setEmail(request.getEmail());
		pty.setDescription("Hi "+request.getName()+" "+request.getLastName());
		pty.setPartyType(ptype);
		
		//Party party = partyRepository.save(pty);
		
		
		UserLogin ulogin = new UserLogin();
		ulogin.setLoginId(request.getEmail());
		ulogin.setLoginPassword(request.getPassword());
		ulogin.setParty(pty);
		
		UserLogin newUser =  userLoginRepository.save(ulogin);
		
		response.setStatusCode(200);
		response.setStatusMessage("Party Registered Successfully");
		response.setUserLogin(newUser);
		
		return response;
	}

}
