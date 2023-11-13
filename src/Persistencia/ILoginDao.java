package Persistencia;

import Modelo.LoginModelo;

public interface ILoginDao {
    boolean validaUsuario(LoginModelo usuario);
}
