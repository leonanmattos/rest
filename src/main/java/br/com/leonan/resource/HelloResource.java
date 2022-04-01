package br.com.leonan.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.leonan.service.HelloService;

@Path("/hello")
public class HelloResource {
	
	private HelloService helloService;
	
	public HelloResource() {}
	
	@Inject
	public HelloResource(HelloService helloService) {
		this.helloService = helloService;
	}
	
	@GET
	public String sayHello() {
		return helloService.sayHello();
	}

}
