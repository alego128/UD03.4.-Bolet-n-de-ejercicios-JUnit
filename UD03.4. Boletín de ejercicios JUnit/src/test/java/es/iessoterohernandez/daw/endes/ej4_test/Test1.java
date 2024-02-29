package es.iessoterohernandez.daw.endes.ej4_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Test1 {
	OperadorAritmetico operador = new OperadorAritmetico();

	@ParameterizedTest
	(name = "{0} + {1} = {2}")
	@CsvSource
	({"1, 2, 3", "-23, 23, 0", "-2147483648, 2147483647, -1"})
	void testSuma(int a, int b, int c) {
	    assertThat(OperadorAritmetico.suma(a, b), is(c));
	}

	@ParameterizedTest
	(name = "{0} / {1} = {2}")
	@CsvSource
	({"10, 2, 5", "-1, 1, -1", "0, 2147483647, 0"})
	void testDivision(int a, int b, int c) throws Exception {
		assertThat(OperadorAritmetico.division(a, b), is(c));
	}
	
	@ParameterizedTest
	(name = "{0} / 0 = NaN")
	@ValueSource
	(ints = {5, -10, Integer.MIN_VALUE})
	void testDivisionPorCero(int num) {
		assertThrows(Exception.class, () -> OperadorAritmetico.division(num, 0));
	}
	
	Subscripcion sub;
	
	@BeforeEach
	void init() {
		sub = new Subscripcion(12, 12);
	}
	
	@AfterEach
	void finish() {
		sub = null;
	}
	
	@Test
	void testPrecioEnteroPositivo() {
		assertEquals(sub.precioPorMes(), 1);
	}
	
	@Test
	void testPrecioEnteroNegativo() {
		sub = new Subscripcion(-12, 12);
		assertEquals(sub.precioPorMes(), 0);
	}
	
	@Test
	void testPrecioNoEntero() {
		sub = new Subscripcion(1, 12);
		assertTrue(sub.precioPorMes() > 0);
	}
	
	@Test
	void testCancelarSubscripcion() {
		sub.cancel();
		assertEquals(sub.precioPorMes(), 0);
	}

}