/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package practicaunolfp.practicaunolfp;

import Backen.Gestor;
import Fronted.FramePrincipal;

/**
 *
 * @author xavi
 */
public class PracticaUnoLFP {

       
   public static void main(String[] args) {
   
       Gestor gestor = new Gestor();
       FramePrincipal frame = new FramePrincipal(gestor);
       frame.setVisible(true);
    }
}
