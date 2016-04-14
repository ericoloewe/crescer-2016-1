import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SindarinParaInglesTest
{
    @Test
    public void traduzirNaurParaIngles()
    {
        TradutorSindarin tradutor = new SindarinParaIngles();
        
        assertEquals("fire", tradutor.traduzir("naur"));
    }
    
    @Test
    public void traduzirNullParaPortugues()
    {
        TradutorSindarin tradutor = new SindarinParaIngles();
        
        assertNull(tradutor.traduzir(null));
    }
}
