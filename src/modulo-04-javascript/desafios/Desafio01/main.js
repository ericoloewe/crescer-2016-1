/*
 *  Função gerarPalavras
 */
function gerarPalavras(hash) {
    var variacoes = function(hash, letras) {
        var palavrasGeradas = new Array();
         
        for(quantidade in hash) {
            hash[quantidade].forEach(function(letra) {
                variacoesPossiveis += (quantidade - 1) * letras.length;
            });
        }
        
        variacoesPossiveis += Math.pow(letras.length, letras.length-1);
        
        return variacoesPossiveis;
    };
    var variacoesPossiveis = 0;
    var letras = new Array();
    
    for(quantidade in hash) {
        hash[quantidade].forEach(function(letra) {
            letras.push(letra); 
        });
    }
       
    variacoesPossiveis = variacoes(hash, letras);
    
    console.log(variacoesPossiveis);
}