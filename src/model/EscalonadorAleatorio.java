package model;

import java.util.ArrayList;
import java.util.Collections;

public class EscalonadorAleatorio extends Escalonador {
	
	
	public EscalonadorAleatorio(ArrayList<Processo> listaProcesso) {
		super(listaProcesso);
		
	}

	public void escalonar() {
		Collections.shuffle(this.getLista());
		
	}

}
