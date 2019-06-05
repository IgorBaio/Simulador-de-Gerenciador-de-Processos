package model;

import java.util.ArrayList;
import java.util.Random;

public class CriaProcessos {

	public static ProcessoCpu criaProcCpu() {
		ProcessoCpu pCPU = new ProcessoCpu();
		pCPU = (ProcessoCpu) criaProcesso(pCPU, 75);
		return pCPU;
		
	}
	
	public static ProcessoIO criaProcIO() {
		ProcessoIO pIO = new ProcessoIO();
		pIO = (ProcessoIO) criaProcesso(pIO, 15);
		return pIO;
	}
	
	private static Processo criaProcesso(Processo proc, int tempo) {
		
		Random gerador = new Random();
		int tempoTotal = gerador.nextInt(800) + 200;
		float aux = gerador.nextInt(10) + tempo;
		int tempoCpu = (int) (tempoTotal * (aux / 100));
		proc.setTempoCpu(tempoCpu);

		int tempoIo = tempoTotal - tempoCpu;

		int[] vetor = vetorDeRandom();
		for (int i = 0; i < vetor.length; i++) {
			int funcao = vetor[i];
			switch (funcao) {
			case 1:
				proc.setTempoMemoria(gerador.nextInt(tempoIo + 1));
				tempoIo = tempoIo - proc.getTempoMemoria();
				break;	
			case 2:
				proc.setTempoRede(gerador.nextInt(tempoIo + 1));
				tempoIo = tempoIo - proc.getTempoRede();
				break;
			case 3:
				proc.setTempoTeclado(gerador.nextInt(tempoIo + 1));
				tempoIo = tempoIo - proc.getTempoTeclado();
				break;
			case 4:
				proc.setTempoVideo(gerador.nextInt(tempoIo + 1));
				tempoIo = tempoIo - proc.getTempoVideo();
				break;

			default:
				break;
			}
		}

		return proc;
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
	
	
	public static void retornaPorcentProcesso(int quantidade, double porcentagem) {
		ArrayList<Processo> lista = new ArrayList<Processo>();
		double num = 0;
		num = (porcentagem*quantidade)/100;
		for(int i = quantidade; i > 0; i--) {
			
			if(i< num) {
				lista.add(CriaProcessos.criaProcCpu());
			}else {
				lista.add(CriaProcessos.criaProcIO());
			}
			
		}	
		
		System.out.println("Número de processos cpu bound: "+num);
		
		
	}





}
