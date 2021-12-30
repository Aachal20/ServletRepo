package com.nt.service;

import com.nt.beans.Employee;

public class PaySlipGeneratorService {
	
	public void generatePaySlip(Employee emp) {
		
		//Calculate grossSalary and netSalary
		float grossSalary = emp.getBasicSalary()+emp.getBasicSalary()*0.4f;
		float netSalary = grossSalary-(grossSalary*0.2f);
		
		//Send the generated gross,netSalary back to java bean class object
		emp.setGrossSalary(grossSalary);
		emp.setNetSalary(netSalary);
	}
}
