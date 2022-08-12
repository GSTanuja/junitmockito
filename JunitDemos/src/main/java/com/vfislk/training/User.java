package com.vfislk.training;

import java.util.Arrays;
import java.util.List;

public class User {
	public String greet(String username) {
		return "Welcome" +username;
		
	}
	public List<String> showFruits(){
		return Arrays.asList("Strawberry","Mango","Grapes");
		
	}

}
