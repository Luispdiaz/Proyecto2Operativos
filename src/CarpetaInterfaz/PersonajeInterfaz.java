/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CarpetaInterfaz;

import CarpetaClases.Personaje;
import javax.swing.JLabel;

/**
 *
 * @author Luisp
 */
public class PersonajeInterfaz extends javax.swing.JPanel {

    /**
     * Creates new form PersonajeInterfaz
     */
    public PersonajeInterfaz() {
        initComponents();
    }
    
    public void ActualizarPersonjaeInterfaz(Personaje Personaje12) {
        this.getIndicadorResultado().setEnabled(false);
        
       
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        IndicadorResultado = new javax.swing.JLabel();
        Foto = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        ID.setText("---");
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        IndicadorResultado.setText("Indicador Resultado");
        jPanel1.add(IndicadorResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 150, 40));

        Foto.setText("Fotos");
        jPanel1.add(Foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 150, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel IndicadorResultado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
