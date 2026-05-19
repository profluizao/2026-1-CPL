package Engine; 
public class CifraCesar { 
 
    private static final int CHAVE = 3; 
 
    /** 
     * Método para cifrar uma palavra. 
     * @param palavra Texto original a ser transformado. 
     * @return Texto cifrado. 
     */ 
    public String cifrar(String palavra) { 
        StringBuilder resultado = new StringBuilder(); 
        String textoParaProcessar = palavra.toUpperCase(); 
 
        for (int i = 0; i < textoParaProcessar.length(); i++) { 
            char caractereOriginal = textoParaProcessar.charAt(i); 
 
            // Filtramos apenas letras de A-Z para simplificar a lógica de mapeamento 
            if (caractereOriginal >= 'A' && caractereOriginal <= 'Z') { 
                // Aplicamos a fórmula: (x + n) mod 26 
                // Subtraímos 'A' para trabalhar no intervalo 0-25
                int posicaoOriginal = caractereOriginal - 'A'; 
                int novaPosicao = (posicaoOriginal + CHAVE) % 26; 
                char caractereCifrado = (char) ('A' + novaPosicao); 
                 
                resultado.append(caractereCifrado); 
            } else { 
                // Se não for letra (espaços/números), mantém o caractere original 
                resultado.append(caractereOriginal); 
            } 
        } 
        return resultado.toString(); 
    } 
 

    public String cifrar(int chave, String palavra) { 
        StringBuilder resultado = new StringBuilder(); 
        String textoParaProcessar = palavra.toUpperCase(); 
 
        for (int i = 0; i < textoParaProcessar.length(); i++) { 
            char caractereOriginal = textoParaProcessar.charAt(i); 
 
            // Filtramos apenas letras de A-Z para simplificar a lógica de mapeamento 
            if (caractereOriginal >= 'A' && caractereOriginal <= 'Z') { 
                // Aplicamos a fórmula: (x + n) mod 26 
                // Subtraímos 'A' para trabalhar no intervalo 0-25
                int posicaoOriginal = caractereOriginal - 'A'; 
                int novaPosicao = (posicaoOriginal + chave) % 26; 
                char caractereCifrado = (char) ('A' + novaPosicao); 
                 
                resultado.append(caractereCifrado); 
            } else { 
                // Se não for letra (espaços/números), mantém o caractere original 
                resultado.append(caractereOriginal); 
            } 
        } 
        return resultado.toString(); 
    } 



    /** 
     * Método para decifrar uma palavra. 
     * @param palavra Texto cifrado. 
     * @return Texto original restaurado. 
     */ 
    public String decifrar(String palavra) { 
        StringBuilder resultado = new StringBuilder(); 
        String textoParaProcessar = palavra.toUpperCase(); 
 
        for (int i = 0; i < textoParaProcessar.length(); i++) { 
            char caractereCifrado = textoParaProcessar.charAt(i); 
 
            if (caractereCifrado >= 'A' && caractereCifrado <= 'Z') { 
                // Aplicamos a fórmula inversa: (x - n) mod 26 
                int posicaoCifrada = caractereCifrado - 'A'; 
                 
                // Em Java, o operador % pode retornar negativo se o resultado for negativo. 
                // Somamos 26 antes do módulo para garantir um resultado positivo. 
                int novaPosicao = (posicaoCifrada - CHAVE + 26) % 26; 
                char caractereOriginal = (char) ('A' + novaPosicao); 
                 
                resultado.append(caractereOriginal); 
            } else { 
                resultado.append(caractereCifrado); 
            } 
        } 
        return resultado.toString();
    }
    
    public String decifrar(int chave, String palavra){
        StringBuilder resultado = new StringBuilder(); 
        String textoParaProcessar = palavra.toUpperCase(); 
 
        for (int i = 0; i < textoParaProcessar.length(); i++) { 
            char caractereCifrado = textoParaProcessar.charAt(i); 
 
            if (caractereCifrado >= 'A' && caractereCifrado <= 'Z') { 
                // Aplicamos a fórmula inversa: (x - n) mod 26 
                int posicaoCifrada = caractereCifrado - 'A'; 
                 
                // Em Java, o operador % pode retornar negativo se o resultado for negativo. 
                // Somamos 26 antes do módulo para garantir um resultado positivo. 
                int novaPosicao = (posicaoCifrada - chave + 26) % 26; 
                char caractereOriginal = (char) ('A' + novaPosicao); 
                 
                resultado.append(caractereOriginal); 
            } else { 
                resultado.append(caractereCifrado); 
            } 
        } 
        return resultado.toString(); 

    }
} 