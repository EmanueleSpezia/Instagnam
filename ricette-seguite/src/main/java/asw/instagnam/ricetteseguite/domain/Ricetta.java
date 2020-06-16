package asw.instagnam.ricetteseguite.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import asw.instagnam.common.api.event.DomainEvent;

import lombok.*; 

/* Ricetta (in formato breve). */ 
@Entity
@Data 
@NoArgsConstructor
public class Ricetta implements DomainEvent{

	@Id
	private Long id; 
	private String autore; 
	private String titolo; 
	
	public Ricetta(Long id,String autore,String titolo) {
		this.id = id;
		this.autore = autore;
		this.titolo = titolo;
	}
	
}
