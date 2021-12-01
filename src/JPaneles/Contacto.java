/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPaneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JosDark
 */
public class Contacto extends JPanel implements ActionListener{
 /**
  * La clase contacto requiere
  * un Nombre , un Numero,Direccion
  */   
  
 /**
  * Los componentes que tiene usamos en el JPanel
  */
public static JTable Tabla;
public static DefaultTableModel modelo;
JScrollPane scroll;
JLabel lblNombre,lblNumero,lblDireccion;
JTextField txtNombre,txtNumero,txtDireccion;
JButton btnGuardar,btnModificar,btnAgregar,btnEliminar;
int fila;
String Datos[];
 

/**
 * Inicia el constructor
 */
    public Contacto(){
    /**
     * Configurando los componentes del Jpanel
     */
  setLayout(null);
  reshape(0, 0,752, 655);
  setBorder(BorderFactory.createLineBorder(Color.black));
  
  Datos = new String[3];
  //Configurando los componentes  para agregar a JPanel
modelo = new DefaultTableModel();
Tabla = new JTable(modelo);
scroll= new JScrollPane(Tabla);

lblNombre= new JLabel("Nombre:");
lblNumero= new JLabel("Numero:");
lblDireccion = new JLabel("Direccion:");

txtNombre= new JTextField(20);
txtNumero= new JTextField(20);
txtDireccion= new JTextField(20);

btnGuardar= new JButton("Guardar");
btnModificar = new JButton("Modificar");
btnAgregar = new JButton("Agregar");
btnEliminar=new JButton("Eliminar");

//agregando nombres a las columnas de la tabla modelo;
modelo.addColumn("Nombre");
modelo.addColumn("Numero");
modelo.addColumn("Direccion");
    
//Colocando las posiciones y tamaño de los componentes
lblNombre.reshape(10,10,75,50);
txtNombre.reshape(95,18,130,25);

lblNumero.reshape(10,70,75,50);
txtNumero.reshape(95,78,130,25);

lblDireccion.reshape(10,130,75,50);
txtDireccion.reshape(95,138 ,130 ,25 );
    
Tabla.reshape(235,18,507,365);
scroll.reshape(235,18,507,365);

btnGuardar.reshape(11,190,100,35);
btnModificar.reshape(121,190,100,35);

btnAgregar.reshape(11,250,100,35);
btnEliminar.reshape(121,250,100,35);

//btn de actividades
btnGuardar.addActionListener(this);
btnModificar.addActionListener(this);
btnAgregar.addActionListener(this);
btnEliminar.addActionListener(this);

//Agregando componentes al JPanel
add(lblNombre);
add(txtNombre);
add(lblNumero);
add(txtNumero);
add(lblDireccion);
add(txtDireccion);
add(scroll);
add(btnGuardar);
add(btnModificar);
add(btnAgregar);
add(btnEliminar);


//reshape(0, 0,752, 655);
    }//fin del connstructor
    
    
    
    public void paintComponent(Graphics g){
    Dimension dmsTamaño = getSize();
    ImageIcon Image = new ImageIcon("src\\Imagen\\Contacto.png");
    g.drawImage(Image.getImage(),0,0,dmsTamaño.width,dmsTamaño.height,null);
    setOpaque(false);
    super.paintComponent(g);
    } //fin de metodo de fondo

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource()==btnGuardar) {
            this.Guardar();
        }if (e.getSource()==btnModificar) {
            this.Modificar();
        }if (e.getSource()==btnAgregar) {
            this.agregar();
        }if (e.getSource()==btnEliminar) {
            this.Eliminar();
        }
        
    
    
    }
    
    /**
     * Metodo Guauardar los cambios que se hayan echo en el boton modificar
     */
    public void Guardar(){
    
     String []datos=new String[3];
    datos[0]=txtNombre.getText();
    datos[1]= txtNumero.getText();
    datos[2]= txtDireccion.getText();
    
    
    for(int i=0;i<Tabla.getColumnCount();i++){
        modelo.setValueAt(datos[i], fila, i);
    
    }
    txtNombre.setText("");
    txtNumero.setText("");
    txtDireccion.setText("");
    ;
        
    }
    
    
    
    /**
     * agregar metodo para agregar los datos en la tabla
     * @return gresara la informacion ingresada en la matriz
     */
    public void agregar(){
    if(txtNombre.getText().equals("")&&txtNumero.getText().equals("")&&txtDireccion.getText().equals("")){
    
    JOptionPane.showMessageDialog(null,"Debe llenar los datos");
    
    }//fin de primer if
    
   

 if(!(txtNombre.getText().equals("")&&txtNumero.getText().equals("")&&txtDireccion.getText().equals(""))){
    
    Datos[0]= txtNombre.getText();
    Datos[1]= txtNumero.getText();
    Datos[2]= txtDireccion.getText();
    
    
    modelo.addRow(Datos);
    
    
    txtNombre.setText("");
    txtNumero.setText("");
    txtDireccion.setText("");
        }
   
    
    //txtNombre.requestFocusInWindow();
    }   //find e metodo
    /**
     * Metodo Modificar los contenidos en una tabla
     */
 public static String nombre,numero,direccion;  
    public void Modificar(){
        
      int filaSel = Tabla.getSelectedRow();
      
    System.out.println("El numero de fila es:"+filaSel);
        
    txtNombre.setText(Tabla.getValueAt(filaSel, 0).toString());//getValue at obtine el valor de la infocrcaicon en fila y columna
     nombre = txtNombre.getText();
     
    txtNumero.setText(Tabla.getValueAt(filaSel, 1).toString());
    numero = txtNumero.getText();
    
    txtDireccion.setText(Tabla.getValueAt(filaSel, 1).toString());
    direccion = txtDireccion.getText();
    
    fila=filaSel;
        
    
    
    }//fin de mostrar
    /**
     * Metodo eliminar filas de la tabla
     */
    public void Eliminar(){
    // TODO add your handling code here:
    int filaselecionada= Tabla.getSelectedRow();
    
    if(filaselecionada>=0){
        
            modelo.removeRow(filaselecionada);
            
    }
    else{
        JOptionPane.showMessageDialog(null, "tabla vacia o no seleciono ninguna fila");
    }
    
    
    
    }//fin de la clase eliminar
    
  public  static Object GetData(JTable table, int row_index, int col_index){
  return table.getModel().getValueAt(row_index, col_index);
 }

    
    
}
