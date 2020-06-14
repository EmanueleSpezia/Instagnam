package asw.instagnam.ricette.domain;
import asw.instagnam.common.api.event.DomainEvent;

public interface RicettePublisher {
	public void publish(DomainEvent message);
}
