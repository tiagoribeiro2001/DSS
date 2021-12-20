package DSS.GestTecnicos;

public interface IGestTecnicosFacade {
    public Tecnico getTecnico(String username);
    public boolean autenticaTecnico(String username, String password);
    boolean isAutenticado (String username);
}
