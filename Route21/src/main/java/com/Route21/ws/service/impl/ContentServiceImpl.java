package com.Route21.ws.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Route21.ws.bean.Content;
import com.Route21.ws.endpoint.ContentController;
import com.Route21.ws.repository.ContentRespositry;
import com.Route21.ws.request.SaveContentRequest;
import com.Route21.ws.response.GetContentResponse;
import com.Route21.ws.response.SaveContentResponse;
import com.Route21.ws.service.ContentService;



@Service
public class ContentServiceImpl implements ContentService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ContentServiceImpl.class);
	@Autowired
	ContentRespositry contentRespositry;

	@Override
	public SaveContentResponse saveContent(SaveContentRequest saveRequest) {
		Content con;	
		SaveContentResponse response = new SaveContentResponse();
		
		if(saveRequest.getId() == 0) {
			con = new Content();
			response.setStatusMessage("Content Inserted Succesfully");
		} else {
			con = contentRespositry.findOne(saveRequest.getId());
			response.setStatusMessage("Content Updated Succesfully");
		}
		con.setDescription(saveRequest.getDescription());
		con.setPageName(saveRequest.getPageName());
		con.setPageUrl(saveRequest.getPageUrl());
		con.setTitle(saveRequest.getTitle());
		con.setTitleUrl(saveRequest.getTitleUrl());
		
		Content content = contentRespositry.saveAndFlush(con);
		
		response.setStatusCode(200);		
		response.setContent(content);		
		return response;
	}

	@Override
	public GetContentResponse listContents() {
		LOGGER.debug("LIST ALL CONTENTS");
		GetContentResponse response = new  GetContentResponse();
		List<Content> contentList = contentRespositry.findAll();
		response.setStatusCode(200);
		response.setStatusMessage("Content List");
		response.setContentList(contentList);
		return response;
	}
	
	@Override
	public GetContentResponse getContent(String pageUrl) {
		//Content content = contentRespositry.findOne(contentId);
		List<Content> content = contentRespositry.findByPageUrl(pageUrl);
		GetContentResponse response = new  GetContentResponse();
		response.setStatusCode(200);
		response.setStatusMessage("Get Content");
		response.setContentList(content);
		return response;
	}

}
