package com.policyapp.client;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {
		IPolicyService policyservice=new PolicyServiceImpl();
		policyservice.getAll().forEach(System.out::println);

		try {
			policyservice.getByType("single").forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			policyservice.getByCategory("motor").forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			policyservice.getByHighSumAssured(200000).forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			policyservice.getByCoverage("child").forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(policyservice.getById(1002));

		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}


}
