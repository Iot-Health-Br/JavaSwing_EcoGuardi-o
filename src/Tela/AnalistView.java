package Tela;

import javax.swing.*;

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
    private JButton button1;
    private JTable table1;

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
