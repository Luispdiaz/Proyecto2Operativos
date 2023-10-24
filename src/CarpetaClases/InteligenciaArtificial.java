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
    String[] Ganadores;
    int contadorGanadores;
    Personaje PersonajeN;
    Personaje PersonajeS;

    int Tiempo;

    Random rand = new Random();

    public Semaphore Semaforo;

    public PersonajeInterfaz PersonajeInterfazN = Proyecto2Operativos.ObjetoInterfaz.getPersonajeN();
    public PersonajeInterfaz PersonajeInterfazS = Proyecto2Operativos.ObjetoInterfaz.getPersonajeS();
    public int TotalCaracteres = 20;

    public InteligenciaArtificial() {
        this.Administrador = Proyecto2Operativos.Admin;
        this.Tiempo = 10 * 1000;
        this.Semaforo = Proyecto2Operativos.Semaforo;
        this.Ganadores = new String[100];
        this.contadorGanadores = 0;
    }
    
    public void run() {
        try {
            while (Ejecucion) {
                

                Semaforo.acquire();

                if (PersonajeN == null || PersonajeS == null) {
                    Administrador.DevolverCapitulos(PersonajeN, PersonajeS);
                    Thread.sleep(Tiempo);

                } else {
                    ActualizarPersonajesInterfaz();
                    Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Pelea");
                    PersonajeInterfazS.CambiarIconoPelea();
                    PersonajeInterfazS.CambiarIconoPelea();

                    int result = rand.nextInt(100);
                    if (result <= 40) { // 40%
                        if(PersonajeN.Global>PersonajeS.Global){
                        PersonajeInterfazN.CambiarIcono(PersonajeN);
                        PersonajeInterfazS.CambiarIcono(PersonajeS);
                        Thread.sleep(Tiempo);
                        Ganadores[contadorGanadores] = PersonajeN.id;
                        PersonajeInterfazN.CambiarIconoGanador();
                        PersonajeInterfazS.CambiarIconoPerdedor();
                        Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Fin");
                        ActualizarPersonajesInterfaz();
                        }
                        else if(PersonajeN.Global<PersonajeS.Global){
                        PersonajeInterfazN.CambiarIcono(PersonajeN);
                        PersonajeInterfazS.CambiarIcono(PersonajeS);
                        Thread.sleep(Tiempo);
                        Ganadores[contadorGanadores] = PersonajeS.id;
                        PersonajeInterfazS.CambiarIconoGanador();
                        PersonajeInterfazN.CambiarIconoPerdedor();
                        Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Fin");
                        ActualizarPersonajesInterfaz();
                        }
                        else{
                            if(PersonajeS.Global<19){
                                PersonajeS.Global++;  
                                PersonajeInterfazN.CambiarIcono(PersonajeN);
                                PersonajeInterfazS.CambiarIcono(PersonajeS);
                                Thread.sleep(Tiempo);
                                Ganadores[contadorGanadores] = PersonajeS.id;
                                PersonajeInterfazS.CambiarIconoGanador();
                                PersonajeInterfazN.CambiarIconoPerdedor();
                                Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Fin");
                                ActualizarPersonajesInterfaz();
                                }
                            else{
                                PersonajeN.Global--;  
                                PersonajeInterfazN.CambiarIcono(PersonajeN);
                                PersonajeInterfazS.CambiarIcono(PersonajeS);
                                Thread.sleep(Tiempo);
                                Ganadores[contadorGanadores] = PersonajeS.id;
                                PersonajeInterfazS.CambiarIconoGanador();
                                PersonajeInterfazN.CambiarIconoPerdedor();
                                Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Fin");
                                ActualizarPersonajesInterfaz();
                            }
                        
                        }
                    } else if (result <= 67) { // 27%
                    PersonajeN.Global = PersonajeS.Global;
                    PersonajeInterfazN.CambiarIcono(PersonajeN);
                    PersonajeInterfazS.CambiarIcono(PersonajeS);
                    Thread.sleep(Tiempo);
                    Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Fin");
                     PersonajeInterfazN.CambiarIconoEmpate();
                     PersonajeInterfazS.CambiarIconoEmpate();
                     Administrador.DevolverCapitulos(PersonajeN, PersonajeS);
                     ActualizarPersonajesInterfaz();
                    }
                     else { // 33%
                    PersonajeInterfazN.CambiarIcono(PersonajeN);
                    PersonajeInterfazS.CambiarIcono(PersonajeS);
                    Thread.sleep(Tiempo);
                    Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Reforzar");
                    Administrador.DevolverCapitulosRecuperacion(PersonajeN, PersonajeS);
                    ActualizarPersonajesInterfaz();
                    }
                    Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Esperando");
                }
                this.Semaforo.release();
            }
        }catch (InterruptedException ex) {
            System.out.println("Error");
        }
    }

    
    public void ActualizarPersonajesInterfaz() {
        this.PersonajeInterfazN.ActualizarPersonjaeInterfaz(PersonajeN);
        this.PersonajeInterfazS.ActualizarPersonjaeInterfaz(PersonajeS);
    }
}
