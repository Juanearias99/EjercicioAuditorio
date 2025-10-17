/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ControladorPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import modelo.Auditorio;

/**
 *
 * @author Juan Esteban
 */
public class VentanaPrincipal extends javax.swing.JFrame implements ActionListener {

    private JButton[][] botones;
    private ControladorPrincipal controlador;

    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.botones = new JButton[3][4];
        this.controlador = new ControladorPrincipal();
        this.dibujarBotones();
        this.pintarBotones();
    }

    private void dibujarBotones() {
        int ancho = 40;
        int alto = 45;
        int separado = 20;
        int contador = 1;
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                botones[i][j] = new JButton();
                botones[i][j].addActionListener(this);
                switch (contador) {
                    case 1, 2, 3 -> {
                        botones[i][j].setBounds(
                                j * ancho + separado,
                                i * alto + separado,
                                ancho, alto
                        );
                        panelBotones.add(botones[i][j]);
                    }

                    case 4 -> {
                        botones[i][j].setBounds(
                                j * ancho + separado + 25,
                                i * alto + separado,
                                ancho, alto
                        );
                        panelBotones.add(botones[i][j]);
                    }

                    case 5, 6, 7 -> {
                        botones[i][j].setBounds(
                                j * ancho + separado,
                                i * alto + separado + 3,
                                ancho, alto
                        );
                        panelBotones.add(botones[i][j]);
                    }

                    case 8 -> {
                        botones[i][j].setBounds(
                                j * ancho + separado + 25,
                                i * alto + separado + 3,
                                ancho, alto
                        );
                        panelBotones.add(botones[i][j]);
                    }

                    case 9, 10, 11 -> {
                        botones[i][j].setBounds(
                                j * ancho + separado,
                                i * alto + separado + 25,
                                ancho, alto
                        );
                        panelBotones.add(botones[i][j]);
                    }

                    case 12 -> {
                        botones[i][j].setBounds(
                                j * ancho + separado + 25,
                                i * alto + separado + 25,
                                ancho, alto
                        );
                        panelBotones.add(botones[i][j]);
                    }
                }
                contador++;
            }
        }
    }

    private void pintarBotones() {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                Auditorio auditorio = controlador.obtenerAuditorios(i, j);
                if (auditorio != null) {
                    botones[i][j].setText(auditorio.getTema());
                    if (auditorio.validarPersona() && auditorio.validarTema()) {
                        botones[i][j].setBackground(Color.BLUE);
                    } else if (!auditorio.validarPersona() && !auditorio.validarTema()) {
                        botones[i][j].setBackground(Color.WHITE);
                    } else if (auditorio.validarTema() && !auditorio.validarPersona()) {
                        botones[i][j].setBackground(Color.GREEN);
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                if (e.getSource().equals(botones[i][j])) {
                    int fila = i;
                    int columna = j;
                    Auditorio auditorio = controlador.obtenerAuditorios(fila, columna);
                    if (auditorio != null) {
                        if (auditorio.validarTema()) {
                            abrirVentanaPersona(auditorio);
                        } else {
                            abrirVentanaTema(auditorio);
                        }
                    }
                }
            }
        }
    }

    private void abrirVentanaPersona(Auditorio auditorio) {
        VentanaPersona vp = new VentanaPersona(auditorio);
        vp.setVisible(true);
        this.dispose();
    }

    private void abrirVentanaTema(Auditorio auditorio) {
        VentanaTema vt = new VentanaTema(auditorio, controlador);
        vt.setVisible(true);
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelBotones;
    // End of variables declaration//GEN-END:variables

}
