package demo;

public class EvenOddNumberDemo {
	

	 public static void main(String[] args) {
		
		 int i;
		 int num = 0;
		 boolean isPrime = true;
		 int maxPrime = 50;
		 String primeNumbersFound = "";
		 
		 for (i=1;i<maxPrime;i++) {
			 
			 isPrime = checkPrime(i);
			 
			  if (isPrime) {
				  
	                primeNumbersFound = primeNumbersFound + i + " ";
	            }
	        }
		 
	        System.out.println("Prime numbers from 1 to " + maxPrime + " are:");
	        // Print prime numbers from 1 to maxCheck
	        System.out.println(primeNumbersFound);
		 }
		 
		 
		 public static boolean checkPrime(int numberToCheck) {
			 int reminder;
			 
			 for(int i=2; i <= numberToCheck / 2; i++) {
				 
				 reminder = numberToCheck % i;
				if(reminder == 0) {
					
					return false;
				} 
			 }
			 
			 return true;
			 
		 }
	    }
	 
