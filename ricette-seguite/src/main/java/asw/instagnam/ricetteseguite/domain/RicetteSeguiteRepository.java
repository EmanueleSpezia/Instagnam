package asw.instagnam.ricetteseguite.domain;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RicetteSeguiteRepository extends CrudRepository<Ricetta, Long> {
	
	public Collection<Ricetta> findAll();

	@Query("SELECT r " +
			"FROM Ricetta r " + 
			"WHERE r.autore=:autore")
	public Collection<Ricetta> findAllByAutore(@Param("autore")String autore);
}
