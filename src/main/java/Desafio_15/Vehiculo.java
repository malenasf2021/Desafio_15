
package Desafio_15;

//Importa la clase random para generar números aleatorios
import java.util.Random;

// Clase abstracta que define la estructura general de Vehiculo
abstract class Vehiculo {
     
    //Atributos de la clase Vehiculo
    protected String nombre;
    protected int distanciaRecorrida;
    
    //Constructor de la clase Vehiculo
    public Vehiculo(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }

    // Método abstracto que define como avanza cada vehiculo
    public abstract void avanzar();


    //Get para obtener el nombre del Vehiculo
    public String getNombre() {
        return nombre;
    }

    //Get para obtener la distancia recorrida por el Vehiculo
    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }



}

