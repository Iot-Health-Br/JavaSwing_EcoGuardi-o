package Modelo;

import Controle.CreateLoginControle;

public class CreateLoginModelo {
    private int id;
    private String nome;
    private int cpf;
    private String função;
    private String senha;

    public CreateLoginModelo(String NOME){
        //this.id = ID;
        this.nome = NOME;
        /*this.cpf = CPF;
        this.função = FUNÇÃO;
        this.senha = SENHA;*/
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getFunção() {
        return função;
    }

    public void setFunção(String função) {
        this.função = função;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
