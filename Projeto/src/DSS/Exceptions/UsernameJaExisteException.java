package DSS.Exceptions;

import java.io.Serializable;

/**
 * Exceção lançada quando ja existe um utilizador com um certo username repetido
 */
public class UsernameJaExisteException extends Exception implements Serializable {
    public UsernameJaExisteException (String msg) {
        super (msg);
    }
}
