package Controle;

import Modelo.UserModelo;
import Persistencia.IUserDao;
import Persistencia.UserDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserControle implements IUserControle{
    private IUserDao dao;
    private DefaultTableModel tableModel;


    ///protocolo
    private UserModelo modelo;


    public UserControle(IUserDao dao, DefaultTableModel tableModel) {
        this.dao = dao;
        this.tableModel = tableModel;
    }


    //Construtor do protocolo, fazer teste se e nescessário
    public UserControle(UserModelo modelo, IUserDao dao) {
        this.modelo = modelo;
        this.dao = dao;
    }
    @Override
    public void buscarUltimaDenuncia() {
        int id = dao.getLastDenunciaId();
        modelo.setUltima_Denuncia(id);
        // Aqui você pode atualizar a view, se necessário
    }


    @Override
    public boolean adicionarDenuncia(UserModelo denuncia) {
        return dao.adicionarDenuncia(denuncia);
    }

    public void atualizarTabela(UserModelo denuncia) {
        // Supondo que UserModelo tem métodos para obter seus dados
        Object[] row = new Object[]{ denuncia.getProtocolo(), denuncia.getData(), denuncia.getStatus(), denuncia.getSigilo(), denuncia.getCategoria()};
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
