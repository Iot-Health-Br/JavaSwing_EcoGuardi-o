package Controle;

import Modelo.AnalistModelo;

public interface IAnalistControle {
        boolean validaUsuario(AnalistModelo usuario);
        void atualizarTabela(AnalistModelo denuncia); // Método para atualizar a tabela
}
