package exercise.example.boot.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import exercise.example.boot.jpa.domain.Campaign;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Integer>{
	
	public Campaign findByCampaignId(Integer campaignId);
}
