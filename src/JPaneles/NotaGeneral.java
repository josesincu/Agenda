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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author JosDark
 */
public class NotaGeneral  extends JPanel{
    JLabel lblGeneral;
    public static JTextArea notaGeneral;
    JScrollPane scrol;
    JButton btnGuardar,btnMostrar,btnEliminar;
    
    
    public NotaGeneral(){
    //configuracion de los componentes de JPanel
  setLayout(null);
  reshape(0, 0,752, 655);
  setBorder(BorderFactory.createLineBorder(Color.black));
  
  //LLamando los componentes
  lblGeneral = new JLabel("Notas Generales");
  
  notaGeneral = new JTextArea(5,1);
  scrol= new JScrollPane(notaGeneral);
  
  btnGuardar = new JButton("Guardar");//escribe el texto
  btnMostrar = new JButton("Mostrar");//Lee el archivo y lo escribe
  btnEliminar = new JButton("Eliminar");//Elimina las actividades en el componente
  
  //configurando las posiciones de los componetete
  lblGeneral.reshape(10,10,200,60);
  notaGeneral.reshape(10,80,732,450);
  scrol.reshape(10,80,732,450);
  
  btnGuardar.reshape(10,540,100,35);
  btnMostrar.reshape(120,540,100,35);
  btnEliminar.reshape(230,540,100,35);
  
  //Agregando los componente al JPanel
  add(lblGeneral);
  add(scrol);
  add(btnGuardar);
  add(btnMostrar);
  add(btnEliminar);  
  
  
    }//fin del constructor
    
    
       public void paintComponent(Graphics g){
    Dimension dmsTamaño = getSize();
    ImageIcon Image = new ImageIcon("src\\Imagen\\NotaGeneral.png");
    g.drawImage(Image.getImage(),0,0,dmsTamaño.width,dmsTamaño.height,null);
    setOpaque(false);
    super.paintComponent(g);
    } //fin de metodo de fondo
       
    
    
       
}
