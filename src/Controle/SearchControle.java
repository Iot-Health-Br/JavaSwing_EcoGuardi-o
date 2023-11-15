package Controle;
import Persistencia.ISearchDao;
import Persistencia.SearchDao;
import Modelo.SearchModelo;

public class SearchControle implements ISearchControle {
    private ISearchDao dao;

    public SearchControle(ISearchDao dao) {
        this.dao = dao;
    }
    @Override
    public boolean validaUsuario(SearchModelo usuario) {
        return dao.validaUsuario(usuario);
    }

}


