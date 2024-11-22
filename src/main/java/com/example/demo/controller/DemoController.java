package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.AsyncService;
import com.example.demo.service.NonAsyncService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DemoController {

	@Autowired
	private AsyncService asyncService;
	@Autowired
	private NonAsyncService nonAsyncService;

	@RequestMapping("/**")
	public ResponseEntity<String> handle(String body,
			HttpMethod method, HttpServletRequest request, HttpServletResponse response) {

		asyncService._final();
		asyncService.nonFinal();
		nonAsyncService._final();
		nonAsyncService.nonFinal();

		return ResponseEntity.ok("ok: see the log");
	}

}
