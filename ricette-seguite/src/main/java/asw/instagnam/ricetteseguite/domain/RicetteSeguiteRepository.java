package asw.instagnam.ricetteseguite.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface RicetteSeguiteRepository extends CrudRepository<Ricetta, Long> {
	
	public Collection<Ricetta> findAll();

	public Collection<Ricetta> findAllByAutore(String autore);
}
