package automata;

import processing.core.PApplet;

/**
 * Automata celular de una dimension
 */
public class Automata extends PApplet {

    /** Cantidad de celdas a lo ancho */
    int ancho = 61;
    /** Cantidad de celdas a lo largo */
    int alto = 60;
    /** Tamaño en pixeles de una celda */
    int celda = 10;
    /** Representacion logica del automata */
    ModeloAutomata modelo;

    @Override
    public void setup(){
        frameRate(60);
        background(200);
        String binario = args[0];
        int b1 = parseInt(""+binario.charAt(0));
        int b2 = parseInt(""+binario.charAt(1));
        int b3 = parseInt(""+binario.charAt(2));
        int b4 = parseInt(""+binario.charAt(3));
        int b5 = parseInt(""+binario.charAt(4));
        int b6 = parseInt(""+binario.charAt(5));
        int b7 = parseInt(""+binario.charAt(6));
        int b8 = parseInt(""+binario.charAt(7));
        Regla regla = new Regla(b1, b2, b3, b4, b5, b6, b7, b8);
        modelo = new ModeloAutomata(ancho, alto, regla);
    }

    @Override
    public void settings(){
        size(ancho * celda,alto * celda);
    }

    @Override
    public void draw(){
        for (int i = 0; i < ancho; i++){
            for (int j = 0; j < alto; j++){
                if (modelo.mundo[i][j] == 0){
                    fill(255,255,255);
                    //stroke(255,255,255);
                    rect(i * celda, j * celda, celda, celda);
                }else{
                    fill(0,0,0);
                    // stroke(0,0,0);
                    rect(i * celda, j * celda, celda, celda);
                }
            }
        }
        // Generamos la siguiente generacion
        modelo.siguienteGeneracion();
    }

    /**
     * Representacion logica de un automata
     */
    class ModeloAutomata extends Thread {

        /** Cantidad de celdas a lo ancho */
        public int ancho;
        /** Cantidad de celdas a lo largo */
        public int alto;
        /** Regla a aplicar */
        Regla regla;
        /** Generacion actual */
        public int generacion = 0;
        /** Tablero del automata */
        public int[][] mundo;
        
        /**
         * Constructor del automata
         * @param ancho cantidad de celdas a lo ancho
         * @param alto cantidad de celdas a lo largo
         * @param regla regla a aplicar
         */
        public ModeloAutomata(int ancho, int alto, Regla regla){
            this.ancho = ancho;
            this.alto = alto;
            this.regla = regla;
            this.mundo = new int[ancho][alto];
            this.mundo[(int) (ancho/2)][0] = 1; // Primera Generacion
        }

        /**
         * Genera la siguiente generacion
         */
        public void siguienteGeneracion(){

            if (generacion == alto - 1){
                return;
            }

            for (int i = 1; i < ancho - 1 ; i++){
                int b1 = mundo[i-1][generacion]; // bit 1
                int b2 = mundo[i][generacion]; // bit 2
                int b3 = mundo[i+1][generacion]; // bit 3
                mundo[i][generacion + 1] = regla.regla(b1, b2, b3);
            }
            generacion++;
        }
    }

    public static void main(String[] args){
        String binario = "01011010"; // Regla 90 por default
        if(args.length > 0){
            binario = Integer.toBinaryString(parseInt(args[0]));
            for ( int i = binario.length() ;  i < 8; i++ ){
                binario = "0" + binario;
            }
        }
        PApplet.main(new String[] { "automata.Automata", binario });
    }

}