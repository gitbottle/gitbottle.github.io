package codingChallenge;

/*
 * Write a function, persistence, that takes in a positive parameter num and returns 
 * its multiplicative persistence, 
 * which is the number of times you must multiply the digits in num until you reach a single digit.
 */
public class Persist {
	public static void main (String [] args) {
		
	}
	
	public static int persistence (long n) {
		long result= 1;
		long pop;
		int count=0;
		while (result > 10){
			
			pop = n%10;
			n = n/10;
			result= n*pop;		
			count++;	
			}			
		return count;	
		
		}
	}


