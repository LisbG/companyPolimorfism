package entities;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private String name;
	private List<Employee> employes = new ArrayList<Employee>();

	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StringBuilder getAllEmployes() {
		StringBuilder auxEmployes = new StringBuilder();

		for (Employee emp : employes) {
			auxEmployes.append(emp.toString() + "\n\n");
		}
		return auxEmployes;
	}
	
	public List<Employee> getEmployes(){
		return employes;
	}

	public void addEmployee(Employee employee) {
		employes.add(employee);
	}
	
	public void addOutsourcedEmployee(OutSourcedEmployee employee) {
		employes.add(employee);
	}
	
	public int getEmployesQuantity() {
		return employes.size();
	}
	
	public Boolean checkEmploye(String employeName) {
		
		for (Employee emp : employes) {
			if (emp.getName().equals(employeName)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Company name: " + this.getName()
				+ "\nEmployes quantity: " + this.getEmployesQuantity();
	}

}
