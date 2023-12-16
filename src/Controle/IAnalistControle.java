package Controle;

import Modelo.AnalistModelo;

public interface IAnalistControle {
        boolean BuscaDenuncia(AnalistModelo usuario);
        boolean AtualizaDenuncia(AnalistModelo usuario);
        void atualizarTabela(AnalistModelo denuncia); // Método para atualizar a tabela
}
