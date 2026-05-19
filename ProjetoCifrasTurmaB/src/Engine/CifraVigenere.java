package Engine; 
 
public class CifraVigenere { 
    private static final String CHAVE = "UNIDERP"; 
 
    /** 
     * Cifra uma palavra utilizando uma chave polialfabética. 
     */ 
    public String cifrar(String palavra) { 
        StringBuilder resultado = new StringBuilder(); 
        String texto = palavra.toUpperCase(); 
        String chave = CHAVE.toUpperCase(); 
         
        int indiceChave = 0; 
 
        for (int i = 0; i < texto.length(); i++) { 
            char c = texto.charAt(i); 
 
            if (c >= 'A' && c <= 'Z') { 
                int p = c - 'A'; 
                int k = chave.charAt(indiceChave) - 'A'; 
                 
                int cifrado = (p + k) % 26; 
                resultado.append((char) (cifrado + 'A')); 
 
                // Avança o ponteiro da chave circularmente 
                indiceChave = (indiceChave + 1) % chave.length(); 
            } else { 
                resultado.append(c); 
            } 
        } 
        return resultado.toString(); 
    } 
 
    public String cifrar(String chaveco, String palavra) { 
        StringBuilder resultado = new StringBuilder(); 
        String texto = palavra.toUpperCase(); 
        String chave = chaveco.toUpperCase(); 
         
        int indiceChave = 0; 
 
        for (int i = 0; i < texto.length(); i++) { 
            char c = texto.charAt(i); 
 
            if (c >= 'A' && c <= 'Z') { 
                int p = c - 'A'; 
                int k = chave.charAt(indiceChave) - 'A'; 
                 
                int cifrado = (p + k) % 26; 
                resultado.append((char) (cifrado + 'A')); 
 
                // Avança o ponteiro da chave circularmente 
                indiceChave = (indiceChave + 1) % chave.length(); 
            } else { 
                resultado.append(c); 
            } 
        } 
        return resultado.toString(); 
    } 

    /** 
     * Decifra uma palavra revertendo o deslocamento baseado na chave. 
     */ 
    public String decifrar(String palavra) { 
        StringBuilder resultado = new StringBuilder(); 
        String texto = palavra.toUpperCase(); 
        String chave = CHAVE.toUpperCase(); 
         
        int indiceChave = 0; 
 
        for (int i = 0; i < texto.length(); i++) { 
            char c = texto.charAt(i); 
            if (c >= 'A' && c <= 'Z') { 
                int p = c - 'A'; 
                int k = chave.charAt(indiceChave) - 'A'; 
                 
                int decifrado = (p - k + 26) % 26; 
                resultado.append((char) (decifrado + 'A')); 
 
                indiceChave = (indiceChave + 1) % chave.length(); 
            } else { 
                resultado.append(c); 
            } 
        } 
        return resultado.toString(); 
    } 

    public String decifrar(String chaveco, String palavra) { 
        StringBuilder resultado = new StringBuilder(); 
        String texto = palavra.toUpperCase(); 
        String chave = chaveco.toUpperCase(); 
         
        int indiceChave = 0; 
 
        for (int i = 0; i < texto.length(); i++) { 
            char c = texto.charAt(i); 
            if (c >= 'A' && c <= 'Z') { 
                int p = c - 'A'; 
                int k = chave.charAt(indiceChave) - 'A'; 
                 
                int decifrado = (p - k + 26) % 26; 
                resultado.append((char) (decifrado + 'A')); 
 
                indiceChave = (indiceChave + 1) % chave.length(); 
            } else { 
                resultado.append(c); 
            } 
        } 
        return resultado.toString(); 
    }
}
