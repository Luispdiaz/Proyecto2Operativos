/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CarpetaClases;

import CarpetaInterfaz.ColaInterfaz;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Luisp
 */
public class Administrador extends Thread{
    
    int ContadorAdmin = 0;
    int IndiceN = 0;
    int IndiceS = 0;

    boolean Ejecucion = true;

    public ColaInterfaz ColaInterfazN1;
    public Cola ColaN1;

    public ColaInterfaz ColaInterfazN2;
    public Cola ColaN2;

    public ColaInterfaz ColaInterfazN3;
    public Cola ColaN3;

    public ColaInterfaz ColaInterfazRecuperacionN;
    public Cola ColaRecuperacionN;

    public ColaInterfaz ColaInterfazS1;
    public Cola ColaS1;

    public ColaInterfaz ColaInterfazS2;
    public Cola ColaS2;

    public ColaInterfaz ColaInterfazS3;
    public Cola ColaS3;

    public ColaInterfaz ColaInterfazRecuperacionS;
    public Cola ColaRecuperacionS;

    public Random rand = new Random();
    
    public InteligenciaArtificial IA;
    public Semaphore Semaforo;

    public Administrador() {
        CrearColas();
        Semaforo = Proyecto2Operativos.Semaforo;
    }

    
    
    private void CrearColas() {
        ColaInterfazN1 = Proyecto2Operativos.ObjetoInterfaz.getColaN1();
        ColaN1 = new Cola();

        ColaInterfazN2 = Proyecto2Operativos.ObjetoInterfaz.getColaN2();
        ColaN2 = new Cola();

        ColaInterfazN3 = Proyecto2Operativos.ObjetoInterfaz.getColaN3();
        ColaN3 = new Cola();

        ColaInterfazRecuperacionN = Proyecto2Operativos.ObjetoInterfaz.getColaRecuperacionN();
        ColaRecuperacionN = new Cola();

        ColaInterfazS1 = Proyecto2Operativos.ObjetoInterfaz.getColaS1();
        ColaS1 = new Cola();

        ColaInterfazS2 = Proyecto2Operativos.ObjetoInterfaz.getColaS2();
        ColaS2 = new Cola();

        ColaInterfazS3 = Proyecto2Operativos.ObjetoInterfaz.getColaS3();
        ColaS3 = new Cola();

        ColaInterfazRecuperacionS = Proyecto2Operativos.ObjetoInterfaz.getColaRecuperacionS();
        ColaRecuperacionS = new Cola();
        
        
    }
    
    public void Inicio() {
        
        for (int i = 0; i < 10; i++) {
            this.CrearPersonaje("N");
            this.CrearPersonaje("S");
        }
        ActualizarColasInterfaz();
       
        IA = Proyecto2Operativos.IA;
       
        
        try {
            Semaforo.acquire();
        } catch (InterruptedException ex) {
            System.out.println("Error");
        }
        this.start();
        IA.start();
    }
    
    @Override
   public void run(){
        try {
            while (Ejecucion) {
           
            
            this.SalidaRefuerzo(ColaRecuperacionN, ColaN1, ColaN2, ColaN3);
            this.SalidaRefuerzo(ColaRecuperacionS, ColaS1, ColaS2, ColaS3);

            if (ContadorAdmin >= 2) {
                this.AgregarPersonajeAleatorio("N");
                this.AgregarPersonajeAleatorio("S");
                ContadorAdmin = 0;
            }

            Personaje PersonajeN = this.DespacharPersonajes(ColaN1, ColaN2, ColaN3);
            Personaje PersonajeS = this.DespacharPersonajes(ColaS1, ColaS2, ColaS3);

            IA.PersonajeN = PersonajeN;
            IA.PersonajeS = PersonajeS;

            if (PersonajeN != null) {
                PersonajeN.Contador = 0;
            }
            if (PersonajeS != null) {
                PersonajeS.Contador = 0;
            }
            this.ActualizarColasInterfaz();
            this.Semaforo.release();
            //Pendiente
            Thread.sleep(500);
            Semaforo.acquire();
            this.ModificarContador(ColaN2);
            this.ModificarContador(ColaN3);
            this.ModificarContador(ColaS2);
            this.ModificarContador(ColaS3);
         

            ContadorAdmin++;
            this.ActualizarColasInterfaz();
          //  this.Semaforo.release();
        }
           
        } catch (InterruptedException ex) {
            System.out.println("Error");
        }
   }
   
   private void ModificarContador(Cola Cola1) {
      
        int Iteraciones = Cola1.Tamano;
        int Indice = 0;
        
        while (Indice < Iteraciones) {
           
            Personaje Personaje1 = Cola1.pFirst.Informacion;
            Cola1.Desencolar();
            
            Personaje1.Contador++;
            if (Personaje1.Contador >= 8) {
                if (Personaje1.Prioridad > 1) {
                    Personaje1.Prioridad--;
                    if (Personaje1.Empresa.equals("N")) {
                        this.EncolarPersonaje(Personaje1, ColaN1, ColaN2, ColaN3);
                    }
                    else {
                        this.EncolarPersonaje(Personaje1, ColaS1, ColaS2, ColaS3);
                    }
                    
                                  
                } else {
                    Cola1.Encolar(Personaje1);
                }
                Personaje1.Contador = 1;
            } else {
                Cola1.Encolar(Personaje1);
            }
            Indice++;
        }
        
    }
   private Personaje DespacharPersonajes(Cola Cola1, Cola Cola2, Cola Cola3) {
        if (!Cola1.esVacia()) {
            Personaje var = Cola1.pFirst.Informacion;
            Cola1.Desencolar();
            return var;
        } else if (!Cola2.esVacia()) {
            
            Personaje var = Cola2.pFirst.Informacion;
            Cola2.Desencolar();
            return var;
            
        } else if (!Cola3.esVacia()) {
            Personaje var = Cola3.pFirst.Informacion;
            Cola3.Desencolar();
            return var;
        }
        return null;
    }
   

   private void AgregarPersonajeAleatorio(String Empresa) {
        int result = rand.nextInt(100);
        if (result <= 70) {
            this.CrearPersonaje(Empresa);
        }
    }
   
   private void SalidaRefuerzo(Cola Recuperacion, Cola Cola1, Cola Cola2, Cola Cola3){
        if (Recuperacion.esVacia()) {
            return;
        }

        int result = rand.nextInt(100);
        if (result <= 40) {
            Personaje perso = Recuperacion.pFirst.Informacion;
            Recuperacion.Desencolar();
            perso.Prioridad = 1;
            this.EncolarPersonaje(perso, Cola1, Cola2, Cola3);
        } else {
            Personaje perso = Recuperacion.pFirst.Informacion;
            Recuperacion.Desencolar();
            Recuperacion.Encolar(perso);
        }
    }
    
    private void CrearPersonaje(String Empresa) {
        if (Empresa.equals("N")) {
            IndiceN ++;
            Personaje nuevo = new Personaje(IndiceN, Empresa);
            nuevo.AsignacionCalidad();
            nuevo.AsignacionGlobal();
            nuevo.VerificacionCalidad();
            this.EncolarPersonaje(nuevo, ColaN1, ColaN2, ColaN3);
        }

        if (Empresa.equals("S")) {
            IndiceS += 1;
            Personaje nuevo = new Personaje(IndiceS, Empresa);
            nuevo.AsignacionCalidad();
            nuevo.AsignacionGlobal();
            nuevo.VerificacionCalidad();
            this.EncolarPersonaje(nuevo, ColaS1, ColaS2, ColaS3);
        }

    }
    
    private void EncolarPersonajeRecuperacion(Personaje nuevo, Cola ColaRecuperacion) {
        ColaRecuperacion.Encolar(nuevo);
    }

    private void EncolarPersonaje(Personaje nuevo, Cola Cola1, Cola Cola2, Cola Cola3) {
        int Prioridad = nuevo.Prioridad;

        if (Prioridad == 1) {
            Cola1.Encolar(nuevo);
        }
        if (Prioridad == 2) {
            Cola2.Encolar(nuevo);
        }
        if (Prioridad == 3) {
            Cola3.Encolar(nuevo);
        }
    }
    public void ActualizarColasInterfaz(){
        ColaInterfazN1.CambiarColaInterfaz(ColaN1);
        ColaInterfazN2.CambiarColaInterfaz(ColaN2);
        ColaInterfazN3.CambiarColaInterfaz(ColaN3);
        ColaInterfazRecuperacionN.CambiarColaInterfaz(ColaRecuperacionN);
        
        ColaInterfazS1.CambiarColaInterfaz(ColaS1);
        ColaInterfazS2.CambiarColaInterfaz(ColaS2);
        ColaInterfazS3.CambiarColaInterfaz(ColaS3);
        ColaInterfazRecuperacionS.CambiarColaInterfaz(ColaRecuperacionS);
        
    }
    
    public void DevolverCapitulos(Personaje PersonajeN, Personaje PersonajeS) {
        if (PersonajeN != null) {
            EncolarPersonaje(PersonajeN, ColaN1, ColaN2, ColaN3);
        }
        if (PersonajeS != null) {
            EncolarPersonaje(PersonajeS, ColaS1, ColaS2, ColaS3);
        }
    }
    
    public void DevolverCapitulosRecuperacion(Personaje PersonajeN, Personaje PersonajeS) {
        if (PersonajeN != null) {
            EncolarPersonajeRecuperacion(PersonajeN, ColaRecuperacionN);
        }
        if (PersonajeS != null) {
            EncolarPersonajeRecuperacion(PersonajeS, ColaRecuperacionS);
        }
    }
    }
    

