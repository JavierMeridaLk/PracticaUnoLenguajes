/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backen;

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
    private final String COLOR_LLAVES = "#DBS29A";
    private final String COLOR_CORCHETES = "#DBA49A";
    private final String COLOR_COMA = "#B79ADB";
    private final String COLOR_PUNTO = "#0050EF";
    
    private String tipo;
    private String columna;
    private String fila;
    private String color;
    
    public Token(){
        
    }
    
    public void nuevoToken(String palabra){
        
        if (palabra.equalsIgnoreCase("+")) {
            color=COLOR_SUMA;
        }else if (palabra.equals("-")) {
            color=COLOR_RESTA;
        }else if (palabra.equals("^")) {
            color=COLOR_EXPONENTE;
        }else if (palabra.equals("/")) {
            color=COLOR_DIVISION;
        }else if (palabra.equals("Mod")) {
            color=COLOR_MODULO;
        }else if (palabra.equals("*")) {
            color=COLOR_MULTIPLICACION;
        }else if (palabra.equals("==")) {
            color=COLOR_IGUAL;
        }else if (palabra.equals("<>")) {
            color=COLOR_DIFERENTE;
        }else if (palabra.equals(">")) {
            color=COLOR_MAYOR_QUE;
        }else if (palabra.equals("<")) {
            color=COLOR_MENOR_QUE;
        }else if (palabra.equals(">=")) {
            color=COLOR_MAYOR_IGUAL;
        }else if (palabra.equals("<=")) {
            color=COLOR_MENOR_IGUAL;
        }else if (palabra.equals("And")) {
            color=COLOR_AND;
        }else if (palabra.equals("Or")) {
            color=COLOR_OR;
        }else if (palabra.equals("Not")) {
            color=COLOR_NOT;
        }else if (palabra.equals("=")) {
            color=COLOR_ASIGNACION_SIMPLE;
        }else if (palabra.equals("+=") || palabra.equals("-=") || palabra.equals("*=") || palabra.equals("/=")) {
            color=COLOR_ASIGNACION_COMPUESTA;
        }else if (palabra.equals("Module") || palabra.equals("End") || palabra.equals("Sub") || palabra.equals("Main") || 
                palabra.equals("Dim") || palabra.equals("As") || palabra.equals("Integer") || palabra.equals("String") || 
                palabra.equals("Boolean") || palabra.equals("Double") || palabra.equals("Char") || palabra.equals("Console.WriteLine") || 
                palabra.equals("Console.ReadLine") || palabra.equals("If") || palabra.equals("ElseIf") || palabra.equals("Else") || 
                palabra.equals("Then") || palabra.equals("While") || palabra.equals("Do") || palabra.equals("Loop") || 
                palabra.equals("For") || palabra.equals("To") || palabra.equals("Next") || palabra.equals("Function") || 
                palabra.equals("Return") || palabra.equals("Const") ) {
            color=COLOR_PALABRA_RESERVADA;
        }else if (palabra.equals("(") || palabra.equals(")") ) {
            color=COLOR_PARENTESIS;
        }else if (palabra.equals("{") || palabra.equals("}") ) {
            color=COLOR_PARENTESIS;
        }else if (palabra.equals("[") || palabra.equals("]") ) {
            color=COLOR_PARENTESIS;
        }else if (palabra.equals(",")) {
            color=COLOR_COMA;
        }else if (palabra.equals(".")) {
            color=COLOR_PUNTO;
        }
        
    }
}
