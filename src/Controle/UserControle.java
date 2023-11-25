package Controle;

import Modelo.UserModelo;
import Persistencia.IUserDao;
import Persistencia.UserDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserControle implements IUserControle{
    private IUserDao dao;
    private DefaultTableModel tableModel;

    public UserControle(IUserDao dao, DefaultTableModel tableModel) {
        this.dao = dao;
        this.tableModel = tableModel;
    }
    @Override
    public boolean adicionarDenuncia(UserModelo denuncia) {
        return dao.adicionarDenuncia(denuncia);
    }

    public void atualizarTabela(UserModelo denuncia) {
        // Supondo que UserModelo tem métodos para obter seus dados
        Object[] row = new Object[]{ denuncia.getId(), denuncia.getData(), denuncia.getStatus(), denuncia.getSigilo(), denuncia.getCategoria()};
        tableModel.addRow(row);
    }


    // Linhas da tabela
    private int getRowIndexById(int id) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int rowId = (int) tableModel.getValueAt(i, 0);
            if (rowId == id) {
                return i;}}
        return -1;}
}
