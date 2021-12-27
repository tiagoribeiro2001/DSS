package DSS.Exceptions;

/**
 * Exceção lançada quando aé procurado um utilizador com um username que não está no sistema
 */
public class UsernameNaoExisteException extends Exception {
    public UsernameNaoExisteException(String s) {
        super(s);
    }
}
