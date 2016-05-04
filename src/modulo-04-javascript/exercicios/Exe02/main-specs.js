'use strict';

/*
 * Exercício 1
 */
describe('Ex 1. Doadores de sangue', function () {
    it("quando chamar a função deve retornar o cavaleiro com id 5, 9 e 12 com o sangue O", function () {
        // arrange
        var idEsperado = [5, 9, 12];
        var tipoSanguineoEsperado = "O";
        
        // act
        var obtido = obterDoadores();        
        
        // assert
        idEsperado.forEach(function(id, i) {
            expect(id).toEqual(obtido[i].id);
            expect(tipoSanguineoEsperado).toEqual(obtido[i].tipoSanguineo);
        });
    });
});

/*
 * Exercício 2
 */
describe('Ex 2. Canivete suíço', function () {
    it("quando chamar a função deve retornar o cavaleiro com id 6 com o nome 'Shaka'", function () {
        // arrange
        var idEsperado = 6;
        var nomeEsperado = "Shaka";
        
        // act
        var obtido = obterCavaleiroComMaisGolpes();        
        
        // assert
        expect(idEsperado).toEqual(obtido.id);
        expect(nomeEsperado).toEqual(obtido.nome);
    });
});

/*
 * Exercício 3
 */
describe('Ex 3. Aniversários', function () {
    it("quando chamar a função deve retornar Março, Maio e Novembro", function () {
        // arrange
        var esperado = ["Março", "Maio", "Novembro"];
        
        // act
        var obtido = obterMesesComMaisAniversarios();        
        
        // assert
        expect(esperado).toEqual(obtido);
    });
});

/*
 * Exercício 4
 */
describe('Ex 4. Altura média', function () {
    it("quando chamar a função deve retornar 1,85", function () {
        // arrange
        var esperado = 1.85;
        
        // act
        var obtido = obterAlturaMedia();        
        
        // assert
        expect(esperado).toEqual(obtido);
    });
});

/*
 * Exercício 5
 */
describe('Ex 5. Altura mediana', function () {
    it("quando chamar a função deve retornar 1,84", function () {
        // arrange
        var esperado = 1.84;
        
        // act
        var obtido = obterAlturaMediana();        
        
        // assert
        expect(esperado).toEqual(obtido);
    });
});

/*
 * Exercício 6
 */
describe('Ex 6. Peso médio', function () {
    it("A - quando chamar a função deve retornar 84,27", function () {
        // arrange
        var esperado = 84.27;
        
        // act
        var obtido = obterPesoMedio();        
        
        // assert
        expect(esperado).toEqual(obtido);
    });    
    it("B - quando chamar a função deve retornar 80,67", function () {
        // arrange
        var esperado = 80.67;
        
        // act
        var obtido = obterPesoMedioDoadores();        
        
        // assert
        expect(esperado).toEqual(obtido);
    });
});

/*
 * Exercício 7
 */
describe('Ex 7. IMC', function () {
    it("quando chamar a função deve retornar um array com 22.64, 29.48, 24.62, 24.22, 24.84, 20.53, 24.54, 24.31, 23.99, 22.45 e 21.5", function () {
        // arrange
        var esperado = [22.64, 29.48, 24.62, 24.22, 24.84, 20.53, 24.54, 24.31, 23.99, 22.45, 21.5];
        
        // act
        var obtido = obterIMC();        
        
        // assert
        expect(esperado).toEqual(obtido);
    });
});

/*
 * Exercício 8
 */
describe('Ex 8. Sobrepeso', function () {
    it("quando chamar a função deve retornar o Aldebaran", function () {
        // arrange
        var nomeEsperado = "Aldebaran";
        var idEsperado = 2;
        
        // act
        var obtido = obterSobrepeso();
        
        // assert
        expect(nomeEsperado).toEqual(obtido[0].nome);
        expect(idEsperado).toEqual(obtido[0].id);
    });
});