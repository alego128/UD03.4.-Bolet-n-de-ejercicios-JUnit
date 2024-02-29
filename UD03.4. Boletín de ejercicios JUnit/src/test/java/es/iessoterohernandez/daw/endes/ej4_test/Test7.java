package es.iessoterohernandez.daw.endes.ej4_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Test7 {
	
	Account cuenta;
	
	@BeforeEach
	void init() {
		cuenta = new Account("Juan", 112233445566L, 600F);
	}
	
	@AfterEach
	void finish() {
		cuenta = null;
	}

    @Test
    public void testFalloPrecisionDecimal() {
    	float balance = cuenta.getBalance();
    	for (int i = 0; i < 100; i++) balance += 0.23F;
    	assertNotEquals(balance, 623F);
    	assertEquals(balance, 622.99805F);
    }

}