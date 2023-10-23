/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CarpetaClases;

import CarpetaInterfaz.PersonajeInterfaz;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Luisp
 */
public class InteligenciaArtificial extends Thread{
    
    Administrador Administrador;
    boolean Ejecucion = true;

    Personaje PersonajeN;
    Personaje PersonajeS;

    int Tiempo;

    Random rand = new Random();

    public Semaphore Semaforo;

    public PersonajeInterfaz PersonajeInterfazN = Proyecto2Operativos.ObjetoInterfaz.getPersonajeN();
    public PersonajeInterfaz PersonajeInterfazS = Proyecto2Operativos.ObjetoInterfaz.getPersonajeS();
    //ACTUALIZAR CON CANTIDAD DE ICONOS
    public int TotalCaracteres = 20;

    public InteligenciaArtificial() {
        this.Administrador = Proyecto2Operativos.Admin;
        this.Tiempo = 10 * 1000;
        this.Semaforo = Proyecto2Operativos.Semaforo;
    }}
    /*
    public void run() { 
        try {
            // null safety check
            while (Ejecucion) {
                
                int TiempoRestante = Tiempo;

                Semaforo.acquire();

                if (PersonajeN == null || PersonajeS == null) {
                    Administrador.DevolverCapitulos(PersonajeN, PersonajeS);
                    Thread.sleep(Tiempo);

                } else {
                    ActualizarPersonajesInterfaz();
                    Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Pelea");

    
}
    
    public void ActualizarPersonajesInterfaz() {
        this.PersonajeInterfazN.ActualizarPersonjaeInterfaz(PersonajeN);
        this.PersonajeInterfazS.ActualizarPersonjaeInterfaz(PersonajeS);
    }
}*/
