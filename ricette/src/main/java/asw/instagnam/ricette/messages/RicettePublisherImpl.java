package asw.instagnam.ricette.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import asw.instagnam.ricette.domain.Ricetta;
import asw.instagnam.ricette.domain.RicettePublisher;

@Service
public class RicettePublisherImpl implements RicettePublisher{
	
	private String channel = "asw.instagnam.channel.ricettaCreatedEvent";
	@Autowired
	private KafkaTemplate<String, Ricetta> template;
	
	
	@Override
	public void publish(Ricetta message) {
		this.template.send(this.channel,message);
	}
 
}
