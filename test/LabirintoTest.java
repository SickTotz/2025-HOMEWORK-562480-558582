import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {
	Labirinto lab;
     Stanza magazzino;
     @BeforeEach
     public void setUp() {
 		lab = new Labirinto();
 		lab.creaStanze();
      
 	}
     
	@Test
	void testGetStanzaVincente() {
		assertEquals("Biblioteca", lab.getStanzaVincente().getNome());
	}


	@Test
	void testGetStanzaCorrente() {
		magazzino=new Stanza("Magazzino");
		lab.setStanzaCorrente(magazzino);
		assertEquals("Magazzino", lab.getStanzaCorrente().getNome());
	}

}
