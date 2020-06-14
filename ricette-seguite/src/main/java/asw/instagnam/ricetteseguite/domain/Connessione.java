package asw.instagnam.ricetteseguite.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*; 
import asw.instagnam.common.api.event.DomainEvent;

@Entity 
@Data
@NoArgsConstructor
public class Connessione implements DomainEvent {

	@Id
	private Long id; 
	private String follower; 
	private String followed;
	
	public String getFollowed() {
		// TODO Auto-generated method stub
		return null;
	} 
	
}
