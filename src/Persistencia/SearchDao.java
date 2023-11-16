package Persistencia;
import Conexão.DatabaseConnection;
import Modelo.SearchModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchDao implements ISearchDao {
    private static final String TABELA_LOGIN = "tabeladeusuario";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_USER = "nome";
    private static final String COLUNA_CPF = "cpf";
    private static final String COLUNA_FUNÇÃO = "perfil";
    private static final String COLUNA_PASSWORD = "senha";

    @Override
    public boolean validaUsuario(SearchModelo usuario) {
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement statement = conexao.prepareStatement(
                     String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", TABELA_LOGIN, COLUNA_CPF, COLUNA_PASSWORD))) {
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getPassword());
            ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    // Armazenar o ID e função/perfil do usuário no modelo
                    usuario.setId(rs.getString(COLUNA_ID));
                    usuario.setFuncao(rs.getString(COLUNA_FUNÇÃO));
                    return true;}
            return false;}

        catch (Exception e) {
            e.printStackTrace();
            return false;}
    }

}
