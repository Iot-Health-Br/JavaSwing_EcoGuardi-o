package Tela;

import Controle.ISearchControle;
import Controle.SearchControle;
import Modelo.SearchModelo;
import Persistencia.SearchDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SearchLoginView extends JFrame{
    JPanel panelMainL;
    private JTextField txt_User;
    private JPasswordField txt_Password;
    private JButton btn_login;
    private JButton esqueceuASenhaButton;
    private JButton criarLoginButton;

    public SearchLoginView() {
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SearchModelo usuario = new SearchModelo(txt_User.getText().toUpperCase(),txt_Password.getText());
                ISearchControle controle = new SearchControle(new SearchDao());
                boolean sucesso = controle.validaUsuario(usuario);

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Bem Vindo ao EcoGuardião");
                    UserView TelaUser = new UserView();
                    TelaUser.setTitle("EcoGuardian - Tela de Denuncias");
                    TelaUser.setContentPane(TelaUser.panelMain);
                    TelaUser.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    TelaUser.setVisible(true); // Torna o novo JFrame visível
                    // Fecha o JFrame 'login'
                    SearchLoginView.this.dispose();}
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
                CreateLoginView novoLogin = new CreateLoginView();
                novoLogin.setTitle("EcoGuardian - Tela de Cadastro");
                novoLogin.setContentPane(novoLogin.panelMain);
                novoLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                novoLogin.setVisible(true); // Torna o novo JFrame visível
                // Fecha o JFrame 'login'
                SearchLoginView.this.dispose(); // 'login' é a instância do seu JFrame atual
            }
        });
    }

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SearchLoginView frame = new SearchLoginView();
                frame.setTitle("EcoGuardian - Tela de Login");
                frame.setContentPane(frame.panelMainL);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
    }

}

