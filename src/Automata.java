package src;

import processing.core.PApplet;

public class Automata extends PApplet {

    int ancho = 61;
    int alto = 60;
    int celda = 10;
    ModeloAutomata modelo;
    Regla regla;

    @Override
    public void setup(){
        frameRate(60);
        background(200);
        modelo = new ModeloAutomata(ancho, alto, new Regla90());
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
        modelo.siguienteGeneracion();
    }

    class ModeloAutomata extends Thread {

        public int ancho;
        public int alto;
        Regla regla;
        public int generacion = 0;
        public int[][] mundo;
        
        public ModeloAutomata(int ancho, int alto, Regla regla){
            this.ancho = ancho;
            this.alto = alto;
            this.regla = regla;
            this.mundo = new int[ancho][alto];
            this.mundo[(int) (ancho/2)][0] = 1; // Primera Generacion
        }

        public void siguienteGeneracion(){

            if (generacion == alto - 1){
                return;
            }

            for (int i = 1; i < ancho - 1 ; i++){
                int b1 = mundo[i-1][generacion];
                int b2 = mundo[i][generacion];
                int b3 = mundo[i+1][generacion];
                int resultado = regla.regla(b1, b2, b3);
                mundo[i][generacion + 1] = resultado;
            }
            generacion++;
        }
    }

    public static void main(String[] args){
        PApplet.main(new String[] { "src.Automata" });
    }

}