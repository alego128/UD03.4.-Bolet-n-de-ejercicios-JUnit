package es.iessoterohernandez.daw.endes.ej4_test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Test2 {
	
	Pila pila;
	int n = 10;
	
	@BeforeEach
	void init() {
		pila = new Pila();
	}
	
	@AfterEach
	void finish() {
		pila = null;
	}
	
	@ParameterizedTest
	@ValueSource
	(ints = {0, 2, 10, 20, 23})
	void testAnadir(int num) {
		pila.push(num);
	}
	
	@Test
	void testQuitarDePilaVacia() {
		assertThat(pila.pop(), nullValue());
	}
	
	@Test
	void testQuitarDePilaNoVacia() {
		pila.push(n);
		assertThat(pila.pop(), is(n));
	}
	
	@Test
	void testPilaVacia() {
		assertTrue(pila.isEmpty());
	}
	
	@Test
	void testPilaNoVacia() {
		pila.push(n);
		assertFalse(pila.isEmpty());
	}
	
	@Test
	void testUltimoDePilaVacia() {
		assertThat(pila.top(), nullValue());
	}
	
	@Test
	void testUltimoDePilaNoVacia() {
		pila.push(n);
		assertThat(pila.top(), is(n));
	}

}