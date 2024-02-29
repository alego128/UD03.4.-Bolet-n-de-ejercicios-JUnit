package es.iessoterohernandez.daw.endes.ej4_test;

import java.text.*;

public class BadMoney {

	public static void main(String[] args) {
		
		// Example 1
	    float originalPrice = 400000.00f;
	    float reducedPrice = originalPrice - 0.05f;
	    float discount = originalPrice - reducedPrice;
	    System.out.println("Discount is: " + discount);  

	    // Example 2
	    float principal = 12345678.12f;
	    int count;
	    NumberFormat fmt = NumberFormat.getCurrencyInstance();
	    System.out.println( "The original principal is " + fmt.format(principal) + ".");
	    for (count = 1; count <= 1000; count = count + 1) {
	    	principal = principal + .10f;
	    }
	    System.out.println( "The new principal is " + fmt.format(principal) + ".");  
	
	    // Example 3 
	    double FloatNumber = 4.35;
	    int IntegerNumber = (int) (100 * FloatNumber);  
	    System.out.println("Computation result is " + IntegerNumber);             
	
	}
	
}