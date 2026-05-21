package Mecanismo;

import java.io.BufferedReader;
import java.util.ArrayList;

import Dominio.Token;

public class Processamento {
    private ArrayList<Token> tabelaSimbolosPrograma;
    private LeitorDeArquivo leitor;
    private ArrayList<Token> listaBufferSecundario;

    public Processamento(){

    }

    public void prepararTabelaSimbolosPrograma(String caminho){
        this.leitor = new LeitorDeArquivo();
        leitor.carregarArquivoParaLeitor(caminho);
        leitor.importarArquivoParaLeitor();
        BufferedReader rd = leitor.getLeitor();

        BufferPrimario bufferPrimario = new BufferPrimario(rd);
        bufferPrimario.processarArquivoNoBufferPrimario();
        bufferPrimario.imprimirConteudoDoBufferPrimario(false);
        ArrayList<String> listaBufferPrimario = bufferPrimario.getBufferPrimario();
        
        BufferSecundario bufferSecundario = new BufferSecundario(listaBufferPrimario);
        bufferSecundario.processarBufferSecundario();
        bufferSecundario.imprimirConteudoBufferSecundario(false);
        this.listaBufferSecundario = bufferSecundario.getBufferSecundario();

        this.tabelaSimbolosPrograma = new ArrayList<>(this.listaBufferSecundario);
    }

    public ArrayList<Token> prepararTabelaSimbolosDaString(String conteudoTexto) {
        ArrayList<String> listaBufferPrimario = new ArrayList<>();
        
        // Divide a string da tela por quebras de linha (\n ou \r\n)
        String[] linhas = conteudoTexto.split("\\r?\\n");
        for (String linha : linhas) {
            listaBufferPrimario.add(linha);
        }
        
        // Executa o seu fluxo original usando o BufferSecundario
        BufferSecundario bufferSecundario = new BufferSecundario(listaBufferPrimario);
        bufferSecundario.processarBufferSecundario();
        
        this.listaBufferSecundario = bufferSecundario.getBufferSecundario();
        this.tabelaSimbolosPrograma = new ArrayList<>(this.listaBufferSecundario);
        
        return this.tabelaSimbolosPrograma;
    }

    public void imprimirTabelaSimbolosPrograma() {
        System.out.println("\n========== TABELA DE SÍMBOLOS DO PROGRAMA ==========");
        System.out.printf("%-20s | %-15s\n", "LEXEMA", "TIPO IDENTIFICADO");
        System.out.println("----------------------------------------------------");
        
        for (Token token : this.tabelaSimbolosPrograma) {
            System.out.printf("%-20s | %-15s\n", token.getLexema(), token.getTipo());
        }
    }
    
}
