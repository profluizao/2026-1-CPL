package Exibicao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Dominio.Token;
import Mecanismo.Processamento;

public class TelaAnalisadorLexico extends JFrame {

    private JTextArea txtCodigoFonte;
    private JTable tblTokens;
    private DefaultTableModel modeloTabela;
    private JButton btnAnalisar;
    private Processamento processador;

    public TelaAnalisadorLexico() {
        processador = new Processamento();
        configurarJanela();
        inicializarComponentes();
    }

    private void configurarJanela() {
        setTitle("Analisador Léxico - Demonstração Acadêmica");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a tela
        setLayout(new BorderLayout(10, 10));
    }

    private void inicializarComponentes() {
        // --- PAINEL ESQUERDO: Código Fonte ---
        JPanel painelEsquerdo = new JPanel(new BorderLayout(5, 5));
        painelEsquerdo.setBorder(BorderFactory.createTitledBorder("Código Fonte (Pascal)"));
        
        txtCodigoFonte = new JTextArea();
        txtCodigoFonte.setFont(new Font("Monospaced", Font.PLAIN, 14));
        // Exemplo inicial padrão para os alunos testarem
        txtCodigoFonte.setText("program Exemplo;\nvar\n  x : integer;\nbegin\n  x := 10;\n  if x >= 10 then\n    writeln('Sucesso');\nend.");
        
        JScrollPane scrollCodigo = new JScrollPane(txtCodigoFonte);
        painelEsquerdo.add(scrollCodigo, BorderLayout.CENTER);

        // --- PAINEL DIREITO: Tabela de Símbolos ---
        JPanel painelDireito = new JPanel(new BorderLayout(5, 5));
        painelDireito.setBorder(BorderFactory.createTitledBorder("Tabela de Símbolos Resultante"));

        // Colunas baseadas nos atributos da sua classe Token
        String[] colunas = {"Lexema", "Tipo Identificado", "Linha", "Posição"};
        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Evita que o aluno edite os tokens na tabela
            }
        };

        tblTokens = new JTable(modeloTabela);
        tblTokens.setFillsViewportHeight(true);
        JScrollPane scrollTabela = new JScrollPane(tblTokens);
        painelDireito.add(scrollTabela, BorderLayout.CENTER);

        // --- DIVISOR CENTRAL (Split Pane) ---
        JSplitPane divisor = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelEsquerdo, painelDireito);
        divisor.setDividerLocation(400); // Define largura inicial do lado esquerdo
        divisor.setResizeWeight(0.5);    // Distribui o redimensionamento igualmente
        add(divisor, BorderLayout.CENTER);

        // --- PAINEL INFERIOR: Botão de Ação ---
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAnalisar = new JButton("Analisar Código");
        btnAnalisar.setFont(new Font("Arial", Font.BOLD, 14));
        btnAnalisar.setBackground(new Color(46, 139, 87)); // Verde escuro profissional
        btnAnalisar.setForeground(Color.WHITE);
        btnAnalisar.setFocusPainted(false);
        
        btnAnalisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executarAnaliseLexica();
            }
        });
        
        painelInferior.add(btnAnalisar);
        add(painelInferior, BorderLayout.SOUTH);
    }

    private void executarAnaliseLexica() {
        String codigo = txtCodigoFonte.getText();
        
        if (codigo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira algum código para analisar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Limpa a tabela antes da nova análise
        modeloTabela.setRowCount(0);

        // Processa o texto da JTextArea utilizando o mecanismo existente
        ArrayList<Token> tokens = processador.prepararTabelaSimbolosDaString(codigo);

        // Alimenta o JTable com a lista retornada do Buffer Secundário
        for (Token token : tokens) {
            Object[] linha = {
                token.getLexema(),
                token.getTipo(),
                token.getLinha(),
                token.getPosicao()
            };
            modeloTabela.addRow(linha);
        }
    }
}