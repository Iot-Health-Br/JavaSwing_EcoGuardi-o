package Tela;

import Controle.AnalistControle;
import Modelo.AnalistModelo;
import Persistencia.AnalistDao;
import Persistencia.IAnalistDao;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class AnalistView extends javax.swing.JFrame {
    JPanel panelMain;
    private JTextField txt_Rua;
    private JTable tabelaDenuncia;
    private JComboBox CB_Sigilo;
    private JComboBox CB_Municipio;
    private JTextField txt_Bairro;
    private JTextField txt_Cep;
    private JTextField txt_Referencia;
    private JTextArea TA_Descricao;
    private JComboBox CB_Categoria;
    private JTextField txt_Autor;
    private JButton btn_Novo;
    private JButton btn_Salvar;
    private JButton btn_Foto;
    private JTextArea TA_Atualizacao;
    private JComboBox CB_Status;
    private JButton SAIRButton;
    private JFormattedTextField txt_Data;
    private JFormattedTextField txt_Latitude;
    private JFormattedTextField txt_Longitude;
    private JPanel JPanelTabela;
    private JLabel label_Foto1;
    private JPanel JPanel_Foto1;
    private JLabel label_Foto2;
    private JPanel JPanel_Foto2;
    private JFormattedTextField txt_Protocolo;

    IAnalistDao pessoaDao = new AnalistDao();
    DefaultTableModel tableModel = (DefaultTableModel) tabelaDenuncia.getModel();


    // Data no formato sql, para salvar no banco de dados e apresentar na tela de usuário
    java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.now());

    public AnalistView() {
        IniciarTela();

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
        btn_Salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tabelaDenuncia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int selectedRow = tabelaDenuncia.getSelectedRow();
                String protocolo = "";

                if (selectedRow != -1) {
                    protocolo = (String) tabelaDenuncia.getValueAt(selectedRow, 0);
                    String pessoaSelecionada = (String) tabelaDenuncia.getValueAt(selectedRow, 1);
                    txt_Protocolo.setText(pessoaSelecionada);}

                AnalistControle controle = new AnalistControle(pessoaDao, tableModel);

                AnalistModelo foto = controle.buscarPorNome(protocolo);

                /*if (foto != null) {
                    ImageIcon image = new ImageIcon(foto.getImagemBytes());
                    // Carregar a imagem
                    Image imag = image.getImage();
                    Image scaledImage = imag.getScaledInstance(label_Foto1.getWidth(), label_Foto1.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);

                    // Definir o ícone do JLabel
                    label_Foto1.setIcon(scaledIcon);}
                else {
                    JOptionPane.showMessageDialog(null, "Pessoa não encontrada!");}*/
            }
        });
    }


    public void IniciarTela() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = formatter.format(sqlDate);
        txt_Data.setText(dateString);
        txt_Data.setEditable(false);
        txt_Data.setEnabled(false);
        TA_Atualizacao.setEditable(false);
        TA_Atualizacao.setEnabled(false);

        //Tabela
        tabelaDenuncia.setModel(new DefaultTableModel(
                null,
                new String[]{"protocolo","data","status","sigilo","categoria"}
        ));
        TableColumnModel column = tabelaDenuncia.getColumnModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        column.getColumn(0).setMinWidth(5);
        column.getColumn(0).setCellRenderer(centerRenderer);
        column.getColumn(1).setCellRenderer(centerRenderer);
        column.getColumn(2).setCellRenderer(centerRenderer);
        column.getColumn(3).setCellRenderer(centerRenderer);
        column.getColumn(4).setCellRenderer(centerRenderer);

        DefaultTableModel tableModel = (DefaultTableModel) tabelaDenuncia.getModel();
        // Limpar dados existentes na tabela
        tableModel.setRowCount(0);
        // Obter lista de Pessoas do banco de dados
        List<AnalistModelo> pessoas = pessoaDao.listarDenuncia();
        // Preencher tabela com os dados das Pessoas
        for (AnalistModelo denunciou : pessoas) {
            Object[] rowData = {denunciou.getProtocolo(), denunciou.getData(), denunciou.getStatus(),denunciou.getSigilo(),denunciou.getCategoria()};
            tableModel.addRow(rowData);}

        TitledBorder Tabela = BorderFactory.createTitledBorder("Status das Denuncias");
        JPanelTabela.setBorder(Tabela);
    }

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnalistView frame = new AnalistView();
                frame.setTitle("EcoGuardian - Gestão de Denuncias");
                frame.setContentPane(frame.panelMain);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
    }
}
