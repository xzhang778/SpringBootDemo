package demo.boot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import demo.boot.rest.service.CampaignMessageService;
import demo.boot.test.domain.CampaignMessage;

@RestController
public class CampaignMessageController 
{
	@Autowired
	private CampaignMessageService service;
	
     
	@PostMapping("/campaignMessage")
	public CampaignMessage postCampaignMessage(CampaignMessage newCampaignMessage)
	{
		return service.createCampaignMessage(newCampaignMessage);
	}
	
	@GetMapping("/campaignMessage/{id}")
	public String getCampaignMessage(@PathVariable("id") Integer id)
	{
		return service.getCampaignMessageById(id);
	}
	
	@PutMapping("/campaignMessage/{id}")
	public CampaignMessage updateCampaignMessage(@PathVariable("id") Integer id, String message)
	{
		return new CampaignMessage("Hello~", id);
	}
	
	@DeleteMapping("/campaignMessage/{id}")
	public void deleteCampaignMessage(@PathVariable("id") Integer id)
	{
		//to do;
	}
	
	
}
