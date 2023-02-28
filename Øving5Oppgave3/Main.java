package Øving5Oppgave3;

public class Main {

	public static void main(String[] args) {
		// lager noen strenger, noen lovlige og noen ulovlige:
		
		ParentesSjekker p = new ParentesSjekker();
		
		String[] s = {"[()]","[{]}"};

		
		for(String q : s) {
		System.out.println(q+": " + " er balansert: " + p.erBalansert(q));
		}

		
		/*1. Symbolene danner ikke par. 
		2. Vi treffer et lukkesymbol og stabelen er tom. 
		3. Det er slutt på teksten og det er fremdeles minst ett symbol på stabelen
		*/

	}

}
