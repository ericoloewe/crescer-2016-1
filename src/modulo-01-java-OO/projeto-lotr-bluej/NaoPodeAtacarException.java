public class NaoPodeAtacarException extends Exception
{
    public NaoPodeAtacarException()
    {
        super("O Exercito não pode atacar!");
    }
    
    public NaoPodeAtacarException(String message)
    {
        super(message);
    }
}
