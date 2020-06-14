package asw.instagnam.common.api.event;

public class DomainRicette implements DomainEvent{

	private String autore; 
	private String titolo; 
	
	public DomainRicette(String autore, String titolo) {
		this.autore = autore;
		this.titolo = titolo;
	}
}

