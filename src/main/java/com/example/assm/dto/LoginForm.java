package com.example.assm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
	private String userId;
	private String password;
	private boolean remember;
}
