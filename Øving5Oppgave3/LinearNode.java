package Øving5Oppgave3;

//************************************************************
///  Representerer en node.
//************************************************************

public class LinearNode{
  private LinearNode neste;
  private char element;
 
  /**********************************************************
    Oppretter en tom node
  **********************************************************/
  public LinearNode()  {
    neste   =  null;
    element = 0;
  }
 
  /**********************************************************
    Oppretter en node med et element.
  **********************************************************/
  public LinearNode (char elem) {
    neste   = null;
    element = elem;
  }
 
  /**********************************************************
    Returnerer etterf�lger.
  **********************************************************/
  public LinearNode getNeste()  {
    return neste;
  }
 
  /**********************************************************
    Setter neste til node
  **********************************************************/
  public void setNeste (LinearNode node)  {
    neste = node;
  }
 
  /**********************************************************
    Returnerer elementet til denne noden
  **********************************************************/
  public char getElement() {
    return element;
  }
 
  /**********************************************************
    Setter nytt element i denne noden.
  **********************************************************/
  public void setElement (char elem) {
    element = elem;
  }
}
