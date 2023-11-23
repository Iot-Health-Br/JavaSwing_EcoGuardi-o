package Modelo;

import java.util.Date;

public class UserModelo {
    private int Id;
    private Date Data;
    private String Status ="";
    private String Sigilo ="";
    private String Categoria ="";
    private String Municipio ="";
    private int IdUsuario = 0;

    //Construtor da tabela
    public UserModelo(int id,Date data, String status, String sigilo, String categoria, String municipio){
        this.Id = id;
        this.Data = data;
        this.Status = status;
        this.Sigilo = sigilo;
        this.Categoria = categoria;
        this.Municipio = municipio;
    }

    public UserModelo(Date data, String status, String sigilo, String categoria, String municipio, int idUsuario){
        this.Data = data;
        this.Status = status;
        this.Sigilo = sigilo;
        this.Categoria = categoria;
        this.Municipio = municipio;
        this.IdUsuario = idUsuario;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public java.sql.Date getData() {
        return (java.sql.Date) Data;
    }

    public void setData(Date data) {
        Data = data;
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

    @Override
    public String toString() {
        return "UserModelo{" +
                "Id=" + Id +
                ", Data=" + Data +
                ", Status='" + Status + '\'' +
                ", Sigilo='" + Sigilo + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", Municipio='" + Municipio + '\'' +
                ", IdUsuario=" + IdUsuario +
                '}';
    }
}
