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
import javax.swing.JToggleButton;
import javax.swing.border.Border;

public class Analizador {
    
    private String nombreDelArchivo;
        
    public Analizador(){
        
    }
    
    public void analizarCodigoFuente(String texto, int cantidadDeToken, JPanel panel, JToggleButton boton){
        
        if (!texto.isEmpty()) {
            //obtener la cantidad de palabras y las mismas
            String textoSinEspacios = texto.replaceAll("\\s+", " ").trim();
            String[] palabras = textoSinEspacios.split("(?<=\\b)(?=[(){}\\[\\],])|(?<=[(){}\\[\\],])|(?<=\\d)(?=\\D)|(?<=\\d\\.\\d+)(?=\\D)|(?<=\\d\\.\\d+)|\\s+");

            int cantidadDePalabras = palabras.length;
               
            if (cantidadDeToken>=cantidadDePalabras) {
                //realiza el analicis si la cantidad de token son igual o mayores a la cantidad de palabras ingresadas
                for (int i = 0; i < palabras.length; i++) {
                    
                    Token token = new Token();
                    panel.add(token.nuevoToken(palabras[i]));
                    panel.revalidate();
                    panel.repaint();   
                }

                if (cantidadDePalabras < cantidadDeToken ) {
                    //rellenar de label vacias si las palabras son menores a la cantidad de token
                    for (int i = 0; i < (cantidadDeToken-cantidadDePalabras); i++) {
                        
                        JLabel label = new JLabel();
                        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
                        label.setBorder(border);
                        panel.add(label);
                        panel.revalidate();
                        panel.repaint();  
                        
                    }
                }
                
                boton.setEnabled(true);
                
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
        //abrir el chose y guardar el archivo para leerlo en otro metodo
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
        //usa un bufferReader para leer el texto e insertarlo en panelText
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
