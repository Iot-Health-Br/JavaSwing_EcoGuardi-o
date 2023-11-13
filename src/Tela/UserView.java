package Tela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends javax.swing.JFrame{
    private JPanel panelMain;
    private JTextField textField1;
    private JTable table1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField3;
    private JTextField textField5;
    private JTextField textField6;
    private JTextArea textArea1;
    private JComboBox comboBox3;
    private JPasswordField passwordField1;
    private JTextField textField2;
    private JButton NOVOButton;
    private JButton SALVARButton;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private JButton FOTOSButton;
    private JTextArea textArea2;

    public UserView() {
        FOTOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        NOVOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        SALVARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void setVisible(boolean b) {
    }

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Tela de Denuncia");
                frame.setContentPane(new UserView().panelMain);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
    }
}
