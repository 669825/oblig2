package Øving4Oppgave1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {

		if (m2) {

		}

		Iterator<T> teller = m2.iterator();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		tab[antall - 1] = null;
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {

		// S�ker etter og fjerner element. Returnerer null-ref ved ikke-funn

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		T svar = null;
		for (int i = 0; (i < antall && !funnet); i++) {
			if (tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall - 1];
				// tab[antall-1] = null;
				antall--;
				funnet = true;

			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	/*
	 * N�r vi overkj�rer (override) equals- meteoden er det anbefalt at vi ogs�
	 * overkj�rer hashcode-metoden da en del biblioterker brker hashcode sammen med
	 * equals. Vi kommer tilbake til forklaring og bruk av hashcode senere i faget.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + Arrays.deepHashCode(tab);
		return result;
	}

	@Override
	public boolean equals(Object m2) {
		
		if (this == m2) {
			return true;
		}
		//hvis ny er null eller ny ikke tilhører samme klasse som this: false
		if (m2 == null || this.getClass() != m2.getClass()) {
			return false;

		}
		boolean likeMengder = true;
		
		//gjør om til Tabellmengde type T, for å sjekke likhet mellom elementer i this og m2 mengde
		TabellMengde<T> tab = (TabellMengde<T>) m2;
		if (this.antall != tab.antall) {
			likeMengder = false;

			Iterator<T> it1 = this.iterator();
			Iterator<T> it2 = this.iterator();
			while (it1.hasNext() && it2.hasNext()) {
				T element1 = it1.next();
				T element2 = it2.next();
				if (element1 != element2) {
					likeMengder = false;
				}

			}
		}
	

	return likeMengder;

	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		/* en ny mengde som kombinerer de to mengdene, legger inn elementer fra
		this.mengde gjennom tabellen, løper så igjennnom m2 mengde ved hjelp
		av Iterator*/
		TabellMengde<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			begge.leggTil(this.tab[i]);
		}
		Iterator<T> teller = m2.iterator();

		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		/*Iterator<T> teller2 = begge.iterator();
		Fjerner deretter potensielle duplikater i mengden begge?
		while(teller2.hasNext()) {*/
			
		return (MengdeADT<T>) begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
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
		MengdeADT<T> differensM = new TabellMengde<T>();
		T element = null;

		Iterator it = m2.iterator();

		for (int i = 0; i < antall; i++) {
			element = it
			if (!inneholder()) {

			}
		}
		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;

		return false;
	}

	@Override
	public String toString() {
		return "TabellMengde [antall=" + antall + ", tab=" + Arrays.toString(tab) + "]";
	}

	@Override
	public Iterator<T> iterator() {
		return new TabellIterator<T>(tab, antall);
	}

	private void settInn(T element) {// hjelpemetode
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

}// class
