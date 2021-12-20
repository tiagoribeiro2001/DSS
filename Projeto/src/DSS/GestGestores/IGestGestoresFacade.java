package DSS.GestGestores;

public interface IGestGestoresFacade {
    boolean autenticaGestor(String username, String password);
    boolean isAutenticado(String username);

}
