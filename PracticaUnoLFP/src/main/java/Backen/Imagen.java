/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backen;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author xavi
 */
public class Imagen {
    
    
    public Imagen(){
        
    }
    
    public void crearCuadricula(JPanel panel, int fila, int columnas){
        panel.setLayout(new GridLayout(fila, columnas));
        System.out.println(fila );
        System.out.println(columnas );
        /*
        //Prueba de rellenos
        //Relleno del panel solo de ejemplo
            for (int i = 1; i <= fila *columnas; i++) {
             JLabel label = new JLabel(); // Crear el JLabel
      
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2); // Borde negro de 2 píxeles
        label.setBorder(border);
               

        // Agregar el JLabel al panel
        panel.add(label);
            
        }
        */
        
    }
}
