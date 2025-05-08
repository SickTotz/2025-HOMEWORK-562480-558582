package it.uniroma3.diadia.comandi;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;


public class ComandoPosaTest {

	private Partita p;
	private Attrezzo mazza;
	private Attrezzo pallet;
	private IO io;
	private Comando comando;

	@Before
	public void setUp() {
		p = new Partita();
		mazza = new Attrezzo("mazza", 3);
		pallet = new Attrezzo("pallet", 20);
		comando = new ComandoPosa();
		io = new IOConsole();
		comando.setIo(io);
	}


	@Test
	public void testAttrezzoPosa() {
		p.getGiocatore().getBorsa().addAttrezzo(mazza);
		comando.setParametro("mazza");
		comando.esegui(p);
		assertTrue(p.getLabirinto().getStanzaCorrente().hasAttrezzo("mazza"));
	}

	@Test
	public void testNull() {
		comando.setParametro("martello");
		comando.esegui(p);
		assertFalse(p.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
	}

	
	@Test
	public void testTroppoPesante() {
		p.getGiocatore().getBorsa().addAttrezzo(pallet);
		comando.setParametro("pallet");
		comando.esegui(p);
		assertFalse(p.getLabirinto().getStanzaCorrente().hasAttrezzo("pallet"));
	}

}

