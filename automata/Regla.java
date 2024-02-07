package automata;
import java.util.HashMap;

public class Regla {

    /**
     * Reglas
     */
    HashMap<String, Integer> reglas = new HashMap<>();

    /**
     *  Constructor de una regla.
     *  Va del bit mas significativo (b1) al menos significativo (b8)
     * @param b1 -> 111
     * @param b2 -> 110
     * @param b3 -> 101
     * @param b4 -> 100
     * @param b5 -> 011
     * @param b6 -> 010
     * @param b7 -> 001
     * @param b8 -> 000
     */
    public Regla(int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8){
        reglas.put("000", b8);
        reglas.put("001", b7);
        reglas.put("010", b6);
        reglas.put("011", b5);
        reglas.put("100", b4);
        reglas.put("101", b3);
        reglas.put("110", b2);
        reglas.put("111", b1);
    }
    
    /**
     * Aplica la regla
     * @param b1 bit1
     * @param b2 bit2
     * @param b3 bit3
     * @return el resultado de la combinacion
     * de b1, b2 y b3
     */
    public int regla(int b1, int b2, int b3){
        return reglas.get(""+b1+b2+b3);
    }
}
