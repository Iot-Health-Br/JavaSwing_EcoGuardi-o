package Tela;

import Controle.IUserControle;
import Controle.UserControle;
import Modelo.UserModelo;
import Persistencia.UserDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UserView extends javax.swing.JFrame{
    JPanel panelMain;
    private JTextField txt_Rua;
    private JTable table1;
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

    // Recebe o id do usuário !
    static SearchLoginView obj = new SearchLoginView();
    static String idUsuario = obj.id;

    public UserView() {
        IniciarCombox();
        IniciarTela();

        btn_Foto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_Novo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Usuário id"+idUsuario);
                txt_Rua.setText(idUsuario.toUpperCase());
            }
        });
        btn_Salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // Substitua pelo formato de data correto
                    Date data = formatter.parse(txt_Data.getText());

                    String status = CB_Status.getSelectedItem().toString();
                    String sigilo = CB_Sigilo.getSelectedItem().toString();
                    String categoria = CB_Categoria.getSelectedItem().toString();
                    String municipio = CB_Municipio.getSelectedItem().toString();

                    UserModelo denuncia = new UserModelo(data, status,sigilo,
                            categoria, txt_Rua.getText(), txt_Bairro.getText(), municipio, txt_Cep.getText(),
                            txt_Latitude.getText(), txt_Longitude.getText(), txt_Referencia.getText(), txt_Autor.getText(), TA_Descricao.getText(),
                            TA_Atualizacao.getText(), idUsuario);

                    IUserControle controle = new UserControle(new UserDao());
                    boolean sucesso = controle.adicionarDenuncia(denuncia);
                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "Denuncia Cadastrada com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao Cadastrar o Denuncia");
                    }
                }catch (Exception erro){}
            }
        });
        SAIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchLoginView novoLogin = new SearchLoginView();
                novoLogin.setTitle("EcoGuardian - Tela de Cadastro");
                novoLogin.setContentPane(novoLogin.panelMainL);
                novoLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
                novoLogin.setVisible(true); // Torna o novo JFrame visível
                // Fecha o JFrame 'login'
                UserView.this.dispose(); // 'login' é a instância do seu JFrame atual
            }
        });
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
            for (String municipio : municipios) {
                CB_Municipio.addItem(municipio);}

        // Sigilo
        String[] sigilos = {"","SIM","NÃO"};
        for (String sigilo : sigilos) {
            CB_Sigilo.addItem(sigilo);}

        //Status
        String[] status = {"ABERTO"};
        for (String Status : status) {
            CB_Status.addItem(Status);}

        //Tipo
        String[] denuncias = {"","FAUNA","FLORA","POLUIÇÃO","ADM. AMBIENTAL","OD.URBANO e PATR.CULTURAL"};
        for (String denuncia : denuncias) {
            CB_Categoria.addItem(denuncia);}
    }
    public void IniciarTela(){
        //Inicia a Data
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = hoje.format(formatador);
        txt_Data.setText(dataFormatada);
        txt_Data.setEditable(false);
        txt_Data.setEnabled(false);
    }

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserView frame = new UserView();
                frame.setTitle("EcoGuardian - Tela de Denuncias");
                frame.setContentPane(frame.panelMain);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
    }
}
