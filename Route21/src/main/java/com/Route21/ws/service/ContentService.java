package com.Route21.ws.service;

import com.Route21.ws.request.SaveContentRequest;
import com.Route21.ws.response.GetContentResponse;
import com.Route21.ws.response.SaveContentResponse;

public interface ContentService {
	
	public SaveContentResponse saveContent(SaveContentRequest saveRequest);
	
	public GetContentResponse listContents();
	
	public GetContentResponse getContent(String pageUrl);
}