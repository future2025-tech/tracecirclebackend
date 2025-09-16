package com.tracecirclebackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	 private Long userId;

	 private String userEmail;

	 private String userPassword; 

}
