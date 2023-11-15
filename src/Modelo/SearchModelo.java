package Modelo;

public class SearchModelo {
    private String username;
    private String password;
    private String Funcao;

    public SearchModelo(String user, String password){
        this.username = user;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String funcao) {
        Funcao = funcao;
    }
}
