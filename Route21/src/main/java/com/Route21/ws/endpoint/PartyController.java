package com.Route21.ws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Route21.ws.constants.Route21Constants;
import com.Route21.ws.request.RegisterPartyRequest;
import com.Route21.ws.response.RegisterPartyResponse;
import com.Route21.ws.response.Response;
import com.Route21.ws.service.PartyService;

@RestController
@Path("/")
public class PartyController {
	
	@Autowired
	protected PartyService partyService;

	@POST
	@Path(Route21Constants.REGISTER_PARTY)
	@Produces("application/json")
	@Consumes("application/json")
	public RegisterPartyResponse registerParty(RegisterPartyRequest request)
	{	
		return partyService.regiterParty(request);
		
	}
	
	
}
