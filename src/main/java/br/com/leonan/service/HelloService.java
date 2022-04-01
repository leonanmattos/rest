package br.com.leonan.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.leonan.repository.HelloRepository;

@RequestScoped
public class HelloService {
	
	private HelloRepository helloRepository;
	
	public HelloService() {}

	@Inject
	public HelloService(HelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}
	
	public String sayHello() {
		return "Hello World";
	}
}
