package Controle;
import Persistencia.SearchLoginDao;
import Modelo.SearchLoginModelo;

public class SearchLoginControle implements ISearchLoginControle {
    private SearchLoginDao dao = new SearchLoginDao();

    @Override
    public boolean validaUsuario(SearchLoginModelo usuario) {
        return dao.validaUsuario(usuario);
    }

}


