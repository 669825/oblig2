package Øving5Oppgave2;

//********************************************************************
//EmptyCollectionException.java   //
//Representerer situasjonen n�r samlingen er tom.
//********************************************************************

public class EmptyCollectionException extends RuntimeException{
 /**
	 * 
	 */
	
/******************************************************************
   Setter opp dette unntaket med passende melding.
 ******************************************************************/
 public EmptyCollectionException (String collection){
    super (" Denne " + collection + " er tom.");
 }
}