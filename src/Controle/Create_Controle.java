package Controle;

import Modelo.Create_Modelo;
import Persistencia.Create_Dao;
import Persistencia.ICreate_Dao;

import javax.swing.*;

public class Create_Controle implements ICreate_Controle {
    private ICreate_Dao dao;

    public Create_Controle(ICreate_Dao dao) {
        this.dao = dao;
    }
    @Override
    public boolean adicionarPessoa(Create_Modelo usuario) {
        return dao.adicionarPessoa(usuario);
    }
}

