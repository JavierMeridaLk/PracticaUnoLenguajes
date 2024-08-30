/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author xavi
 */
public class Imagen {
    
    
    public Imagen(){
        
    }
    
   public int[] crearCuadricula(JPanel panel) {
    int[] tamaños = new int[2]; // Tamaños para filas y columnas
    
    // Solicitar el número de filas
    String filas = JOptionPane.showInputDialog(null, 
            "Ingrese el número de filas:", "Tamaño de la cuadrícula", 
            JOptionPane.QUESTION_MESSAGE);

    // Verificar si el usuario presionó "Cancelar" o dejó el cuadro de texto vacío
    if (filas == null || filas.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Operación cancelada o entrada vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        tamaños[0] = 0; // Indica error
        tamaños[1] = 0; // Indica error
        return tamaños;
    }

    int filasInt=0;
    try {
        filasInt = Integer.parseInt(filas);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido para las filas.", "Error", JOptionPane.ERROR_MESSAGE);
        tamaños[0] = 0; // Indica error
        tamaños[1] = 0; // Indica error
        return tamaños;
    }

    // Solicitar el número de columnas
    String columnas = JOptionPane.showInputDialog(null, 
            "Ingrese el número de columnas:", "Tamaño de la cuadrícula", 
            JOptionPane.QUESTION_MESSAGE);

    // Verificar si el usuario presionó "Cancelar" o dejó el cuadro de texto vacío
    if (columnas == null || columnas.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Operación cancelada o entrada vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        tamaños[0] = 0; // Indica error
        tamaños[1] = 0; // Indica error
        return tamaños;
    }

    int columnasInt=0;
    try {
        columnasInt = Integer.parseInt(columnas);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido para las columnas.", "Error", JOptionPane.ERROR_MESSAGE);
        tamaños[0] = 0; // Indica error
        tamaños[1] = 0; // Indica error
        return tamaños;
    }

    // Asignar los tamaños al array
    tamaños[0] = filasInt;
    tamaños[1] = columnasInt;

    // Configurar el panel con el GridLayout
    panel.setLayout(new GridLayout(filasInt, columnasInt));
    
    System.out.println("Filas: " + filasInt);
    System.out.println("Columnas: " + columnasInt);

    /*
    // Prueba de relleno (opcional)
    // Relleno del panel solo de ejemplo
    for (int i = 1; i <= filasInt * columnasInt; i++) {
        JLabel label = new JLabel(); // Crear el JLabel
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2); // Borde negro de 2 píxeles
        label.setBorder(border);

        // Agregar el JLabel al panel
        panel.add(label);
    }
    */

    return tamaños;
    }
   
   public void exportarImagen(JPanel ImgPanel){
       
       File carpeta = new File("Imagenes");
            if (!carpeta.exists()) {
                carpeta.mkdirs(); // Crear la carpeta y sus subcarpetas si no existen
            }
            
       
       BufferedImage image = new BufferedImage(ImgPanel.getWidth(), ImgPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                ImgPanel.paint(g2d);
                g2d.dispose();

                // Guardar la imagen en un archivo
                try {
                    String nombre = JOptionPane.showInputDialog(null, 
                    "Ingrese un nombre para la imagen:", "Nombre", 
                    JOptionPane.QUESTION_MESSAGE);
                    File archivo = new File(carpeta, nombre);
                    
                    ImageIO.write(image, "png", archivo);
                    JOptionPane.showMessageDialog(null, "Imagen guardada como: "+ nombre + ", en la carpeta: "+ carpeta , "Exito", JOptionPane.INFORMATION_MESSAGE);
                   
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al guardar la imagen: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
   }
    
}
