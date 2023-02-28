package Øving4Oppgave2;

public class DataKontakt {
	private Medlem[] medlemstabell;
	private int antallMedlemmer;
	
	
	public DataKontakt(int maksAntall) {
		medlemstabell = new Medlem[maksAntall];
		antallMedlemmer = 0;

	}
	
	public void leggTilMedlem(Medlem person) {
		//legger inn ny person bakerst i tabellen
		medlemstabell[antallMedlemmer] = person;
		//oppdaterer antallMedlemmer
		antallMedlemmer++;
	}
	
	public int finnMedlemsIndeks(String medlemsnavn) {
		
		int indeks = -1;
		for(int i = 0; i < antallMedlemmer; i++) {
			if(medlemstabell[i].equals(medlemsnavn)) {
				indeks = i;
			}
		}
		return indeks;
		
	}
	
	public void tilbakestillStatusIndeks(String medlemsnavn) {
		
		int medlemsindeks = finnMedlemsIndeks(medlemsnavn);
		
		//sjekker om medlem finnes i tabell og har en partner
		if(medlemsindeks != -1 && medlemstabell[medlemsindeks].getStatusIndeks() != -1) {
			int partnerindeks = medlemstabell[medlemsindeks].getStatusIndeks();
			
			medlemstabell[medlemsindeks].setStatusIndeks(-1);
			medlemstabell[partnerindeks].setStatusIndeks(-1);
			
		}
	}
	
	public int finnPartnerFor(String medlemsnavn) {
		int indeks = -1;//
		//medlemsindeks = -1 om ikke finnes i tabell, i ellers
		int medlemsindeks = finnMedlemsIndeks(medlemsnavn);
		
		/*medlemsindeks != -1: medlemmet finnes i tabellen
		 * statusindeks == -1: ikke koblet med en annen partner*/
		
		if(medlemsindeks != -1 && medlemstabell[medlemsindeks].getStatusIndeks() == -1)
		
			/*1: i != medlemsindeks: at det ikke er samme medlemmet
			 *2: medlemmet ikke allerede er koblet til en partner
			 *3: sjekker om medlemmet passer til aktuelle medlemmet
		     */
			for(int i = 0; i < antallMedlemmer; i++) {
				if(i != medlemsindeks && medlemstabell[i].getStatusIndeks() == -1
						&& medlemstabell[medlemsindeks].passerTil(medlemstabell[i]))
					
					/*Oppdaterer statusIndeksen for begge medlemmer
					 * slik at de vises som "koblet"
					 */
					medlemstabell[medlemsindeks].setStatusIndeks(i);
					medlemstabell[i].setStatusIndeks(medlemsindeks);
					indeks = i;
					break;//avslutter søk/løkken når partner er funnet
					
				}
		//returnerer indeks til partner hvis fuhnn, ellers: -1
		return indeks;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
