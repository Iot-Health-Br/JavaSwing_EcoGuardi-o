package Persistencia;
import Conexão.DatabaseConnection;
import Modelo.CreateLoginModelo;

import javax.swing.*;
import java.sql.*;

public class CreateLoginDao implements ICreateLoginDao {
    private static final String TABELA_USUARIOS = "tabelaDeUsuarios";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_CPF = "cpf";
    private static final String COLUNA_SENHA = "senha";

    public CreateLoginDao() {
        criarTabela();
    }
    private void criarTabela() {
        try (Connection conexao = DatabaseConnection.getConnection();
             Statement statement = conexao.createStatement()) {
            String query = String.format("CREATE TABLE IF NOT EXISTS %s (%s SERIAL PRIMARY KEY, %s VARCHAR(255)UNIQUE, %s BYTEA not null)",
                    TABELA_USUARIOS, COLUNA_ID, COLUNA_NOME);
            statement.executeUpdate(query);}
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao criar tabela de Pessoa");}
    }

    public CreateLoginModelo adicionarPessoa(String nome) {

        try (Connection conexao = DatabaseConnection.getConnection();

             // Verifica se a PESSOA já está cadastrada
             PreparedStatement verificacaoStatement = conexao.prepareStatement(
                     String.format("SELECT * FROM %s WHERE %s = ?", TABELA_USUARIOS, COLUNA_NOME));

             /////////////////////////////////////////////////////////////////////////////////////////////////////////////

             // Inserir a PESSOA no banco de dados
             PreparedStatement insercaoStatement = conexao.prepareStatement(
                     String.format("INSERT INTO %s (%s,%s) VALUES (?,?) ", TABELA_USUARIOS, COLUNA_NOME),
                     Statement.RETURN_GENERATED_KEYS)) {


            // Verificar se a (PESSOA) já está cadastrada
            verificacaoStatement.setString(1, nome);
            ResultSet resultSet = verificacaoStatement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "A pessoa já está cadastrada.");
                return null;}

            // Inserir a PESSOA no banco de dados
            insercaoStatement.setString(1, nome );
            int rowsAffected = insercaoStatement.executeUpdate();

            if (rowsAffected == 0) {
                return null;}

            try (ResultSet generatedKeys = insercaoStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(0);
                    return new CreateLoginModelo( nome);}
                else {
                    return null;}}
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;}
    }
}
