package Exemplos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exemplo03 extends BaseExemplo{

    @Override
    public void executar(){
        String texto = "A prova será realizada em 15/03/2025 no laboratório.";
        
        // Expressão regular com grupos de captura
        String regex = "(\\d{2})/(\\d{2})/(\\d{4})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println("A string analisada é: " + texto);
        if (matcher.find()) {
            System.out.println("Data encontrada!");
            System.out.println("Dia: " + matcher.group(1));
            System.out.println("Mês: " + matcher.group(2));
            System.out.println("Ano: " + matcher.group(3));
        }
    }

    public void executarOutraVersao(){
        String texto = "Provas: 10/03/2025 e 25/03/2025.";
        
        // Expressão regular com grupos de captura
        String regex = "(\\d{2})/(\\d{2})/(\\d{4})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println("A string analisada é: " + texto);
        while (matcher.find()) {
            System.out.println("Data encontrada!");
            System.out.println("Dia: " + matcher.group(1));
            System.out.println("Mês: " + matcher.group(2));
            System.out.println("Ano: " + matcher.group(3));
            
        }
    }    
}
