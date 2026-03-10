package Exemplos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exemplo01 extends BaseExemplo {

    @Override
    public void executar(){
        // Texto que será analisado
        String texto = "12345";

        // Expressão regular: apenas números
        String regex = "^[0-9]+$";

        // Responsável por compilar a expressão regular.
        // Objetivo é transformar a regex em um autômato interno que reconhece o padrão.
        Pattern pattern = Pattern.compile(regex);

        // O Matcher aplica o padrão sobre uma cadeia de entrada.
        // O conceito aqui é:
        //     regex → autômato
        //     texto → cadeia
        //     matcher → processo de reconhecimento        
        Matcher matcher = pattern.matcher(texto);

        // Verificação de correspondência
        // Retorna:
        //     true → string inteira corresponde ao padrão
        //     false → não corresponde
        System.out.println("A string analisada é: " + texto);
        if (matcher.matches()) {
            System.out.println("A string contém apenas números.");
        } else {
            System.out.println("A string contém outros caracteres.");
        }
    }
    
}
