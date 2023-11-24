package Controle;

import Modelo.UserModelo;
import Persistencia.IUserDao;
import Persistencia.UserDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserControle implements IUserControle{
    private IUserDao dao;

    private DefaultTableModel tableModel;

    /*// Variaveis pertinentes a tabela
    private IUserDao pessoaDao;
    private DefaultTableModel tableModel;


    public UserControle(IUserDao pessoaDao, DefaultTableModel tableModel) {
        this.pessoaDao = pessoaDao;
        this.tableModel = tableModel;}*/

    public UserControle(IUserDao dao) {

        this.dao = dao;
    }
    @Override
    public boolean adicionarDenuncia(UserModelo denuncia) {
        return dao.adicionarDenuncia(denuncia);
    }

    // Linhas da tabela
    private int getRowIndexById(int id) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int rowId = (int) tableModel.getValueAt(i, 0);
            if (rowId == id) {
                return i;}}
        return -1;}
}
