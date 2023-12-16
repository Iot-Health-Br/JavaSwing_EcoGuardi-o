package Controle;

import Modelo.AnalistModelo;
import Persistencia.AnalistDao;
import Persistencia.IAnalistDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AnalistControle implements IAnalistControle {
    private IAnalistDao dao;
    private DefaultTableModel tableModel;

    AnalistModelo modelo = new AnalistModelo();

    //Primeiro Construtor
    public AnalistControle(IAnalistDao dao, DefaultTableModel tableModel) {
        this.dao = dao;
        this.tableModel = tableModel;
    }

    // Segundo construtor
    public AnalistControle(IAnalistDao dao) {
        this.dao = dao;
    }

    //Metodo de Busca de Denuncia
    @Override
    public boolean BuscaDenuncia(AnalistModelo usuario) {
        return dao.BuscaDenuncia(usuario);
    }

    //Metodo de Busca de Denuncia
    @Override
    public boolean AtualizaDenuncia(AnalistModelo usuario) {
        return dao.AtualizaDenuncia(usuario);
    }

    // Metodo de Atualizar Tabela
    public void atualizarTabela(AnalistModelo denuncia) {

        String LProtocolo = denuncia.getProtocolo();

        int rowIndex = getRowIndexByProtocolo(LProtocolo);
        if (rowIndex != -1) {
            tableModel.setValueAt(denuncia.getProtocolo(), rowIndex, 0);
            //tableModel.setValueAt(denuncia.getData(), rowIndex, 1);
            tableModel.setValueAt(denuncia.getStatus(), rowIndex, 2);
            tableModel.setValueAt(denuncia.getSigilo(), rowIndex, 3);
            tableModel.setValueAt(denuncia.getCategoria(), rowIndex, 4);
        } else {
            JOptionPane.showMessageDialog(null, "Linha com protocolo " + LProtocolo + " não encontrada.");
        }
    }

    //Atualiza a linha da Jtable denuncia
    private int getRowIndexByProtocolo(String id) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(id)) {
                return i;
            }
        }
        return -1; // Retorna -1 se não encontrar uma linha correspondente
    }

    // Linhas da tabela
    private int getRowIndexById(int id) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int rowId = (int) tableModel.getValueAt(i, 0);
            if (rowId == id) {
                return i;}}
        return -1;
    }
}
