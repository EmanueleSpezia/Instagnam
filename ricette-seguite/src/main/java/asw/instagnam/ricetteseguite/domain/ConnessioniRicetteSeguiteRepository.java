package asw.instagnam.ricetteseguite.domain;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ConnessioniRicetteSeguiteRepository extends CrudRepository<Connessione, Long>  {
	
	public Collection<Connessione> findAll();

	public Collection<Connessione> findAllByFollower(String follower);
}
