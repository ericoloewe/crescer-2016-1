'use strict';
/*
 * Lista 1 de exercicios de javascript
 */

// exe01
function daisyGame(num) {
    return num%2 == 0 ? 'Love me not' : 'Love me';
}

// exe02
function maiorTexto(arrayDeStrings) {
    var maiorTexto = undefined;
    if(Array.isArray(arrayDeStrings))
    {
        maiorTexto = arrayDeStrings.shift();
        arrayDeStrings.forEach(function (str) {
            if(typeof str === "string" && str.length > maiorTexto.length)
            {
                maiorTexto = str;
            }            
        });
    }    
    return maiorTexto;    
}

// exe03
function imprime(nomes, funcParaImprimir) {
    if(typeof funcParaImprimir === "function" && Array.isArray(nomes))
        nomes.forEach(function(nome) {
            funcParaImprimir(nome);
        });
}

// exe04
function adicionar(a) {
    return function(b) {
        return a + b;
    };
}

// exe05
function fiboSum(num) {
    var fiboNumeros = 0;
    for(var i = 1; i <= num; i++) {
        fiboNumeros += fibonacci(i); 
    }
    return fiboNumeros;
}

function fibonacci(n) {
    return n < 2 ? n : fibonacci(n - 1) + fibonacci(n - 2);
}

// exe06
function queroCafe(numero, listaDeNumeros) {
    var numerosMenores = new Array();
    if(Array.isArray(listaDeNumeros)) {
        listaDeNumeros.forEach(function(num) {
            if(num <= numero)
                numerosMenores.push(num);
        });
    }        
    return numerosMenores.sort().toString();
}

// exe07
function contarPorTipo(obj, tipo) {
    var podeContinuar = false;
    var tiposAceitos = ['string', 'number', 'boolean', 'object', 'undefined', 'null', 'function', 'array'];
    
    tiposAceitos.forEach(function(t) {
        if(t == tipo) {
            podeContinuar = true;
        }            
    });
    
    if(!podeContinuar)
        return;
    
    var soma = 0;
    for(var i in obj)
    {
        if(typeof obj[i] === "object") {
           if(obj[i] === null && tipo === "null")
               soma++;
           else if(Array.isArray(obj[i]) && tipo === "array")
               soma++;
           else if(tipo === "object")
               soma++;
        } else if(typeof obj[i] === tipo)
            soma++;
    }
    return soma;
}

// exe08

var gohan = 'gohan', goku = 'Goku';
function revelarSaiyaman() {
  console.log(gohan);
  goku = 'Son Goku';
  var gohan = 'Son ' + gohan;
  return gohan;
}
console.log(revelarSaiyaman());
console.log(goku);

/*
 *  Gohan e goku estavam fora da função, logo, eles são tratados como variaveis "publicas" ou "globais"
 *  quando é chamado o metodo, dentro do metodo dão um console.log do qual mostra undefined, porem quando atribuem
 *  'Son Goku' ao goku, o goku recebe o valor estipulado, e quando atribuem ao gohan, retorna como undefined.
 *  É um comportamento muito estranho de uma linguagem isso, é confuso, e não cheguei em uma conclusão sem analisar o compilador :(
 */