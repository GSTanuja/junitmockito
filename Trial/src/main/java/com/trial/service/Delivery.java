package com.trial.service;

import java.util.Arrays;
import java.util.List;

public class Delivery {

	public List<String> showFood(String type) {
		if(type.equals("Chinese")) {
			return Arrays.asList("Noodles","French fries");
		}
		if(type.equals("South")) {
			return Arrays.asList("Dosa","Idli");

		}
		else {
			return Arrays.asList("Pani puri","maggie");
		}
	}
	
	public String greetMessage(String name) {
		System.out.println("printing");
		return "Great Day"+name;
		
	}
}