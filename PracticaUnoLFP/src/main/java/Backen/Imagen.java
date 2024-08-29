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
        
        /*
        //Prueba de rellenos
        //Relleno del panel solo de ejemplo
            for (int i = 1; i <= fila *columnas; i++) {
             JLabel label = new JLabel(); // Crear el JLabel
            
             Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;

        // Definir el color basado en el número aleatorio
        Color color;
        switch (randomNumber) {
            case 1:
                color = Color.decode("#414ED9"); // Oro
                break;
            case 2:
                color = Color.decode("#1BA1E2"); // Plata
                break;
            case 3:
                color = Color.decode("#C19A6B"); // Bronce
                break;
            case 4:
                color = Color.decode("#0050EF"); // Naranja fuerte
                break;
            case 5:
                color = Color.decode("#60A917"); // Azul profundo
                break;
            default:
                color = Color.WHITE; // Valor por defecto (blanco)
        }
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2); // Borde negro de 2 píxeles
        label.setBorder(border);
        label.setOpaque(true); // Necesario para que el color de fondo sea visible
        label.setBackground(color);

        // Agregar el JLabel al panel
        panel.add(label);
            
        }
        */
        
    }
}
