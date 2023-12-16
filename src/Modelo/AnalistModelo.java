package Modelo;

import java.sql.Date;

public class AnalistModelo {
    private int Id = 0;
    private int Ultima_Denuncia = 0 ;
    private String Protocolo = "";
    private Date Data;
    private Date Data_Atualizacao;
    private String Status ="";
    private String Sigilo ="";
    private String Categoria ="";
    private String Municipio ="";
    private int IdUsuario = 0;

    //Construtor da tabela
    public AnalistModelo(String protocolo,Date data, String status, String sigilo, String categoria, String municipio){
        this.Protocolo = protocolo;
        this.Data = data;
        this.Status = status;
        this.Sigilo = sigilo;
        this.Categoria = categoria;
        this.Municipio = municipio;
    }

    //Construtor Mouse Clicked
    public AnalistModelo(String protocolo,Date data, String status){
        this.Protocolo = protocolo;
        this.Data = data;
        this.Status = status;
    }


    public AnalistModelo(String protocolo) {
        this.Protocolo = protocolo;
    }

    public AnalistModelo(String protocolo, Date sqlDate, String status, String sigilo, String categoria, String municipio, int userId) {
        this.Protocolo = protocolo;
        this.Data_Atualizacao = sqlDate;
        this.Status = status;
        this.Sigilo = sigilo;
        this.Categoria = categoria;
        this.Municipio = municipio;
        this.IdUsuario = userId;
    }

    public AnalistModelo() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUltima_Denuncia() {
        return Ultima_Denuncia;
    }

    public void setUltima_Denuncia(int ultima_Denuncia) {
        Ultima_Denuncia = ultima_Denuncia;
    }

    public String getProtocolo() {
        return Protocolo;
    }

    public void setProtocolo(String protocolo) {
        Protocolo = protocolo;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public Date getData_Atualizacao() {
        return Data_Atualizacao;
    }

    public void setData_Atualizacao(Date data_Atualizacao) {
        Data_Atualizacao = data_Atualizacao;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getSigilo() {
        return Sigilo;
    }

    public void setSigilo(String sigilo) {
        Sigilo = sigilo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }
}
