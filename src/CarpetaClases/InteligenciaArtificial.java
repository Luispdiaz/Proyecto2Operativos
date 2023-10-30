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
    int GanadoresN;
    int GanadoresS;
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
        this.GanadoresN = 0;
        this.GanadoresS = 0;
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
                    Administrador.ActualizarColasInterfaz();
                    Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Dictaminando el Ganador");
                    PersonajeInterfazN.CambiarIconoPelea();
                    PersonajeInterfazS.CambiarIconoPelea();
                    int result = rand.nextInt(100);
                    if (result <= 40) { // 40%
                        if(PersonajeN.Global>PersonajeS.Global){
                        PersonajeInterfazN.CambiarIcono(PersonajeN);
                        PersonajeInterfazS.CambiarIcono(PersonajeS);
                        Thread.sleep(Tiempo);
                        Ganadores[contadorGanadores] = PersonajeN.id;
                        GanadoresN++;
                        Proyecto2Operativos.ObjetoInterfaz.ActualizarGanadores(PersonajeN, GanadoresN);
                        PersonajeInterfazN.CambiarIconoGanador();
                        PersonajeInterfazS.CambiarIconoPerdedor();
                        Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Declarando al Ganador");
                        ActualizarPersonajesInterfaz();
                        Thread.sleep(5000);
                        }
                        else if(PersonajeN.Global<PersonajeS.Global){
                        PersonajeInterfazN.CambiarIcono(PersonajeN);
                        PersonajeInterfazS.CambiarIcono(PersonajeS);
                        Thread.sleep(Tiempo);
                        Ganadores[contadorGanadores] = PersonajeS.id;
                        GanadoresS++;
                        Proyecto2Operativos.ObjetoInterfaz.ActualizarGanadores(PersonajeS, GanadoresS);
                        PersonajeInterfazS.CambiarIconoGanador();
                        PersonajeInterfazN.CambiarIconoPerdedor();
                        Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Declarando al Ganador");
                        ActualizarPersonajesInterfaz();
                        Thread.sleep(5000);
                        }
                        else{
                            if(PersonajeS.Global<19){
                                PersonajeS.Global++;  
                                PersonajeInterfazN.CambiarIcono(PersonajeN);
                                PersonajeInterfazS.CambiarIcono(PersonajeS);
                                Thread.sleep(Tiempo);
                                Ganadores[contadorGanadores] = PersonajeS.id;
                                GanadoresS++;
                                Proyecto2Operativos.ObjetoInterfaz.ActualizarGanadores(PersonajeS, GanadoresS);
                                PersonajeInterfazS.CambiarIconoGanador();
                                PersonajeInterfazN.CambiarIconoPerdedor();
                                Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Declarando al Ganador");
                                ActualizarPersonajesInterfaz();
                                Thread.sleep(5000);
                                }
                            else{
                                PersonajeN.Global--;  
                                PersonajeInterfazN.CambiarIcono(PersonajeN);
                                PersonajeInterfazS.CambiarIcono(PersonajeS);
                                Thread.sleep(Tiempo);
                                Ganadores[contadorGanadores] = PersonajeS.id;
                                GanadoresS++;
                                Proyecto2Operativos.ObjetoInterfaz.ActualizarGanadores(PersonajeS, GanadoresS);
                                PersonajeInterfazS.CambiarIconoGanador();
                                PersonajeInterfazN.CambiarIconoPerdedor();
                                Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Declarando al Ganador");
                                ActualizarPersonajesInterfaz();
                                Thread.sleep(5000);
                            }
                        
                        }
                    } else if (result <= 67) { // 27%
                    PersonajeN.Global = PersonajeS.Global;
                    PersonajeInterfazN.CambiarIcono(PersonajeN);
                    PersonajeInterfazS.CambiarIcono(PersonajeS);
                    Thread.sleep(Tiempo);
                    Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Declarando al Ganador");
                    PersonajeInterfazN.CambiarIconoEmpate();
                    PersonajeInterfazS.CambiarIconoEmpate();
                    Administrador.DevolverCapitulos(PersonajeN, PersonajeS);
                    ActualizarPersonajesInterfaz();
                    Administrador.ActualizarColasInterfaz();
                    Thread.sleep(5000);
                    }
                    else { // 33%
                    PersonajeInterfazN.CambiarIcono(PersonajeN);
                    PersonajeInterfazS.CambiarIcono(PersonajeS);
                    Thread.sleep(Tiempo);
                    Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Enviando a Reforzar");
                    Administrador.DevolverCapitulosRecuperacion(PersonajeN, PersonajeS);
                    PersonajeInterfazS.CambiarIconoReforzar();
                    PersonajeInterfazN.CambiarIconoReforzar();
                    ActualizarPersonajesInterfaz();
                    Administrador.ActualizarColasInterfaz();
                    Thread.sleep(5000);
                    }
                    Proyecto2Operativos.ObjetoInterfaz.setEstadoIA("Esperando Contrincantes");
                    PersonajeInterfazN.CambiarIconoEsperar();
                    PersonajeInterfazS.CambiarIconoEsperar();
                    Thread.sleep(3000);
                }
                this.Semaforo.release();
                Thread.sleep(100);
            }
        }catch (InterruptedException ex) {
            System.out.println("Error");
        }
    }

    
    public void ActualizarPersonajesInterfaz() {
        this.PersonajeInterfazN.ActualizarPersonjaeInterfaz(PersonajeN);
        this.PersonajeInterfazS.ActualizarPersonjaeInterfaz(PersonajeS);
    }

    public int getTiempo() {
        return Tiempo;
    }

    public void setTiempo(int Tiempo) {
        this.Tiempo = Tiempo;
    }
    
}
