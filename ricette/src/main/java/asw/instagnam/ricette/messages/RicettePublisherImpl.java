package asw.instagnam.ricette.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import asw.instagnam.ricette.domain.Ricetta;
import asw.instagnam.ricette.domain.RicettePublisher;
import asw.instagnam.common.api.event.DomainEvent;

@Service
public class RicettePublisherImpl implements RicettePublisher{
	
	private String channel = "ricettaCreatedEvent";
	@Autowired
	private KafkaTemplate<String, String> template;
	
	
	@Override
	public void publish(DomainEvent message) {
		ObjectMapper om = new ObjectMapper();
		try {
			String generatedJson = om.writeValueAsString(message);
			System.out.println("\nInvio ricetta:\n" + generatedJson + "\n\n");
			this.template.send(this.channel, generatedJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
 
}
