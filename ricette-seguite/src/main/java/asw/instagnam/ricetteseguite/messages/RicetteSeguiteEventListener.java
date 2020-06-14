package asw.instagnam.ricetteseguite.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import asw.instagnam.ricetteseguite.domain.DomainEvent;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteEventConsumer;
@Component
public class RicetteSeguiteEventListener {
		static final String KAFKACHANNELRICETTE = "asw.instagnam.channel.ricettaCreatedEvent";
		static final String KAFKACHANNELCONNESSIONI = "asw.instagnam.channel.connessioneCreatedEvent";
	
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
