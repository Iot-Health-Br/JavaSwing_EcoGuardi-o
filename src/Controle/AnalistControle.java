package Controle;

import Modelo.AnalistModelo;
import Persistencia.AnalistDao;
import Persistencia.IAnalistDao;

import javax.swing.table.DefaultTableModel;

public class AnalistControle implements IAnalistControle {
    private IAnalistDao dao;
    private DefaultTableModel tableModel;
    //private IAnalistDao dao = new AnalistDao();

    public AnalistControle(IAnalistDao dao, DefaultTableModel tableModel) {
        this.dao = dao;
        this.tableModel = tableModel;
    }

    public AnalistModelo buscarPorNome(String protocolo) {
        return dao.buscarPorNome(protocolo);
    }
    public void atualizarTabela(AnalistModelo denuncia) {
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
        return -1;
    }
}
