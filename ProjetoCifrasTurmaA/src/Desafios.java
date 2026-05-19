import Engine.*;

public class Desafios {

    public static void resolver(){
        resolverVigenere();
        resolverRC4();
        resolverCesar();
    }

    private static void resolverVigenere(){

        CifraVigenere algoritmo = new CifraVigenere();
        String chave = "MXLINUX";
        String teste = "H_A_C_K_E_R";

        String res = algoritmo.cifrar(chave, teste);
        System.out.println("Original: " + teste);
        System.out.println("Cifrado:  " + res);
        System.out.println("Decifrado: " + algoritmo.decifrar(chave, res));

        System.out.println("-----------------------------------------------------------------------");
        //String cifrado = "T_X_N_S_R_L";        
    }






    private static void resolverRC4(){
        CifraRC4 algoritmo = new CifraRC4();
        String originalStr = "RESERVA";
        byte[] originalBytes = originalStr.getBytes();

        // 1. Cifragem
        byte[] cifrado = algoritmo.processar("HACKER", originalBytes);
        
        // 2. Decifragem (passando os bytes cifrados de volta)
        byte[] decifradoBytes = algoritmo.processar("HACKER", cifrado);
        String resultadoFinal = new String(decifradoBytes);

        System.out.println("Original:  " + originalStr);
        System.out.println("Cifrado (Hex): " + bytesParaHex(cifrado));
        System.out.println("Decifrado: " + resultadoFinal);    
        System.out.println("-----------------------------------------------------------------------");
        //B1 F4 C6 6C F6 7D 4F
    }

    // Método auxiliar para exibir os bytes de forma legível
    private static String bytesParaHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }


    private static void resolverCesar(){
        CifraCesar algoritmo = new CifraCesar();
        String teste = "REITOR";
        
        int chave = 4;

        String cifrado = algoritmo.cifrar(chave, teste);
        String decifrado = algoritmo.decifrar(chave, cifrado);
        
        System.out.println("Original: " + teste);
        System.out.println("Cifrado:  " + cifrado);   // Saída esperada: MDYD
        System.out.println("Decifrado: " + decifrado);

        //VIMXSV
    }
}
