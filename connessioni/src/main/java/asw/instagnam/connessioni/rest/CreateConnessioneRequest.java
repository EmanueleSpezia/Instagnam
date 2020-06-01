package asw.instagnam.connessioni.rest;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateConnessioneRequest {

	private String follower; 
	private String followed;
	
	public String getFollower() {
		return follower;
	}

	public String getFollowed() {
		return followed;
	} 

}

