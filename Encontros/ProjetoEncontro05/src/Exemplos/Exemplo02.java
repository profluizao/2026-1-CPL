package Exemplos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exemplo02 extends BaseExemplo {

    @Override
    public void executar(){
        String texto = "João tem 25 anos e comprou 3 livros por 120 reais.";

        // Devemos identificar: 
        // 25 
        // 3 
        // 120

        // Expressão regular para números
        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println("A string analisada é: " + texto);
        System.out.println("Números encontrados no texto:");
        // Cada chamada de find():
        //     - procura a próxima ocorrência
        //     - move o cursor interno do matcher
        // Conceitualmente:
        //     texto → varrido da esquerda para direita
        //     regex → padrão procurado
        //     matcher → scanner
        while (matcher.find()) {
            // O método group() retorna o trecho da string que correspondeu à regex.
            System.out.println(matcher.group());
        }          
    }
    
}
