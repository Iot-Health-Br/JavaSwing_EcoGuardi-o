package Persistencia;
import Conexão.DatabaseConnection;
import Modelo.SearchLoginModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchLoginDao implements ISearchLoginDao {
    private static final String TABELA_LOGIN = "tabeladeusuario";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_USER = "nome";
    private static final String COLUNA_PASSWORD = "senha";

    @Override
    public boolean validaUsuario(SearchLoginModelo usuario) {

        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement statement = conexao.prepareStatement( String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", TABELA_LOGIN, COLUNA_USER, COLUNA_PASSWORD))) {
                statement.setString(1, usuario.getUsername());
                statement.setString(2,usuario.getPassword());
                //statement.setString(2, usuario.getPassword());
                ResultSet rs = statement.executeQuery();
                return rs.next();}
        catch (Exception e) {
            e.printStackTrace();
            return false;}
    }
}
