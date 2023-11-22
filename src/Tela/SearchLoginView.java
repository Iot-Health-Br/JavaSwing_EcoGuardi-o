package Tela;

import Controle.ISearchControle;
import Controle.SearchControle;
import Modelo.SearchModelo;
import Modelo.UserModelo;
import Persistencia.SearchDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchLoginView extends JFrame{
    public String id;
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

                // Injeção de Depêndencia
                SearchModelo usuario = new SearchModelo(txt_User.getText().toUpperCase(),txt_Password.getText());
                ISearchControle controle = new SearchControle(new SearchDao());
                boolean sucesso = controle.validaUsuario(usuario);

                // Classe signeton, pega o id e passa para outra estrutura modelo user.
                int id = usuario.getId();
                SearchModelo.getInstance().setId(id);

                if (sucesso) {
                    String perfil = usuario.getFuncao();

                        if (perfil.equals("USUARIO")) {
                            JOptionPane.showMessageDialog(null, "Bem Vindo ao EcoGuardião"+ id);
                            UserView TelaUser = new UserView();
                            TelaUser.setTitle("EcoGuardian - Tela de Denuncias");
                            TelaUser.setContentPane(TelaUser.panelMain);
                            TelaUser.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            TelaUser.setVisible(true); // Torna o novo JFrame visível
                            // Fecha o JFrame 'login'
                            SearchLoginView.this.dispose();}

                        else if (perfil.equals("ANALISTA")){
                            JOptionPane.showMessageDialog(null, "Bem Vindo, Analista"+ id);
                            AnalistView TelaAnalista = new AnalistView();
                            TelaAnalista.setTitle("EcoGuardian - Gestão de Denuncias");
                            TelaAnalista.setContentPane(TelaAnalista.panelMainA);
                            TelaAnalista.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            TelaAnalista.setVisible(true); // Torna o novo JFrame visível
                            // Fecha o JFrame 'login'
                            SearchLoginView.this.dispose();}
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

