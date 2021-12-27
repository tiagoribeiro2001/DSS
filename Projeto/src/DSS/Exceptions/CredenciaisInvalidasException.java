package DSS.Exceptions;

/**
 * Exceção lançada quando as credenciais de um autenticação estão erradas
 */
public class CredenciaisInvalidasException extends Exception {
    public CredenciaisInvalidasException (String msg) {
        super (msg);
    }
}
