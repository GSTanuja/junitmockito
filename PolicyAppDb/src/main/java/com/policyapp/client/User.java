package com.policyapp.client;

import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {
		IPolicyService policyservice=new PolicyServiceImpl();
		//policyservice.getAll().forEach(System.out::println);
		Policy policy=new Policy("jeevanLab",1002,3000,"Health",20,"family","LIC","Adult", 200000);
		policyservice.addPolicy(policy);
		policyservice.deletePolicy(2);
		policyservice.getAll().forEach(System.out::println);

	}


}
