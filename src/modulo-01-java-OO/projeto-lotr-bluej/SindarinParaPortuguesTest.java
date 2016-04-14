import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SindarinParaPortuguesTest
{
    @Test
    public void traduzirNaurParaPortugues()
    {
        TradutorSindarin tradutor = new SindarinParaPortugues();
        
        assertEquals("fogo", tradutor.traduzir("naur"));
    }
    
    @Test
    public void traduzirNullParaPortugues()
    {
        TradutorSindarin tradutor = new SindarinParaPortugues();
        
        assertNull(tradutor.traduzir(null));
    }
}
