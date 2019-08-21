package brian.template.boot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import brian.template.boot.rest.service.BootService;
import brian.template.boot.test.domain.Hello;

@RestController
public class BootController 
{
	@Autowired
	private BootService service;
	
	@GetMapping("/")
	public Hello getHello()
	{
		return new Hello("Hello~", 99);
	}
	
	@GetMapping("/search/{name}")
	public List<Hello> searchByName(@PathVariable("name") String name)
	{
		return service.searchPersonalInfo(name);
	}
}
