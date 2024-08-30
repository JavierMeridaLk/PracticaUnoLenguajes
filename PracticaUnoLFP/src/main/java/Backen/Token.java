/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backen;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author xavi
 */
public class Token {
    
    private final String COLOR_IDENTIFICADOR= "#FFD300";
    
    private final String COLOR_SUMA= "#FF33FF";
    private final String COLOR_RESTA= "#C19A6B";
    private final String COLOR_EXPONENTE= "#FCD0B4";
    private final String COLOR_DIVISION= "#B4D941";
    private final String COLOR_MODULO= "#D9AB41";
    private final String COLOR_MULTIPLICACION= "#D80073";
    
    private final String COLOR_IGUAL= "#6A00FF";
    private final String COLOR_DIFERENTE= "#3F2212";
    private final String COLOR_MAYOR_QUE= "#D9D441";
    private final String COLOR_MENOR_QUE= "#D94A41";
    private final String COLOR_MAYOR_IGUAL= "#E3C800";
    private final String COLOR_MENOR_IGUAL= "#F0A30A";
    
    private final String COLOR_AND = "#414ED9";
    private final String COLOR_OR = "#41D95D";
    private final String COLOR_NOT = "#A741D9";
    
    private final String COLOR_ASIGNACION_SIMPLE = "#41D9D4";
    private final String COLOR_ASIGNACION_COMPUESTA = "#FFFFFF";

    private final String COLOR_PALABRA_RESERVADA = "#60A917";
    
    private final String COLOR_ENTERO = "#1BA1E2";
    private final String COLOR_DECIMAL = "#FFFF88";
    private final String COLOR_CADENA = "#E51400";
    private final String COLOR_BOOLEANO = "#FA6800";
    private final String COLOR_CARACTER = "#0050EF";

    private final String COLOR_COMENTARIO = "#B3B3B3";
    
    private final String COLOR_PARENTESIS = "#9AD8DB";
    private final String COLOR_LLAVES = "#DBD29A";
    private final String COLOR_CORCHETES = "#DBA49A";
    private final String COLOR_COMA = "#B79ADB";
    private final String COLOR_PUNTO = "#9ADBA6";
    
    private final char SIGNO_COMENTARIO_CARACTER = '\'' ;
    
    private String tipo;
    private String columna;
    private String fila;
    private Color color;
    
    public Token(){
        
    }
    
    public JLabel nuevoToken(String palabra){
 
        JLabel label = new JLabel();
                    
            try {
                Integer.parseInt(palabra);
                color = Color.decode(COLOR_ENTERO);

            } catch (NumberFormatException e1) {
                // Si no es un entero, verificar si es un decimal
                try {
                    Double.parseDouble(palabra);
                    color = Color.decode(COLOR_DECIMAL);
                } catch (NumberFormatException e2) {
                    if (palabra.equalsIgnoreCase("+")) {
                        color = Color.decode(COLOR_SUMA);
                    }else if (palabra.equals("-")) {
                        color=Color.decode(COLOR_RESTA);
                    }else if (palabra.equals("^")) {
                        color=Color.decode(COLOR_EXPONENTE);
                    }else if (palabra.equals("/")) {
                        color=Color.decode(COLOR_DIVISION);
                    }else if (palabra.equals("Mod")) {
                        color=Color.decode(COLOR_MODULO);
                    }else if (palabra.equals("*")) {
                        color=Color.decode(COLOR_MULTIPLICACION);
                    }else if (palabra.equals("==")) {
                        color=Color.decode(COLOR_IGUAL);
                    }else if (palabra.equals("<>")) {
                        color=Color.decode(COLOR_DIFERENTE);
                    }else if (palabra.equals(">")) {
                        color=Color.decode(COLOR_MAYOR_QUE);
                    }else if (palabra.equals("<")) {
                        color=Color.decode(COLOR_MENOR_QUE);
                    }else if (palabra.equals(">=")) {
                        color=Color.decode(COLOR_MAYOR_IGUAL);
                    }else if (palabra.equals("<=")) {
                        color=Color.decode(COLOR_MENOR_IGUAL);
                    }else if (palabra.equals("And")) {
                        color=Color.decode(COLOR_AND);
                    }else if (palabra.equals("Or")) {
                        color=Color.decode(COLOR_OR);
                    }else if (palabra.equals("Not")) {
                        color=Color.decode(COLOR_NOT);
                    }else if (palabra.equals("=")) {
                        color=Color.decode(COLOR_ASIGNACION_SIMPLE);
                    }else if (palabra.equals("+=") || palabra.equals("-=") || palabra.equals("*=") || palabra.equals("/=")) {
                        color=Color.decode(COLOR_ASIGNACION_COMPUESTA);
                    }else if (palabra.equals("Module") || palabra.equals("End") || palabra.equals("Sub") || palabra.equals("Main") || 
                            palabra.equals("Dim") || palabra.equals("As") || palabra.equals("Integer") || palabra.equals("String") || 
                            palabra.equals("Boolean") || palabra.equals("Double") || palabra.equals("Char") || palabra.equals("Console.WriteLine") || 
                            palabra.equals("Console.ReadLine") || palabra.equals("If") || palabra.equals("ElseIf") || palabra.equals("Else") || 
                            palabra.equals("Then") || palabra.equals("While") || palabra.equals("Do") || palabra.equals("Loop") || 
                            palabra.equals("For") || palabra.equals("To") || palabra.equals("Next") || palabra.equals("Function") || 
                            palabra.equals("Return") || palabra.equals("Const") ) {
                        color=Color.decode(COLOR_PALABRA_RESERVADA);
                    }else if (palabra.equals("(") || palabra.equals(")") ) {
                        color=Color.decode(COLOR_PARENTESIS);
                    }else if (palabra.equals("{") || palabra.equals("}") ) {
                        color=Color.decode(COLOR_LLAVES);
                    }else if (palabra.equals("[") || palabra.equals("]") ) {
                        color=Color.decode(COLOR_CORCHETES);
                    }else if (palabra.equals(",")) {
                        color=Color.decode(COLOR_COMA);
                    }else if (palabra.equals(".")) {
                        color=Color.decode(COLOR_PUNTO);
                    }else if (palabra.equals("True") || palabra.equals("False")) {
                        color=Color.decode(COLOR_BOOLEANO);
                    }else if (palabra.charAt(0) == '"' ) {
                        color=Color.decode(COLOR_CADENA);
                    }else if (palabra.charAt(0) == '‘') {
                        color=Color.decode(COLOR_COMENTARIO);
                    }else if (palabra.charAt(0) == SIGNO_COMENTARIO_CARACTER && palabra.charAt(palabra.length()-1)== SIGNO_COMENTARIO_CARACTER) {
                        color=Color.decode(COLOR_CARACTER);
                    }else if (!Character.isDigit(palabra.charAt(0))) {
                        color=Color.decode(COLOR_IDENTIFICADOR);
                    }else if (palabra.equals("=")) {
                        color=Color.decode(COLOR_ASIGNACION_SIMPLE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Token no aceptado: " + palabra, "Error", JOptionPane.ERROR_MESSAGE);
                        return null;
                    }
                }
            }
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1); 
        label.setBorder(border);
        label.setOpaque(true); // Necesario para que el color de fondo sea visible
        label.setBackground(color);
        return label;
    }
}

