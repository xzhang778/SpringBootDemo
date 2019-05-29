package brian.template.boot.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brian.template.boot.test.domain.Hello;

@RestController
public class BootController 
{
	@RequestMapping("/")
	public Hello getHello()
	{
		return new Hello("Hello~");
	}
}
