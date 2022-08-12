package com.policyapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.util.DbConnection;

public class PolicyDAOImpl implements IPolicyDAO {

	@Override
	public void addPolicy(Policy policy) {


		String sql="insert into policy(policy_name, premium,  type, duration, coverage, category, brand, sum_assured)values(?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement=null;
		Connection connection=DbConnection.openConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,policy.getPolicyName());
			preparedStatement.setDouble(2,policy.getPremium());
			preparedStatement.setString(3,policy.getType());
			preparedStatement.setInt(4,policy.getDuration());
			preparedStatement.setString(5,policy.getCoverage());
			preparedStatement.setString(6,policy.getBrand());
			preparedStatement.setString(7,policy.getCategory());
			preparedStatement.setDouble(8,policy.getSumAssured());
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				DbConnection.closeConnection();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deletePolicy(int policyId) {

		String sql="delete from policy where policy_id="+policyId;
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbConnection.closeConnection();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
	@Override
	public void updatePolicy(int policyId, String Coverage) {
		String sql="update policy set Coverage=? where  policy_id=?";
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,Coverage);
			preparedStatement.setInt(2, policyId);

			preparedStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbConnection.closeConnection();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public List<Policy> findAll() {
		List<Policy> policies=new ArrayList<Policy>();
		String sql="select * from Policy";
		Connection connection=DbConnection.openConnection();
		ResultSet resultset=null;
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				Policy policy=new Policy();

				String policyName=resultset.getString("policy_name");
				Integer policyNumber=resultset.getInt("policy_id");
				double premium=resultset.getInt("premium");
				String type=resultset.getString("type");
				int duration=resultset.getInt("duration");
				String coverage=resultset.getString("coverage");
				String category=resultset.getString("category");
				String brand=resultset.getString("brand");
				double SumAssured=resultset.getDouble("sum_assured");

				policy.setPolicyName(policyName);
				policy.setPolicyNumber(policyNumber);
				policy.setPremium(premium);
				policy.setType(type);
				policy.setDuration(duration);
				policy.setCoverage(coverage);
				policy.setBrand(brand);
				policy.setSumAssured(SumAssured);

				policies.add(policy);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbConnection.closeConnection();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return policies;
	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		List<Policy> policies=new ArrayList<Policy>();
		String sql="select * from Policy where type=?";
		Connection connection=DbConnection.openConnection();
		ResultSet resultset=null;
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,type);
			resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				Policy policy=new Policy();
				String policyName=resultset.getString("policy_name");
				Integer policyNumber=resultset.getInt(" policy_id");
				double premium=resultset.getInt("premium");
				String types=resultset.getString("type");
				int duration=resultset.getInt("duration");
				String coverage=resultset.getString("coverage");
				String category=resultset.getString("category");
				String brand=resultset.getString("brand");
				double SumAssured=resultset.getDouble("sum_assured");

				policy.setPolicyName(policyName);
				policy.setPolicyNumber(policyNumber);
				policy.setPremium(premium);
				policy.setType(type);
				policy.setDuration(duration);
				policy.setCoverage(coverage);
				policy.setBrand(brand);
				policy.setSumAssured(SumAssured);
		
				
			}
		}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						DbConnection.closeConnection();
						if(preparedStatement!=null)
							preparedStatement.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}

		return policies.stream().filter((c)->c.getType().equals(type)).collect(Collectors.toList());
			}
		
		@Override
		public List<Policy> findByCategory(String category) throws PolicyNotFoundException {
			List<Policy> policies=new ArrayList<Policy>();
			String sql="select * from Policy where category=?";
			Connection connection=DbConnection.openConnection();
			ResultSet resultset=null;
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1,category);
				resultset=preparedStatement.executeQuery();
				while(resultset.next()) {
					Policy policy=new Policy();
					String policyName=resultset.getString("policyName");
					Integer policyNumber=resultset.getInt("policyId");
					double premium=resultset.getInt("premium");
					String types=resultset.getString("type");
					int duration=resultset.getInt("duration");
					String coverage=resultset.getString("coverage");
					String mcategory=resultset.getString("category");
					String brand=resultset.getString("brand");
					double SumAssured=resultset.getDouble("sumAssured");

					policy.setPolicyName(policyName);
					policy.setPolicyNumber(policyNumber);
					policy.setPremium(premium);
					policy.setType(category);
					policy.setDuration(duration);
					policy.setCoverage(coverage);
					policy.setBrand(brand);
					policy.setSumAssured(SumAssured);

					policies.add(policy);
				}
			}catch (SQLException e) {
						e.printStackTrace();
					}finally {
						try {
							DbConnection.closeConnection();
							if(preparedStatement!=null)
								preparedStatement.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}

			return policies.stream().filter((c)->c.getCategory().equals(category)).collect(Collectors.toList());
				}
								
		@Override
		public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
			List<Policy> policies=new ArrayList<Policy>();
			String sql="select * from Policy where sum_assured>?";
			Connection connection=DbConnection.openConnection();
			ResultSet resultset=null;
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setDouble(1,sumAssured);
				resultset=preparedStatement.executeQuery();
				while(resultset.next()) {
					Policy policy=new Policy();
					String policyName=resultset.getString("policyName");
					Integer policyNumber=resultset.getInt("policyId");
					double premium=resultset.getInt("premium");
					String mtypes=resultset.getString("type");
					int duration=resultset.getInt("duration");
					String coverage=resultset.getString("coverage");
					String category=resultset.getString("category");
					String brand=resultset.getString("brand");
					double SumAssured=resultset.getDouble("sumAssured");

					policy.setPolicyName(policyName);
					policy.setPolicyNumber(policyNumber);
					policy.setPremium(premium);
					policy.setType(category);
					policy.setDuration(duration);
					policy.setCoverage(coverage);
					policy.setBrand(brand);
					policy.setSumAssured(SumAssured);

					policies.add(policy);
				}
			}catch (SQLException e) {
						e.printStackTrace();
					}finally {
						try {
							DbConnection.closeConnection();
							if(preparedStatement!=null)
								preparedStatement.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}

			return policies;
				}
							
								@Override
		public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {
			List<Policy> policies=new ArrayList<Policy>();
			String sql="select * from Policy where coverage=?";
			Connection connection=DbConnection.openConnection();
			ResultSet resultset=null;
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1,coverage);
				resultset=preparedStatement.executeQuery();
				while(resultset.next()) {
					Policy policy=new Policy();
					String policyName=resultset.getString("policyName");
					Integer policyNumber=resultset.getInt("policyId");
					double premium=resultset.getInt("premium");
					String ntypes=resultset.getString("type");
					int duration=resultset.getInt("duration");
					String mcoverage=resultset.getString("coverage");
					String category=resultset.getString("category");
					String brand=resultset.getString("brand");
					double SumAssured=resultset.getDouble("sumAssured");

					policy.setPolicyName(policyName);
					policy.setPolicyNumber(policyNumber);
					policy.setPremium(premium);
					policy.setType(category);
					policy.setDuration(duration);
					policy.setCoverage(coverage);
					policy.setBrand(brand);
					policy.setSumAssured(SumAssured);

					policies.add(policy);
				}
			}catch (SQLException e) {
						e.printStackTrace();
					}finally {
						try {
							DbConnection.closeConnection();
							if(preparedStatement!=null)
								preparedStatement.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}

					return policies.stream().filter((c)->c.getCoverage().equals(coverage)).collect(Collectors.toList());
		}	
						
			
		@Override
		public List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException {
			List<Policy> policies=new ArrayList<Policy>();
			String sql="select * from Policy where premium<?";
			Connection connection=DbConnection.openConnection();
			ResultSet resultset=null;
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setDouble(1,premium);
				resultset=preparedStatement.executeQuery();
				while(resultset.next()) {
					Policy policy=new Policy();
					String policyName=resultset.getString("policyName");
					Integer policyNumber=resultset.getInt("policyId");
					double mpremium=resultset.getInt("premium");
					String mtypes=resultset.getString("type");
					int duration=resultset.getInt("duration");
					String coverage=resultset.getString("coverage");
					String category=resultset.getString("category");
					String brand=resultset.getString("brand");
					double SumAssured=resultset.getDouble("sumAssured");

					policy.setPolicyName(policyName);
					policy.setPolicyNumber(policyNumber);
					policy.setPremium(premium);
					policy.setType(category);
					policy.setDuration(duration);
					policy.setCoverage(coverage);
					policy.setBrand(brand);
					policy.setSumAssured(SumAssured);

					policies.add(policy);
				}
			}catch (SQLException e) {
						e.printStackTrace();
					}finally {
						try {
							DbConnection.closeConnection();
							if(preparedStatement!=null)
								preparedStatement.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}

					return policies;
		}	
			
						
		@Override
		public Policy findById(int policyId) throws IdNotFoundException {
			Policy policy=null;
			String sql="select * from Policy where policy_id=?";
			Connection connection=DbConnection.openConnection();
			ResultSet resultset=null;
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setInt(1,policyId);
				resultset=preparedStatement.executeQuery();
				while(resultset.next()) {
					String policyName=resultset.getString("policyName");
					Integer policyNumber=resultset.getInt("policyId");
					double mpremium=resultset.getInt("premium");
					String mtypes=resultset.getString("type");
					int duration=resultset.getInt("duration");
					String coverage=resultset.getString("coverage");
					String category=resultset.getString("category");
					String mbrand=resultset.getString("brand");
					double SumAssured=resultset.getDouble("sumAssured");

				     // policy= new Policy("policy_name", "premium",  "type", duration, "coverage", "category", "brand", SumAssured);

			
				}
			}catch (SQLException e) {
						e.printStackTrace();
					}finally {
						try {
							DbConnection.closeConnection();
							if(preparedStatement!=null)
								preparedStatement.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}

					return policy;
		
					
			
		}

		@Override
		public List<Policy> findByBrand(String brand) throws PolicyNotFoundException {
			List<Policy> policies=new ArrayList<Policy>();
			String sql="select * from Policy where brand=?";
			Connection connection=DbConnection.openConnection();
			ResultSet resultset=null;
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1,brand);
				resultset=preparedStatement.executeQuery();
				while(resultset.next()) {
					Policy policy=new Policy();
					String policyName=resultset.getString("policyName");
					Integer policyNumber=resultset.getInt("policyId");
					double mpremium=resultset.getInt("premium");
					String mtypes=resultset.getString("type");
					int duration=resultset.getInt("duration");
					String coverage=resultset.getString("coverage");
					String category=resultset.getString("category");
					String mbrand=resultset.getString("brand");
					double SumAssured=resultset.getDouble("sumAssured");

					policy.setPolicyName(policyName);
					policy.setPolicyNumber(policyNumber);
					policy.setPremium(mpremium);
					policy.setType(category);
					policy.setDuration(duration);
					policy.setCoverage(coverage);
					policy.setBrand(brand);
					policy.setSumAssured(SumAssured);

					policies.add(policy);
				}
			}catch (SQLException e) {
						e.printStackTrace();
					}finally {
						try {
							DbConnection.closeConnection();
							if(preparedStatement!=null)
								preparedStatement.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}

			return policies.stream().filter((c)->c.getBrand().equals(brand)).collect(Collectors.toList());
		}	
					
	}
