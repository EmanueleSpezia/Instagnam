package asw.instagnam.ricetteseguite.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*; 
import asw.instagnam.common.api.event.DomainEvent;

@Entity 
@Data
@NoArgsConstructor
public class Ricetteseguite implements DomainEvent {

	@Id
	@GeneratedValue
	private Long id;
	private String utenteFollower;
	private Long idRicetta;
	private String autoreRicetta; 
	private String titoloRicetta;

	public Ricetteseguite(String utenteFollower,Long idRicetta,String autoreRicetta,String titoloRicetta) {
		this.utenteFollower = utenteFollower;
		this.idRicetta = idRicetta;
		this.autoreRicetta = autoreRicetta;
		this.titoloRicetta = titoloRicetta;
	}
	
}
