package Øving5Oppgave3;

public class ParentesSjekker implements ParentessjekkerADT {

	private KjedetStabel stabel;
	
	public ParentesSjekker() {
		stabel = new KjedetStabel();
	}
	

	
	
	@Override
	public boolean erVenstreparentes(char p) {
		return (p == '(' || p == '[' || p == '{');
		}
	
	@Override
	public boolean erHogreparentes(char p) {
		return (p == ')' || p == ']' || p == '}');
	}

	@Override
	public boolean erParentes(char p) {
		return erVenstreparentes(p) || erHogreparentes(p);
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		if (venstre == '(' && hogre == ')')
			return true;
		if (venstre == '[' && hogre == ']')
			return true;
		if (venstre == '{' && hogre == '}')
			return true;
		return false;
	}

	@Override
	public boolean erBalansert(String s) {
		stabel = new KjedetStabel();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (erVenstreparentes(c)) {//åpne parenteser legges i stabel
				stabel.push(c);
				
			} else if (erHogreparentes(c)) {//lukkeparenteser sjekkes opp mot siste åpne parentes på stabel
				if (stabel.erTom()) {
					System.out.print("Feil 2: Vi treffer et lukkesymbol og stabelen er tom. ");
					return false;
				}
				if(!erPar(stabel.pop(), c)) {//symbolene danner ikke par
					System.out.print("Feil 1: Danner ikke par. ");
					return false;
					}
				}//end else if
		}//end for
		
		//sjekker om det er gjenværende parenteser 
		if (!stabel.erTom()) {
			System.out.print("Feil 3: Det er slutt på teksten og det er fremdeles minst ett symbol på stabelen. ");
			return false;
			
	}
	
	return true;
	
	}
	
}//end class
