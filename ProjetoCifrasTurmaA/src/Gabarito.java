import Engine.CifraCesar;
import Engine.CifraRC4;
import Engine.CifraVigenere;

public class Gabarito {

    public static void resolver() {
        String chaveco = "MXLINUX";
        String cifra1 = "T_X_N_S_R_L";
        resolverVigenere(chaveco, cifra1);

        chaveco = "HACKER";
        String cifra2 = "B1F4C66CF67D4F";
        resolverRC4(chaveco, cifra2);

        int chaveca = 4;
        String cifra3 = "VIMXSV";
        resolverCesar(chaveca, cifra3);
    }

    private static void resolverVigenere(String chave, String cifrado) {
        System.out.println("### VIGENERE ###");
        CifraVigenere algoritmo = new CifraVigenere();
        System.out.println("Cifrado:  " + cifrado);
        System.out.println("Decifrado: " + algoritmo.decifrar(chave, cifrado));
    }

    private static void resolverRC4(String chave, String cifra) {
        System.out.println("### RC4 ###");
        CifraRC4 algoritmo = new CifraRC4();
        byte[] cifrado = hexToBytes(cifra);
        byte[] decifradoBytes = algoritmo.processar("HACKER", cifrado);
        String resultadoFinal = new String(decifradoBytes);
        System.out.println("Chave: " + chave);
        System.out.println("Cifrado (Hex): " + cifra);
        System.out.println("Decifrado: " + resultadoFinal);
    }

    private static void resolverCesar(int chave, String cifrado) {
        System.out.println("### CESAR ###");
        CifraCesar algoritmo = new CifraCesar();
        String decifrado = algoritmo.decifrar(chave, cifrado);
        System.out.println("Original: " + cifrado);
        System.out.println("Decifrado: " + decifrado);
    }

    private static byte[] hexToBytes(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

}
