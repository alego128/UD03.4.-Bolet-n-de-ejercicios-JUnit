package es.iessoterohernandez.daw.endes.ej4_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Test3 {

	Boa boa;
	
	@BeforeEach
	void init() {
        boa = new Boa("enroskada", 13, "granola bars");
	}
	
	@AfterEach
	void finish() {
		boa = null;
	}
	
    void init(String nombre, int longitud, String comidaFavorita) {
        boa = new Boa(nombre, longitud, comidaFavorita);
    }
	
    @ParameterizedTest
    (name = "Salud de {0}")
    @MethodSource
    ("boas")
    void testBoaSana(String nombre, int longitud, String comidaFavorita, boolean boaSana) {
    	init(nombre, longitud, comidaFavorita);
    	assertEquals(boa.isHealthy(), boaSana);
    }

    @Test
    void testBoaCabeEnJaula() {
    	assertTrue(boa.fitsInCage(20));
    }
    
    @Test
    void testBoaNoCabeEnJaula() {
    	assertFalse(boa.fitsInCage(10));
    }

    static Stream<Arguments> boas() {
        return Stream.of(
    		Arguments.of("fideo", 7, "espaguetis", false),
    		Arguments.of("enroskada", 13, "granola bars", true)
    	);
    }

}
