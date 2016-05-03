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
 * Exercício 2
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