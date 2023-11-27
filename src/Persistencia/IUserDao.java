package Persistencia;

import Modelo.UserModelo;

import java.util.List;

public interface IUserDao {
    int getLastDenunciaId();
    boolean adicionarDenuncia(UserModelo usuario);

    List<UserModelo> listarDenuncia(int userId);
}
