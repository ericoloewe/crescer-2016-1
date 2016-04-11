import java.util.*;

public class HobbitContador
{    
    public Integer calcularDiferenca(ArrayList<ArrayList<Integer>> lista)
    {
        return lista != null ? this.calcularDiferencaV2(lista, 0) : null;
    }
    
    private Integer calcularDiferencaV2(ArrayList<ArrayList<Integer>> lista, int i)
    {
        if(i == lista.size()) 
            return 0;        
        return calcularDiferencaV2(lista, i + 1) + (calculaProduto(lista.get(i)) - calculaMinimoMultiplo(lista.get(i)));
    }    
    
    private ArrayList<Integer> calculaProdutosDoArray(ArrayList<ArrayList<Integer>> arrayDePares)
    {
        ArrayList<Integer> produtos = new ArrayList<>(); 
        for(ArrayList<Integer> lista : arrayDePares)
        {
            produtos.add(calculaProduto(lista));
        }
        return produtos;
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
    
    private ArrayList<Integer> calculaMinimoMultiplosDoArray(ArrayList<ArrayList<Integer>> arrayDePares)
    {
        ArrayList<Integer> mmcs = new ArrayList<>(); 
        
        for(ArrayList<Integer> lista : arrayDePares)
        {
            mmcs.add(this.calculaMinimoMultiplo(lista));
        }
        
        return mmcs;
    }
    
    private Integer calculaMinimoMultiplo(ArrayList<Integer> arrayDePares)
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
