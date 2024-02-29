package es.iessoterohernandez.daw.endes.ej4_test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Test4 {
	
	Fridge frigo;
	String comida = "tarta";
	
	@BeforeEach
	void init() {
		frigo = new Fridge();
		frigo.put(comida);
	}
	
	@AfterEach
	void finish() {
		frigo = null;
	}
	
	@ParameterizedTest
	(name = "Meter {0}")
	@ValueSource
	(strings = {"fresas", "queso", "zumo"})
	void testAnadirVariosAlimentos(String alimento) {
		assertTrue(frigo.put(alimento));
	}
	
	@Test
	void testAnadirMismoAlimento() {
		assertFalse(frigo.put(comida));
	}
	
	@Test
	void testBuscarAlimentoExistente() {
		assertTrue(frigo.contains(comida));
	}
	
	@Test
	void testBuscarAlimentoAusente() throws NoSuchItemException {
		frigo.take(comida);
		assertFalse(frigo.contains(comida));
	}
	
	@Test
    public void testSacarAlimentoAusente() throws NoSuchItemException {
		frigo.take(comida);
        assertThrows(NoSuchItemException.class, () -> frigo.take(comida));
    }
}