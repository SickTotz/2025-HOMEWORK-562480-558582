package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Before;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	private Partita p;
	private Attrezzo mazza;
	private Attrezzo mattone;
	
	private Comando comando;
	private IO io;
	
	@Before
	public void setUp() {
		p = new Partita();
		mazza = new Attrezzo("mazza", 3);
		mattone = new Attrezzo("mattone", 20);
		
		comando = new ComandoPrendi();
		io = new IOConsole();
		comando.setIo(io);
	}
	
	public boolean attrezzoPresente(String s) {
		Attrezzo[] array = p.getLabirinto().getStanzaCorrente().getAttrezzi();
		for(Attrezzo a : array) {
			if(a != null && s.equals(a.getNome()))
					return true;
		}
		return false;
	}
	
	@Test
	public void testAttrezzoPreso() {
		p.getLabirinto().getStanzaCorrente().addAttrezzo(mazza);
		comando.setParametro("mazza");
		comando.esegui(p);
		assertFalse(attrezzoPresente("mazza"));
	}
	@Test
	public void testAttrezzoNonPresente() {
		comando.setParametro("mattone");
		comando.esegui(p);
		assertFalse(attrezzoPresente("mattone"));
	}
	
	@Test
	public void testAttrezzoPesante() {
		p.getLabirinto().getStanzaCorrente().addAttrezzo(mattone);
		comando.setParametro("mattone");
		comando.esegui(p);
		assertTrue(attrezzoPresente("mattone"));
	}
	
}