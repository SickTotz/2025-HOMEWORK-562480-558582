package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;
	private IO io;
	private Comando c;
	
	@Before
	public void setUp() {
		io = new IOConsole();
		fabbrica = new FabbricaDiComandiFisarmonica(io);
	}
	@Test
	public void testComandoNonValido() {
		c = new ComandoNonValido();
		assertEquals( c.getNome(), fabbrica.costruisciComando("prova").getNome());
	}
	
	@Test
	public void testComandoCompleto() {
		c = new ComandoVai();
		c.setParametro("sud");
		Comando current = fabbrica.costruisciComando("vai sud");
		assertEquals( c.getNome(), current.getNome());
		assertEquals( c.getParametro(), current.getParametro());
	}
	
	@Test
	public void testComandoFine() {
		c = new ComandoFine();
		assertEquals( c.getNome(), fabbrica.costruisciComando("fine").getNome());
	}

}
