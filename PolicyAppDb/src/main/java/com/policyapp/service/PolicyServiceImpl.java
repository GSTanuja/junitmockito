package com.policyapp.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl implements IPolicyService {

		IPolicyDAO policyDao=new  PolicyDAOImpl();
		@Override
		public void addPolicy(Policy policy) {
			policyDao.addPolicy(policy);			
		}

		@Override
		public void deletePolicy(int policyId) {
			policyDao.deletePolicy(policyId);
			
		}

		@Override
		public void updatePolicy(int policyId, String Coverage) {
			policyDao.updatePolicy(policyId, Coverage);
			
		}
					
	@Override
	public List<Policy> getAll() {
		List<Policy> policies=policyDao.findAll();
		if(policies!=null) {
			return policies.stream().sorted((Policy p1,Policy p2)->p1.getType().compareTo(p2.getType())).collect(Collectors.toList());
		}
		return policies;
	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		List<Policy>policies= policyDao.findByType(type).stream()
				.sorted((p1,p2)->p1.getType().compareTo(p2.getType())).collect(Collectors.toList());
		if(policies.isEmpty())
			throw new PolicyNotFoundException();
		return policies;
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		List<Policy>policies= policyDao.findByCategory(category).stream()
				.sorted((p1,p2)->p1.getCategory().compareTo(p2.getCategory())).collect(Collectors.toList());
		if(policies.isEmpty())
			throw new PolicyNotFoundException();
		return policies;
	}
		

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy> policies= policyDao.findByHighSumAssured(sumAssured);
		
		
		if(policies.isEmpty())
			throw new PolicyNotFoundException();
		return policies.stream().sorted((Policy p1,Policy p2)->p1.getType().compareTo(p2.getType())).collect(Collectors.toList());
	}
	

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy>policies= policyDao.findByCoverage(coverage).stream()
				.sorted((p1,p2)->p1.getCoverage().compareTo(p2.getCoverage())).collect(Collectors.toList());
		if(policies.isEmpty())
			throw new PolicyNotFoundException();
		return policies;
	
		
	}

	@Override
	public List<Policy> getByBrand(String brand) throws PolicyNotFoundException {
		List<Policy>policies= policyDao.findByBrand(brand).stream()
				.sorted((p1,p2)->p1.getBrand().compareTo(p2.getBrand())).collect(Collectors.toList());
		if(policies.isEmpty())
			throw new PolicyNotFoundException();
		return policies;
	
		
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {
		List<Policy>policies= policyDao.findByLessPremium(premium);
				
		if(policies.isEmpty())
			throw new PolicyNotFoundException();
		return policies.stream().sorted((Policy p1,Policy p2)->p1.getType().compareTo(p2.getType())).collect(Collectors.toList());
	}
		
	

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy policy=new Policy();
		policy.getPolicyNumber();
		if(policy!=null){
			policy.getPolicyNumber();
		
		}
		return null;
	}
}