package Tela;

import Controle.AnalistControle;
import Controle.IAnalistControle;
import Modelo.AnalistModelo;
import Modelo.SearchModelo;
import Persistencia.AnalistDao;
import Persistencia.IAnalistDao;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
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
    private JButton btn_Atualizar;
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

    //Id do analista
    int userId = SearchModelo.getInstance().getId();

    IAnalistDao pessoaDao = new AnalistDao();
    DefaultTableModel tableModel = (DefaultTableModel) tabelaDenuncia.getModel();


    // Data no formato sql, para salvar no banco de dados e apresentar na tela de usuário
    java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.now());

    public AnalistView() {
        IniciarTela();
        IniciarCombox();

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
        btn_Atualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*
                if(!txt_Protocolo.getText().equals("")){
                    String nomePessoa = txt_Nome.getText().toUpperCase(); // Supondo que jTextFieldNomePessoa seja o campo de entrada para o nome da Pessoa
                    int selectedRow = tabelaPessoas.getSelectedRow();
                    if (selectedRow != -1) {
                        int idNome = (int) tabelaDenuncia.getValueAt(selectedRow, 0);
                        IPessoaControle pessoaControle = new AnalistControle(pessoaDao, (DefaultTableModel) tabelaDenuncia.getModel());
                        pessoaControle.atualizarPessoa(idNome,nomePessoa,imagemBytes);}
                }
                else{
                    JOptionPane.showMessageDialog(null, "Campos vazios !");}*/
            }
        });
        tabelaDenuncia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int selectedRow = tabelaDenuncia.getSelectedRow();
                String protocolo = "";

                if (selectedRow != -1) {
                    //protocolo = (String) tabelaDenuncia.getValueAt(selectedRow, 0);
                    String pessoaSelecionada = (String) tabelaDenuncia.getValueAt(selectedRow, 0);
                    txt_Protocolo.setText(pessoaSelecionada);}


                // Injeção de Depêndencia
                AnalistModelo usuario = new AnalistModelo(txt_Protocolo.getText());
                IAnalistControle controle = new AnalistControle(new AnalistDao());
                boolean sucesso = controle.validaUsuario(usuario);


                if (sucesso) {
                    JOptionPane.showMessageDialog(null, ""+usuario.getMunicipio());

                    String Status = usuario.getStatus();
                    String Sigilo = usuario.getSigilo();
                    String Categoria = usuario.getCategoria();
                    String Municipio = usuario.getMunicipio();

                    boolean status = false;
                    for (int i = 0; i < CB_Status.getItemCount(); i++) {
                        if (CB_Status.getItemAt(i).equals(Status)) {
                            CB_Status.setSelectedIndex(i);
                            status = true;
                            break;}}
                    if (!status) {
                        JOptionPane.showMessageDialog(null, "Status não encontrado !");}

                    boolean sigilo = false;
                    for (int i = 0; i < CB_Sigilo.getItemCount(); i++) {
                        if (CB_Sigilo.getItemAt(i).equals(Sigilo)) {
                            CB_Sigilo.setSelectedIndex(i);
                            sigilo = true;
                            break;}}
                    if (!sigilo) {
                        JOptionPane.showMessageDialog(null, "Sigilo não encontrado !");}

                    boolean categoria = false;
                    for (int i = 0; i < CB_Categoria.getItemCount(); i++) {
                        if (CB_Categoria.getItemAt(i).equals(Categoria)) {
                            CB_Categoria.setSelectedIndex(i);
                            categoria = true;
                            break;}}
                    if (!categoria) {
                        JOptionPane.showMessageDialog(null, "Categoria não encontrado !");}

                    boolean municipio = false;
                    for (int i = 0; i < CB_Municipio.getItemCount(); i++) {
                        if (CB_Municipio.getItemAt(i).equals(Municipio)) {
                            CB_Municipio.setSelectedIndex(i);
                            municipio = true;
                            break;}}
                    if (!municipio) {
                        JOptionPane.showMessageDialog(null, "Municipio não encontrado !");}


                }
                else {
                    JOptionPane.showMessageDialog(null, "Denuncia não encontrada !");}


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
        btn_Novo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LimparCampos();
            }
        });
        btn_Atualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    // Método auxiliar para verificar se a JComboBox contém um determinado valor
    private boolean contemValorNaComboBox(JComboBox<String> comboBox, String valor) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public void LimparCampos(){
        txt_Rua.setText("");
        txt_Bairro.setText("");
        txt_Cep.setText("");
        txt_Latitude.setText("");
        txt_Longitude.setText("");
        txt_Referencia.setText("");
        txt_Autor.setText("");
        TA_Descricao.setText("");
        TA_Atualizacao.setText("");
    }

    public void IniciarCombox(){
        String[] municipios = {"",
                "Abadia de Goiás", "Abadiânia", "Acreúna", "Adelândia", "Água Fria de Goiás",
                "Água Limpa", "Águas Lindas de Goiás", "Alexânia", "Aloândia", "Alto Horizonte",
                "Alto Paraíso de Goiás", "Alvorada do Norte", "Amaralina", "Americano do Brasil",
                "Amorinópolis", "Anápolis", "Anhanguera", "Anicuns", "Aparecida de Goiânia",
                "Aparecida do Rio Doce", "Aporé", "Araçu", "Aragarças", "Aragoiânia", "Araguapaz",
                "Arenópolis", "Aruanã", "Aurilândia", "Avelinópolis", "Baliza", "Barro Alto",
                "Bela Vista de Goiás", "Bom Jardim de Goiás", "Bom Jesus de Goiás", "Bonfinópolis",
                "Bonópolis", "Brazabrantes", "Britânia", "Buriti Alegre", "Buriti de Goiás",
                "Buritinópolis", "Cabeceiras", "Cachoeira Alta", "Cacheira de Goiás", "Cachoeira Dourada",
                "Caçu", "Caiapônia", "Caldas Novas", "Caldazinha", "Campestre de Goiás", "Campinaçu",
                "Campinorte", "Campo Alegre de Goiás", "Campo Limpo de Goiás", "Campos Belos",
                "Campos Verdes", "Carmo do Rio Verde", "Castelândia", "Catalão", "Caturaí",
                "Cavalcante", "Ceres", "Cezarina", "Chapadão do Céu", "Cidade Ocidental", "Cocalzinho de Goiás",
                "Colinas do Sul", "Córrego do Ouro", "Corumbá de Goiás", "Corumbaíba", "Cristalina",
                "Cristianópolis", "Crixás", "Cromínia", "Cumari", "Damianópolis", "Damolândia",
                "Davinópolis", "Diorama", "Divinópolis de Goiás", "Doverlândia", "Edealina", "Edéia",
                "Estrela do Norte", "Faina", "Fazenda Nova", "Firminópolis", "Flores de Goiás", "Formosa",
                "Formoso", "Gameleira de Goiás", "Goianápolis", "Goiandira", "Goianésia", "Goiânia",
                "Goianira", "Goiás", "Goiatuba", "Gouvelândia", "Guapó", "Guaraíta", "Guarani de Goiás",
                "Guarinos", "Heitoraí", "Hidrolândia", "Hidrolina", "Iaciara", "Inaciolândia", "Indiara",
                "Inhumas", "Ipameri", "Ipiranga de Goiás", "Iporá", "Israelândia", "Itaberaí", "Itaguari",
                "Itaguaru", "Itajá", "Itapaci", "Itapirapuã", "Itapuranga", "Itarumã", "Itauçu", "Itumbiara",
                "Ivolândia", "Jandaia", "Jaraguá", "Jataí", "Jaupaci", "Jesúpolis", "Joviânia", "Jussara",
                "Lagoa Santa", "Leopoldo de Bulhões", "Luziânia", "Mairipotaba", "Mambaí", "Mara Rosa",
                "Marzagão", "Matrinchã", "Maurilândia", "Mimoso de Goiás", "Minaçu", "Mineiros", "Moiporá",
                "Monte Alegre de Goiás", "Montes Claros de Goiás", "Montividiu", "Montividiu do Norte",
                "Morrinhos", "Morro Agudo de Goiás", "Mossâmedes", "Mozarlândia", "Mundo Novo", "Mutunópolis",
                "Nazário", "Nerópolis", "Niquelândia", "Nova América", "Nova Aurora", "Nova Crixás",
                "Nova Glória", "Nova Iguaçu de Goiás", "Nova Roma", "Nova Veneza", "Novo Brasil", "Novo Gama",
                "Novo Planalto", "Orizona", "Ouro Verde de Goiás", "Ouvidor", "Padre Bernardo", "Palestina de Goiás",
                "Palmeiras de Goiás", "Palmelo", "Palminópolis", "Panamá", "Paranaiguara", "Paraúna",
                "Perolândia", "Petrolina de Goiás", "Pilar de Goiás", "Piracanjuba", "Piranhas", "Pirenópolis",
                "Pires do Rio", "Planaltina", "Pontalina", "Porangatu", "Porteirão", "Portelândia", "Posse",
                "Professor Jamil", "Quirinópolis", "Rialma", "Rianápolis", "Rio Quente", "Rio Verde", "Rubiataba",
                "Sanclerlândia", "Santa Bárbara de Goiás", "Santa Cruz de Goiás", "Santa Fé de Goiás",
                "Santa Helena de Goiás", "Santa Isabel", "Santa Rita do Araguaia", "Santa Rita do Novo Destino",
                "Santa Rosa de Goiás", "Santa Tereza de Goiás", "Santa Terezinha de Goiás", "Santo Antônio da Barra",
                "Santo Antônio de Goiás", "Santo Antônio do Descoberto", "São Domingos", "São Francisco de Goiás",
                "São João da Paraúna", "São João d'Aliança", "São Luís de Montes Belos", "São Luiz do Norte",
                "São Miguel do Araguaia", "São Miguel do Passa Quatro", "São Patrício", "São Simão", "Senador Canedo",
                "Serranópolis", "Silvânia", "Simolândia", "Sítio d'Abadia", "Taquaral de Goiás", "Teresina de Goiás",
                "Terezópolis de Goiás", "Três Ranchos", "Trindade", "Trombas", "Turvânia", "Turvelândia", "Uirapuru",
                "Uruaçu", "Uruana", "Urutaí", "Valparaíso de Goiás", "Varjão", "Vianópolis", "Vicentinópolis",
                "Vila Boa", "Vila Propício"
        };
        // Combobox de Municipios
        for (String municipio : municipios) {
            CB_Municipio.addItem(municipio);}

        // Combobox de Sigilo
        String[] sigilos = {"","SIM","NÃO"};
        for (String sigilo : sigilos) {
            CB_Sigilo.addItem(sigilo);}

        // Combobox de Status
        String[] status = {"","ABERTO","EM PROCESSO","SOLUCIONADA"};
        for (String Status : status) {
            CB_Status.addItem(Status);}

        // Combobox de Tipo
        String[] denuncias = {"","FAUNA","FLORA","POLUIÇÃO","ADM.AMBIENTAL","OD.URBANO e PATR.CULTURAL"};
        for (String denuncia : denuncias) {
            CB_Categoria.addItem(denuncia);}
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
