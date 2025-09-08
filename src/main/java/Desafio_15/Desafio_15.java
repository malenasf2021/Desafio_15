
package Desafio_15;

import java.util.Random;


public class Desafio_15 {

    public static void main(String[] args) {
         // Objeto Random para otras implementaciones
        //Random random = new Random();
        
        //Arreglo polimórfico de vehículos participantes de la carrera
        Vehiculo[] participantes = new Vehiculo[4]; 
            participantes[0] = new Auto("ByD");
            participantes[1] = new Moto("Honda");
            participantes[2] = new Auto("Fiat");
            participantes[3] = new Moto("Zanella");
       

        System.out.println("Inicio de la carrera");
        //Bucle que simula 5 rondas de la carrera
        for (int ronda = 1; ronda <= 5; ronda++) {
            //Indica cada ronda
            System.out.println("Ronda " + ronda + ":");
            
            //v es cada elemento del arreglo: auto o moto
            for (Vehiculo v : participantes) {
                //llama al método de cada vehículo
                v.avanzar();
            }
        }

        // Determinar ganador comparando las distancias
        //El primer vehículo es el ganador provisorio
        Vehiculo ganador = participantes[0];
        
        //Recorre el arreglo de participantes
        for (Vehiculo v : participantes) {

            //Comparar la distancia de cada vehículo con la del ganador provisorio
            if (v.getDistanciaRecorrida() > ganador.getDistanciaRecorrida()) {

                //Se actualiza la variable ganador si algún vehículo recorrió más distancia
                ganador = v;
            }
        }

        System.out.println("El vehículo ganador es: " + ganador.getNombre() + " con " + ganador.getDistanciaRecorrida() + " km recorridos.");
    }
}
