package model;

public abstract class Processo {
	private int tempoCPU;
	private int tempoRede;
	private int tempoVideo;
	private int tempoMemoria;
	private int tempoTeclado;
	
	
	
	
	public int getTempoCPU() {
		return tempoCPU;
	}
	public void setTempoCPU(int tempoCPU) {
		this.tempoCPU = tempoCPU;
	}
	public int getTempoRede() {
		return tempoRede;
	}
	public void setTempoRede(int tempoRede) {
		this.tempoRede = tempoRede;
	}
	public int getTempoVideo() {
		return tempoVideo;
	}
	public void setTempoVideo(int tempoVideo) {
		this.tempoVideo = tempoVideo;
	}
	public int getTempoMemoria() {
		return tempoMemoria;
	}
	public void setTempoMemoria(int tempoMemoria) {
		this.tempoMemoria = tempoMemoria;
	}
	public int getTempoTeclado() {
		return tempoTeclado;
	}
	public void setTempoTeclado(int tempoTeclado) {
		this.tempoTeclado = tempoTeclado;
	}
	
	
}
