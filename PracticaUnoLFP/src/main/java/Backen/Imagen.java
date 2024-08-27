/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backen;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author xavi
 */
public class Imagen {
    
    
    public Imagen(){
        
    }
    
    public void crearCuadricula(JPanel panel, int tamañoCuadricula){
        panel.setLayout(new GridLayout(tamañoCuadricula, tamañoCuadricula));
        
        /*
        Relleno del panel solo de ejemplo
            for (int i = 1; i <= tamañoCuadricula*tamañoCuadricula; i++) {
            panel.add(new JButton("Botón " + i));
        }
        */
    }
}
