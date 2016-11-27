package com.Route21.ws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Route21.ws.constants.Route21Constants;
import com.Route21.ws.request.LoginRequest;
import com.Route21.ws.request.SampleRequest;
import com.Route21.ws.response.RegisterPartyResponse;
import com.Route21.ws.response.Response;
import com.Route21.ws.service.UserLoginService;

@RestController
@Path("/")
public class UserLoginController {
	
	@Autowired
	protected UserLoginService userLoginService;

	@GET
	@Produces("application/json")
	@Path("/User")
	public Response test()
	{
		Response res = new Response();
		res.setStatusCode(200);
		res.setStatusMessage("Processed Successfully");
		return res;
	}
	
	@POST
	@Path("/User")
	@Produces("application/json")
	@Consumes("application/json")
	public Response test2(SampleRequest request)
	{		
		Response res = new Response();
		res.setStatusCode(200);
		res.setStatusMessage("ID::::"+request.getId()+"Name:::"+request.getName());
		return res;
		
	}
	
	@POST
	@Path(Route21Constants.USER_LOGIN)
	@Produces("application/json")
	@Consumes("application/json")
	public RegisterPartyResponse userLogin(LoginRequest request)
	{
			
		return userLoginService.userLogin(request);
		
	}
}
