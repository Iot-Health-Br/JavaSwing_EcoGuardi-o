package Modelo;

public class Create_Modelo {
    private int id;
    private String nome;
    private String cpf;
    private String funcao;
    private String senha;

    public Create_Modelo(String NOME, String CPF, String FUNCAO, String SENHA){
        //this.id = ID;
        this.nome = NOME;
        this.cpf = CPF;
        this.funcao = FUNCAO;
        this.senha = SENHA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFunção() {
        return funcao;
    }

    public void setFunção(String função) {
        this.funcao = função;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Create_Modelo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", função='" + funcao + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
