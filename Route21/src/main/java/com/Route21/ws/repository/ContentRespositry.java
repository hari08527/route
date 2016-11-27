package com.Route21.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Route21.ws.bean.Content;


public interface ContentRespositry extends JpaRepository<Content,Long> {
	List<Content> findByPageUrl(String pageUrl);
}
