package asw.instagnam.ricette.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRicettaRequest {

	private String autore; 
	private String titolo; 
	private String preparazione;
	
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

