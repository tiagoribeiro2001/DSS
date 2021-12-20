package DSS.GestTecnicos;

public interface IGestTecnicosFacade {

    public boolean autenticaTecnico(String username, String password);
    boolean isAutenticado (String username);
}
