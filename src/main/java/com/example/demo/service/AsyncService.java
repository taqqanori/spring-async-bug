package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Value("${spring.application.name}")
	private String value;

	@Async
	public void async() {
		// just declared, never called
	}

	public void nonFinal() {
		System.out.println("async non-final: " + value);
	}

	public final void _final() {
		System.out.println("async final: " + value);
	}

}
