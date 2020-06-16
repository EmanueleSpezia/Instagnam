package asw.instagnam.ricetteseguite.domain;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;


public interface RicetteSeguiteExtraRepository extends CrudRepository<Ricetteseguite, Long> {
	
	public Collection<Ricetteseguite> findAll();
	
	public Collection<Ricetteseguite> findAllByUtenteFollower(String utenteFollower);

}
