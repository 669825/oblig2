package Øving4Oppgave2;

import java.util.Objects;

public class Medlem {

	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;

//… Konstruktør
	public Medlem(String navn, MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndeks = -1;

	}
	
	public boolean passerTil(Medlem Medlem2) {
		return this.hobbyer.equals(Medlem2.getHobbyer());	
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(navn, statusIndeks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medlem other = (Medlem) obj;
		return Objects.equals(navn, other.navn) && statusIndeks == other.statusIndeks;
	}

	@Override
	public String toString() {
		return "Medlem [navn=" + navn + ", hobbyer=" + hobbyer + ", statusIndeks=" + statusIndeks + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
