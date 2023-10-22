/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CarpetaClases;

/**
 *
 * @author Luisp
 */
public class Cola {
    
    Nodo pFirst;
    Nodo pLast;
    int Tamano;

    public Cola() {
        this.pFirst = null;
        this.pLast = null;
        this.Tamano = 0;
    }
    
    public boolean esVacia(){
        return Tamano==0;
        
    }
    
    public void Encolar(Personaje informacion) {
        Nodo node = new Nodo(informacion);
        if (esVacia()) {
            pFirst = node;
            pLast = node;
        } else {
            node.pNext = pLast;
            pLast = node;
        }
        Tamano++;
    }

    public void Desencolar() {
        if (!esVacia()) {
            if (Tamano == 1) {
                pFirst =null;
                pLast = null;
            } else {
                Nodo node = pLast;
                while (node.pNext != pFirst) {
                    node = node.pNext;
                }
                node.pNext = null;
                pFirst = node;
            }
            Tamano--;
        }
    }
    
    public void DesencolarporID(String Id, Personaje Person) {
        if (!esVacia()) {
            if (Tamano == 1) {
                pFirst = null;
                pLast = null;
            } else {
                Nodo node = pLast;
                if (node.Informacion.id == Id) {
                    pLast = node.pNext;
                } else {
                    while (node.Informacion.id != Id) {
                        node = node.pNext;
                }
                     if (node.pNext == pFirst) {
                     pFirst = node;
                } else {
                         node.pNext = node.pNext.pNext;
                }
                
                }
            }
            this.Tamano--;
        }
    }
    
    public String StringInterfaz(){
        Nodo node = pLast;
        String aux = "";
        while (node != null) {
            aux = " " + node.Informacion.id + " " + aux;
            node = node.pNext;
        }
        return aux;
    }
    
}
        
