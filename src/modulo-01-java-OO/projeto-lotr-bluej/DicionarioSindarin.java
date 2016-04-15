import java.util.*;

public class DicionarioSindarin
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao tradutor Sindarin! Escolha a linguagem:");
        System.out.println("[P]ortuguês [I]nglês");
        String idioma = scanner.nextLine();
        
        TradutorSindarin tradutor = criarTradutor(idioma);
        
        System.out.println("Digite a palavra que você deseja traduzir");
        String palavra = scanner.nextLine();
        System.out.println(palavra + " significa: " + tradutor.traduzir(palavra));
    }
    
    private static TradutorSindarin criarTradutor(String idioma)
    {
        TradutorSindarin tradutor = null;
        
        switch(idioma.toLowerCase()) {
            case "i":
                tradutor = new SindarinParaIngles();
                break;
            default:
                tradutor = new SindarinParaPortugues();            
                break;
        }
        
        return tradutor;
    }
    
    private static void rodarExemplosHashMap()
    {
        HashMap<String, String> dicionarioSindarin = new HashMap<>();
        dicionarioSindarin.put("terra", "amar");
        dicionarioSindarin.put("fogo", "naur");
        dicionarioSindarin.put("vento", "gwaew");
        dicionarioSindarin.put("água", "nen");
        dicionarioSindarin.put("coração", "gûr");
        
        // Obter um valor a partir de uma chave
        String terraEmSindarin = dicionarioSindarin.get("terra");
        // Sobrepor o valor de uma determinada chave
        dicionarioSindarin.put("água", "nîn");
        // Remover chave-valor
        dicionarioSindarin.remove("água");
        // Está vazio?
        boolean estaVazio = dicionarioSindarin.isEmpty();
        // Tamanho
        int tamanhoDePares = dicionarioSindarin.size();
        // Contém chave?
        boolean contemAgua = dicionarioSindarin.containsKey("água");
        // Contém valor?
        boolean contemNaur  = dicionarioSindarin.containsValue("naur");
        
        for (String chave : dicionarioSindarin.keySet()) {
            System.out.println(chave);
        }
        
        int qtdNaur = 0;
        for (String valor : dicionarioSindarin.values()) {
             if (valor.equals("naur")) {
                 qtdNaur++;
             }
        }
        System.out.println("Quantos tem naur: " + qtdNaur);
        
        qtdNaur = 0;
        for (Map.Entry<String, String> chaveValor : dicionarioSindarin.entrySet()) {
             if (chaveValor.getValue().equals("naur")) {
                 qtdNaur++;
                 System.out.println("A chave " + chaveValor.getKey() + " significa naur");
             }
        }
        
        System.out.println("Quantos tem naur: " + qtdNaur);
        
        dicionarioSindarin.put("FB", "facebook");
        dicionarioSindarin.put("Ea", "badoo");
        
        System.out.println("--------------------------------------");
        for (Map.Entry<String, String> chaveValor : dicionarioSindarin.entrySet()) {
            System.out.println("K: " + chaveValor.getKey() + "- V: " + chaveValor.getValue());
        }
    }
}
