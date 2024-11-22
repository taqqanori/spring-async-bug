package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NonAsyncService {

	@Value("${spring.application.name}")
	private String value;

	public void nonFinal() {
		System.out.println("non-async non-final: " + value);
	}

	public final void _final() {
		System.out.println("non-async final: " + value);
	}

}
