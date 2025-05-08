package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(a != null){
            if (partita.getGiocatore().getBorsa().getSpazioDisponibile(a)) {
                partita.getGiocatore().getBorsa().addAttrezzo(a);
                partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
                io.mostraMessaggio("L'attrezzo è stato preso");
            } 
            else {
                io.mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa!");
            }
        } else {
            io.mostraMessaggio("Attrezzo non esistente nella stanza!");
        }
    }

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
