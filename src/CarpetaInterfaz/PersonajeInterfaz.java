/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CarpetaInterfaz;

import CarpetaClases.Personaje;
import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Luisp
 */
public class PersonajeInterfaz extends javax.swing.JPanel {
    
    int contador;
    Random rand;

    
    
    public PersonajeInterfaz() {
        initComponents();
        rand = new Random();
        this.contador = rand.nextInt(10) + 1;
        this.setOpaque(true); 
        this.setBackground(new Color(245, 230, 200));
        this.setForeground(Color.BLACK);
        Border border = new LineBorder(new Color(139, 69, 19), 2); 
        this.setBorder(border);
    }
    
    public void ActualizarPersonjaeInterfaz(Personaje Personaje12) {
        this.getIndicadorResultado().setEnabled(false);
        this.getID().setText(Personaje12.getId());
        
    }
    
    public void CambiarIcono(Personaje Personaje12) {
       
        this.Foto.setIcon(new ImageIcon("src\\Imagenes\\"+contador+Personaje12.getEmpresa()+".png"));
        this.Poder.setText(Integer.toString(Personaje12.getGlobal()));
        contador++;
        if(contador == 11){
        contador = 1;
        }
    }
    
    public void CambiarIconoPelea() {
        this.IndicadorResultado.setIcon(new ImageIcon("src\\Imagenes\\pelea.png"));
    }
    
    public void CambiarIconoEsperar() {
        this.Foto.setIcon(new ImageIcon("src\\Imagenes\\VAyR.gif"));
        this.Poder.setText("--");
        this.ID.setText("--");
         this.IndicadorResultado.setIcon(null);
    }
    
    public void CambiarIconoReforzar() {
        this.IndicadorResultado.setIcon(new ImageIcon("src\\Imagenes\\BackUp.png"));  
    }
    
    public void CambiarIconoGanador() {
        this.IndicadorResultado.setIcon(new ImageIcon("src\\Imagenes\\ganador.png"));  
    }
    
    public void CambiarIconoPerdedor() {
        this.IndicadorResultado.setIcon(new ImageIcon("src\\Imagenes\\perdedor.png"));
    }
    public void CambiarIconoEmpate() {
        this.IndicadorResultado.setIcon(new ImageIcon("src\\Imagenes\\empate.png"));
    }

    public JLabel getFoto() {
        return Foto;
    }

    public JLabel getID() {
        return ID;
    }

    public JLabel getIndicadorResultado() {
        return IndicadorResultado;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        Foto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Poder = new javax.swing.JLabel();
        IndicadorResultado = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(245, 230, 200));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("ID: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        ID.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        ID.setText("---");
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        Foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/8S - copia.png"))); // NOI18N
        jPanel1.add(Foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 360, 400));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Poder: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        Poder.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Poder.setText("---");
        jPanel1.add(Poder, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        IndicadorResultado.setBackground(null);
        IndicadorResultado.setDisplayedMnemonic('n');
        IndicadorResultado.setForeground(new java.awt.Color(255, 255, 255));
        IndicadorResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pelea - copia.png"))); // NOI18N
        jPanel1.add(IndicadorResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 260, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel IndicadorResultado;
    private javax.swing.JLabel Poder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
