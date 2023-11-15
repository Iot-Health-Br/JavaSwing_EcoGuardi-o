package Controle;
import Persistencia.SearchDao;
import Modelo.SearchModelo;

public class SearchControle implements ISearchControle {
    private SearchDao dao = new SearchDao();

    @Override
    public boolean validaUsuario(SearchModelo usuario) {
        return dao.validaUsuario(usuario);
    }

}


