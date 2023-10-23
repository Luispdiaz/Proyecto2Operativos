/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CarpetaClases;

import CarpetaInterfaz.Interfaz;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Luisp
 */
public class Proyecto2Operativos {
    
    public static Semaphore Semaforo = new Semaphore(1);
    public static Administrador Admin = new Administrador();
    public static InteligenciaArtificial IA = new InteligenciaArtificial();
    public static Interfaz ObjetoInterfaz = new Interfaz();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjetoInterfaz.setVisible(true);
    }
    
}
