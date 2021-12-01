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
public class Marcadores  extends JPanel implements ActionListener{
   //marcadores
    //nombre de usaurio correo
    
      
 /**
  * Los componentes que tiene usamos en el JPanel
  */
public static JTable Tabla;
public static DefaultTableModel modelo;
JScrollPane scroll;
JLabel lblMarcador,lblCorreo;
JTextField txtMarcador,txtCorreo;
JButton btnGuardar,btnModificar,btnAgregar,btnEliminar;
int fila;
String Datos[];

/**
 * Inicia el constructor
 */
    public Marcadores(){
    /**
     * Configurando los componentes del Jpanel
     */
  setLayout(null);
  reshape(0, 0,752, 655);
  setBorder(BorderFactory.createLineBorder(Color.black));
  
  //Configurando los componentes  para agregar a JPanel
modelo = new DefaultTableModel();
Tabla = new JTable(modelo);
scroll= new JScrollPane(Tabla);
Datos = new String[2];

lblMarcador= new JLabel("Marcadores");
lblCorreo = new JLabel("Direccion:");

txtMarcador= new JTextField(20);
txtCorreo= new JTextField(20);

btnGuardar= new JButton("Guardar");
btnModificar = new JButton("Modificar");
btnAgregar = new JButton("Agregar");
btnEliminar=new JButton("Eliminar");

//agregando nombres a las columnas de la tabla modelo;

modelo.addColumn("Marcadores");
modelo.addColumn("Ccorreo");
    
//Colocando las posiciones y tamaño de los componentes
lblMarcador.reshape(10,10,75,50);
txtMarcador.reshape(95,18,130,25);

lblCorreo.reshape(10,70,75,50);
txtCorreo.reshape(95,78,130,25);
    
Tabla.reshape(235,18,507,365);
scroll.reshape(235,18,507,365);

btnGuardar.reshape(11,190,100,35);
btnModificar.reshape(121,190,100,35);

btnAgregar.reshape(11,250,100,35);
btnEliminar.reshape(121,250,100,35);

btnGuardar.addActionListener(this);
btnModificar.addActionListener(this);
btnAgregar.addActionListener(this);
btnEliminar.addActionListener(this);

//Agregando componentes al JPanel
add(lblMarcador);
add(txtMarcador);
add(lblCorreo);
add(txtCorreo);
add(scroll);
add(btnGuardar);
add(btnModificar);
add(btnAgregar);
add(btnEliminar);


//reshape(0, 0,752, 655);
    }//dfin del constructor

    
    
       public void paintComponent(Graphics g){
    Dimension dmsTamaño = getSize();
    ImageIcon Image = new ImageIcon("src\\Imagen\\Marcadores.png");
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
    
     String []datos=new String[4];
    datos[0]=txtMarcador.getText();
    datos[1]= txtCorreo.getText();
    
    
    for(int i=0;i<Tabla.getColumnCount();i++){
        modelo.setValueAt(datos[i], fila, i);
    
    }
    txtMarcador.setText("");
    txtCorreo.setText("");
    ;
        
    }
    
    
    
    /**
     * agregar metodo para agregar los datos en la tabla
     * @return gresara la informacion ingresada en la matriz
     */
    public void agregar(){
    if(txtMarcador.getText().equals("")&&txtCorreo.getText().equals("")){
    
    JOptionPane.showMessageDialog(null,"Debe llenar los datos");
    
    }//fin de primer if
    
   
   
 if(!(txtMarcador.getText().equals("")&&txtCorreo.getText().equals(""))){
    
    Datos[0]= txtMarcador.getText();
    Datos[1]= txtCorreo.getText();
    
    
    modelo.addRow(Datos);
    
    
    txtMarcador.setText("");
    txtCorreo.setText("");
        }
   
    
    //txtNombre.requestFocusInWindow();
    }   //find e metodo
    /**
     * Metodo Modificar los contenidos en una tabla
     */
    
    public void Modificar(){
        
      int filaSel = Tabla.getSelectedRow();
      
    System.out.println("El numero de fila es:"+filaSel);
        
    txtMarcador.setText(Tabla.getValueAt(filaSel, 0).toString());//getValue at obtine el valor de la infocrcaicon en fila y columna
    txtCorreo.setText(Tabla.getValueAt(filaSel, 1).toString());
   
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
    
    
    
    }//fin de la metodo eliminar

      
  public  static Object GetData(JTable table, int row_index, int col_index){
  return table.getModel().getValueAt(row_index, col_index);
 }
    
    
    
    
    
}//fin de clase 
