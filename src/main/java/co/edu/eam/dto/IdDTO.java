package co.edu.eam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IdDTO {
	
	@JsonProperty("id")
	private String id;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	

}
