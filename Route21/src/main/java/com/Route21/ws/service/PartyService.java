package com.Route21.ws.service;

import com.Route21.ws.request.RegisterPartyRequest;
import com.Route21.ws.response.RegisterPartyResponse;

public interface PartyService {

	public RegisterPartyResponse regiterParty(RegisterPartyRequest request);

}
