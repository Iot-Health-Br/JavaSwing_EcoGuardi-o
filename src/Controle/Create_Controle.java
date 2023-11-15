package Controle;

import Persistencia.Create_Dao;
import Persistencia.ICreate_Dao;

public class Create_Controle implements ICreate_Controle {
    private ICreate_Dao pessoaDao;
    private ICreate_Dao dao = new Create_Dao();
    public void adicionarPessoa(String nome) {
        //CreateLoginModelo pessoa = CreateLoginDao.adicionarPessoa(nome);
    }
}

