package utils;

import java.util.ArrayList;
import java.util.Random;

import model.Processo;
import model.ProcessoCpu;
import model.ProcessoIO;

public class CriaProcessos {

	public static ProcessoCpu criaProcCpu() {
		return new ProcessoCpu();
		
	}
	
	public static ProcessoIO criaProcIO() {
		return new ProcessoIO();
	}
	
	
	public static ArrayList<Processo> CriarProcessosPorcentagemCpu(int quantidade, double porcentagem) {
		ArrayList<Processo> lista = new ArrayList<Processo>();
		double num = 0;
		num = (porcentagem*quantidade)/100;
		for(int i = quantidade; i > 0; i--) {
			
			if(i<= num) {
				lista.add(CriaProcessos.criaProcCpu());
			}else {
				lista.add(CriaProcessos.criaProcIO());
			}
			
		}	
		
		return lista;
		
	}





}
