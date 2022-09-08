package mobileCompany;

public class Phone {
	private long number;

	public Phone(long number) {
		super();
		this.number = number;
	}

	public Phone() {
		super();
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public void incomingCall(long incomingNumber) {
		if (number == incomingNumber) {
			System.out.println("You can't call to yourself!");
			System.out.println();
		} else {
			System.out.println("Abonent " + number + " has incoming call from number: " + incomingNumber);
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "Phone []";
	}

}
