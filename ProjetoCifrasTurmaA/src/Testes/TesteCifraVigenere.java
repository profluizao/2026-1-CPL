package Testes;

import Engine.CifraVigenere;

public class TesteCifraVigenere {

    public static void executar(){
        CifraVigenere algoritmo = new CifraVigenere();
        String teste = "COMPILADORES";
        
        String res = algoritmo.cifrar(teste);
        System.out.println("Original: " + teste);
        System.out.println("Cifrado:  " + res);
        System.out.println("Decifrado: " + algoritmo.decifrar(res));
    }
}
