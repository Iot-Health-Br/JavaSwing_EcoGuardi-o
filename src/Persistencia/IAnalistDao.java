package Persistencia;

import Modelo.AnalistModelo;

import java.util.List;


public interface IAnalistDao {
    List<AnalistModelo> listarDenuncia();

    AnalistModelo buscarPorNome(String idNome);
}