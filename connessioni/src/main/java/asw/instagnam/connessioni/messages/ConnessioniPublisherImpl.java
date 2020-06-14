package asw.instagnam.connessioni.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import asw.instagnam.connessioni.domain.Connessione;
import asw.instagnam.connessioni.domain.ConnessioniPublisher;
import asw.instagnam.common.api.event.DomainEvent;

@Service
public class ConnessioniPublisherImpl implements ConnessioniPublisher{
	
	private String channel = "connessioneCreatedEvent";
	@Autowired
	private KafkaTemplate<String, String> template;
	
	@Override
	public void publish(DomainEvent message) {
		ObjectMapper om = new ObjectMapper();
		try {
			String generatedJson = om.writeValueAsString(message);
			this.template.send(this.channel, generatedJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}

