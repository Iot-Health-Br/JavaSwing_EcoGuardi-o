package Persistencia;

import Conexão.DatabaseConnection;
import Modelo.AnalistModelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AnalistDao implements IAnalistDao{
    private static final String TABELA_DENUNCIAS = "tabelaDeDenuncias";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_PROTOCOLO = "protocolo";
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

    public AnalistDao(){

    }
    public AnalistModelo buscarPorNome(String protocolo) {
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement statement = conexao.prepareStatement(String.format("SELECT %s FROM %s", COLUNA_PROTOCOLO,TABELA_DENUNCIAS))) {
            statement.setString(1, protocolo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Usando o novo construtor aqui
                    AnalistModelo pessoa = new AnalistModelo(
                            resultSet.getString("protocolo"),
                            resultSet.getDate("data"),
                            resultSet.getString("status"));
                    return pessoa;}}}
        catch (SQLException e) {
            e.printStackTrace();}
        return null;
    }

    public List<AnalistModelo> listarDenuncia(){
        List<AnalistModelo> denuncias = new ArrayList<>();

        try (Connection conexao = DatabaseConnection.getConnection();
             Statement statement = conexao.createStatement()) {
            String query = String.format("SELECT * FROM %s ORDER BY id ASC", TABELA_DENUNCIAS);

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String protocolo = resultSet.getString(COLUNA_PROTOCOLO);
                Date data = resultSet.getDate(COLUNA_DATA);
                String status = resultSet.getString(COLUNA_STATUS);
                String sigilo = resultSet.getString(COLUNA_SIGILO);
                String categoria = resultSet.getString(COLUNA_CATEGORIA);
                String municipio = resultSet.getString(COLUNA_MUNICIPIO);
                AnalistModelo denuncia = new AnalistModelo(protocolo, data, status, sigilo, categoria, municipio);
                denuncias.add(denuncia);}
            resultSet.close();}
        catch (SQLException e) {
            e.printStackTrace();}
        return denuncias;}
}
