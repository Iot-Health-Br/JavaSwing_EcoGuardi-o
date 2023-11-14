package Tela;

import Controle.SearchLoginControle;
import Modelo.SearchLoginModelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SearchLoginView extends javax.swing.JFrame{

    private JPanel panelMain;
    private JTextField txt_User;
    private JPasswordField txt_Password;
    private JButton btn_login;
    private JButton esqueceuASenhaButton;
    private JButton criarLoginButton;


    public SearchLoginView() {
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txt_User.getText();
                String password = Arrays.toString(txt_Password.getPassword());

                SearchLoginModelo usuario = new SearchLoginModelo(user, password);
                SearchLoginControle controle = new SearchLoginControle();

                if (controle.validaUsuario(usuario)) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");

                    UserView TelaUser = new UserView();
                    TelaUser.setVisible(true);
                    SearchLoginView.this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Usuário e Senha não encontrado !");}
            }
        });
        esqueceuASenhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        criarLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Tela de Login");
                frame.setContentPane(new SearchLoginView().panelMain);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
    }

}

