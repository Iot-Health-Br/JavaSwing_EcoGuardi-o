package Controle;

import Modelo.UserModelo;

public interface IUserControle {
        void buscarUltimaDenuncia();
        boolean adicionarDenuncia(UserModelo denuncia);
        void atualizarTabela(UserModelo denuncia); // Método para atualizar a tabela
}
