import Engine.CifraCesar;
import Engine.CifraRC4;
import Engine.CifraVigenere;

public class Resolucao {
    public static void primeiraPista(){
        CifraCesar cifra = new CifraCesar();
        String original = "ENTRADA";
        String cifrada = cifra.cifrar(5, original);
        String decifrada= cifra.decifrar(5, cifrada);
        System.out.println(original);
        System.out.println(cifrada);
        System.out.println(decifrada);

        // String cripto;
        // System.out.println();
    }

    public static void segundaPista(){
        CifraVigenere cifra = new CifraVigenere();
        String chave = "UNIDERP";
        String original = "A_MEIA_A_NOITE";        
        String cifrada = cifra.cifrar(chave, original);
        String decifrada = cifra.decifrar(chave, cifrada);
        System.out.println(original);
        System.out.println(cifrada);
        System.out.println(decifrada);
    }

    public static void terceiraPista(){
        CifraRC4 cifra = new CifraRC4();
        String chave = "ENTRADA";
        String original = "PLACAS_VIDEO";
        byte[] originalBytes = original.getBytes(); 
        byte[] cifradaBytes = cifra.processar(chave, originalBytes);
        byte[] decifradoBytes = cifra.processar(chave, cifradaBytes); 
        String decifrada = new String(decifradoBytes);

        System.out.println("Original:  " + original); 
        System.out.println("Cifrada (Hex): " + bytesParaHex(cifradaBytes)); 
        System.out.println("Decifrado: " + decifrada);
    }

    private static String bytesParaHex(byte[] bytes) { 
        StringBuilder sb = new StringBuilder(); 
        for (byte b : bytes) { 
            sb.append(String.format("%02X ", b)); 
        } 
        return sb.toString(); 
    }     
}
