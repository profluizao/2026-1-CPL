import Engine.CifraCesar;
import Engine.CifraRC4;
import Engine.CifraVigenere;

public class Gabarito {
    public static void resolverPista01(int chave, String cifrada){
        CifraCesar cifra = new CifraCesar();
        String decifrada= cifra.decifrar(5, cifrada);
        System.out.println("Cifrada: " + cifrada);
        System.out.println("Decifrada: " + decifrada);
    }

    public static void resolverPista02(String chave, String cifrada){
        CifraVigenere cifra = new CifraVigenere();
        String decifrada = cifra.decifrar(chave, cifrada);
        System.out.println("Cifrada: " + cifrada);
        System.out.println("Decifrada: " + decifrada);      
    }

    public static void resolverPista03(String chave, String bytesStr){
        CifraRC4 cifra = new CifraRC4();
        byte[] cifradaBytes = hexToBytes(bytesStr);
        byte[] decifradoBytes = cifra.processar(chave, cifradaBytes); 
        String decifrada = new String(decifradoBytes);
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
    
    public static byte[] hexToBytes(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }    
}
