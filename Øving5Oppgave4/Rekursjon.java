package Øving5Oppgave4;

public class Rekursjon {
	
	
	//oppgave 4.a sum naturlige tall
	public static int Sum(int n) {
		
		if(n == 1) {//basistilfellet
			return n;
		}else {
			
			return Sum(n-1) + n;	
	}
}
	
	//oppgave 4.b tallfølge
	public static int TallFolge(int n) {
		int i = 2;
		int j = 5;
		
		if(n == 0) {//basistilfellet
			return 2;//a1
			
		}else if(n == 1) {
			return 5;//a2
			
		}else {
			return 5 * TallFolge(n-1) - 6 * TallFolge(n-2) + 2;
		}
	}
	
	//oppgave 4.c
	public static int F(int n) {
		
		if(n == 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}else {
			return (F(n-1)) + (F(n-2));
		}
	}
	
	//oppgave 4.d
	public static void F2(int n) {
	
		if(n <= 1) {
			System.out.print(0);
		}else {
		
		int fib1 = 0;
		int fib2 = 1;
		int fib = 0;
		System.out.print(fib1+" "+fib2+" ");
		for(int i = 2; i <= n; i++) {
		fib = fib1 + fib2;
		fib1 = fib2;
		fib2 = fib;
		System.out.print(fib + " ");
		}
	
	}
		}

	public static void main(String[] args) {
		
		/*test: 4.a
		//int n = 100;
		//System.out.println(S(n));
		 */
		
		//test 4.b
		int n2 = 10;
		System.out.print("Foelgen {an}: ");
		for(int i = 0; i < n2; i++) {
			System.out.print(TallFolge(i) + " ");
		}
		
		/*test 4.c
		int n3 = 10;
		System.out.print("Fn: ");
		for(int i = 0; i < n3; i++) {
			System.out.print(F(i) + " ");
		}*/
		
		/*test 4.d
		int n4 = 6;
		F2(n4);*/
		
		
		
		
		
		
		
		
		

	}

}
