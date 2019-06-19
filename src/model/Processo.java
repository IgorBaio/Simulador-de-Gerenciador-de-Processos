package model;

import java.util.Random;

public abstract class Processo  {
	private int tempoCPU;
	private int tempoRede;
	private int tempoVideo;
	private int tempoMemoria;
	private int tempoTeclado;
		
	public Processo(int tempo) {
		Random gerador = new Random();
		int tempoTotal = gerador.nextInt(8000) + 2000;
		float aux = gerador.nextInt(10) + tempo;
		int tempoCpu = (int) (tempoTotal * (aux / 100));
		this.setTempoCpu(tempoCpu);

		int tempoIo = tempoTotal - tempoCpu;

		int[] vetor = vetorDeRandom();
		for (int i = 0; i < vetor.length; i++) {
			int funcao = vetor[i];
			switch (funcao) {
			case 1:
				this.setTempoMemoria(gerador.nextInt(tempoIo + 1));
				tempoIo = tempoIo - this.getTempoMemoria();
				break;	
			case 2:
				this.setTempoRede(gerador.nextInt(tempoIo + 1));
				tempoIo = tempoIo - this.getTempoRede();
				break;
			case 3:
				this.setTempoTeclado(gerador.nextInt(tempoIo + 1));
				tempoIo = tempoIo - this.getTempoTeclado();
				break;
			case 4:
				this.setTempoVideo(gerador.nextInt(tempoIo + 1));
				tempoIo = tempoIo - this.getTempoVideo();
				break;

			default:
				break;
			}
		}
	}

	private static int[] vetorDeRandom() {
		Random generator = new Random();
		int[] vetor = { 1, 2, 3, 4 };

		for (int i = vetor.length - 1; i > 0; i--) {
			int j = generator.nextInt(i);
			int temp = vetor[i];
			vetor[i] = vetor[j];
			vetor[j] = temp;

		}
		
		return vetor;
	}
	
	
	public int getTempoCPU() {
		return tempoCPU;
	}
	public void setTempoCpu(int tempoCpu) {
		this.tempoCPU=tempoCpu;
	}
	public void subtraiTempoCpu(int tempo) {
		if(tempo > tempoCPU) {
			this.tempoCPU = 0;
		}else {
			this.tempoCPU = tempoCPU - tempo;		
		}
		
	}
	
	public int getTempoRede() {
		return tempoRede;
	}
	public void setTempoRede(int tempoRede) {
		this.tempoRede = tempoRede;
	}
	public void subtraiTempoRede(int tempo) {
		if(tempo > tempoRede) {
			this.tempoRede = 0;
		}else {
			this.tempoRede = tempoRede - tempo;		
		}
		
	}
	public int getTempoVideo() {
		return tempoVideo;
	}
	public void setTempoVideo(int tempoVideo) {
		this.tempoVideo = tempoVideo;
	}
	public void subtraiTempoVideo(int tempo) {
		if(tempo > tempoVideo) {
			this.tempoVideo = 0;
		}else {
			this.tempoVideo = tempoVideo - tempo;		
		}
		
	}
	public int getTempoMemoria() {
		return tempoMemoria;
	}
	public void setTempoMemoria(int tempoMemoria) {
		this.tempoMemoria = tempoMemoria;
	}
	public void subtraiTempoMemoria(int tempo) {
		if(tempo > tempoMemoria) {
			this.tempoMemoria = 0;
		}else {
			this.tempoMemoria = tempoMemoria - tempo;		
		}
		
	}
	public int getTempoTeclado() {
		return tempoTeclado;
	}
	public void setTempoTeclado(int tempoTeclado) {
		this.tempoTeclado = tempoTeclado;
	}
	public void subtraiTempoTeclado(int tempo) {
		if(tempo > tempoTeclado) {
			this.tempoTeclado = 0;
		}else {
			this.tempoTeclado = tempoTeclado - tempo;		
		}
		
	}
        
        public int getTempoTotal(){
            return tempoTeclado + tempoVideo + tempoRede+ tempoMemoria + tempoCPU;
        }
	
}
