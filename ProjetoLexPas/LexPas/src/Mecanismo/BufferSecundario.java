package Mecanismo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Dominio.TabelaSimboloLinguagem;
import Dominio.Token;
import Dominio.TokenType;

public class BufferSecundario {
    private ArrayList<String> bufferPrimario;

    private ArrayList<Token> bufferSecundario;

    public ArrayList<Token> getBufferSecundario(){
        return this.bufferSecundario;
    }

    public BufferSecundario(ArrayList<String> buffer){
        this.bufferPrimario = buffer;
    }

    private Boolean IsCharacter(String valor){
        Pattern patt = Pattern.compile(PadroesLexicos.CHARACTER);
        Matcher mat = patt.matcher(valor);
        return mat.find();
    }

    private Boolean IsIdentifier(String valor){
        Pattern patt = Pattern.compile(PadroesLexicos.IDENTIFIER);
        Matcher mat = patt.matcher(valor);
        return mat.find();
    }

    private Boolean IsLiteral(String valor){
        Pattern patt = Pattern.compile(PadroesLexicos.LITERAL);
        Matcher mat = patt.matcher(valor);
        return mat.find();
    }

    private Boolean IsNumber(String valor){
        Pattern patt = Pattern.compile(PadroesLexicos.NUMBER);
        Matcher mat = patt.matcher(valor);
        return mat.find();
    }

    public void processarBufferSecundario(){
        String capture = 
                        PadroesLexicos.COMMENT + "|" +
                        PadroesLexicos.NUMBER + "|" +
                        PadroesLexicos.LITERAL + "|" + 
                        PadroesLexicos.WORDS + "|" + 
                        PadroesLexicos.CHARACTER;
        
        this.bufferSecundario = new ArrayList<>();

        ArrayList<String> lexemasProcessados = new ArrayList<>();

        Pattern patt = Pattern.compile(capture);

        int linha = 1;

        for (String texto : bufferPrimario) {
            Matcher mat = patt.matcher(texto);
            Token valor = null;
            while(mat.find()){
                String lexema = mat.group();
                int posicao = mat.start();

                if ((lexema.startsWith("//")) || (lexema.startsWith("(*"))){
                    continue;
                }

                if (lexemasProcessados.contains(lexema) == false){
                    lexemasProcessados.add(lexema);

                    if (TabelaSimboloLinguagem.contem(lexema)){
                        TokenType tipo = TabelaSimboloLinguagem.buscar(lexema);
                        valor = new Token(tipo, lexema, linha, posicao);
                    }
                    else if (this.IsCharacter(lexema)){
                        valor = new Token(TokenType.CHARACTER, lexema, linha, posicao);
                    }
                    else if (this.IsIdentifier(lexema)){
                        valor = new Token(TokenType.IDENTIFIER, lexema, linha, posicao);
                    }
                    else if (this.IsLiteral(lexema)){
                        valor = new Token(TokenType.LITERAL, lexema, linha, posicao);
                    }
                    else if (this.IsNumber(lexema)){
                        valor = new Token(TokenType.NUMBER, lexema, linha, posicao);
                    }
                    else{
                        valor = new Token(TokenType.UNKNOWN, lexema, linha, posicao);
                    }
                    this.bufferSecundario.add(valor);
                }
            }
            linha++;
        }
    }

    public void imprimirConteudoBufferSecundario(Boolean flag){
        if (flag == true){
            System.out.println("-------------------------------------");
            System.out.println("### Conteúdo do Buffer Secundário ###");
            for (Token tk : this.bufferSecundario) {
                System.out.println(tk);
            }
            System.out.println("-------------------------------------");
        }
    }
}
