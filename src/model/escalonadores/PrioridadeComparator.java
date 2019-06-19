package model.escalonadores;

import java.util.Comparator;

import model.Processo;

public class PrioridadeComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Processo p1 = (Processo) o1;
        Processo p2 = (Processo) o2;

        int tempoIoP1 = p1.getTempoMemoria() + p1.getTempoRede() + p1.getTempoTeclado()
                + p1.getTempoVideo();

        int tempoIoP2 = p2.getTempoMemoria() + p2.getTempoRede() + p2.getTempoTeclado()
                + p2.getTempoVideo();

        int tempoTotalP1 = p1.getTempoTotal();
        int tempoTotalP2 = p2.getTempoTotal();

        if (tempoTotalP1 > 0 && tempoTotalP2 > 0) {
            int porcentagemIoP1 = tempoIoP1 * 100 / tempoTotalP1;
            int porcentagemIoP2 = tempoIoP2 * 100 / tempoTotalP2;
            if (porcentagemIoP1 > porcentagemIoP2) {
                return 1;
            } else if (porcentagemIoP1 < porcentagemIoP2) {
                return -1;
            } else {
                return 0;
            }

        } else if (tempoTotalP2 <= 0) {
            return 1;
        } else if (tempoTotalP1 <= 0) {
            return -1;
        } else {
            return 0;
        }

    }

}
