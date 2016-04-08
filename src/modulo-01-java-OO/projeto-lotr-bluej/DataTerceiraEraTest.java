

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
    public void criarDataSemData()
    {
        DataTerceiraEra data = new DataTerceiraEra();
                      
        assertEquals(data.getDia(), 1);
        assertEquals(data.getMes(), 1);
        assertEquals(data.getAno(), 1);
    }
    
    @Test
    public void criarDataComData()
    {
        DataTerceiraEra data = new DataTerceiraEra(1, 1, 2016);
        
        assertEquals(data.getDia(), 1);
        assertEquals(data.getMes(), 1);
        assertEquals(data.getAno(), 2016);
    }
    
    @Test
    public void ano2016EhBissexto()
    {
        DataTerceiraEra data = new DataTerceiraEra(01, 01, 2016);
        
        boolean esperado = true;
        boolean obtido = data.ehBissexto();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void ano2000EhBissexto()
    {
        DataTerceiraEra data = new DataTerceiraEra(01, 01, 2000);
        
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
    
    @Test
    public void ano1900NaoEhBissexto()
    {
        DataTerceiraEra data = new DataTerceiraEra(01, 01, 1900);
        
        boolean obtido = data.ehBissexto();
        
        assertFalse(obtido);
    }
    
    @Test
    public void ano1NaoEhBissexto()
    {
        DataTerceiraEra data = new DataTerceiraEra(1, 1, 1);
        
        boolean obtido = data.ehBissexto();
        
        assertFalse(obtido);
    }
    
    @Test
    public void ano2200NaoEhBissexto()
    {
        DataTerceiraEra data = new DataTerceiraEra(01, 01, 2200);
        
        boolean obtido = data.ehBissexto();
        
        assertFalse(obtido);
    }
}
