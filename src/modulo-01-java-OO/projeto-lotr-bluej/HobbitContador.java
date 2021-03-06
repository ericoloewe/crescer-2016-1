import java.util.*;

public class HobbitContador
{    
    public int obterMaiorMultiploDeTresAte(int numero)
    {
        /*
         * Feita a analise do codigo e encontrado os seguintes erros:
         * - No lugar do numero no for havia um limite, no qual o limite é o proprio numero.
         * - Havia uma lista, da qual não é necessaria, por deve-se retornar somente o maior multiplo de tres,
         *   e por isso foi criado uma variavel do tipo inteira para guardar o maior multiplo de 3 e enviar a mesma.
         * - Foi removido o continue do cod, o qual é totalmente desnecessario.
         */
        int maiorMultiploDeTres = 0;
        
        for (int i = numero; i >= 0; i--) 
        {
            if (i % 3 == 0) 
            {
                maiorMultiploDeTres = i;
                break;
            }
        }
        
        return maiorMultiploDeTres;
    }
    
    public ArrayList<Integer> obterMultiplosDeTresAte(int numero) 
    {
        /*
         * Feita a analise do codigo e encontrado os seguintes erros:
         * - No lugar do numero no for havia um limite, no qual o limite é o proprio numero.
         * - Foi removido o break do cod, o qual é totalmente desnecessario.
         */
        ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0));
        
        for (int i = 1; i <= numero; i++) 
        {
            if (i % 3 == 0)
                multiplos.add(i);
        }
        
        return multiplos;
    }
    
    public Integer calcularDiferenca(ArrayList<ArrayList<Integer>> lista)
    {
        return lista != null ? this.calcularDiferenca(lista, 0) : null;
    }
    
    private Integer calcularDiferenca(ArrayList<ArrayList<Integer>> lista, int i)
    {
        if(i == lista.size()) 
            return 0;        
        return this.calcularDiferenca(lista, i + 1) + (this.calculaProduto(lista.get(i)) - this.calculaMinimoMultiplo(lista.get(i)));
    }    
    
    private Integer calculaProduto(ArrayList<Integer> lista)
    {
        Integer produto = 1;
        for(Integer i : lista)
        {
            produto *= i;
        }
        return produto;
    }
    
    private Integer calculaMinimoMultiplo(ArrayList<Integer> arrayDePares)
    {
        boolean existeZero = this.exiteZero(arrayDePares);
        int fator = 2, mmc = existeZero ? 0 : 1;        
        
        ArrayList<Integer> listaDeFatores = new ArrayList<Integer>();
    
        while(this.numDecomposto(arrayDePares) && !existeZero)
        {
            if(this.ehFator(arrayDePares, fator))
            {
                listaDeFatores.add(fator);
                for(Integer i : arrayDePares)
                {
                    if(i != 1 && i%fator == 0)
                    {
                        arrayDePares.set(arrayDePares.indexOf(i), i/fator);
                    }
                }
            } else {
                fator++;
            }
        }
        
        for(Integer i : listaDeFatores)
        {
            mmc *= i;
        }  
        
        return mmc;
    }
    
    private boolean numDecomposto(ArrayList<Integer> arrayDePares)
    {
        for(int i : arrayDePares)
        {
            if(i != 1)
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean ehFator(ArrayList<Integer> arrayDePares, Integer fator)
    {
        for(int i : arrayDePares)
        {
            if(i%fator == 0)
            {
                return true;
            }
        }
        return false;
    }    
    
    private boolean exiteZero(ArrayList<Integer> arrayDePares)
    {
        for(int i : arrayDePares)
        {
            if(i == 0)
            {
                return true;
            }
        }
        return false;
    }   
}
