import java.util.*;

public class HobbitContador
{    
    public Integer calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares)
    {
        Integer diferenca = arrayDePares != null ? 0 : null;
        if(arrayDePares != null)
        {
            ArrayList<Integer> produtos = this.calculaProdutosDoArray(arrayDePares);
            ArrayList<Integer> mmc = this.calculaMinimoMultiplosDoArray(arrayDePares);
            
            for(int i=0; i < produtos.size(); i++)
            {
                diferenca += produtos.get(i) - mmc.get(i);
            }            
                     
        }
        return diferenca; 
    }
    
    private ArrayList<Integer> calculaProdutosDoArray(ArrayList<ArrayList<Integer>> arrayDePares)
    {
        ArrayList<Integer> produtos = new ArrayList<>(); 
        for(ArrayList<Integer> lista : arrayDePares)
        {
            Integer produto = 1;
            for(Integer i : lista)
            {
                produto *= i;
            }
            produtos.add(produto);
        }
        return produtos;
    }
    
    private ArrayList<Integer> calculaMinimoMultiplosDoArray(ArrayList<ArrayList<Integer>> arrayDePares)
    {
        ArrayList<Integer> mmcs = new ArrayList<>(); 
        
        for(ArrayList<Integer> lista : arrayDePares)
        {
            mmcs.add(this.calculaMMC(lista));
        }
        
        return mmcs;
    }
    
    private Integer calculaMMC(ArrayList<Integer> arrayDePares)
    {
        int fator = 2, mmc = 1;
        ArrayList<Integer> listaDeFatores = new ArrayList<Integer>();
        
        while(numDecomposto(arrayDePares))
        {
            if(ehFator(arrayDePares, fator))
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
}
