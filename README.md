# Desafío 15: Simulación de carrera de vehículos

Simula una carrera de `Vehiculo` (subclases `Auto` y `Moto`) en la que cada vehículo avanza una **distancia aleatoria** en cada turno.  
Usa un **arreglo polimórfico** para los competidores y determina el ganador al final de **5 rondas**.

---

## Código en Java

```java
// Importa la clase Random para generar números aleatorios
import java.util.Random;

// Clase abstracta que define la estructura general de Vehiculo
abstract class Vehiculo {
     
    // Atributos de la clase Vehiculo
    protected String nombre;
    protected int distanciaRecorrida;
    
    // Constructor de la clase Vehiculo
    public Vehiculo(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }

    // Método abstracto que define cómo avanza cada vehículo
    public abstract void avanzar();

    // Get para obtener el nombre del Vehiculo
    public String getNombre() {
        return nombre;
    }

    // Get para obtener la distancia recorrida por el Vehiculo
    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }
}

// Subclase Auto que hereda de Vehiculo
class Auto extends Vehiculo {
    private Random random = new Random();

    // Constructor que llama al constructor de la clase padre con super
    public Auto(String nombre) {
        super(nombre);
    }

    // Implementación del método avanzar() para Autos
    public void avanzar() {
        int avance = random.nextInt(6) + 5; // Avanza entre 5 y 10 metros
        distanciaRecorrida += avance;
        System.out.println("El auto: " + nombre + " avanza " + avance + " metros. Total recorrido: " + distanciaRecorrida);
    }
}

// Subclase Moto que hereda de Vehiculo
class Moto extends Vehiculo {
    private Random random = new Random();

    // Constructor que llama al constructor de la clase padre con super
    public Moto(String nombre) {
        super(nombre);
    }

    // Implementación del método avanzar() para Motos
    public void avanzar() {
        int avance = random.nextInt(6) + 5; // Avanza entre 5 y 10 metros
        distanciaRecorrida += avance;
        System.out.println("La moto: " + nombre + " avanza " + avance + " metros. Total recorrido: " + distanciaRecorrida);
    }
}

// Clase principal main
public class Desafio_15 {
    public static void main(String[] args) {
        // Arreglo polimórfico de vehículos participantes
        Vehiculo[] participantes = new Vehiculo[4];
        participantes[0] = new Auto("ByD");
        participantes[1] = new Moto("Honda");
        participantes[2] = new Auto("Fiat");
        participantes[3] = new Moto("Zanella");

        System.out.println("Inicia la carrera");

        // Simula 5 rondas de la carrera
        for (int ronda = 1; ronda <= 5; ronda++) {
            System.out.println("Ronda " + ronda + ":");
            for (Vehiculo v : participantes) {
                v.avanzar();
            }
        }

        // Determinar ganador comparando las distancias
        Vehiculo ganador = participantes[0];
        for (Vehiculo v : participantes) {
            if (v.getDistanciaRecorrida() > ganador.getDistanciaRecorrida()) {
                ganador = v;
            }
        }

        System.out.println("El vehículo ganador es: " + ganador.getNombre() + " con " + ganador.getDistanciaRecorrida() + " metros recorridos.");
    }
}
```
---

## Fundamentación

Primeramente, se creó un proyecto con una clase principal (main), donde se probó el funcionamiento general del programa. 
Posteriormente, se creó la clase abstracta Vehiculo, que contiene el método abstracto avanzar(), y dos clases concretas que 
implementan los comportamientos específicos de sus subclases: Auto y Moto.

En todas las clases hubo que importar la clase Random de Java, lo que permite generar números aleatorios para simular el 
avance de los vehículos en cada una de las 5 rondas. 

Luego, se define una clase abstracta Vehiculo que actúa como clase padre para los tipos de vehículos. Esta clase contiene 
los atributos nombre y distanciaRecorrida, declarados como protected para que sean accesibles desde las subclases y dentro 
del mismo paquete, sin necesidad de exponerlos al exterior. 

Esta clase abstracta incluye un constructor que inicializa estos atributos y define un método abstracto avanzar(), el cual 
se implementará en cada subclase con su propio comportamiento específico de avance. 

Además, se incluyen métodos `getNombre() y getDistanciaRecorrida()` para acceder a los valores de estos atributos.
Las subclases Auto y Moto heredan de Vehiculo (mediante extends) e implementan de forma concreta el método `avanzar()`. 
Cada una de estas subclases utiliza un objeto Random para determinar de forma aleatoria la distancia en metros que avanzan en cada turno. 
La distancia se acumula en la variable `distanciaRecorrida`, y mediante `System.out.println` se muestran el tipo de vehículo, 
su avance y el total acumulado.

En la clase principal Desafio_15, se crea un arreglo polimórfico de tipo Vehiculo[ ] que contiene instancias de Auto y Moto. 
Acá se aprovecha el polimorfismo, ya que se puede llamar al método `avanzar()` sobre referencias de tipo Vehiculo y se ejecuta 
la implementación correspondiente a cada subclase. 

Luego se implementa un bucle for que simula cinco rondas de la carrera, invocando el método `avanzar()` para cada vehículo en cada ronda.
Al finalizar las rondas, se determina el ganador mediante la comparación de las distancias recorridas. 

Inicialmente, se considera que el primer vehículo del arreglo es el ganador provisorio, y mediante un bucle for se va comparando 
la `DistanciaRecorrida()` de cada vehículo con el ganador provisorio y se va actualizando la variable ganador con el que recorrió más distancia. 

Se imprime en pantalla el nombre del vehículo ganador junto con la distancia total recorrida en metros: 
```java
Inicio de la carrera
Ronda 1:
El auto: ByD avanza 5 metros. Total: 5
La moto: Honda avanza 8 metros. Total: 8
El auto: Fiat avanza 7 metros. Total: 7
La moto: Zanella avanza 8 metros. Total: 8
Ronda 2:
El auto: ByD avanza 6 metros. Total: 11
La moto: Honda avanza 5 metros. Total: 13
El auto: Fiat avanza 8 metros. Total: 15
La moto: Zanella avanza 6 metros. Total: 14
Ronda 3:
El auto: ByD avanza 7 metros. Total: 18
La moto: Honda avanza 8 metros. Total: 21
El auto: Fiat avanza 9 metros. Total: 24
La moto: Zanella avanza 7 metros. Total: 21
Ronda 4:
El auto: ByD avanza 7 metros. Total: 25
La moto: Honda avanza 8 metros. Total: 29
El auto: Fiat avanza 8 metros. Total: 32
La moto: Zanella avanza 9 metros. Total: 30
Ronda 5:
El auto: ByD avanza 6 metros. Total: 31
La moto: Honda avanza 8 metros. Total: 37
El auto: Fiat avanza 8 metros. Total: 40
La moto: Zanella avanza 6 metros. Total: 36
El vehículo ganador es: Fiat con 40 metros recorridos.
```
