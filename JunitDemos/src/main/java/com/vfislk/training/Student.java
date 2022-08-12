package com.vfislk.training;

import com.vfislk.exception.InvaliedNumberException;
import com.vfislk.exception.NegativeValueException;

public class Student {

	public int calcTotal(int m1,int m2,int m3) throws NegativeValueException, InvaliedNumberException {
		if(m1<0||m2<0||m3<0) {
			throw new NegativeValueException("marks should me greater than zero");
		}

		if(m1>100||m2>100||m3>100) {
			throw new InvaliedNumberException("marks should me less than or equal to 100");
		}

		return (m1+m2+m3);

	}
	public String getGrade(int[] marks) throws InvaliedNumberException {
		int sum=0;
		String grade=null;
		if(marks==null)
			return null;
		for (int mark : marks) {
			if(mark<0 || mark>100)
				throw new InvaliedNumberException();
			sum+=mark;
		}
		
		int Avg=sum/marks.length;

		if(Avg>=90) {
			grade="A";
		}
		if(Avg>=80 && Avg<90) {
			grade="B";
		}
		if(Avg>=70 && Avg<80) {
			grade="C";
		}
		if(Avg >=60 && Avg<70) {
			grade="D";
		}
		if(Avg>=50 && Avg<60) {
			grade="E";
		}
		if(Avg<50) {
			grade="Fail";
		}
		return grade;

	}
}
