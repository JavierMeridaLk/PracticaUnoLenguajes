package Backen;

import Fronted.ReportesDialog;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Analizador {
    
    private String nombreDelArchivo;
    private Gestor gestor;
    ReportesDialog reporte;
    //JTable tabla;
          
    public Analizador(ReportesDialog reporte){
        this.gestor=gestor;
        this.reporte=reporte;
        //dialog = new ReportesDialog(null,gestor);
        
        
        
    }
    
    public void analizarCodigoFuente(String texto, int cantidadDeToken, JPanel panel, JToggleButton boton,JToggleButton botonReporte){
        
        if (!texto.isEmpty()) {
            // Obtener lineas y evaluar si es un comnetario o no, luego separar por palabras
            String[] lineas = texto.split("\n");
            String[] lineasSinEspacios =new String[lineas.length];
            
             for (int i = 0; i < lineas.length; i++) {
                // Eliminar espacios al inicio y al final de cada línea y reemplazar múltiples espacios en blanco con uno solo
                lineasSinEspacios[i] = lineas[i].trim().replaceAll("\\s+", " ");
                if (!lineasSinEspacios[i].isEmpty() && lineasSinEspacios[i].charAt(0) == '\'') {
                    lineasSinEspacios[i] = "'";
                }
            }
            
            int totalPalabras = 0;
            for (String linea : lineasSinEspacios) {
                totalPalabras += linea.split(" ").length;
            }
            
            String[] palabras = new String[totalPalabras];
            int indice = 0;
            
            for (String linea : lineasSinEspacios) {
                String[] palabrasLinea = linea.split(" ");
                for (String palabra : palabrasLinea) {
                    palabras[indice++] = palabra;
                }
            }
            // Contar el número total de tokens después de la división
            int totalPalabrasVerificadas = 0;
            // Primero, contar el número total de tokens para asignar un array de tamaño adecuado
            for (String palabra : palabras) {
                totalPalabrasVerificadas += palabra.split("(?<=\\b)(?=[(){}\\[\\],])|(?<=[(){}\\[\\],])|(?<=\\s)(?=[(){}\\[\\],])|(?<=\\s)(?=\\s)").length;
            }
            // Crear un array para almacenar todos los tokens verificadas
            String[] palabrasVerificadas = new String[totalPalabrasVerificadas];
            int index = 0;
            // Dividir las palabras y almacenar en el array
            for (String palabra : palabras) {
                String[] tokens = palabra.split("(?<=\\b)(?=[(){}\\[\\],])|(?<=[(){}\\[\\],])|(?<=\\s)(?=[(){}\\[\\],])|(?<=\\s)(?=\\s)");
                for (String token : tokens) {
                    palabrasVerificadas[index++] = token;
                }
            }
            
            int cantidadDePalabras = palabrasVerificadas.length;
               
            if (cantidadDeToken>=cantidadDePalabras) {
                //realiza el analicis si la cantidad de token son igual o mayores a la cantidad de palabras ingresadas
                String[] columnNames = {"Token", "Lexema", "Linea", "Columna", "Cuadro"};
                DefaultTableModel model = new DefaultTableModel(columnNames , 0);
                JTable tabla = new JTable(model);
                tabla.setSize(740, 430);
                tabla.setEnabled(false);
                Object[] nombre = {"Token", "Lexema", "Linea", "Columna", "Cuadro"};
                model.addRow(nombre);
                
                
                for (int i = 0; i < palabrasVerificadas.length; i++) {
                    Token token = new Token(gestor);
                    panel.add(token.nuevoToken(palabrasVerificadas[i]));
                    Object[] newRow = {token.getToken(),token.getLexema(), token.getLinea(), token.getColumna(), "Primera línea\nSegunda línea\nTercera línea"};
                    model.addRow(newRow);
                    panel.revalidate();
                    panel.repaint();   
                }
                reporte.agregarTabla(tabla);
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
                botonReporte.setEnabled(true);
                
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
