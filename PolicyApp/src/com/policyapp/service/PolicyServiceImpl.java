package com.policyapp.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl implements IPolicyService {

	IPolicyDAO policyDAO=new PolicyDAOImpl();

	@Override
	public List<Policy> getAll() {
		List<Policy> policies=policyDAO.findAll();
		List<Policy> policyList=policies
				.stream()
				.sorted((Policy p1,Policy p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		return policyList;
	}
	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		System.out.println();
		System.out.println("policies by type");
		List<Policy> policies=policyDAO.findByType(type);
		List<Policy> PolicyList=policies
				.stream()
				.sorted((Policy p1,Policy p2)->p1.getType().compareTo(p2.getType()))
				.collect(Collectors.toList());

		if(PolicyList != null){
			return PolicyList;
		}
		throw new PolicyNotFoundException ("policy not found");
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		System.out.println("");
		System.out.println("policies by category");
		List<Policy> policies=policyDAO.findByCategory(category);
		List<Policy> PolicyList=policies
				.stream()
				.sorted((Policy p1,Policy p2)->p1.getCategory().compareTo(p2.getCategory()))
				.collect(Collectors.toList());

		if(PolicyList != null){
			return PolicyList;
		}
		throw new PolicyNotFoundException ("policy not found");
	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		System.out.println();
		System.out.println("policies by sumAssured");
		List<Policy> policies=policyDAO.findByHighSumAssured(sumAssured);
		List<Policy> PolicyList=policies
				.stream()
				.sorted((Policy p1,Policy p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());

		if(PolicyList.isEmpty()){
			throw new PolicyNotFoundException ("policy not found");
		}
		return PolicyList;
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		System.out.println();
		System.out.println("policies by coverage");
		List<Policy> policies=policyDAO.findByCoverage(coverage);
		List<Policy> PolicyList=policies
				.stream()
				.sorted((Policy p1,Policy p2)->p1.getCoverage().compareTo(p2.getCoverage()))
				.collect(Collectors.toList());

		if(PolicyList==null){
			throw new PolicyNotFoundException ("policy not found");
		}
		return PolicyList;
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {
		System.out.println();
		System.out.println("policies by premium");
		List<Policy> policies=policyDAO.findByLessPremium(premium);
		List<Policy> PolicyList=policies
				.stream()
				.collect(Collectors.toList());
		if(policies.isEmpty()){
			throw new PolicyNotFoundException ("sorry policy not found");
		}
		return PolicyList;
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy policy=policyDAO.findById(policyId);
		if(policy==null) {
			throw new IdNotFoundException ("sorry policy Id is not found");
		}
		return policy;
	}
}
