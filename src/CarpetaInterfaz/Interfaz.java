/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CarpetaInterfaz;
;


import CarpetaClases.Proyecto2Operativos;


import CarpetaClases.Personaje;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Luisp
 */
public final class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        this.getGanadoresS().setOpaque(true); 
        this.getGanadoresS().setBackground(new Color(245, 230, 200)); 
        this.getGanadoresS().setForeground(Color.BLACK);
        Border border = new LineBorder(new Color(139, 69, 19), 2); 
        this.getGanadoresS().setBorder(border);
        this.getGanadoresN().setOpaque(true);
        this.getGanadoresN().setBackground(new Color(245, 230, 200)); 
        this.getGanadoresN().setForeground(Color.BLACK);
        Border border1 = new LineBorder(new Color(139, 69, 19), 2); 
        this.getGanadoresN().setBorder(border1);
        this.ColaN1.getTitulo().setText("Cola de Prioridad 1");
        this.ColaN2.getTitulo().setText("Cola de Prioridad 2");
        this.ColaN3.getTitulo().setText("Cola de Prioridad 3");
        this.ColaS1.getTitulo().setText("Cola de Prioridad 1");
        this.ColaS2.getTitulo().setText("Cola de Prioridad 2");
        this.ColaS3.getTitulo().setText("Cola de Prioridad 3");
        this.ColaRecuperacionN.getTitulo().setText("Cola de Recuperacion");
        this.ColaRecuperacionS.getTitulo().setText("Cola de Recuperacion");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ColaN1 = new CarpetaInterfaz.ColaInterfaz();
        ColaRecuperacionN = new CarpetaInterfaz.ColaInterfaz();
        ColaN2 = new CarpetaInterfaz.ColaInterfaz();
        ColaN3 = new CarpetaInterfaz.ColaInterfaz();
        ColaS1 = new CarpetaInterfaz.ColaInterfaz();
        ColaRecuperacionS = new CarpetaInterfaz.ColaInterfaz();
        ColaS2 = new CarpetaInterfaz.ColaInterfaz();
        ColaS3 = new CarpetaInterfaz.ColaInterfaz();
        SliderTiempo = new javax.swing.JSlider();
        GanadoresN = new javax.swing.JLabel();
        GanadoresS = new javax.swing.JLabel();
        EstadoIA = new javax.swing.JLabel();
        PersonajeN = new CarpetaInterfaz.PersonajeInterfaz();
        PersonajeS = new CarpetaInterfaz.PersonajeInterfaz();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(ColaN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        jPanel1.add(ColaRecuperacionN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));
        jPanel1.add(ColaN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));
        jPanel1.add(ColaN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));
        jPanel1.add(ColaS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 150, -1, -1));
        jPanel1.add(ColaRecuperacionS, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 510, -1, -1));
        jPanel1.add(ColaS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 270, -1, -1));
        jPanel1.add(ColaS3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 390, -1, -1));

        SliderTiempo.setMajorTickSpacing(1);
        SliderTiempo.setMaximum(21);
        SliderTiempo.setMinimum(1);
        SliderTiempo.setPaintLabels(true);
        SliderTiempo.setPaintTicks(true);
        SliderTiempo.setValue(11);
        SliderTiempo.setBorder(new javax.swing.border.MatteBorder(null));
        SliderTiempo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderTiempoStateChanged(evt);
            }
        });
        jPanel1.add(SliderTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 740, 370, -1));
        SliderTiempo.getAccessibleContext().setAccessibleName("");
        SliderTiempo.getAccessibleContext().setAccessibleDescription("");

        GanadoresN.setBackground(new java.awt.Color(245, 230, 200));
        GanadoresN.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        GanadoresN.setForeground(new java.awt.Color(0, 0, 0));
        GanadoresN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GanadoresN.setText("Peleas Ganadas: 0");
        jPanel1.add(GanadoresN, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 240, -1));

        GanadoresS.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        GanadoresS.setForeground(new java.awt.Color(0, 0, 0));
        GanadoresS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GanadoresS.setText("Peleas Ganadas: 0");
        jPanel1.add(GanadoresS, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 650, 230, -1));

        EstadoIA.setBackground(new java.awt.Color(255, 255, 255));
        EstadoIA.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        EstadoIA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EstadoIA.setText("Estado de la IA");
        jPanel1.add(EstadoIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 480, -1));

        PersonajeN.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.add(PersonajeN, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 390, -1));
        jPanel1.add(PersonajeS, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 390, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dojo.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SliderTiempoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderTiempoStateChanged
        Proyecto2Operativos.IA.setTiempo(this.SliderTiempo.getValue() * 1000);
    }//GEN-LAST:event_SliderTiempoStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    public JLabel getEstadoIA() {
        return EstadoIA;
    }

    public void setEstadoIA(String EstadoIA) {
    this.getEstadoIA().setText("Estado de la IA → " + EstadoIA);
    this.getEstadoIA().setOpaque(true); 
    getEstadoIA().setBackground(new Color(245, 230, 200)); 
    this.getEstadoIA().setForeground(Color.BLACK);
    Border border = new LineBorder(new Color(139, 69, 19), 2); 
    this.getEstadoIA().setBorder(border);
        
    }
    
    public void ActualizarGanadores(Personaje Person, int contador){
    char primerCaracter = Person.getEmpresa().charAt(0);
    if(primerCaracter=='N'){
    this.getGanadoresN().setText("Peleas Ganadas: " + contador);
   
    } else{
    this.getGanadoresS().setText("Peleas Ganadas: " + contador);
    }
    }

    public PersonajeInterfaz getPersonajeN() {
        return PersonajeN;
    }

    public PersonajeInterfaz getPersonajeS() {
        return PersonajeS;
    }

    public JLabel getGanadoresN() {
        return GanadoresN;
    }

    public final JLabel getGanadoresS() {
        return GanadoresS;
    }

    public ColaInterfaz getColaN1() {
        return ColaN1;
    }

    public ColaInterfaz getColaN2() {
        return ColaN2;
    }

    public ColaInterfaz getColaN3() {
        return ColaN3;
    }

    public ColaInterfaz getColaRecuperacionN() {
        return ColaRecuperacionN;
    }

    public ColaInterfaz getColaRecuperacionS() {
        return ColaRecuperacionS;
    }

    public ColaInterfaz getColaS1() {
        return ColaS1;
    }

    public ColaInterfaz getColaS2() {
        return ColaS2;
    }

    public ColaInterfaz getColaS3() {
        return ColaS3;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CarpetaInterfaz.ColaInterfaz ColaN1;
    private CarpetaInterfaz.ColaInterfaz ColaN2;
    private CarpetaInterfaz.ColaInterfaz ColaN3;
    private CarpetaInterfaz.ColaInterfaz ColaRecuperacionN;
    private CarpetaInterfaz.ColaInterfaz ColaRecuperacionS;
    private CarpetaInterfaz.ColaInterfaz ColaS1;
    private CarpetaInterfaz.ColaInterfaz ColaS2;
    private CarpetaInterfaz.ColaInterfaz ColaS3;
    private javax.swing.JLabel EstadoIA;
    private javax.swing.JLabel GanadoresN;
    private javax.swing.JLabel GanadoresS;
    private CarpetaInterfaz.PersonajeInterfaz PersonajeN;
    private CarpetaInterfaz.PersonajeInterfaz PersonajeS;
    private javax.swing.JSlider SliderTiempo;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
