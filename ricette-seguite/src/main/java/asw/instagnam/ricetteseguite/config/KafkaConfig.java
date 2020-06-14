package asw.instagnam.ricetteseguite.config;

import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

@Configuration
public class KafkaConfig {

	/*@Bean
	public NewTopic ricetteTopic() {
	    return new NewTopic("asw.instagnam.channel.ricettaCreatedEvent", 1, (short) 1);
	}
	
	@Bean
	public NewTopic connessioneTopic() {
	    return new NewTopic("asw.instagnam.channel.connessioneCreatedEvent", 1, (short) 1);
	}*/
}
