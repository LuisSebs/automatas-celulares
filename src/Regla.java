package src;
import java.util.HashMap;

public class Regla {

    /**
     * Reglas
     */
    HashMap<String, Integer> reglas = new HashMap<>();
    
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
