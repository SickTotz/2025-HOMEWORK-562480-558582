package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
 Borsa borsa;
 Attrezzo martello;
 Attrezzo cacciavite;
	@BeforeEach
	void setUp() throws Exception {
		borsa=new Borsa();
		martello=new Attrezzo("martello", 3);
		cacciavite=new Attrezzo("cacciavite", 2);
		borsa.addAttrezzo(cacciavite);
	}

	@Test
	void testAddAttrezzo() {
		borsa.addAttrezzo(martello);
		assertTrue(borsa.hasAttrezzo("martello"));
	}

	@Test
	void testHasAttrezzo() {
		assertTrue(borsa.hasAttrezzo("cacciavite"));
	}

	@Test
	void testRemoveAttrezzo() {
		borsa.removeAttrezzo("cacciavite");
		assertFalse(borsa.hasAttrezzo("cacciavite"));
	}

}
