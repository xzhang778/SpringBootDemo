package demo.boot.rest.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import demo.boot.test.domain.CampaignMessage;

@Service
public class CampaignMessageService {

	HashMap<Integer, CampaignMessage> map = new HashMap<Integer, CampaignMessage>();
	CampaignMessage obj1 = new CampaignMessage("You are qualified for a new overdraft limit.", 1);
	
	public CampaignMessageService() {
		map.put(0, obj1 );
	}
	
	public CampaignMessage createCampaignMessage(CampaignMessage obj) {
		Integer id = obj.getCampaignMessageId();
		map.put(id, obj);
		return map.get(id);
	}
	
	public String getCampaignMessageById (Integer id) {
		return 	map.get(id).getCampaignMessage();
	}
}
