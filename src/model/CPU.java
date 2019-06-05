package model;

import java.util.ArrayList;
import java.util.Random;

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

	public void processar() {
		// pega um processo do escalonador e armazena em p
		Processo p = escalonador.getProcesso();
		double chanceBloqueioVideo = p.getTempoVideo() / 100;
		double chanceBloqueioMemoria = p.getTempoMemoria() / 100;
		double chanceBloqueioRede = p.getTempoRede() / 100;
		double chanceBloqueioTeclado = p.getTempoTeclado() / 100;

		Random generator = new Random();
		double chance = generator.nextDouble() * 400;
		int tempoPassado = generator.nextInt(99);
		if (chance <= chanceBloqueioVideo) {
			// bloqueia video
			p.subtraiTempoCpu(tempoPassado);
			this.listaVideo.add(p);
		} else if (chance > 100 && chance <= chanceBloqueioMemoria) {
			// bloqueia memoria
			p.subtraiTempoCpu(tempoPassado);
			this.listaMemoria.add(p);
		} else if (chance > 200 && chance <= chanceBloqueioRede) {
			// bloqueia rede
			p.subtraiTempoCpu(tempoPassado);
			this.listaRede.add(p);
		} else if (chance > 300 && chance <= chanceBloqueioTeclado) {
			// bloqueia teclado
			p.subtraiTempoCpu(tempoPassado);
			this.listaTeclado.add(p);
		} else {
			// nao bloqueia
			tempoPassado = timeSlice;
			p.subtraiTempoCpu(tempoPassado);
			escalonador.voltarProcesso(p);
		}
		
		

	}

	public void processarVideo(int tempo) {
		if(!this.listaVideo.isEmpty()) {
			listaVideo.get(0).subtraiTempoVideo(tempo);
		}
	}
	public void processarRede(int tempo) {
		if(!this.listaRede.isEmpty()) {
			listaRede.get(0).subtraiTempoRede(tempo);
		}
	}
	public void processarMemoria(int tempo) {
		if(!this.listaMemoria.isEmpty()) {
			listaMemoria.get(0).subtraiTempoMemoria(tempo);
		}
	}
	public void processarTeclado(int tempo) {
		if(!this.listaTeclado.isEmpty()) {
			listaTeclado.get(0).subtraiTempoTeclado(tempo);
		}
	}

}
