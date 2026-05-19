package Engine;

public class CifraRC4 {
private static final String CHAVE = "UNIDERP2026";

    /**
     * No RC4, o processo de cifrar e decifrar é idêntico devido à operação XOR.
     * @param dados Dados(byte) de entrada (claro ou cifrado).
     * @return Dados processados.
     */
    public byte[] processar(byte[] dados) {
        int[] s = inicializarKSA(CHAVE.getBytes());
        byte[] saida = new byte[dados.length];

        int i = 0, j = 0;

        for (int k = 0; k < dados.length; k++) {
            i = (i + 1) % 256;
            j = (j + s[i]) % 256;

            // Swap
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            int t = (s[i] + s[j]) % 256;
            int valorK = s[t];

            // Operação XOR
            saida[k] = (byte) (dados[k] ^ valorK);
        }

        return saida;
    }



    public byte[] processar(String chaveco, byte[] dados) {
        int[] s = inicializarKSA(chaveco.getBytes());
        byte[] saida = new byte[dados.length];

        int i = 0, j = 0;

        for (int k = 0; k < dados.length; k++) {
            i = (i + 1) % 256;
            j = (j + s[i]) % 256;

            // Swap
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            int t = (s[i] + s[j]) % 256;
            int valorK = s[t];

            // Operação XOR
            saida[k] = (byte) (dados[k] ^ valorK);
        }

        return saida;
    }





    private int[] inicializarKSA(byte[] chave) {
        int[] s = new int[256];
        for (int i = 0; i < 256; i++) s[i] = i;

        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + s[i] + (chave[i % chave.length] & 0xFF)) % 256;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        return s;
    }
}
