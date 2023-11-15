package Persistencia;
import Conexão.DatabaseConnection;
import Modelo.Create_Modelo;

import javax.swing.*;
import java.sql.*;

public class Create_Dao implements ICreate_Dao {
    private static final String TABELA_USUARIOS = "tabeladeusuario";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_CPF = "cpf";
    private static final String COLUNA_FUNCAO = "perfil";
    private static final String COLUNA_SENHA = "senha";

    public Create_Dao() {

        criarTabela();
    }
    private void criarTabela() {
        try (Connection conexao = DatabaseConnection.getConnection();
             Statement statement = conexao.createStatement()) {
            String query = String.format("CREATE TABLE IF NOT EXISTS %s (%s SERIAL PRIMARY KEY, %s VARCHAR(150)UNIQUE,  %s VARCHAR(15)UNIQUE," +
                            " %s VARCHAR(10), %s VARCHAR(50))",
                    TABELA_USUARIOS, COLUNA_ID, COLUNA_NOME, COLUNA_CPF, COLUNA_FUNCAO,COLUNA_SENHA);
            statement.executeUpdate(query);}
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao criar tabela de Pessoa");}
    }

        @Override
        public boolean adicionarPessoa(Create_Modelo usuario) {
            try (Connection conexao = DatabaseConnection.getConnection();

                 // Verifica se o usuário já está cadastrado
                 PreparedStatement verificacaoStatement = conexao.prepareStatement(
                         String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?",
                                 TABELA_USUARIOS, COLUNA_NOME, COLUNA_CPF));

                 // Inserir o usuário no banco de dados
                 PreparedStatement insercaoStatement = conexao.prepareStatement(
                         String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?)",
                                 TABELA_USUARIOS, COLUNA_NOME, COLUNA_CPF, COLUNA_FUNCAO, COLUNA_SENHA))) {

                // Verificar se o usuário já está cadastrado
                verificacaoStatement.setString(1, usuario.getNome());
                verificacaoStatement.setString(2, usuario.getCpf());
                ResultSet resultSet = verificacaoStatement.executeQuery();

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "O usuário já está cadastrado.");
                        return false;
                    }

                // Inserir o usuário no banco de dados
                insercaoStatement.setString(1, usuario.getNome());
                insercaoStatement.setString(2, usuario.getCpf());
                insercaoStatement.setString(3, usuario.getFunção()); // Supondo que você tenha um getFuncao() no Modelo
                insercaoStatement.setString(4, usuario.getSenha());
                int affectedRows = insercaoStatement.executeUpdate();

                    if (affectedRows > 0) {
                        return true;}
                    else {
                        return false;}}

            catch (SQLException e) {
                e.printStackTrace();
                return false;}
        }
}
