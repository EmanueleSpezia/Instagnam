package asw.instagnam.ricetteseguite.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteEventConsumer;
@Component
public class RicetteSeguiteEventListener {
	 @Autowired
	    private RicetteSeguiteEventConsumer ricetteSeguiteEventConsumer;

		@KafkaListener(topics = {"asw.instagnam.channel.ricettaCreatedEvent","asw.instagnam.channel.connessioneCreatedEvent"})
	    public void listen(ConsumerRecord<String, Object> record) throws Exception {
	        Object event = record.value(); //TODO questo deve essere cambiato
			ricetteSeguiteEventConsumer.onEvent(event); 
	    }

}
