package asw.instagnam.ricetteseguite.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import asw.instagnam.common.api.event.DomainEvent;

import asw.instagnam.ricetteseguite.domain.RicetteSeguiteEventConsumer;
@Component
public class RicetteSeguiteEventListener {
		static final String KAFKACHANNELRICETTE = "ricettaCreatedEvent";
		static final String KAFKACHANNELCONNESSIONI = "connessioneCreatedEvent";
	
	 	@Autowired
	    private RicetteSeguiteEventConsumer ricetteSeguiteEventConsumer;

		@KafkaListener(topics = KAFKACHANNELRICETTE)
	    public void listenRicette(ConsumerRecord<String, DomainEvent> record) throws Exception {
	        DomainEvent event = record.value();  
			ricetteSeguiteEventConsumer.onEvent(event); 
	    }
		
		@KafkaListener(topics = KAFKACHANNELCONNESSIONI)
	    public void listenConnessioni(ConsumerRecord<String, DomainEvent> record) throws Exception {
	        DomainEvent event = record.value(); 
			ricetteSeguiteEventConsumer.onEvent(event); 
	    }


}
