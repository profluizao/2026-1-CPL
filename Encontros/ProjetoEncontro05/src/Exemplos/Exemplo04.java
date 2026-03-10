package Exemplos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exemplo04 extends BaseExemplo{

    @Override
    public void executar(){
        String texto = "Cliente: João Silva\nCPF: 123.456.789-00";

        // Expressão regular para CPF
        String regex = "(\\d{3})\\.(\\d{3})\\.(\\d{3})-(\\d{2})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        // Substituição usando grupos capturados
        String resultado = matcher.replaceAll("***.***.***-$4");

        System.out.println("Texto original:\n");
        System.out.println(texto);

        System.out.println("\nTexto mascarado:\n");
        System.out.println(resultado);


        // Java permite fazer direto com String.replaceAll():
        // String resultado = texto.replaceAll("(\\d{3})\\.(\\d{3})\\.(\\d{3})-(\\d{2})","***.***.***-$4");        
    }
}
