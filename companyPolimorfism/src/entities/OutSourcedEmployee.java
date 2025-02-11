package entities;

public class OutSourcedEmployee extends Employee {

	private Double additionalCharge;

	public OutSourcedEmployee() {
	}

	public OutSourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}

	public Double getAdditionalCharge() {
		return additionalCharge;
	}

	public void setAdditionalCharge(Double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}
	
	@Override
	public double getPayment() {
		return super.getPayment() + (additionalCharge * 1.1);
	}
}
