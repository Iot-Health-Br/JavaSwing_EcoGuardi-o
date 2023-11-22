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
    private static final String COLUNA_IdUsuário = "idUsuario";
    private static final String COLUNA_IdAnalista = "idAnalista";


    public UserDao(){
        criarTabela();
    }
    private void criarTabela() {
        try (Connection conexao = DatabaseConnection.getConnection();
             Statement statement = conexao.createStatement()) {
            String query = String.format("CREATE TABLE IF NOT EXISTS %s (" + "%s SERIAL PRIMARY KEY, " +
                            "%s VARCHAR(255), " +  // Coluna DATA
                            "%s VARCHAR(15)NOT NULL, " +  // Coluna STATUS
                            "%s VARCHAR(15)NOT NULL, " +  // Coluna SIGILO
                            "%s VARCHAR(50)NOT NULL, " +  // Coluna CATEGORIA
                            "%s VARCHAR(255)NOT NULL, " + // Coluna RUA
                            "%s VARCHAR(100)NOT NULL, " + // Coluna BAIRRO
                            "%s BYTEA NOT NULL, " +// Coluna FOTO
                            "%s VARCHAR(255)NOT NULL, " + // Coluna MUNICIPIO
                            "%s VARCHAR(255)NOT NULL, " + // Coluna CEP
                            "%s VARCHAR(255), " +  // Coluna LATITUDE
                            "%s VARCHAR(255), " +  // Coluna LONGITUDE
                            "%s TEXT, " +          // Coluna PONTO DE REFERÊNCIA
                            "%s VARCHAR(255), " +  // Coluna AUTOR
                            "%s TEXT, " +          // Coluna DESCRICAO
                            "%s TEXT, " +     // Coluna ATUALIZACAO
                            "%s VARCHAR(255), " +    // Coluna ID USUÁRIO
                            "%s INTEGER NOT NULL)",      // Coluna ID ANALISTA
                    TABELA_DENUNCIAS, COLUNA_ID, COLUNA_DATA, COLUNA_STATUS, COLUNA_SIGILO, COLUNA_CATEGORIA,
                    COLUNA_RUA, COLUNA_BAIRRO, COLUNA_FOTO, COLUNA_MUNICIPIO, COLUNA_CEP, COLUNA_LATITUDE, COLUNA_LONGITUDE,
                    COLUNA_PONTO_Referencia, COLUNA_AUTOR, COLUNA_DESCRICAO, COLUNA_ATUALIZACAO, COLUNA_IdUsuário, COLUNA_IdAnalista);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao criar tabela de Pessoa");
        }
    }

    @Override
    public boolean adicionarDenuncia(UserModelo usuario) {
        try (Connection conexao = DatabaseConnection.getConnection();

             // Verifica se o usuário já está cadastrado
             PreparedStatement verificacaoStatement = conexao.prepareStatement(
                     String.format("SELECT * FROM %s WHERE %s = ?",
                             TABELA_DENUNCIAS, COLUNA_ID));

             // Inserir o usuário no banco de dados
             PreparedStatement insercaoStatement = conexao.prepareStatement(
                     String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                             TABELA_DENUNCIAS, COLUNA_DATA, COLUNA_STATUS, COLUNA_SIGILO, COLUNA_CATEGORIA, COLUNA_RUA, COLUNA_BAIRRO,
                             COLUNA_MUNICIPIO, COLUNA_CEP, COLUNA_LATITUDE, COLUNA_LONGITUDE, COLUNA_PONTO_Referencia, COLUNA_AUTOR,
                             COLUNA_DESCRICAO, COLUNA_ATUALIZACAO, COLUNA_IdAnalista, COLUNA_FOTO, COLUNA_IdUsuário)))
{

            // Verificar se o usuário já está cadastrado
            verificacaoStatement.setDate(1, usuario.getData());
            verificacaoStatement.setString(2, usuario.getStatus());
            ResultSet resultSet = verificacaoStatement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "O usuário já está cadastrado.");
                return false;
            }
            // Inserir o usuário no banco de dados
            insercaoStatement.setDate(1, usuario.getData());
            insercaoStatement.setString(2, usuario.getStatus());
            insercaoStatement.setString(3, usuario.getSigilo()); // Supondo que você tenha um getFuncao() no Modelo
            insercaoStatement.setString(4, usuario.getCategoria());
            insercaoStatement.setString(5, usuario.getRua());
            insercaoStatement.setString(6, usuario.getBairro());
            insercaoStatement.setString(7, usuario.getMunicipio());
            insercaoStatement.setString(8, usuario.getCEP());
            insercaoStatement.setString(9, usuario.getLatitude());
            insercaoStatement.setString(10, usuario.getLongitude());
            insercaoStatement.setString(11, usuario.getReferencia());
            insercaoStatement.setString(12, usuario.getAutor());
            insercaoStatement.setString(13, usuario.getDescricao());
            insercaoStatement.setString(14, usuario.getAtualizacao());
            insercaoStatement.setBytes(15, usuario.getFoto());
            insercaoStatement.setInt(16, usuario.getIdUsuario());
            int affectedRows = insercaoStatement.executeUpdate();

            if (affectedRows > 0) {
                return true;}
            else {
                return false;}}

        catch (SQLException e) {
            e.printStackTrace();
            return false;}
    }




/*
    public List<UserModelo> listarPessoa() {
        List<UserModelo> pessoas = new ArrayList<>();
        try (Connection conexao = DatabaseConnection.getConnection();
             Statement statement = conexao.createStatement()) {
            String query = String.format("SELECT %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s FROM %s WHERE %s = VALOR ORDER BY id ASC",
                    COLUNA_ID, COLUNA_DATA, COLUNA_STATUS, COLUNA_SIGILO, COLUNA_CATEGORIA, COLUNA_RUA,
                    COLUNA_BAIRRO, COLUNA_MUNICIPIO, COLUNA_CEP, COLUNA_LATITUDE, COLUNA_LONGITUDE,
                    COLUNA_PONTO_Referencia, COLUNA_AUTOR, COLUNA_DESCRICAO, COLUNA_ATUALIZACAO,
                    COLUNA_IdAnalista, COLUNA_FOTO, TABELA_DENUNCIAS, COLUNA_IdUsuário);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                UserModelo pessoa = new UserModelo();
                pessoa.setId(resultSet.getInt(COLUNA_ID));
                pessoa.setData(resultSet.getDate(COLUNA_DATA));
                pessoa.setStatus(resultSet.getString(COLUNA_STATUS));
                pessoa.setSigilo(resultSet.getString(COLUNA_SIGILO));
                pessoa.setCategoria(resultSet.getString(COLUNA_CATEGORIA));
                pessoa.setRua(resultSet.getString(COLUNA_RUA));
                pessoa.setBairro(resultSet.getString(COLUNA_BAIRRO));
                pessoa.setMunicipio(resultSet.getString(COLUNA_MUNICIPIO));
                pessoa.setCEP(resultSet.getString(COLUNA_CEP));
                pessoa.setLatitude(resultSet.getInt(COLUNA_LATITUDE));
                pessoa.setLongitude(resultSet.getInt(COLUNA_LONGITUDE));
                pessoa.setReferencia(resultSet.getString(COLUNA_PONTO_Referencia));
                pessoa.setAutor(resultSet.getString(COLUNA_AUTOR));
                pessoa.setDescricao(resultSet.getString(COLUNA_DESCRICAO));
                pessoa.setAtualizacao(resultSet.getString(COLUNA_ATUALIZACAO));
                pessoa.setIdUsuario(resultSet.getInt(COLUNA_IdUsuário));
                pessoa.setFoto(resultSet.getBytes(COLUNA_FOTO));
                pessoas.add(pessoa);}
            resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();}
        return pessoas;
    }
*/

}
