package Øving4Oppgave1;

import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class KjedetMengdeTest {

	private MengdeADT<Integer> begge;
	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;

	@Test
	public void testUnion() {
		m1.leggTil(e0);
		m2.leggTil(e1);
		m1.union(m2);
		
		
		assertEquals(,m1.Union(m2));
	
	
		
		
		@Test
		public void testSnitt() {
			
			
		}
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
