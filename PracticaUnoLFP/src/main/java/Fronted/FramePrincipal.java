package Fronted;

import Backen.Analizador;
import Backen.Imagen;

public class FramePrincipal extends javax.swing.JFrame {

    private int cantidadDeTokens;
    private Analizador analizador;
    
    public FramePrincipal() {
        
        this.setLocationRelativeTo(null);
        this.setTitle("ANALIZADOR LEXICO");
        this.setSize(1000, 640);
        
        initComponents();
        
        cantidadDeTokens=0;
        panelTexto.setEditable(false);
        this.analizador = new Analizador();
        botonExportar.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelTexto = new javax.swing.JTextPane();
        ImgPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        botonExportar = new javax.swing.JToggleButton();
        tamañoLabel = new javax.swing.JLabel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(panelTexto);

        ImgPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout ImgPanelLayout = new javax.swing.GroupLayout(ImgPanel);
        ImgPanel.setLayout(ImgPanelLayout);
        ImgPanelLayout.setHorizontalGroup(
            ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        ImgPanelLayout.setVerticalGroup(
            ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel1.setText("ANALIZADOR LEXICO");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("Codigo fuente:");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Tamaño de la imagen:");

        jToggleButton1.setFont(new java.awt.Font("Century Gothic", 2, 15)); // NOI18N
        jToggleButton1.setText("Nuevo");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        botonExportar.setFont(new java.awt.Font("Century Gothic", 2, 15)); // NOI18N
        botonExportar.setText("Exportar imagen");
        botonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExportarActionPerformed(evt);
            }
        });

        tamañoLabel.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        jToggleButton3.setFont(new java.awt.Font("Century Gothic", 2, 15)); // NOI18N
        jToggleButton3.setText("Analizar");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setFont(new java.awt.Font("Century Gothic", 2, 15)); // NOI18N
        jToggleButton4.setText("Cargar Archivo");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(341, 341, 341))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonExportar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(370, 370, 370))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tamañoLabel)
                                .addGap(43, 43, 43)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4)
                    .addComponent(botonExportar))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tamañoLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExportarActionPerformed
        //Boton para exportar imagenes
        Imagen imagen = new Imagen();
        imagen.exportarImagen(ImgPanel);
    }//GEN-LAST:event_botonExportarActionPerformed

    public int getCantidadDeTokens() {
        return cantidadDeTokens;
    }

    public void setCantidadDeTokens(int cantidadDeTokens) {
        this.cantidadDeTokens = cantidadDeTokens;
    }

    private void limpiar(){
        //metodo para limpiar componentes
        tamañoLabel.setText("");
        ImgPanel.removeAll();
        ImgPanel.revalidate();
        ImgPanel.repaint();
        panelTexto.setText("");  
    }
    
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        //Iniciar una nueva cuadricula, llamando a un metodo
        iniciarTablero();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void iniciarTablero(){
        //metodo para iniciar tablero atra vex de la clase imagen
        limpiar();
        
        Imagen imagen = new Imagen();
        int[] posiciones = imagen.crearCuadricula(ImgPanel);
        
        this.add(ImgPanel);
        tamañoLabel.setText(posiciones[0] + "x" + posiciones[1]);
        cantidadDeTokens= posiciones[0]*posiciones[1];
        System.out.println(cantidadDeTokens);
        panelTexto.setEditable(true);
    }
    
    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        //Boton para analizar el codigo fuente
        ImgPanel.removeAll();
        String texto = panelTexto.getText().trim();
        analizador.analizarCodigoFuente(texto,cantidadDeTokens,ImgPanel,botonExportar);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        //Boton para cargar archivos de texto
        iniciarTablero();
        analizador.leer(panelTexto); 
    }//GEN-LAST:event_jToggleButton4ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ImgPanel;
    private javax.swing.JToggleButton botonExportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JTextPane panelTexto;
    private javax.swing.JLabel tamañoLabel;
    // End of variables declaration//GEN-END:variables
}
