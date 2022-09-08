package mobileCompany;

import java.util.Arrays;

public class Network {

	private long[] dataBase = new long[1];
	private int i = 0;

	public Network(long[] dataBase) {
		super();
		this.dataBase = dataBase;
	}

	public Network() {
		super();
	}

	public long[] getdataBase() {
		return dataBase;
	}

	public void setdataBase(long[] dataBase) {
		this.dataBase = dataBase;
	}

	public long[] registration(long number) {

		if (checkNumber(number)) {
			System.out.println("This phone number already in the system");
			System.out.println();
		} else {
			dataBase = Arrays.copyOf(dataBase, i + 1);
			dataBase[i] = number;
			i++;
			System.out.println("Phone number " + number + " successfully registered in the system");
			System.out.println();
		}

		return dataBase;

	}

	public boolean checkNumber(long number) {
		boolean result = false;
		for (int i = 0; i < dataBase.length; i++) {
			if (number == dataBase[i]) {
				result = true;
				break;
			}
		}

		return result;
	}

	@Override
	public String toString() {
		return "Network []";
	}

}
