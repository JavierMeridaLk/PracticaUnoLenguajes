package Backen;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Token extends JLabel{
    
    private static final String DOT_EXTENSION = ".dot";
    private static final String PNG_EXTENSION = ".png";
    private static final String FILE_PREFIX = "automata_";
    
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
    
    private String token;
    private String lexema;
    private String linea;
    private String columna;
    private int filaCuadro;
    private int columnaCuadro;
    private Color color;
    
    public Token(String palabra){

        addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        mostrarInformacion(palabra);
                    } catch (IOException ex) {
                        Logger.getLogger(Token.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
    }
    
    public JLabel nuevoToken(String palabra){
        
        lexema=palabra;
        
        try {
            Integer.parseInt(palabra);
            color = Color.decode(COLOR_ENTERO);
            token="Entero";
        } catch (NumberFormatException e1) {
        // Si no es un entero, verificar si es un decimal
            try {
                Double.parseDouble(palabra);
                color = Color.decode(COLOR_DECIMAL);
                token="Decimal";
                } catch (NumberFormatException e2) {
                    
                if (palabra.equalsIgnoreCase("+")) {
                    color = Color.decode(COLOR_SUMA);
                    token="Suma";
                }else if (palabra.equals("-")) {
                    color=Color.decode(COLOR_RESTA);
                    token="Resta";
                }else if (palabra.equals("^")) {
                    color=Color.decode(COLOR_EXPONENTE);
                    token="Exponnte";
                }else if (palabra.equals("/")) {
                    token="Division";
                    color=Color.decode(COLOR_DIVISION);
                }else if (palabra.equals("Mod")) {
                    token="Modulo";
                    color=Color.decode(COLOR_MODULO);
                }else if (palabra.equals("*")) {
                    token="Multiplicacion";
                    color=Color.decode(COLOR_MULTIPLICACION);
                }else if (palabra.equals("==")) {
                    token="Igual";
                    color=Color.decode(COLOR_IGUAL);
                }else if (palabra.equals("<>")) {
                    token="Diferente";
                    color=Color.decode(COLOR_DIFERENTE);
                }else if (palabra.equals(">")) {
                    token="Mayor que";
                    color=Color.decode(COLOR_MAYOR_QUE);
                }else if (palabra.equals("<")) {
                    token="Menor que";
                    color=Color.decode(COLOR_MENOR_QUE);
                }else if (palabra.equals(">=")) {
                    token="Mayor o Igual que";
                    color=Color.decode(COLOR_MAYOR_IGUAL);
                }else if (palabra.equals("<=")) {
                    token="Menor o Igual que";
                    color=Color.decode(COLOR_MENOR_IGUAL);
                }else if (palabra.equals("And")) {
                    token="Y";
                    color=Color.decode(COLOR_AND);
                }else if (palabra.equals("Or")) {
                    token="O";
                    color=Color.decode(COLOR_OR);
                }else if (palabra.equals("Not")) {
                    token="Negación";
                    color=Color.decode(COLOR_NOT);
                }else if (palabra.equals("=")) {
                    token="Asignacion Simple";
                    color=Color.decode(COLOR_ASIGNACION_SIMPLE);
                }else if (palabra.equals("+=") || palabra.equals("-=") || palabra.equals("*=") || palabra.equals("/=")) {
                    token="Asignacion Compuesta";
                    color=Color.decode(COLOR_ASIGNACION_COMPUESTA);
                }else if (palabra.equals("Module") || palabra.equals("End") || palabra.equals("Sub") || palabra.equals("Main") || 
                        palabra.equals("Dim") || palabra.equals("As") || palabra.equals("Integer") || palabra.equals("String") || 
                        palabra.equals("Boolean") || palabra.equals("Double") || palabra.equals("Char") || palabra.equals("Console.WriteLine") || 
                        palabra.equals("Console.ReadLine") || palabra.equals("If") || palabra.equals("ElseIf") || palabra.equals("Else") || 
                        palabra.equals("Then") || palabra.equals("While") || palabra.equals("Do") || palabra.equals("Loop") || 
                        palabra.equals("For") || palabra.equals("To") || palabra.equals("Next") || palabra.equals("Function") || 
                        palabra.equals("Return") || palabra.equals("Const") ) {
                    token="Palabra Reservada";
                    color=Color.decode(COLOR_PALABRA_RESERVADA);
                }else if (palabra.equals("(") || palabra.equals(")") ) {
                    token="Paréntesis";
                    color=Color.decode(COLOR_PARENTESIS);
                }else if (palabra.equals("{") || palabra.equals("}") ) {
                    token="Llaves";
                    color=Color.decode(COLOR_LLAVES);
                }else if (palabra.equals("[") || palabra.equals("]") ) {
                    token="Corchetes";
                    color=Color.decode(COLOR_CORCHETES);
                }else if (palabra.equals(",")) {
                    token="Coma";
                    color=Color.decode(COLOR_COMA);
                }else if (palabra.equals(".")) {
                    token="Punto";
                    color=Color.decode(COLOR_PUNTO);
                }else if (palabra.equals("True") || palabra.equals("False")) {
                    token="Booleano";
                    color=Color.decode(COLOR_BOOLEANO);
                }else if (palabra.charAt(0) == '"' ) {
                    token="Cadena";
                    color=Color.decode(COLOR_CADENA);
                }else if (palabra.charAt(0) == SIGNO_COMENTARIO_CARACTER) {
                    token="Comentario";
                    color=Color.decode(COLOR_COMENTARIO);
                }else if (palabra.charAt(0) == SIGNO_COMENTARIO_CARACTER && palabra.charAt(palabra.length()-1)== SIGNO_COMENTARIO_CARACTER) {
                    token="Carácter";
                    color=Color.decode(COLOR_CARACTER);
                }else if (!Character.isDigit(palabra.charAt(0))) {
                    token="Identificador";
                    color=Color.decode(COLOR_IDENTIFICADOR);
                }else{
                    JOptionPane.showMessageDialog(null, "Token no aceptado: " + palabra, "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            }
        }
        //personalizar el label segun su estilo y token
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1); 
        this.setBorder(border);
        this.setOpaque(true);
        this.setBackground(color);
        return this;
    }
    
    public String getToken() {
        return token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setFilaCuadro(int filaCuadro) {
        this.filaCuadro = filaCuadro;
    }

    public void setColumnaCuadro(int columnaCuadro) {
        this.columnaCuadro = columnaCuadro;
    }

    public String getLinea() {
        return linea;
    }

    public String getColumna() {
        return columna;
    }

    public int getFilaCuadro() {
        return filaCuadro;
    }

    public int getColumnaCuadro() {
        return columnaCuadro;
    }

    public Color getColor() {
        return color;
    }
    
    public void mostrarInformacion(String token) throws IOException {
        
        File carpeta = new File("Autonomas");
        // Crear la carpeta y sus subcarpetas si no existen 
        if (!carpeta.exists()) {
            carpeta.mkdirs(); 
        }
        //crear el path
        String dotPath = carpeta.getPath() + File.separator + generarNombre(DOT_EXTENSION);
        File imagen = new File(carpeta, generarNombre(PNG_EXTENSION));
        // Crear el archivo DOT y renderizar la imagen
        generarArchivo(token, dotPath);
        Graphviz.fromFile(new File(dotPath)).render(Format.PNG).toFile(imagen);
        // Verificar si el archivo PNG se ha creado correctamente
        if (!imagen.exists()) {
            throw new IOException("No se pudo crear el archivo de imagen PNG.");
        }
        generarDialog(imagen);
    }

    private String generarNombre(String extension) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String fechaHora = LocalDateTime.now().format(formatter);
        return FILE_PREFIX + fechaHora + extension;
    }

    private void generarArchivo(String expresion, String dotPath) throws IOException {
        String dotContent = generarCadena(expresion);
        // Guardar el archivo DOT
        try (FileWriter writer = new FileWriter(dotPath)) {
            writer.write(dotContent);
        }
    }

    private String generarCadena(String palabra) {
        StringBuilder dot = new StringBuilder("digraph G {\n");
        dot.append("rankdir=LR;\n"); // Dirección de izquierda a derecha
        // Crear los nodos y las transiciones para el autómata
        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            String label = remplazarCaracteres(String.valueOf(caracter));
            dot.append("q").append(i)
               .append(" -> q").append(i + 1)
               .append(" [label=\"").append(label).append("\"];\n");
        }
        dot.append("q").append(palabra.length()).append(" [shape=doublecircle];\n"); // Estado final
        dot.append("}");

        return dot.toString();
    }

    private String remplazarCaracteres(String label) {
        return label.replace("\"", "\\\"");
    }
    
    private void generarDialog(File archivoImagen) {
        // Crear el ImageIcon y el JLabel para la imagen
        ImageIcon icon = new ImageIcon(archivoImagen.getAbsolutePath());
        JLabel imageLabel = new JLabel(icon);
        // Crear el JLabel para la información
        String texto = String.format("Fila y columna en la cuadricula: [%d, %d]", filaCuadro, columnaCuadro);
        JLabel filaColumLabel = new JLabel(texto, SwingConstants.CENTER);
        // Crear un panel para colocar la imagen y la información
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(filaColumLabel, BorderLayout.SOUTH);
        // Mostrar el JOptionPane con la información y la imagen
        JOptionPane.showMessageDialog(null, panel, "AUTOMATA", JOptionPane.INFORMATION_MESSAGE);
    } 
}