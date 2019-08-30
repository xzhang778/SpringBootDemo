package exercise.example.boot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import exercise.example.boot.jpa.domain.Campaign;
import exercise.example.boot.jpa.service.CampaignService;

@RestController
public class CampaignController {

	private CampaignService service;
	
	public CampaignController() {}
	
	@Autowired
	public CampaignController(CampaignService service) {
		this.service = service;
	}
		
	@GetMapping(value="/campaignmessage/{campaignId}")
	public ResponseEntity<Campaign> getCampaign(@PathVariable("campaignId") int campaignId)
	{
		Campaign campaign = service.getCampaign(campaignId);
		return new ResponseEntity<>( campaign, HttpStatus.OK );
	}
	
	@PostMapping(value="/campaignmessage")
	public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign)
	{
		campaign = service.saveCampaign(campaign);	
		return new ResponseEntity<>( campaign, HttpStatus.OK );
	}
	
	@DeleteMapping(value="/campaignmessage/{campaignId}")
	public ResponseEntity<Campaign> deleteCampaign(@PathVariable("campaignId") int campaignId)
	{
		Campaign campaign = new Campaign();
		campaign.setCampaignId(campaignId);
		service.deleteCampaign(campaign);
		return new ResponseEntity<>( campaign, HttpStatus.OK );
	}
	
	@PutMapping(value="/campaignmessage/{campaignId}")
	public ResponseEntity<Campaign>  updateCampaign(@RequestBody Campaign campaign)
	{
		campaign = service.saveCampaign(campaign);
		return new ResponseEntity<>( campaign, HttpStatus.OK );
	} 
}
