package org.kpsc.docgen.dto;

public class Employee {
	
	int empNumber;
	String empName;
	double salary;
	String deptNum;
	
	
	public Employee() {
		
	}

	public Employee(int empNumber, String empName, double salary, String deptNum) {
		super();
		this.empNumber = empNumber;
		this.empName = empName;
		this.salary = salary;
		this.deptNum = deptNum;
	}
	
	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}

	@Override
	public String toString() {
		return "Employee [empNumber=" + empNumber + ", empName=" + empName + ", salary=" + salary + ", deptNum="
				+ deptNum + "]";
	}
	
	
}
