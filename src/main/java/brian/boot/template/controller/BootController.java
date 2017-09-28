package brian.boot.template.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brian.boot.template.domain.Hello;

@RestController
public class BootController 
{
	@RequestMapping("/")
	public Hello getHello()
	{
		return new Hello("Hello~");
	}
}
