package Øving5Oppgave3;

public class KjedetStabel implements StabelADT {
	private LinearNode topp;

	public KjedetStabel() {
		topp = null;

	}

	@Override
	public void push(char p) {
		LinearNode nynode = new LinearNode(p);
		nynode.setNeste(topp);
		topp = nynode;

	}

	@Override
	public char pop() {
		if (erTom())
			throw new EmptyCollectionException("stabel");
		char resultat = topp.getElement();
		topp = topp.getNeste();

		return resultat;
	}

	@Override
	public char peek() {
		if (erTom())
			throw new EmptyCollectionException("stabel");

		return topp.getElement();
	}

	@Override
	public boolean erTom() {
		return (topp == null);
	}

}