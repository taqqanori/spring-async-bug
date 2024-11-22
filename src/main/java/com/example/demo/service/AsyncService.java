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

	public final void _final() {
		// becomes null
		System.out.println("async final: " + value);
	}

	public void nonFinal() {
		// becomes "demo"
		System.out.println("async non-final: " + value);
	}

}
