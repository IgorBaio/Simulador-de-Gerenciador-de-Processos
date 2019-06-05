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
	public void setTempoCpu(int tempoCpu) {
		this.tempoCPU=tempoCpu;
	}
	public void subtraiTempoCpu(int tempo) {
		this.tempoCPU = tempoCPU - tempo;
	}
	
	public int getTempoRede() {
		return tempoRede;
	}
	public void setTempoRede(int tempoRede) {
		this.tempoRede = tempoRede;
	}
	public void subtraiTempoRede(int tempo) {
		this.tempoRede = tempoRede - tempo;
	}
	public int getTempoVideo() {
		return tempoVideo;
	}
	public void setTempoVideo(int tempoVideo) {
		this.tempoVideo = tempoVideo;
	}
	public void subtraiTempoVideo(int tempo) {
		this.tempoVideo = tempoVideo - tempo;
	}
	public int getTempoMemoria() {
		return tempoMemoria;
	}
	public void setTempoMemoria(int tempoMemoria) {
		this.tempoMemoria = tempoMemoria;
	}
	public void subtraiTempoMemoria(int tempo) {
		this.tempoMemoria = tempoMemoria - tempo;
	}
	public int getTempoTeclado() {
		return tempoTeclado;
	}
	public void setTempoTeclado(int tempoTeclado) {
		this.tempoTeclado = tempoTeclado;
	}
	public void subtraiTempoTeclado(int tempo) {
		this.tempoTeclado = tempoTeclado - tempo;
	}
	
}
