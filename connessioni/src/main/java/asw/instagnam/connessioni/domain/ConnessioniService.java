package asw.instagnam.connessioni.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import asw.instagnam.common.api.event.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger; 
import java.util.*; 

@Service
public class ConnessioniService {
	
	@Autowired
	private ConnessioniPublisher publisher;

	@Autowired
	private ConnessioniRepository connessioniRepository;

 	public Connessione createConnessione(String follower, String followed) {
		Connessione connessione = new Connessione(follower, followed); 
		connessione = connessioniRepository.save(connessione);
		DomainEvent event = new DomainConnessioni(connessione.getId(),connessione.getFollower(),connessione.getFollowed());
		this.publisher.publish(event);
		return connessione;
	}

 	public Connessione getConnessione(Long id) {
		Connessione connessione = connessioniRepository.findById(id).orElse(null);
		return connessione;
	}

 	public Collection<Connessione> getConnessioni() {
		Collection<Connessione> connessioni = connessioniRepository.findAll();
		return connessioni;
	}

	public Collection<Connessione> getConnessioniByFollower(String follower) {
		Collection<Connessione> connessioni = connessioniRepository.findAllByFollower(follower);
		return connessioni;
	}
	
	public Collection<Connessione> getConnessioniByFollowed(String followed) {
		Collection<Connessione> connessioni = connessioniRepository.findAllByFollowed(followed);
		return connessioni;
	}

}
