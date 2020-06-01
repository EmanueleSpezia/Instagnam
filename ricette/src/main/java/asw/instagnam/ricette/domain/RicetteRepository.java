package asw.instagnam.ricette.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository; 

public interface RicetteRepository extends CrudRepository<RicettaCompleta, Long> {

	public Collection<RicettaCompleta> findAll();

	public Collection<RicettaCompleta> findAllByAutore(String autore);

}

