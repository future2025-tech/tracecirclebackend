	package com.tracecirclebackend.DTO;
	
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class UserDTO {
		
		 private String id;
	
		 private String email;
	
		 private String password; 
	
	}
