package model.escalonadores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import model.Processo;

public class EscalonadorPrioridadeIO extends Escalonador{

	public EscalonadorPrioridadeIO(ArrayList<Processo> listaProcesso) {
		super(listaProcesso);
		
	}

	@Override
	public void escalonar() {
		Collections.sort(this.getLista(), new PrioridadeComparator());
	}
	
}
