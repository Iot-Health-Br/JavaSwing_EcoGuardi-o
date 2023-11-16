package Sessão;

public class SessaoUsuario {
    private static SessaoUsuario instance;
    private long idUsuario;

    private SessaoUsuario() {}

    public static SessaoUsuario getInstance() {
        if (instance == null) {
            instance = new SessaoUsuario();
        }
        return instance;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Método para limpar a sessão
    public void clear() {
        idUsuario = 0;
    }
}
