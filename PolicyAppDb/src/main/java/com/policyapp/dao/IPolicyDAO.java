package com.policyapp.dao;


import java.util.List;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.model.*;
public interface IPolicyDAO {
	

	void addPolicy(Policy policy);
	void deletePolicy(int policyId);
	void updatePolicy(int policyId,String Coverage);
	List<Policy> findAll();
	List<Policy> findByType(String type) throws PolicyNotFoundException;
	List<Policy> findByCategory(String category) throws PolicyNotFoundException;
	List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException;
	List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException;
	List<Policy> findByBrand(String brand) throws PolicyNotFoundException;
	List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException;

	Policy findById(int policyId) throws IdNotFoundException;

}
