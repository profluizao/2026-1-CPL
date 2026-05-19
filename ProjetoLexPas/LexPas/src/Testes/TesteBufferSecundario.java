package Testes;

import java.io.BufferedReader;
import java.util.ArrayList;

import Mecanismo.BufferPrimario;
import Mecanismo.BufferSecundario;
import Mecanismo.LeitorDeArquivo;

public class TesteBufferSecundario {
    public static void executar(){
        LeitorDeArquivo leitor = new LeitorDeArquivo();
        String caminho = "C:\\Temp\\exemplo.txt";
        //String caminho = "/home/colossus/Documents/GitHub/2026-1-CPL/ProjetoLexPas/LexPas/src/Temp/exemplo.pas";
        leitor.carregarArquivoParaLeitor(caminho);
        leitor.importarArquivoParaLeitor();

        BufferedReader br = leitor.getLeitor();
        BufferPrimario bfp = new BufferPrimario(br);
        bfp.processarArquivoNoBufferPrimario();
        bfp.imprimirConteudoDoBufferPrimario(true);

        ArrayList<String> buffer = bfp.getBufferPrimario();
        BufferSecundario bfs = new BufferSecundario(buffer);
        bfs.processarBufferSecundario();
        bfs.imprimirConteudoBufferSecundario(true);
    }    
}
