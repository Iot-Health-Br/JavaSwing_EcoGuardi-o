package Controle;
import Persistencia.LoginDao;
import Persistencia.ILoginDao;
import Modelo.LoginModelo;
import Controle.ILoginControle;
public class LoginControle implements ILoginControle{
    private LoginDao dao = new LoginDao();

    @Override
    public boolean validaUsuario(LoginModelo usuario) {
        return dao.validaUsuario(usuario);
    }

}


