package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata sb;
	private Stanza s;
	private Attrezzo a;
	
	@Before
	public void setUp() {
		sb = new StanzaBloccata("StanzaBloccata", "sud", "ariete");
		s = new Stanza("atrio");
		a = new Attrezzo("ariete", 6);
		sb.impostaStanzaAdiacente("sud", s);
		
	}

	@Test
	public void testDirezioneBloccata() {
		assertEquals(sb, sb.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(s, sb.getStanzaAdiacente("sud"));
		
	}

	@Test
	public void testDescrizioneDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(sb.toString(), sb.getDescrizione());
	}
	
	@Test
	public void testDescrizioneDirezioneBloccata() {
		String e = "Stanza bloccata nella direzione: sud"+"\nPrendi: ariete";
		assertEquals(e, sb.getDescrizione());
		
	}

}
