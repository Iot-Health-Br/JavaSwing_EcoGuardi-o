package Tela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CreateLoginView {
    private JTextField txt_Nome;
    private JPasswordField txt_Senha1;
    private JPasswordField txt_Senha2;
    private JPasswordField txt_CPF;
    private JButton btn_Novo;
    private JButton btn_Salvar;
    private JButton btn_Voltar;
    private JRadioButton usuárioRadioButton;
    private JRadioButton analistaRadioButton;

    public String user = "";
    public String analist = "";

    public void limparCampos(){
        txt_Nome.setText("");
        txt_CPF.setText("");
        txt_Senha1.setText("");
        txt_Senha2.setText("");
        usuárioRadioButton.setAction(null);
        analistaRadioButton.setAction(null);
    }

    public CreateLoginView() {
        usuárioRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = "USUARIO";
            }
        });
        analistaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!analistaRadioButton.equals(null)){
                    JOptionPane.showMessageDialog(null, "Digite a senha de ADM");
                }
                analist = "ANALISTA";
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
                        JOptionPane.showMessageDialog(null, "As senhas não condizem !");}
                    else if (!usuárioRadioButton.equals(null)){
                        String nome = txt_Nome.getText();
                        String cpf = Arrays.toString(txt_CPF.getPassword());
                        String senha = Arrays.toString(txt_Senha1.getPassword());

                        JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso !");
                        limparCampos();}
                }
                catch (Exception erro){}
            }
        });
        btn_Voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
