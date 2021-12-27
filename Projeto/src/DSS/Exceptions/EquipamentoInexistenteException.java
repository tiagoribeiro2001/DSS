package DSS.Exceptions;

/**
 * Exceção lançada quando se procura um equipamento e ele não existe
 */
public class EquipamentoInexistenteException extends Exception{
    public EquipamentoInexistenteException (String s) {
        super (s);
    }
}
