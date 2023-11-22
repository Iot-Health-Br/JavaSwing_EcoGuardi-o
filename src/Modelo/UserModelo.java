package Modelo;

import java.util.Date;

public class UserModelo {
    private int Id;
    private Date Data;
    private String Status ="";
    private String Sigilo ="";
    private String Categoria ="";
    private String Rua ="";
    private byte[] Foto;
    private String Bairro ="";
    private String Municipio ="";
    private String CEP ="";
    private String Latitude ="";
    private String Longitude ="";
    private String Referencia ="";
    private String Autor ="";
    private String Descricao ="";
    private String Atualizacao ="";
    private int IdUsuario = 0;


    public UserModelo(int IDUSUARIO){
        this.IdUsuario = IDUSUARIO;
    }
    public UserModelo(Date data, String status, String sigilo, String categoria, String rua, String bairro, String municipio, String CEP,
                      String latitude, String longitude, String referencia, String autor, String descricao, String atualizacao, int idUsuario){
        this.Data = data;
        this.Status = status;
        this.Sigilo = sigilo;
        this.Categoria = categoria;
        this.Rua = rua;
        this.Bairro = bairro;
        this.Municipio = municipio;
        this.CEP = CEP;
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.Referencia = referencia;
        this.Autor = autor;
        this.Descricao = descricao;
        this.Atualizacao = atualizacao;
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

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] foto) {
        Foto = foto;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getAtualizacao() {
        return Atualizacao;
    }

    public void setAtualizacao(String atualizacao) {
        Atualizacao = atualizacao;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }


}
