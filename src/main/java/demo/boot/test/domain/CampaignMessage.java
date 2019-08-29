package demo.boot.test.domain;

public class CampaignMessage {
	private String message;
	private Integer messageid;

	public CampaignMessage() {}
	
	public CampaignMessage(String message, Integer id) {
		this.message = message;
		this.messageid = id;
	}

	public void setCampaignMessageId(Integer id) {
		this.messageid = id;
	}
	
	public Integer getCampaignMessageId() {
		return this.messageid;
	}
	
	public String getCampaignMessage() {
		return message;
	}

	public void setCampaignMessage(String message) {
		this.message = message;
	}

}
