package asw.instagnam.connessioni.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import asw.instagnam.connessioni.domain.Connessione;
import asw.instagnam.connessioni.domain.ConnessioniPublisher;
import asw.instagnam.common.api.event.DomainEvent;

@Service
public class ConnessioniPublisherImpl implements ConnessioniPublisher{
	
	private String channel = "connessioneCreatedEvent";
	@Autowired
	private KafkaTemplate<String, DomainEvent> template;
	
	@Override
	public void publish(DomainEvent message) {
		this.template.send(this.channel,message);
	}
 
}

