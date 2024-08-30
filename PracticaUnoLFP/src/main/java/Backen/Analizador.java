/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backen;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.Border;

/**
 *
 * @author xavi
 */
public class Analizador {
    
     private String nombreDelArchivo;
     
    public Analizador(){
        
    }
    
    public void analizarCodigoFuente(String texto, int cantidadDeToken, JPanel panel){
        
        if (!texto.isEmpty()) {
            //obtener la cantidad de palabras y las mismas
            String textoSinEspacios = texto.replaceAll("\\s+", " ").trim();
            String[] palabras = textoSinEspacios.split("(?<=\\b)(?=[(){}\\[\\],])|(?<=[(){}\\[\\],])|(?<=\\d)(?=\\D)|(?<=\\d\\.\\d+)(?=\\D)|(?<=\\d\\.\\d+)|\\s+");

            int cantidadDePalabras = palabras.length;
               /*
                // Mostrar el número total de palabras
                System.out.println("Número total de palabras: " + cantidadDePalabras);
                // Mostrar cada palabra individualmente
                for (int i = 0; i < palabras.length; i++) {
                    System.out.println("Palabra " + (i + 1) + ": " + palabras[i]);
                }
                */
               
            if (cantidadDeToken>=cantidadDePalabras) {
                for (int i = 0; i < palabras.length; i++) {
                    Token token = new Token();
                    panel.add(token.nuevoToken(palabras[i]));
                    panel.revalidate(); // Reorganiza los componentes
                    panel.repaint();    // Redibuja el panel
                    
                }

                if (cantidadDePalabras < cantidadDeToken ) {
                    for (int i = 0; i < (cantidadDeToken-cantidadDePalabras); i++) {
                        JLabel label = new JLabel();
                        Border border = BorderFactory.createLineBorder(Color.BLACK, 1); // Borde negro de 2 píxeles
                        label.setBorder(border);
                        panel.add(label);
                        panel.revalidate(); // Reorganiza los componentes
                        panel.repaint();  
                        
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "La cantidad de tokens ingresados superan la cuadricula ingresada por: " + (cantidadDePalabras-cantidadDeToken),
                        "Error", JOptionPane.ERROR_MESSAGE);
            return;
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null, "El codigo fuente esta vacio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }  
    }
    public File abrirChose(){
        
        
        JFileChooser fileChooser = new JFileChooser();
         
        int seleccion = fileChooser.showOpenDialog(null);
    
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            nombreDelArchivo= archivo.getName();
        
            return archivo;
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    
        return null;
    
    }
    public void leer(JTextPane text){
        File archivo = abrirChose();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                text.setText(content.toString());
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al leer el archivo: ", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }
}
