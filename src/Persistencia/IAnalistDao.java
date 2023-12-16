package Persistencia;

import Modelo.AnalistModelo;
import Modelo.UserModelo;

import java.util.List;


public interface IAnalistDao {
    List<AnalistModelo> listarDenuncia();
    boolean BuscaDenuncia(AnalistModelo usuario);
    boolean AtualizaDenuncia(AnalistModelo usuario);
    AnalistModelo buscarPorNome(String idNome);
}