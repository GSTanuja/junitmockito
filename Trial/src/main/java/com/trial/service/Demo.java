package com.trial.service;

import java.util.List;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Delivery delivery=new Delivery();
		String msg=delivery.greetMessage("Priya");
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter food type");
		String type=scanner.next();
		List<String> foodList=delivery.showFood(type);
		System.out.println(foodList);
		
		
}
}