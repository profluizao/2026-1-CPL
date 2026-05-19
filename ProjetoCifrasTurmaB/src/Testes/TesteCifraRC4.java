package Testes;

import Engine.CifraRC4; 
 
public class TesteCifraRC4 { 
    public static void executar(){ 
        CifraRC4 algoritmo = new CifraRC4(); 
        String originalStr = "COMPILADORES"; 
        byte[] originalBytes = originalStr.getBytes(); 
 
        // 1. Cifragem 
        byte[] cifrado = algoritmo.processar(originalBytes); 
         
        // 2. Decifragem (passando os bytes cifrados de volta) 
        byte[] decifradoBytes = algoritmo.processar(cifrado); 
        String resultadoFinal = new String(decifradoBytes); 
 
        System.out.println("Original:  " + originalStr); 
        System.out.println("Cifrado (Hex): " + bytesParaHex(cifrado)); 
        System.out.println("Decifrado: " + resultadoFinal);     
    } 
 
    // Método auxiliar para exibir os bytes de forma legível 
    private static String bytesParaHex(byte[] bytes) { 
        StringBuilder sb = new StringBuilder(); 
        for (byte b : bytes) { 
            sb.append(String.format("%02X ", b)); 
        } 
        return sb.toString(); 
    }     
} 
