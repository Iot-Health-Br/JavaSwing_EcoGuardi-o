package Persistencia;

import Conexão.DatabaseConnection;
import Modelo.UserModelo;
import Tela.SearchLoginView;
import Tela.UserView;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    // Busca o ID do usuário
    private static final String TABELA_DENUNCIAS = "tabelaDeDenuncias";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_DATA = "data";
    private static final String COLUNA_STATUS = "status";
    private static final String COLUNA_SIGILO = "sigilo";
    private static final String COLUNA_CATEGORIA = "categoria";
    private static final String COLUNA_RUA = "rua";
    private static final String COLUNA_BAIRRO = "bairro";
    private static final String COLUNA_FOTO = "foto";
    private static final String COLUNA_MUNICIPIO = "municipio";
    private static final String COLUNA_CEP = "cep";
    private static final String COLUNA_LATITUDE = "latitude";
    private static final String COLUNA_LONGITUDE = "longitude";
    private static final String COLUNA_PONTO_Referencia = "referencia";
    private static final String COLUNA_AUTOR = "autor";
    private static final String COLUNA_DESCRICAO = "descricao";
    private static final String COLUNA_ATUALIZACAO = "atualizacao";
    private static final String COLUNA_IdUsuario = "idUsuario";
    private static final String COLUNA_IdAnalista = "idAnalista";


    public UserDao(){

        criarTabela();
    }
    private void criarTabela() {
        try (Connection conexao = DatabaseConnection.getConnection();
             Statement statement = conexao.createStatement()) {
            String query = String.format("CREATE TABLE IF NOT EXISTS %s (" +
                            "%s SERIAL PRIMARY KEY, " + // Coluna ID
                            "%s DATE, " +  // Coluna DATA
                            "%s VARCHAR(15) NOT NULL, " +  // Coluna STATUS
                            "%s VARCHAR(5) NOT NULL, " +  // Coluna SIGILO
                            "%s VARCHAR(50) NOT NULL, " +  // Coluna CATEGORIA
                            "%s VARCHAR(255) NOT NULL, " + // Coluna MUNICIPIO
                            "%s INTEGER)",  // Coluna ID USUÁRIO
                    TABELA_DENUNCIAS, COLUNA_ID, COLUNA_DATA, COLUNA_STATUS, COLUNA_SIGILO, COLUNA_CATEGORIA,
                    COLUNA_MUNICIPIO, COLUNA_IdUsuario);
            statement.executeUpdate(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao criar tabela de Denuncia");
        }
    }

    @Override
    public boolean adicionarDenuncia(UserModelo usuario) {
        try (Connection conexao = DatabaseConnection.getConnection();

             // Inserir o usuário no banco de dados
             PreparedStatement insercaoStatement = conexao.prepareStatement(
                     String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?)",
                             TABELA_DENUNCIAS, COLUNA_DATA, COLUNA_STATUS, COLUNA_SIGILO, COLUNA_CATEGORIA,
                             COLUNA_MUNICIPIO, COLUNA_IdUsuario))) {

            // Inserir o usuário no banco de dados
            insercaoStatement.setDate(1, usuario.getData());
            insercaoStatement.setString(2, usuario.getStatus());
            insercaoStatement.setString(3, usuario.getSigilo());
            insercaoStatement.setString(4, usuario.getCategoria());
            insercaoStatement.setString(5, usuario.getMunicipio());
            insercaoStatement.setInt(6, usuario.getIdUsuario());
            int affectedRows = insercaoStatement.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }
            else {
                return false;}}

        catch (SQLException e) {
            e.printStackTrace();
            return false;}
    }

    public List<UserModelo>listarDenuncia(){
        List<UserModelo> denuncias = new ArrayList<>();

        try (Connection conexao = DatabaseConnection.getConnection();
             Statement statement = conexao.createStatement()) {
            String query = String.format("SELECT * FROM %s ORDER BY id ASC", TABELA_DENUNCIAS);

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(COLUNA_ID);
                Date data = resultSet.getDate(COLUNA_DATA);
                String status = resultSet.getString(COLUNA_STATUS);
                String sigilo = resultSet.getString(COLUNA_SIGILO);
                String categoria = resultSet.getString(COLUNA_CATEGORIA);
                String municipio = resultSet.getString(COLUNA_STATUS);
                UserModelo denuncia = new UserModelo(id, data, status, sigilo, categoria, municipio);
                denuncias.add(denuncia);}
            resultSet.close();}
        catch (SQLException e) {
            e.printStackTrace();}
        return denuncias;}
}
