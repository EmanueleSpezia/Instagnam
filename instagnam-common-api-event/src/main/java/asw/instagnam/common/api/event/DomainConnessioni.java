package asw.instagnam.common.api.event;

public class DomainConnessioni implements DomainEvent{

	private String follower; 
	private String followed;
	
	public DomainConnessioni(String follower, String followed) {
		this.follower = follower;
		this.followed = followed;
	}
}

