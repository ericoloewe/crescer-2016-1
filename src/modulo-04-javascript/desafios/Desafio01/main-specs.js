/*
 * Desafio - 01
 */
describe('Exemplos ex 1', function() {
  it('quando informa 2a, 1b 1c', function() {
    var esperado = ['aabc', 'aacb', 'abac', 'abca', 'acab', 'acba', 'baac', 'baca', 'bcaa', 'caab', 'caba', 'cbaa'];
    expect(gerarPalavras({ 2: [ 'a' ], 1: [ 'b', 'c' ] })).toEqual(esperado);
  });
});