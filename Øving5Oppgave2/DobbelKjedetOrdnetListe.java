package Øving5Oppgave2;

import java.util.Iterator;
import javax.swing.text.ElementIterator;

public class DobbelKjedetOrdnetListe<T extends Comparable<T>> implements DobbelKjedetOrdnetListeADT<T> {
	private DobbelNode<T> foerste;
	private DobbelNode<T> siste;
	private int antall;

	// lager konstruktør
	public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi) {
		// Opprett kunstige noder
		foerste = new DobbelNode<T>(null);
		siste = new DobbelNode<T>(null);
		// Kjede dem sammen
		foerste.setNeste(siste);
		siste.setForrige(foerste);
		//sette verdier til de kunstige nodene
		foerste.setElement(minVerdi);
		siste.setElement(maksVerdi);
		// initialiserer antall
		antall = 0;
	}

	@Override
	public void leggTil(T el) {
		DobbelNode<T> nyNode = new DobbelNode<T>(el);
		
		if(erTom()) {
			foerste = nyNode;
		} else {
			siste.setNeste(nyNode);
			siste = nyNode;
		}

	}

	@Override
	public T fjern(T el) {
		T resultat = null;
		if (erTom())
			throw new EmptyCollectionException("dobbelkjedet ordnet liste er tom");
		DobbelNode<T> aktuell = finn(el);
		if (aktuell != null) {// returner og slett
			resultat = aktuell.getElement();
			aktuell.getForrige().setNeste(aktuell.getNeste());
			aktuell.getNeste().setForrige(aktuell.getForrige());

		}

		return resultat;

	}

	/*
	 * Returnerer referansen til noden hvis el fins, ellers returneres
	 * null-referansen
	 */
	private DobbelNode<T> finn(T el) {

		DobbelNode<T> aktuell = foerste.getNeste();

		while (aktuell != siste) {
			if (aktuell.getElement().equals(el)) {
				return aktuell;
			}
			aktuell = aktuell.getNeste();
			}
		return aktuell;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	public String toString() {
		String resultat = "";
		DobbelNode<T> aktuell = foerste.getNeste();
		while (aktuell != siste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}

	public String tilStrengBaklengs() {
		String resultat = "";
		DobbelNode<T> aktuell = siste.getForrige();
		while (aktuell != foerste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getForrige();
		}

		return resultat;

	}

	public void visListe() {
		
		String resultat = "";
		DobbelNode<T> aktuell = foerste.getNeste();
	
		while (aktuell != siste) {
			
			System.out.print(aktuell.getElement());
			aktuell = aktuell.getNeste();
	}
		System.out.println();

}
}
