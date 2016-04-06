public class CestoDeLembas {
    
    private int numeroDePaes;
    
    public CestoDeLembas(int numeroDePaes) {
        this.numeroDePaes = numeroDePaes;
    }
    
    public boolean podeDividirEmPares() {
        return numeroDePaes > 2 && numeroDePaes <= 100 && numeroDePaes % 2 == 0;
        // terneiro
        // return podeDividir ? true : false;
    }
}











