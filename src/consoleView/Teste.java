package consoleView;

import java.util.ArrayList;
import utils.CriaProcessos;
import utils.XMLReader;
import model.*;

public class Teste {

    public static void main(String[] args) {

        //Cria objeto leitor pra lidar com os xml
        XMLReader leitor = new XMLReader();

        //Exemplo de como salvar a lista
        
        //Cria a lista de processos (quant, porcentIO)
        ArrayList<Processo> lista = CriaProcessos.CriarProcessosPorcentagemCpu(200, 50);
        
        //Passa a lista e o nome do arquivo que quer salvar;
        leitor.salvar(lista, "teste1");
        
        
        //Exemplo de como ler o arquivo
        //Passa o nome do arquivo que quer ler
        leitor.ler("teste");
        
        
        //Obs: Arquivos vão ser salvos na pasta xml dentro da raiz do projeto e todos eles já vão estar com a extensão de xml
        
    }

}
