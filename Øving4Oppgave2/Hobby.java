package Øving4Oppgave2;

import java.util.Objects;

public class Hobby {
	private String hobbynavn;
	
	public Hobby(String hobby) {
		hobbynavn = hobby;
	}
	
	public String getHobbynavn() {
		return hobbynavn;
	}

	public void setHobbynavn(String hobbynavn) {
		this.hobbynavn = hobbynavn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hobbynavn);
	}

	@Override
	public boolean equals(Object hobby2) {
		if (this == hobby2) 
			return true;
		if (hobby2 == null) 
			return false;
		if (getClass() != hobby2.getClass())
			return false;
		Hobby andre = (Hobby) hobby2;
		return hobbynavn.equals(andre.getHobbynavn());
	}

	public String toString() {
		return "<"+getHobbynavn()+", "+getHobbynavn()+">";
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
