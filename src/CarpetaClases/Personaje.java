/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CarpetaClases;

import static java.lang.Math.random;

/**
 *
 * @author Luisp
 */
public class Personaje {
    String id;
    int Idnumerico;
    int Prioridad;
    int Contador;
    int Vida;
    int Striking;
    int Fuerza;
    int Grappling;
    int Global;
    String Empresa;

    public Personaje(int ID, String Empresa) {
        this.Contador = 0;
        this.Vida = 0;
        this.Striking = 0;
        this.Fuerza = 0;
        this.Grappling = 0;
        this.Global = 0;
        this.Empresa = Empresa;
        this.id = "" + Empresa + ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public int getGlobal() {
        return Global;
    }

    public void setGlobal(int Global) {
        this.Global = Global;
    }
    
    
    public void AsignacionCalidad(){
        Vida += (Math.random() < 0.70) ? 10 : 0;
        Striking += (Math.random() < 0.60) ? 10 : 0;
        Fuerza += (Math.random() < 0.50) ? 10 : 0;
        Grappling += (Math.random() < 0.40) ? 10 : 0;
    }
    
    public void AsignacionGlobal(){
        Vida += (int) (Math.random() * 10);
        Striking += (int) (Math.random() * 10);
        Fuerza += (int) (Math.random() * 10);
        Grappling += (int) (Math.random() * 10);
        Global = Vida + Striking + Fuerza + Grappling;
    }
    
    public void VerificacionCalidad(){
        
    int cont = 0;
    String VidaConver = Integer.toString(Vida);
    char VidaConverPosicion = VidaConver.charAt(0);
    if(VidaConverPosicion=='1'){
    cont++;
    }
    String FuerzaConver = Integer.toString(Fuerza);
    char FuerzaConverPosicion = FuerzaConver.charAt(0);
    if(FuerzaConverPosicion=='1'){
    cont++;
    }
    String StrikingConver = Integer.toString(Striking);
    char StrikingConverPosicion = StrikingConver.charAt(0);
    if(StrikingConverPosicion=='1'){
    cont++;
    }
    String GrapplingConver = Integer.toString(Grappling);
    char GrapplingConverPosicion = GrapplingConver.charAt(0);
    if(GrapplingConverPosicion=='1'){
    cont++;
    }
    
    if(cont == 3 || cont == 4){
       Prioridad = 1;
    }
    else if(cont == 2){
        Prioridad = 2;
    }
    else if(cont == 0 || cont == 1){
        Prioridad = 3;
    }
    }
    
    public void ActualizarContador(){
        if (Contador < 7) {
            Contador++;
        } else {
            Contador = 0; 
            Prioridad--;
        }
    }
}
