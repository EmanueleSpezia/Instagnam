package asw.instagnam.connessioni.domain;
import asw.instagnam.common.api.event.DomainEvent;

public interface ConnessioniPublisher {
	public void publish(DomainEvent message);
}
