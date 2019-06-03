package model;

public class Teste {

	public static void main(String[] args) {
		ProcessoCpu p1 = CriaProcessos.criaProcCpu();
		ProcessoIO p2 = CriaProcessos.criaProcIO();
		CriaProcessos.retornaPorcentProcesso(2500, 20);
		System.out.println("Hello World");

	}

}
