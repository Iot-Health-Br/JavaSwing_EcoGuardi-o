package Persistencia;

import Modelo.SearchLoginModelo;

public interface ISearchLoginDao {
    boolean validaUsuario(SearchLoginModelo usuario);
}
