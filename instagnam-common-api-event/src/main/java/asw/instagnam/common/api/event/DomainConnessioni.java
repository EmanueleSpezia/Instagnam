package asw.instagnam.common.api.event;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainConnessioni implements DomainEvent{

	private Long id;
	private String follower; 
	private String followed;
	
}

