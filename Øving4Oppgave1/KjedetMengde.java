package Øving4Oppgave1;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext()) {
			this.leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		int valg = rand.nextInt(antall) + 1;
		if (valg == 1) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			forgjenger = start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		antall--;

		return resultat;

	}//

	@Override
	public T fjern(T element) { // Denne skal vi se p� litt senere

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (start.getElement().equals(element)) {// Sletter foran
			resultat = start.getElement();
			start = start.getNeste();
			antall--;
		} else {// Gjennomg�r den kjedete strukturen
			forgjenger = start;
			aktuell = start.getNeste();
			for (int sok = 2; sok <= antall && !funnet; sok++) {
				if (aktuell.getElement().equals(element))
					funnet = true;
				else {
					forgjenger = aktuell;
					aktuell = aktuell.getNeste();
				}
			}
			if (funnet) {
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste()); // Slette midt inni/bak
				antall--;
			}
		}
		return resultat;

	}//

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}
	/*
	 * N�r vi overkj�rer (override) equals- meteoden er det anbefalt at vi ogs�
	 * overkj�rer hashcode-metoden da en del biblioteker bruker hascode sammen med
	 * equals. Vi kommer tilbake til forklaring og bruk av hashcode senere i faget.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object ny) {
		
		if (this == ny) {
			return true;
		}
		
		if (ny == null || this.getClass() != ny.getClass()) {
			return false;
		}
			
		boolean likeMengder = true;
			
		// Gjør ny om til en MengdeADT av typen T og sjekker om antall elementer i "ny" og "this" er like
		MengdeADT<T> m2 = (KjedetMengde<T>) ny;
		if (this.antall != m2.antall()) {
			likeMengder = false;
		} else {
		
			// lager iterator for å gjennomgå elementene i mengdene
			Iterator<T> teller1 = this.iterator();
			Iterator<T> teller2 = m2.iterator();

			//itererer gjennom elementene i mengdene så lenge de har elementer og disse er like
			while (teller1.hasNext() && teller2.hasNext()) {
				T element1 = teller1.next();
				T element2 = teller2.next();
				if (element1 != element2) {
					likeMengder = false;
				}
			}
			
		}
		return likeMengder;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	// For å gjøre koden mer effektiv kan vi bruke mer effektive metoder
	// som f.eks. leggTilAlle istedefor LeggTil
	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) { // Denne ersattes med en mer effektiv union, se kladdeoppgavenr3
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode aktuell = start;
		
		//legger inn elementer fra this-mengde til begge-mengde
		while (aktuell != null) {
			begge.leggTil((T) aktuell.getElement());
			aktuell = aktuell.getNeste();
		}
		//legger inn elemneter fra m2-mengde i begge-mengde
		Iterator<T> it = m2.iterator();
		T element = it.next();
		if(!begge.inneholder(element)) {
		begge.leggTil(element);	
	}
		
		return begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new KjedetMengde<T>();
		Iterator<T> it = m2.iterator();
		
		while (it.hasNext()) {
			T element = it.next();
			if(inneholder(element)) {
				snittM.leggTil(element);
			}
		}
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> diffM = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		
		//legger alle elementer(som ikke finnes i m2) fra this-mengde til diffM
		while (aktuell != null) {
			T element = aktuell.getElement();
			if (!m2.inneholder(element)) {
			diffM.leggTil(element);
		}
		aktuell = aktuell.getNeste();
	}
		return diffM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		
		Iterator<T> it = iterator();
		
		while (it.hasNext()) {
			T element = it.next();
			if(!m2.inneholder(element)) {
				erUnderMengde = false;
			}
			
			}
		
		return erUnderMengde;
	}

	@Override
	public String toString() {
		return "KjedetMengde [antall=" + antall + ", start=" + start + "]";
	}

	@Override
	public Iterator<T> iterator() {
		return new KjedetIterator<T>(start);
	}

	private void settInn(T element) { // Hjelpemetode
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	public static void main(String[] args) {
		
		
		

	}

}// class
