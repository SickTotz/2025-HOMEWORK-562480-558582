package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOConsole;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


public class ComandoVaiTest {

	private Stanza s1;
	private Stanza s2;
	private Comando vai;
	private Partita p;
	
	@Before
	public void setUp() throws Exception {
		s1 = new Stanza("atrio");
		s2 = new Stanza("biblioteca");
		vai = new ComandoVai();
		p = new Partita();
		vai.setIo(new IOConsole());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVaiNull() {
		p.getLabirinto().setStanzaCorrente(s1);
		vai.esegui(p);
		assertEquals(s1, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneEsistente() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud", s2);
		vai.setParametro("sud");
		vai.esegui(p);
		assertEquals(s2, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneInesistente() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("nord");
		vai.esegui(p);
		assertNotEquals(s2, p.getLabirinto().getStanzaCorrente());
	}
	
	
}

