import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;



class PartitaTest {

	Partita p= new Partita();
	Stanza atrio = new Stanza("atrio");

	@Test
	void testGetStanzaCorrente() {
		p.getLabirinto().setStanzaCorrente(atrio);
		assertEquals("atrio", p.getLabirinto().getStanzaCorrente().getNome());
	}

	@Test
	void testIsFinita() {
		assertFalse(p.isFinita());
	}

	@Test
	void testGetCfu() {
		p.getGiocatore().setCfu(30);
		assertEquals(30, p.getGiocatore().getCfu());
	}

}
