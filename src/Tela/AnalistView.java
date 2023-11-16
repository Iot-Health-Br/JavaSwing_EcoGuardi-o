package Tela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnalistView extends JFrame {
    JPanel panelMainA;
    private JTextArea textArea1;
    private JComboBox comboBox3;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JButton NOVOButton;
    private JTextField textField1;
    private JTextField textField3;
    private JComboBox comboBox2;
    private JTextField textField5;
    private JPasswordField passwordField2;
    private JTextField textField6;
    private JButton FOTOSButton;
    private JTextArea textArea2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField3;
    private JButton SALVARButton;
    private JComboBox comboBox4;
    private JTable table1;
    private JButton SAIRButton;
    private JButton VOLTARButton;

    public AnalistView() {
        SAIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchLoginView novoLogin = new SearchLoginView();
                novoLogin.setTitle("EcoGuardian - Tela de Cadastro");
                novoLogin.setContentPane(novoLogin.panelMainL);
                novoLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                novoLogin.setVisible(true); // Torna o novo JFrame visível
                // Fecha o JFrame 'login'
                AnalistView.this.dispose(); // 'login' é a instância do seu JFrame atual
            }
        });
    }

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnalistView frame = new AnalistView();
                frame.setTitle("EcoGuardian - Gestão de Denuncias");
                frame.setContentPane(frame.panelMainA);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
    }
}
