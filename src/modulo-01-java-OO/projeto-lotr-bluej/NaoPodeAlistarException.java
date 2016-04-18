public class NaoPodeAlistarException extends Exception
{
    public NaoPodeAlistarException()
    {
        this("O Elfo do tipo normal não pode ser alistado!");
    }
    
    public NaoPodeAlistarException(String message)
    {
        super(message);
    }
}
