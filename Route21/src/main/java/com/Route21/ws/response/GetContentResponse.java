package com.Route21.ws.response;

import java.util.List;

import com.Route21.ws.bean.Content;

public class GetContentResponse extends Response {
	
	private List<Content> contentList;

	public List<Content> getContentList() {
		return contentList;
	}

	public void setContentList(List<Content> contentList) {
		this.contentList = contentList;
	}
}
