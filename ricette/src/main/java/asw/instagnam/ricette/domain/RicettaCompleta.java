package asw.instagnam.ricette.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor; 

/* Ricetta, in formato completo. */ 
@Entity 
@Data 
public class RicettaCompleta {

	@Id 
	@GeneratedValue
	private Long id; 
	private String autore; 
	private String titolo; 
	private String preparazione; 
	
	public RicettaCompleta(String autore, String titolo, String preparazione) {
		this(); 
		this.autore = autore; 
		this.titolo = titolo; 
		this.preparazione = preparazione; 
	}


	public RicettaCompleta() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public String getAutore() {
		return autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getPreparazione() {
		return preparazione;
	}
	
	
}
