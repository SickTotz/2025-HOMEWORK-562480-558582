package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {
	Giocatore g1;

	@BeforeEach
	void setUp() throws Exception {
		g1=new Giocatore();
	}

	@Test
	void testGetCfu() {
		g1.setCfu(20);
		assertEquals(20 ,g1.getCfu());
	}

	@Test
	void testGetBorsa() {
		assertNotNull(g1.getBorsa());
	}

}
