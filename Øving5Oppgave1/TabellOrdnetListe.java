package Øving5Oppgave1;

import javax.lang.model.element.Element;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.kjedet.LinearNode;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("tom liste");

		if (foerste() == siste()) {
			T siste = null;
		}
		int i = 0;
		while (i < bak) {
			i++;

		}
		liste[i] = null;
		T siste = liste[i];

		return siste;
	}

	@Override
	public T fjernFoerste() {
		if (foerste() == null) {
			throw new EmptyCollectionException("tom liste");
		}
		T resultat = foerste();
		return resultat = null;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {

		if (erTom())
			throw new EmptyCollectionException("tom liste");

		int i = 0;
		while (i < bak) {
			i++;
		}
		T siste = liste[i];

		return siste;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {

		if (foerste() == null) {
			utvid();
		}

		int i = 0;
		while (i < bak && element.compareTo(liste[i]) > 0) {
			i++;
		}
		int j = bak;
		while (j > i) {
			liste[j] = liste[j - 1];
			j--;
		}
		liste[i] = element;

	}

	@Override
	public boolean inneholder(T element) {

		int i = 0;
		while (i < bak && liste[i] != element) {
			i++;
			if (liste[i] == element) {
				return true;
			}
		}
		return false;
	}

	@Override
	public T fjern(T element) {
		
		if (erTom())
			throw new EmptyCollectionException("tom liste");

		T svar = null;
		
		for (int i = 0;i < bak; i++) {
			if (liste[i].equals(element)) {
				svar = liste[i];
				liste[i] = liste[bak - 1];
				bak--;
			}
		}
		return svar;
	}


	// finner indeksen/plassen til hvor elementet ligger i listen
	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;

		while (i < bak && liste[i] != el) {
			i++;
			if (liste[i] == el) {
				resultat = i;

			}
		}
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
