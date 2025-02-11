package entities;

public class SystemOptions {
	
	public static String mainOptions() {
		return "1 - Add company"
				+ "\n2 - Check companies"
				+ "\n3 - Manage company"
				+ "\n0 - Exit";
	}
	
	public static String companyOptions() {
		return "1 - Add employee"
				+ "\n2 - Check employes"
				+ "\n3 - Manage employee"
				+ "\n0 - Exit";
	}
	
	public static String EmployeeOptions() {
		return "1 - Change name "
				+ "\n2 - Change hours"
				+ "\n3 - Change value per hour"
				+ "\n4 - Get payment"
				+ "\n0 - Exit";
	}

}
