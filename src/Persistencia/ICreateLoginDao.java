package Persistencia;

import Modelo.CreateLoginModelo;

public interface ICreateLoginDao {
    CreateLoginModelo adicionarPessoa(String nome);
}
