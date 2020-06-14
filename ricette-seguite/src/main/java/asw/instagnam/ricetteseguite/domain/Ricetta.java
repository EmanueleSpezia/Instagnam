package asw.instagnam.ricetteseguite.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import asw.instagnam.common.api.event.DomainEvent;

import lombok.*; 

/* Ricetta (in formato breve). */ 
@Entity
@Data 
public class Ricetta implements DomainEvent{

	@Id
	private Long id; 
	private String autore; 
	private String titolo; 
	
}
