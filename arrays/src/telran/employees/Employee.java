package telran.employees;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
	private long id;
	private int basicSalary;
	private String department;
	
	public Employee(long id, int basicSalary, String department) {
		this.id = id;
		this.basicSalary = basicSalary;
		this.department = department;
	}
	@Override
	public int compareTo(Employee o) {
	// TODO Auto-generated method stub
//	Comparing according to id
	    return Long.compare(this.id, o.id);
	}
	public long getId() {
		return id;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public String getDepartment() {
	return department;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}
	
}
