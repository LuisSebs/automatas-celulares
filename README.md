# Automatas Celulares

Un autómata celular consiste en una serie de celdas, cada una coloreada ya sea de color blanco  o negro. En cada paso hay entonces una regla definida que determina el color de una celda dada dependiente del color de esa celda y de los vecinos inmediatos izquierdo y derecho del paso anterior.

![cellular automaton](https://mathworld.wolfram.com/images/eps-svg/ElementaryCARule090_1000.svg)

# Ejecucion

Para correr la práctica crea un carpeta `./classes`
```bash
mkdir ./classes
```

Ejecuta el siguiente comando para compilar todas las clases

```bash
javac -d ./classes -cp lib/core.jar:. automata/*.java
```

Ejecuta el siguiente comando.

```bash
java -cp ./classes:lib/core.jar automata.Automata
```

Al ejecutar el programa se mostara por pantalla un autómata celular usando la **regla90**. Puedes crear mas reglas y usarlas en el automata. Para esto crea una nueva clase en un archivo por separado con una estructura similar al de `Regla90.java`. Al final solo pasalo como argumento al crear el modelo del automata dentro del archivo `Automata.java`.

## `Automata.java`
```java
@Override
    public void setup(){
        frameRate(60);
        background(200);
        // Agrega aquí la regla que quieras usar
        Regla regla = new Regla90();
        modelo = new ModeloAutomata(ancho, alto, regla);
    }
```