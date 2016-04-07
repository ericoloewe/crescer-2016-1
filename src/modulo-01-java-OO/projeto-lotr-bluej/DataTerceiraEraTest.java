

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste DataTerceiraEraTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class DataTerceiraEraTest
{
    @Test
    public void ano2016EhBissexto()
    {
        DataTerceiraEra data = new DataTerceiraEra(01, 01, 2016);
        
        boolean esperado = true;
        boolean obtido = data.ehBissexto();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void ano2013NaoEhBissexto()
    {
        DataTerceiraEra data = new DataTerceiraEra(01, 01, 2013);
        
        boolean esperado = false;
        boolean obtido = data.ehBissexto();
        
        assertEquals(esperado, obtido);
    }
}
