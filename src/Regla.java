package src;
import java.util.HashMap;

public class Regla {

    HashMap<String, Integer> reglas = new HashMap<>();
    
    public int regla(int b1, int b2, int b3){
        return reglas.get(""+b1+b2+b3);
    }
}
