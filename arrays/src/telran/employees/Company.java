package telran.employees;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import telran.util.Arrays;

public class Company implements Iterable<Employee>{
	private Employee[] employees;
	public void addEmployee(Employee empl) {
//		TODO adds new Employee to array of employees
//		if an employee with id 	equaled to id of empl exists, then to throw illegalStateException
	    for (Employee emp : employees) {
	        if (emp.getId() == empl.getId()) {
	            throw new IllegalStateException("Employee with ID " + empl.getId() + " already exists.");
	        }
	    }
	    employees = Arrays.add(employees, empl);
	}
	public Employee getEmployee(long id) {
//		TODO data about an employee with given id
//		if the company does not have such employee, then returns null
	    for (Employee emp : employees) {
	        if (emp.getId() == id) {
	            return emp;
	        }
	    }
	    return null;
	}
	public Employee removeEmployee(long id) {
//		TODO removes from company an employee with a given id
//		if such employee does not exist, throw noSuchElementException
//		returns reference to being removed employee
	    int indexToRemove = -1;
	    for (int i = 0; i < employees.length; i++) {
	        if (employees[i].getId() == id) {
	            indexToRemove = i;
	            break;
	        }
	    }

	    if (indexToRemove == -1) {
	        throw new NoSuchElementException("No employee found with ID " + id);
	    }

	    Employee[] newEmployees = new Employee[employees.length - 1];
	    for (int i = 0; i < indexToRemove; i++) {
	        newEmployees[i] = employees[i];
	    }
	    for (int i = indexToRemove + 1; i < employees.length; i++) {
	        newEmployees[i - 1] = employees[i];
	    }

	    Employee removed = employees[indexToRemove];
	    employees = newEmployees;
	    return removed;
	}
	public int getDepartmentBudget(String department) {
//		TODO returns sum of basic salary values for all employees of a given department
//		if employees of a given department does not exist, returns 0;
//	    int total = 0;
//	    for (Employee emp : employees) {
//	        if (emp.getDepartment().equals(department)) {
//	            total += emp.getBasicSalary();
//	        }
//	    }
//	    return total;
	    int total = 0;
	    for (Employee emp : employees) {
	        if (Objects.equals(emp.getDepartment(), department)) {
	            total += emp.getBasicSalary();
	        }
	    }
	    return total;
	}
	public Company(Employee[] employees) {
		this.employees = Arrays.copy(employees);
	}
	@Override
	public Iterator<Employee> iterator() {
		return new CompanyIterator();
	}
	private class CompanyIterator implements Iterator<Employee>{
//		TODO
//		iterating all employees in the ascending order of the ID values 
	    private int currentIndex = 0;
	    private Employee[] sortedEmployees;

	    public CompanyIterator() {
	        sortedEmployees = Arrays.copy(employees);
	        Arrays.bubbleSort(sortedEmployees, (e1, e2) -> e1.compareTo(e2));
	    }

	    @Override
	    public boolean hasNext() {
	        return currentIndex < sortedEmployees.length;
	    }

	    @Override
	    public Employee next() {
	        if (!hasNext()) {
	            throw new NoSuchElementException();
	        }
	        return sortedEmployees[currentIndex++];
	    }
}
}
