package DSS.Exceptions;

import java.io.Serializable;

public class UsernameJaExisteException extends Exception implements Serializable {
    public UsernameJaExisteException (String msg) {
        super (msg);
    }
}
