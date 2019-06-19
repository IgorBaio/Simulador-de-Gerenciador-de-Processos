package consoleView;

import java.util.ArrayList;
import java.util.Scanner;
import model.CPU;
import model.Processo;
import model.escalonadores.Escalonador;
import model.escalonadores.EscalonadorAleatorio;
import model.escalonadores.EscalonadorPrioridadeIO;
import utils.CriaProcessos;
import utils.Relatorio;
import utils.XMLReader;

public class Principal {

    private static Scanner scanf = new Scanner(System.in);
    private static ArrayList<Processo> listaProcesso;
    private static Escalonador esca;

    public static void main(String[] args) {
        boolean menu = true;
        while (menu) {
            imprimeMenu();
            int opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    criarCargaProcesso();
                    break;
                case 2:
                    lerCargaProcesso();
                    break;
                case 3:
                    escalonar();
                    break;
                case 4:
                    relatorio();
                    break;
                case 5:
                    menu = false;
                    break;
            }
        }

    }

    public static void imprimeMenu() {
        System.out.println("***************");
        System.out.println("1 - Criar nova carga de processo");
        System.out.println("2 - Ler uma caga de processo");
        System.out.println("3 - Escalonar Carga selecionada");
        System.out.println("4 - Relatório");
        System.out.println("5 - Sair");
        System.out.println("***************");
    }

    public static int lerOpcao() {
        System.out.println("Digite a opcao desejada: ");
        int opcao = scanf.nextInt();
        return opcao;
    }

    public static void criarCargaProcesso() {
        System.out.println("Quantos deseja criar? ");
        int decisaoProc = scanf.nextInt();

        System.out.println("Qual a porcentagem que deseja de CPUs? ");
        int porcent = scanf.nextInt();

        //Cria objeto leitor pra lidar com os xml
        XMLReader leitorXml = new XMLReader();
        //Cria a lista de processos (quant, porcentIO)
        ArrayList<Processo> lista = CriaProcessos.CriarProcessosPorcentagemCpu(decisaoProc, porcent);
        //Passa a lista e o nome do arquivo que quer salvar;

        System.out.println("Digite o nome do arquivo .xml que deseja");
        String nomeArquivo = scanf.next();
        leitorXml.salvar(lista, nomeArquivo);

    }

    public static void lerCargaProcesso() {
        System.out.println("Digite o nome do arquivo .xml que deseja ler");
        String nomeArquivo = scanf.next();
        XMLReader leitorXml = new XMLReader();
        listaProcesso = leitorXml.ler(nomeArquivo);
    }

    public static boolean escalonar() {
        if (listaProcesso == null) {
            System.out.println("Por favor leia ou crie uma carga antes de escalonar");
            return false;
        } else {
            CPU cpu = new CPU(escolherEscalonador());
            int resultado = cpu.calcularResultadoProcessado();
        
            System.out.println("Tempo gasto no escalonamento: " + resultado);
            return true;
        }
    }

    public static Escalonador escolherEscalonador() {
        System.out.println("1 - Escalonador Aleatorio");
        System.out.println("2 - Escalonador por Prioridade de IO");
        Escalonador escalonador;

        while (true) {
            int opcao = scanf.nextInt();
            if (opcao == 1) {
                escalonador = new EscalonadorAleatorio(listaProcesso);
                break;
            } else if (opcao == 2) {
                escalonador = new EscalonadorPrioridadeIO(listaProcesso);
                break;
            } else {
                System.out.println("Digite uma opcao correta!");
            }
        }

        return escalonador;
    }
    
    public static void relatorio(){
        System.out.println("Digite quantas repetições: ");
        int repeticao = scanf.nextInt();
        
        System.out.println("Nome do arquivo: ");
        String nome = scanf.next();
        
        Relatorio relatorio = new Relatorio();
        relatorio.rodarMultiplos(repeticao, nome);
    }
    
}
