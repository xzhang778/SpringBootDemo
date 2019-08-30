package exercise.example.boot.jpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "CAMPAIGN")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaign_id")
    private int campaignId;
    private String customerName;
    private String messageText;

    public Campaign(){
    	
    }

    public Campaign(String customerName, String messageText){
       this.customerName = customerName;
       this.messageText = messageText;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
