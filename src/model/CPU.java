package model;

import java.util.ArrayList;
import java.util.Random;
import model.escalonadores.Escalonador;

public class CPU {

    private int tempoTotal;
    private ArrayList<Processo> listaVideo;
    private ArrayList<Processo> listaMemoria;
    private ArrayList<Processo> listaTeclado;
    private ArrayList<Processo> listaRede;
    private Escalonador escalonador;
    private final int timeSlice = 100;

    public CPU(Escalonador escalonador) {
        this.tempoTotal = 0;
        this.escalonador = escalonador;
        this.listaMemoria = new ArrayList<Processo>();
        this.listaRede = new ArrayList<Processo>();
        this.listaTeclado = new ArrayList<Processo>();
        this.listaVideo = new ArrayList<Processo>();
    }

    public int calcularResultadoProcessado() {
        boolean terminou = false;

        while (!terminou) {
            int tempo = processar();
            processarMemoria(tempo);
            processarTeclado(tempo);
            processarRede(tempo);
            processarVideo(tempo);
            
            tempoTotal += tempo;
            
            if (escalonador.getLista().size() == 0
                    && listaMemoria.size() == 0 && listaRede.size() == 0
                    && listaTeclado.size() == 0 && listaVideo.size() == 0) {
                terminou = true;
            }
        }
        return tempoTotal;
    }

    private int processar() {
        // pega um processo do escalonador e armazena em p
        Processo p = escalonador.getProcesso();
        if(p == null) {
            return timeSlice;
        }
        
        int tempoTotal = p.getTempoTotal();
        
        float chanceNaoBloqueio = (p.getTempoCPU()*100) /  tempoTotal;
        float chanceBloqueioVideo = (p.getTempoVideo()*100) / tempoTotal;
        float chanceBloqueioMemoria = (p.getTempoMemoria()*100) / tempoTotal;
        float chanceBloqueioRede = (p.getTempoRede()*100 )/ tempoTotal;
        float chanceBloqueioTeclado = (p.getTempoTeclado()*100) / tempoTotal;
        float somaChances = chanceBloqueioMemoria + chanceBloqueioRede + chanceBloqueioTeclado
                + chanceBloqueioVideo + chanceNaoBloqueio;
        
        Random generator = new Random();
        double chance = generator.nextDouble() * somaChances;
        int tempoPassado = generator.nextInt(100);
        if (chance <= p.getTempoVideo()) {
            // bloqueia video
            p.subtraiTempoCpu(tempoPassado);
            this.listaVideo.add(p);
        } else if ( chance <= p.getTempoVideo() + p.getTempoMemoria()) {
            // bloqueia memoria
            p.subtraiTempoCpu(tempoPassado);
            this.listaMemoria.add(p);
        } else if ( chance <= p.getTempoVideo() + p.getTempoMemoria() + p.getTempoRede()) {
            // bloqueia rede
            p.subtraiTempoCpu(tempoPassado);
            this.listaRede.add(p);
        } else if (chance <= p.getTempoVideo() + p.getTempoTeclado() + p.getTempoMemoria() + p.getTempoRede()) {
            // bloqueia teclado
            p.subtraiTempoCpu(tempoPassado);
            this.listaTeclado.add(p);
        } else {
            // nao bloqueia
            tempoPassado = timeSlice;
            p.subtraiTempoCpu(tempoPassado);
            escalonador.voltarProcesso(p);
        }
        return tempoPassado;
    }

    private void processarVideo(int tempo) {
        if (!this.listaVideo.isEmpty()) {

            listaVideo.get(0).subtraiTempoVideo(tempo);
            Random random = new Random();
            if (random.nextInt(2) == 1) {
                // acaba o tempo de video
                escalonador.voltarProcesso(listaVideo.remove(0));
            }
        }
    }

    private void processarMemoria(int tempo) {
        if (!this.listaMemoria.isEmpty()) {

            listaMemoria.get(0).subtraiTempoMemoria(tempo);
            Random random = new Random();
            if (random.nextInt(2) == 1) {
                // acaba o tempo de memoria
                escalonador.voltarProcesso(listaMemoria.remove(0));
            }
        }
    }

    private void processarRede(int tempo) {
        if (!this.listaRede.isEmpty()) {

            listaRede.get(0).subtraiTempoRede(tempo);
            Random random = new Random();
            if (random.nextInt(2) == 1) {
                // acaba o tempo de rede
                escalonador.voltarProcesso(listaRede.remove(0));
            }
        }
    }

    private void processarTeclado(int tempo) {
        if (!this.listaTeclado.isEmpty()) {

            listaTeclado.get(0).subtraiTempoTeclado(tempo);
            Random random = new Random();
            if (random.nextInt(2) == 1) {
                // acaba o tempo de teclado
                escalonador.voltarProcesso(listaTeclado.remove(0));
            }
        }
    }

}
