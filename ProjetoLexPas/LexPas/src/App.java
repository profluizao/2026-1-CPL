import javax.swing.SwingUtilities;

import Exibicao.TelaAnalisadorLexico;
import Mecanismo.Processamento;

public class App {
    public static void main(String[] args) throws Exception {
        //exibirNoConsole();
        exibirUsandoSwing();
    }

    private static void exibirNoConsole(){
        Processamento proc = new Processamento();
        String caminho = "/home/colossus/Documents/GitHub/2026-1-CPL/ProjetoLexPas/LexPas/src/Temp/exemplo.pas";
        proc.prepararTabelaSimbolosPrograma(caminho);
        proc.imprimirTabelaSimbolosPrograma();
    }

    private static void exibirUsandoSwing(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaAnalisadorLexico tela = new TelaAnalisadorLexico();
                tela.setVisible(true);
            }
        });        
    }
}
