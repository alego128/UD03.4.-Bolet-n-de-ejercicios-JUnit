package es.iessoterohernandez.daw.endes.ej4_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Test6 {
	
	Account cuenta;
	float balanceInicial, tarifa;
	
	@BeforeEach
	void init() {
		cuenta = new Account("Juan", 112233445566L, 600F);
		balanceInicial = cuenta.getBalance();
		tarifa = 2F;
	}
	
	@AfterEach
	void finish() {
		cuenta = null;
		balanceInicial = tarifa = 0;
	}
	
	@Test
	void testCuentaCreada() {
		assertThat(cuenta, notNullValue());
	}
	
	@ParameterizedTest
	(name = "Ingresar +{0}€")
	@MethodSource
	("cantidades")
	void testIngresarPositivos(float monto) {
		assertTrue(cuenta.deposit(monto));
		assertEquals(cuenta.getBalance(), balanceInicial + monto);
	}
	
	@ParameterizedTest
	(name = "Ingresar -{0}€")
	@MethodSource
	("cantidades")
	void testIngresarNegativos(float monto) {
		assertFalse(cuenta.deposit(-monto));
		assertEquals(cuenta.getBalance(), balanceInicial);
	}
	
	@ParameterizedTest
	(name = "Retirar +{0}€ con tarifa")
	@MethodSource
	("cantidades")
	/** @see Account#withdraw(float, float) -> line 30 */
	void testRetirarPositivos(float monto) {
		assertTrue(cuenta.withdraw(monto, tarifa));
	}
	
	@ParameterizedTest
	(name = "Retirar -{0}€ con tarifa")
	@MethodSource
	("cantidades")
	void testRetirarNegativos(float monto) {
		assertFalse(cuenta.withdraw(-monto, tarifa));
	}
	
	@Test
	void testAnadirInteres() {
		cuenta.addInterest();
		assertNotEquals(cuenta.getBalance(), balanceInicial);
	}
	
	@Test
	void testNumeroCuentaLong() {
		assertThat(cuenta.getAccountNumber(), isA(long.class));
	}
	
	@Test
    void testToString() {
		String resultado = cuenta.toString();
		assertTrue(resultado.contains(Long.toString(cuenta.getAccountNumber())));
	    assertTrue(resultado.contains(String.format("%.2f", balanceInicial)));
    }
	
	static Stream<Float> cantidades() {
        return Stream.of(10F, 200F, 500F);
    }

}
