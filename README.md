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

Ahora ejecutamos el programa con la regla que se quiera aplicar: 

```bash
java -cp ./classes:lib/core.jar automata.Automata <regla>
```

Por ejemplo, en el siguiente comando estamos aplicando la regla 150:

```bash
java -cp ./classes:lib/core.jar automata.Automata 150
```

Si se ejcuta sin especificar alguna regla se aplicara la regla 90 por default. 