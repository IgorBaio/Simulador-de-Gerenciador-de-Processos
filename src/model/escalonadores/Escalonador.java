package model.escalonadores;

import java.util.ArrayList;

import model.Processo;

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
        if (proc.getTempoTotal() >= 0) {
            listaProc.add(proc);
        }
        escalonar();

    }

    //libera processo
    public Processo getProcesso() {
        while(listaProc.size() > 0 && listaProc.get(0).getTempoTotal() <= 0){
            this.listaProc.remove(0);
        }
        if (listaProc.size() > 0) {
            return this.listaProc.remove(0);
        } else {
            return null;
        }
    }

    public abstract void escalonar();

}
