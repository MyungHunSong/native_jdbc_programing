package native_jdbc_programing.dto;

public class Employee {
	private int empNo;
	private String empName;
	private Title title; // 외래키의 참조 땜에 밑에거도 이럼
	private Employee manager;
	private int salary;
	private Department dept;


	public Employee(int empNo) {
		this.empNo = empNo;
	}

	public Employee(int empNo, String empName, Title title, Employee manager, int salary, Department dept) {
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dept = dept;
	}

	

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return String.format("Employee  %s %s %s %s %s %s %s", empNo,
				empName, title.gettNo(),manager.getEmpName() ,manager.getEmpNo(), salary, dept); // 깔금
	}

}
