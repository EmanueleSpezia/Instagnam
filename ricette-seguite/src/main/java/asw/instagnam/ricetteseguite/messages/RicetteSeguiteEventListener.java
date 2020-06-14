package asw.instagnam.ricetteseguite.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricetteseguite.domain.Connessione;
import asw.instagnam.ricetteseguite.domain.Ricetta;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteEventConsumer;
@Component
public class RicetteSeguiteEventListener {
		static final String KAFKACHANNELRICETTE = "ricettaCreatedEvent";
		static final String KAFKACHANNELCONNESSIONI = "connessioneCreatedEvent";
	
	 	@Autowired
	    private RicetteSeguiteEventConsumer ricetteSeguiteEventConsumer;

		@KafkaListener(topics = KAFKACHANNELRICETTE)
		public void listenerRicette(@Payload String message) throws Exception {
			System.out.println("\nRicevuta ricetta:\n" + message + "\n\n");
			ObjectMapper om = new ObjectMapper();
			Ricetta ricetta = om.readValue(message, Ricetta.class);
			ricetteSeguiteEventConsumer.onEvent(ricetta); 
	    }
		
		@KafkaListener(topics = KAFKACHANNELCONNESSIONI)
		public void listenerConnessioni(@Payload String message) throws Exception {
			System.out.println("\nRicevuta connessione:\n" + message + "\n\n");
			ObjectMapper om = new ObjectMapper();
			Connessione connessione = om.readValue(message, Connessione.class);
			ricetteSeguiteEventConsumer.onEvent(connessione); 
	    }


}
