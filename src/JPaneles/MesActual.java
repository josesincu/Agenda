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
public class MesActual extends JPanel {
 JLabel lblMes,lblNota1,lblNota2,lblNota3,lblNota4; 
 public static  JTextArea mesNotas,nota1,nota2,nota3,nota4;
 JButton btnMostrar,btnEliminar;
 JScrollPane scrol1,scrol2,scrol3,scrol4,scrol5;
 
 public MesActual(){
 
  //Configurando JPanel
  setLayout(null);
  reshape(0, 0,752, 655);
  setBorder(BorderFactory.createLineBorder(Color.black));
        
//Inicializancion de los componentes del JPanel
lblMes= new JLabel("Notas Mes");
lblNota1= new JLabel("Semana 1");
lblNota2= new JLabel("Semana 2");
lblNota3 = new JLabel("Semana 3");
lblNota4 = new JLabel("Semana 4");
 
mesNotas = new JTextArea(5,1);
nota1= new JTextArea(5,1);
nota2 = new JTextArea(5,1);
nota3 = new JTextArea(5,1);
nota4= new JTextArea(5,1);

scrol1= new JScrollPane(mesNotas);
scrol2= new JScrollPane(nota1);
scrol3= new JScrollPane(nota2);
scrol4= new JScrollPane(nota3);
scrol5= new JScrollPane(nota4);

btnMostrar= new JButton("Mostrar");
btnEliminar= new JButton("Eliminar");

//configurando las posicones de los componentes
lblNota1.reshape(10, 10, 100, 50);
nota1.reshape(10, 70, 250, 200);
scrol2.reshape(10, 70, 250, 200);

lblNota2.reshape(270,10,100,50);
nota2.reshape(270,70,250,200);
scrol3.reshape(270,70,250,200);

lblNota3.reshape(530, 10, 100, 50);
nota3.reshape(530, 70, 213, 200);
scrol4.reshape(530, 70, 213, 200);

lblNota4.reshape(10,280,100,50);
nota4.reshape(10,340,250,200);
scrol5.reshape(10,340,250,200);

lblMes.reshape(270,280,100,50);
mesNotas.reshape(270,340,475,305);
scrol1.reshape(270,340,475,305);
 
btnMostrar.reshape(10,550, 100, 30);
btnEliminar.reshape(120, 550, 100, 30);
 
//reshape(0, 0,752, 655);
 
 //agregando los componentes a JPanel
 add(lblMes);
 add(scrol1);
 add(lblNota1);
 add(scrol2);
 add(lblNota2);
 add(scrol3);
 add(lblNota3);
 add(scrol4);
 add(lblNota4);
 add(scrol5);
 add(btnMostrar);
 add(btnEliminar);
 
 
 
 }//fin del constructor
 
 
 
    
       public void paintComponent(Graphics g){
    Dimension dmsTamaño = getSize();
    ImageIcon Image = new ImageIcon("src\\Imagen\\MesActual.png");
    g.drawImage(Image.getImage(),0,0,dmsTamaño.width,dmsTamaño.height,null);
    setOpaque(false);
    super.paintComponent(g);
    } //fin de metodo de fondo
    
    
    
    
    
}
