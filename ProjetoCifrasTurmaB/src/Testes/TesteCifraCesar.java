package Testes; 
 
import Engine.CifraCesar; 
 
public class TesteCifraCesar { 
    public static void executar() { 
        CifraCesar algoritmo = new CifraCesar(); 
        String teste = "COMPILADORES"; 
         
        String cifrado = algoritmo.cifrar(teste); 
        String decifrado = algoritmo.decifrar(cifrado);     
        System.out.println("Original: " + teste); 
        System.out.println("Cifrado:  " + cifrado);   // Saída esperada: MDYD 
        System.out.println("Decifrado: " + decifrado); 
    }     
}
