package model;

import java.util.ArrayList;

public abstract class Escalonador {
	private ArrayList<Processo> listaProc;

	public Escalonador(ArrayList<Processo> listaProcesso) {
		this.listaProc = listaProcesso;
		escalonar();

	}

	
	public ArrayList<Processo> getLista() {
		return listaProc;
	}

	
	public void voltarProcesso(Processo proc) {
		listaProc.add(proc);
		escalonar();

	}

	public Processo getProcesso() {
		return this.listaProc.remove(0);
	}
	
	public abstract void escalonar(); 

}
