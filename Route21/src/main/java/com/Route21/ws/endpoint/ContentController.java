package com.Route21.ws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Route21.ws.constants.Route21Constants;
import com.Route21.ws.request.SampleRequest;
import com.Route21.ws.request.SaveContentRequest;
import com.Route21.ws.response.GetContentResponse;
import com.Route21.ws.response.Response;
import com.Route21.ws.service.ContentService;

@RestController
@Path("/")
public class ContentController {

	private final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);
	
	@Autowired
	ContentService contentService;
	
	
	@POST
	@Path(Route21Constants.SAVE_CONTENT)
	@Produces("application/json")
	@Consumes("application/json")
	public Object saveContent(SaveContentRequest saveRequest) {
		LOGGER.debug("SAVE CONTENT METHOD");
		System.out.println("CONTENT METHOD CALLED");
		return contentService.saveContent(saveRequest);
	}
	
	@GET
	@Path(Route21Constants.LIST_CONTENT)
	@Produces("application/json")
	public GetContentResponse listContnets() {
		LOGGER.debug("LIST CONTENT");
		return contentService.listContents();
	}
	
	@GET
	@Path(Route21Constants.GET_CONTENT)
	@Produces("application/json")
	public GetContentResponse getContent(@PathParam("pageUrl") String pageUrl) {
		LOGGER.debug("GET CONTENT");
		return contentService.getContent(pageUrl);
	}
}
