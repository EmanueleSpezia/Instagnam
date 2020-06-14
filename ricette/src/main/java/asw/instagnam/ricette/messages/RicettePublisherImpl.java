package asw.instagnam.ricette.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import asw.instagnam.ricette.domain.Ricetta;
import asw.instagnam.ricette.domain.RicettePublisher;
import asw.instagnam.common.api.event.DomainEvent;

@Service
public class RicettePublisherImpl implements RicettePublisher{
	
	private String channel = "ricettaCreatedEvent";
	@Autowired
	private KafkaTemplate<String, DomainEvent> template;
	
	
	@Override
	public void publish(DomainEvent message) {
		this.template.send(this.channel,message);
	}
 
}
