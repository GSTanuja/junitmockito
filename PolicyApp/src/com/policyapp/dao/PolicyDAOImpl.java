package com.policyapp.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyDAOImpl implements IPolicyDAO {

	@Override
	public List<Policy> findAll() {
		return showAllPolicies();
	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		return showAllPolicies().stream().filter(policy->policy.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCategory(String category) throws PolicyNotFoundException {
		return showAllPolicies().stream().filter(policy->policy.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());	
	}

	@Override
	public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {

		return showAllPolicies().stream().filter((policy)->policy.getSumAssured()>sumAssured).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {
		return showAllPolicies().stream().filter(policy->policy.getCoverage().equalsIgnoreCase(coverage)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException {
		return showAllPolicies().stream().filter((policy)->policy.getPremium()<premium).collect(Collectors.toList());
	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {
		Optional<Policy> policy=showAllPolicies().stream().filter((p)->p.getPolicyNumber()==(policyId)).findFirst();
		if(policy.isPresent()) {
			return policy.get();
		}
		return null;
	}
	private List<Policy> showAllPolicies(){
		return Arrays.asList(
				new Policy("jeevan saati",1001,2000,"term",10,"marriage","general",200000),
				new Policy("jeevan Anand",1002,3000,"endowment",40,"life ","life",500000),
				new Policy("Life saral",1003,1600,"pension",50,"retirement","general",200000),
				new Policy("Bajaj Allianz",1004,2000,"endowment",20,"accidents","motor",200000),
				new Policy("Tata Allianz",1005,2000,"term",30,"marriage","general",200000),
				new Policy("ClickToProtect",1006,2000,"single",60,"child","life",200000)
				);
	}

}
