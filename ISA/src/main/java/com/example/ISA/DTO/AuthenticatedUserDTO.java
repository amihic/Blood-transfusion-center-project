package com.example.ISA.DTO;

import com.example.ISA.security.DTO.UserTokenState;

public class AuthenticatedUserDTO {
	 private int id;
	    private String role;
	    private String email;
	    private UserTokenState token;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public UserTokenState getToken() {
			return token;
		}
		public void setToken(UserTokenState token) {
			this.token = token;
		}
		public AuthenticatedUserDTO(int id, String role, String email, UserTokenState token) {
			super();
			this.id = id;
			this.role = role;
			this.email = email;
			this.token = token;
		}
		
		public AuthenticatedUserDTO() {}
	    
	    
}
