package Tela;

import Controle.Create_Controle;
import Controle.ICreate_Controle;
import Modelo.Create_Modelo;
import Persistencia.Create_Dao;
import Persistencia.ICreate_Dao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CreateLoginView extends JFrame{
    private JTextField txt_Nome;
    private JPasswordField txt_Senha1;
    private JPasswordField txt_Senha2;
    private JPasswordField txt_CPF;
    private JButton btn_Novo;
    private JButton btn_Salvar;
    private JButton btn_Voltar;
    private JRadioButton usuárioRadioButton;
    private JRadioButton analistaRadioButton;
    JPanel panelMain;

    public String funcao = "";

    public void limparCampos(){
        funcao = "";
        txt_Nome.setText("");
        txt_CPF.setText("");
        txt_Senha1.setText("");
        txt_Senha2.setText("");
        //usuárioRadioButton.setSelected(false);
        //analistaRadioButton.setSelected(false);
    }

    public CreateLoginView() {
        usuárioRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcao = "USUARIO";
            }
        });
        analistaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcao = "ANALISTA";
            }
        });
        btn_Novo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        btn_Salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String senha1 = Arrays.toString(txt_Senha1.getPassword());
                    String senha2 = Arrays.toString(txt_Senha2.getPassword());

                    if (txt_Nome.getText().equals("")||txt_CPF.getText().equals("")||txt_Senha1.getPassword().equals("")
                            ||txt_Senha2.getPassword().equals("")||analistaRadioButton.equals(null)||usuárioRadioButton.equals(null)){
                                JOptionPane.showMessageDialog(null, "Campos Vazios");}
                    else if (!senha1.equals(senha2)) {
                        txt_Senha1.setText("");
                        txt_Senha2.setText("");
                        JOptionPane.showMessageDialog(null, "As Senhas não Condizem !");}
                    else {
                        Create_Modelo usuario = new Create_Modelo(txt_Nome.getText().toUpperCase(),txt_CPF.getText(),funcao,txt_Senha1.getText());
                        ICreate_Controle controle = new Create_Controle(new Create_Dao());
                        boolean sucesso = controle.adicionarPessoa(usuario);
                            if (sucesso) {
                                JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso");}
                            else {
                                JOptionPane.showMessageDialog(null, "Erro ao Cadastrar o usuário");}
                                limparCampos();}
                }
                catch (Exception erro){}
            }
        });
        btn_Voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchLoginView novoLogin = new SearchLoginView();
                novoLogin.setTitle("EcoGuardian - Tela de Login");
                novoLogin.setContentPane(novoLogin.panelMainL);
                novoLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                novoLogin.setVisible(true); // Torna o novo JFrame visível
                // Fecha o JFrame 'login'
                CreateLoginView.this.dispose(); // 'login' é a instância do seu JFrame atual
            }
        });
    }
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateLoginView frame = new CreateLoginView();
                frame.setTitle("EcoGuardian - Tela de Cadastro");
                frame.setContentPane(frame.panelMain);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
    }
}
