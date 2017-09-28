package brian.boot.template.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brian.boot.template.test.domain.Hello;

@RestController
public class BootController 
{
	@RequestMapping("/")
	public Hello getHello()
	{
		return new Hello("Hello~");
	}
}
