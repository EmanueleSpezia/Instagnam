package asw.instagnam.connessioni.domain;

import asw.instagnam.common.api.event.DomainEvent;

import javax.persistence.*; 

import lombok.*; 

@Entity 
@Data 
public class Connessione implements DomainEvent {

	@Id 
	@GeneratedValue
	private Long id; 
	private String follower; 
	private String followed; 
	
	public Connessione(String follower, String followed) {
		this(); 
		this.follower = follower; 
		this.followed = followed; 
	}

	public Connessione() {
		// TODO Auto-generated constructor stub
	}
	
}
