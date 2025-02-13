package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Employee;
import entities.OutSourcedEmployee;
import entities.SystemOptions;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Company> companies = new ArrayList<Company>();

		int option;

		do {
			System.out.println(SystemOptions.mainOptions());

			System.out.print("Option: ");
			option = sc.nextInt();

			switch (option) {

			case 1:
				String companyName;

				System.out.print("Company name: ");
				companyName = sc.next();

				companies.add(new Company(companyName));

				System.out.println("Company created!\n");
				break;
			case 2:
				System.out.println(getCompanies(companies));
				break;
			case 3:
				System.out.print("Company name: ");
				companyName = sc.next();

				if (checkCompany(companies, companyName)) {

					for (Company comp : companies) {
						if (comp.getName().equals(companyName)) {

							int companyOptions;

							do {
								System.out.println(SystemOptions.companyOptions());
								System.out.print("Option: ");
								companyOptions = sc.nextInt();

								switch (companyOptions) {

								case 1:
									String employeeName;
									char outSourced;
									Integer employeeHours;
									double employeValuePerHour;

									System.out.print("Employee name: ");
									employeeName = sc.next();

									System.out.print("Hours: ");
									employeeHours = sc.nextInt();

									System.out.print("Value per hour: ");
									employeValuePerHour = sc.nextDouble();

									System.out.print("Outsourced Employee? (Y/N): ");
									outSourced = sc.next().charAt(0);

									switch (outSourced) {

									case 'Y':
										Double additionalCharge;

										System.out.print("Aditional charge: ");
										additionalCharge = sc.nextDouble();

										comp.addOutsourcedEmployee(new OutSourcedEmployee(employeeName, employeeHours,
												employeValuePerHour, additionalCharge));
										break;
									case 'N':
										comp.addEmployee(
												new Employee(employeeName, employeeHours, employeValuePerHour));
										break;
									default:
										System.out.println("Invalid option!");
										break;
									}

									System.out.println("Employee added!\n\n");
									break;

								case 2:

									System.out.println(comp.getAllEmployes());
									break;

								case 3:

									System.out.print("Employee name: ");
									employeeName = sc.next();

									if (comp.checkEmploye(employeeName)) {

										for (Employee emp : comp.getEmployes()) {
											if (emp.getName().equals(employeeName)) {

												int employeeOption;
												do {
													System.out.println(SystemOptions.EmployeeOptions());
													System.out.print("Option: ");
													employeeOption = sc.nextInt();

													switch (employeeOption) {
													case 1:
														String newEmployeeName;
														System.out.print("New employee name: ");
														newEmployeeName = sc.next();
														emp.setName(newEmployeeName);

														System.out.println("Emplayee name changed!");

														break;
													case 2:
														Integer newEmployeeHours;
														System.out.print("New employee name: ");
														newEmployeeHours = sc.nextInt();
														emp.setHours(newEmployeeHours);

														System.out.println("Emplayee hours changed!");

														break;
													case 3:
														double newEmployeeValuePerHour;
														System.out.print("New employee name: ");
														newEmployeeValuePerHour = sc.nextDouble();
														emp.setValuePerHours(newEmployeeValuePerHour);

														System.out.println("Emplayee value per hour changed!");
														break;
													case 4:
														System.out.println("Employee payment: " + emp.getPayment());
														break;
													case 0:
														break;
													default:
														System.out.println("Please, go for a valid option!");
														break;
													}

												} while (employeeOption != 0);
											}
										}

									} else {
										System.out.println("Employee not finded!");
									}
									break;

								case 0:
									break;

								default:
									System.out.println("Please, go for a valid option!");
									break;

								}
							} while (companyOptions != 0);
						}
					}
				} else {
					System.out.println("Company not finded!");
				}

				break;
			case 0:
				break;
			default:
				System.out.println("Please, go for a valid option!");
				break;
			}

		} while (option != 0);

		sc.close();
	}

	public static StringBuilder getCompanies(List<Company> companies) {
		StringBuilder auxCompanies = new StringBuilder();

		for (Company comp : companies) {
			auxCompanies.append(comp.toString() + "\n\n");
		}

		return auxCompanies;
	}

	public static Boolean checkCompany(List<Company> companies, String companyName) {

		for (Company comp : companies) {
			if (comp.getName().equals(companyName)) {
				return true;
			}
		}
		return false;
	}

}
