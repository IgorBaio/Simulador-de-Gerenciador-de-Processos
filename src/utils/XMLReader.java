package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Processo;
import model.ProcessoCpu;
import model.ProcessoIO;

public class XMLReader {

    private XStream xstream;

    public XMLReader() {
        xstream = new XStream(new DomDriver());
        xstream.setupDefaultSecurity(xstream);
        Class[] classes = new Class[] {Processo.class, ProcessoIO.class, ProcessoCpu.class};
        xstream.allowTypes(classes);
        xstream.alias("processo", model.Processo.class);
        xstream.alias("processo", model.ProcessoIO.class);
        xstream.alias("processo", model.ProcessoCpu.class);
    }

    public void salvar(ArrayList<Processo> processos, String name) {
        String xml = xstream.toXML(processos);

        try {

            Writer wr = new FileWriter("xml/" + name + ".xml");
            wr.write(xml);
            wr.flush();
            wr.close();

        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo");
        }

    }

    public ArrayList<Processo> ler(String name) {
        try {
            FileReader fileReader = new FileReader("xml/" + name +".xml"); 
            ArrayList<Processo> processos = (ArrayList<Processo>) this.xstream.fromXML(fileReader);
            return processos;

        } catch (IOException ex) {
            System.out.println("Erro ao ler o arquivo");
        }
        
       return null;
    }
}
