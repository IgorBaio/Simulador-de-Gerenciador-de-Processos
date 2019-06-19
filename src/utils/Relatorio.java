/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import model.CPU;
import model.Processo;
import model.escalonadores.Escalonador;
import model.escalonadores.EscalonadorAleatorio;
import model.escalonadores.EscalonadorPrioridadeIO;

/**
 *
 * @author Igor
 */
public class Relatorio {
    public void rodarMultiplos(int quantidade, String nomeArquivo){
        XMLReader leitorXml = new XMLReader();
        ArrayList<Processo> listaProcessos = leitorXml.ler(nomeArquivo);
        int[] tempoIO = new int[quantidade];
        int[] tempoAleatorio = new int[quantidade];
        
        for(int i = 0; i < quantidade; i++){
            CPU cpu = new CPU(new EscalonadorPrioridadeIO(leitorXml.ler(nomeArquivo)));
            tempoIO[i] = cpu.calcularResultadoProcessado();
        }
           
        for(int i = 0; i < quantidade; i++){
            CPU cpu = new CPU(new EscalonadorAleatorio(leitorXml.ler(nomeArquivo)));
            tempoAleatorio[i] = cpu.calcularResultadoProcessado();
        }
        
        imprimeRelatorio(tempoIO, tempoAleatorio);
            
    }

    private void imprimeRelatorio(int[] tempoIO, int[] tempoAleatorio){
        double totalIO = 0;
        double totalAleatorio =0;

        System.out.println("Tempos I/O: \n");
        for(int i = 0; i< tempoIO.length ; i++){
            System.out.print(tempoIO[i]+" ");
            totalIO += tempoIO[i];
        }
        
        System.out.println("\nTempos Aleatório: \n");
        for(int i = 0; i< tempoAleatorio.length ; i++){
            System.out.print(tempoAleatorio[i]+" ");
            totalAleatorio += tempoAleatorio[i];
        }
         
        
        
        System.out.println("I/O: \nTotal: " + totalIO +"\n Média:¨"+totalIO/tempoIO.length );
        System.out.println("Aleatorio: \nTotal: " + totalAleatorio +"\n Média:¨"+totalAleatorio/tempoAleatorio.length );
    }
}
