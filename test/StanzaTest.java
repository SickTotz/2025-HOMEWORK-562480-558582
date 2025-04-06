import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private Stanza stanza;
	private Attrezzo torcia;

	
	@BeforeEach
	public void setUp() {
		stanza = new Stanza("stanza");
		torcia = new Attrezzo("torcia", 1);

	}
	
	
	//Test per metodo addAttrezzo
	@Test
	public void testAddAttrezzo() {
		assertTrue(stanza.addAttrezzo(torcia));
	}
	
	//Test per metodo hasAttrezzo
	@Test
	public void testHasAttrezzo() {
		stanza.addAttrezzo(torcia);
		assertTrue(stanza.hasAttrezzo("torcia"));
	}
	
	@Test
	public void testHasAttrezzoNull() {
		assertFalse(stanza.hasAttrezzo(null));
	}
	
	@Test
	public void testHasAttrezzoSconosciuto() {
		assertFalse(stanza.hasAttrezzo("attrezzoSconosciuto"));
	}

	//Test getNome
	@Test
	public void testGetNome() {
		Stanza stanzaNome = new Stanza("stanzaNome");
		assertTrue(stanzaNome.getNome().equals("stanzaNome"));
	}
	
	//Test per getAttrezzi
	@Test
	public void testGetAttrezzi() {
		stanza.addAttrezzo(torcia);
		assertEquals(stanza.getAttrezzi()[0], torcia);
	}
}
