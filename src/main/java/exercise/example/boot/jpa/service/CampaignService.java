package exercise.example.boot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercise.example.boot.jpa.domain.Campaign;
import exercise.example.boot.jpa.repository.CampaignRepository;

@Service
public class CampaignService{

	private CampaignRepository repo;
	
	public CampaignService() {}
	
	@Autowired
	public CampaignService(CampaignRepository repo) {
		this.repo = repo;
	}
	
	public Campaign getCampaign(int campaignId) {
		return repo.findByCampaignId(Integer.valueOf(campaignId));
	}
	
	
	public Campaign saveCampaign(Campaign campaign) {
		return repo.save(campaign);
	}
	
	public void deleteCampaign(Campaign campaign) {
		repo.delete(campaign);
	}
	
}
