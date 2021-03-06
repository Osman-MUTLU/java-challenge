package com.kodgemisi.usermanagement;

/**
 * Represents a phone number, never stores a null value. If constructed with a null value stores an empty string.
 */
public class Phone implements CharSequence {

	private final String phoneNumber;

	public Phone(String phoneNumber) {
		if(phoneNumber == null || phoneNumber.equals("")){
			throw new IllegalArgumentException("Phone number is not null!");
		}
		else if( phoneNumber.equals("")){
			throw new IllegalArgumentException("Phone number is not empty!");
		}
		else if(!(phoneNumber.equals("911")|| phoneNumber.equals("112"))){
			if(phoneNumber.charAt(0) != '+'){
				throw new IllegalArgumentException("Phone number must be start with '+'.");
			}
			else if(phoneNumber.contains("+90")){
				if(phoneNumber.length() != 13){
					throw new IllegalArgumentException("Phone number size must be equal 13 when it starts with '+90'");
				}
			}
			else{
				if(phoneNumber.length() < 5){
					throw new IllegalArgumentException("Phone number size must be longer than 4");
				}
			}
		}
		
		this.phoneNumber = phoneNumber == null ? "" : phoneNumber;
		
	}

	public String number() {
		return phoneNumber;
	}

	@Override
	public int length() {
		return phoneNumber.length();
	}

	@Override
	public char charAt(int index) {
		return phoneNumber.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return phoneNumber.subSequence(start, end);
	}

	@Override
	public String toString() {
		return phoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Phone phone = (Phone) o;

		return phoneNumber.equals(phone.phoneNumber);
	}

	@Override
	public int hashCode() {
		return phoneNumber.hashCode();
	}
}
