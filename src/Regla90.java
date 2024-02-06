package src;

public class Regla90 extends Regla {

    public Regla90(){
        super();
        reglas.put("000", 0);
        reglas.put("001", 1);
        reglas.put("010", 0);
        reglas.put("011", 1);
        reglas.put("100", 1);
        reglas.put("101", 0);
        reglas.put("110", 1);
        reglas.put("111", 0);
    }
}
