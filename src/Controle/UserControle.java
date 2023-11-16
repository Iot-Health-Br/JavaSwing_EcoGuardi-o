package Controle;

import Modelo.UserModelo;
import Persistencia.IUserDao;

import javax.swing.*;

public class UserControle implements IUserControle{
    private IUserDao dao;

    public UserControle(IUserDao dao) {
        this.dao = dao;
    }
    @Override
    public boolean adicionarDenuncia(UserModelo denuncia) {
        return dao.adicionarDenuncia(denuncia);
    }
}
