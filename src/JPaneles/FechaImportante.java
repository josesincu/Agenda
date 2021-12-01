/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPaneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author JosDark
 */
public class FechaImportante extends JPanel{
    
    /**
     * Coponentes de losta de meses
     */
   JLabel lblEnero,lblFebrero,lblMarzo,lblAbril,lblMayo,
           lblJunio,lblJulio,lblAgosto,lblSeptiembre,lblOctubre,lblNoviembre,lblDiciembre;
  public static JTextArea enero,febrero,marzo,abril,mayo,junio,julio,agosto,septiembre,octubre,noviembre,diciembre;
   
   JButton btnGuardar,btnEliminar;
    
   public FechaImportante(){
   /**
    * Comfigurando los componentes de JPanel
    */
   setLayout(null);
   reshape(0, 0,752, 655);
   setBorder(BorderFactory.createLineBorder(Color.black));
   
   /**
    * intanciando los comoponentes del JPane
    */
   lblEnero= new JLabel("Enero");
   lblFebrero= new JLabel("Febrero");
   lblMarzo= new JLabel("Marzo");
   lblAbril= new JLabel("Abril");
   lblMayo= new JLabel("Mayo");
   lblJunio= new JLabel("Junio");
   lblJulio= new JLabel("Julio");
   lblAgosto= new JLabel("Agosto");
   lblSeptiembre= new JLabel("Septiembre");
   lblOctubre= new JLabel("Octubre");
   lblNoviembre= new JLabel("Noviembre");
   lblDiciembre= new JLabel("Diciembre");
   
   enero = new JTextArea(5,1);
   febrero= new JTextArea(5,1);
   marzo= new JTextArea(5,1);
   abril = new JTextArea(5,1);
   mayo = new JTextArea(5,1);
   junio= new JTextArea(5,1);
   julio= new JTextArea(5,1);
   agosto = new JTextArea(5,1);
   septiembre = new JTextArea(5,1);
   octubre= new JTextArea(5,1);
   noviembre= new JTextArea(5,1);
   diciembre = new JTextArea(5,1);
   
   btnGuardar = new JButton("Guardar");
   btnEliminar= new JButton("Eliminar");
   
   /**
    * Colocando las posicones y tamaños de los componentes
    * 
    */
   lblEnero.reshape(10,10,80,25);
   enero.reshape(10,45,240,100);
   
   lblFebrero.reshape(260,10,80,25);
   febrero.reshape(260,45,240,100);
   
   lblMarzo.reshape(510,10,80,25);
   marzo.reshape(510,45,233,100);
   
   //Primera
   
   lblAbril.reshape(10,155,80,25);
   abril.reshape(10,190,240,100);
   
   lblMayo.reshape(260,155,80,25);
   mayo.reshape(260,190,240,100);
   
   lblJunio.reshape(510,155,80,25);
   junio.reshape(510,190,233,100);
   
   //segunda
   
   lblJulio.reshape(10,300,80,25);
   julio.reshape(10,335,240,100);
   
   lblAgosto.reshape(260,300,80,25);
   agosto.reshape(260,335,240,100);
   
   lblSeptiembre.reshape(510,300,80,25);
   septiembre.reshape(510,335,233,100);
   //Tercera
   lblOctubre.reshape(10,445,80,25);
   octubre.reshape(10,470,240,100);
   
   lblNoviembre.reshape(260,445,80,25);
   noviembre.reshape(260,470,240,100);
   
   lblDiciembre.reshape(510,445,80,25);
   diciembre.reshape(510,470,233,100);
   
   /**
    * Agregando los componentes a JPanel
    */
   add(lblEnero); add(enero); add(lblFebrero); add(febrero); add(lblMarzo);  add(marzo);add(lblAbril);add(abril);
   add(lblMayo); add(mayo); add(lblJunio); add(junio); add(lblJulio);  add(julio);add(lblAgosto);add(agosto);
   add(lblSeptiembre); add(septiembre); add(lblOctubre); add(octubre); add(lblNoviembre);  add(noviembre);
   add(lblDiciembre);add(diciembre);
        
  
   
   
   
  // btnGuardar.reshape();
   //reshape(0, 0,752, 655);
   
   
   
   }//fin del constructo
    
   
    
       public void paintComponent(Graphics g){
    Dimension dmsTamaño = getSize();
    ImageIcon Image = new ImageIcon("src\\Imagen\\FechaImportante.png");
    g.drawImage(Image.getImage(),0,0,dmsTamaño.width,dmsTamaño.height,null);
    setOpaque(false);
    super.paintComponent(g);
    } //fin de metodo de fondo
    
    
    
    
}//fin de la clase
