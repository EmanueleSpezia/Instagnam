package asw.instagnam.connessioni.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import asw.instagnam.connessioni.domain.Connessione;
import asw.instagnam.connessioni.domain.ConnessioniPublisher;

@Service
public class ConnessioniPublisherImpl implements ConnessioniPublisher{
	
	private String channel = "asw.instagnam.channel.ricettaCreatedEvent";
	@Autowired
	private KafkaTemplate<String, Connessione> template;
	
	
	@Override
	public void publish(Connessione message) {
		this.template.send(this.channel,message);
	}
 
}

