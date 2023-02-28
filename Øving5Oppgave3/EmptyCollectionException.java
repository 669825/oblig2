package Øving5Oppgave3;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen n�r samlingen er tom
//********************************************************************
public class EmptyCollectionException extends RuntimeException {
	/******************************************************************
	 * Setter opp et unntak med passende melding.
	 ******************************************************************/
	public EmptyCollectionException(String samling) {
		super("" + samling + " er tom.");
	}
}
