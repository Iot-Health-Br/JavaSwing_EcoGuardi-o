package Persistencia;

import Modelo.AnalistModelo;

import java.util.List;


public interface IAnalistDao {
    List<AnalistModelo> listarDenuncia();
    boolean validaUsuario(AnalistModelo usuario);

    AnalistModelo buscarPorNome(String idNome);
}