package asw.instagnam.connessioni.domain;

import javax.persistence.*; 

import lombok.*; 

@Entity 
@Data 
public class Connessione {

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
