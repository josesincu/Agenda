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
public class DiasFestivo extends JPanel implements ActionListener{
    JLabel lblAsueto;
    JTextField txtAsueto;
    JLabel lblDia;
    JTextField txtDia;
    JLabel lblFecha;
    JTextField txtFecha;
 public static   JTable Tabla;
    JScrollPane scroll ;
 public static  DefaultTableModel modelo;
    int fila;
    String Datos[];
   
   
   JButton btnGuardar,btnAgregar,btnModificar,btnEliminar;
   
   
   
   public DiasFestivo(){
   
   //Configurando JPanel
   Datos = new String[3];
    
    reshape(0, 0,752, 655);
    setBorder(BorderFactory.createLineBorder(Color.black));
    setLayout(null);
   
   
   //inicializacion de los componentes
   modelo = new DefaultTableModel();
    lblAsueto = new JLabel("Asueto:");
    txtAsueto = new JTextField(20);
    
    
    lblDia = new JLabel("Dia:");
    txtDia = new JTextField(20);
    
    lblFecha= new JLabel("Fecha:");
    txtFecha = new JTextField(20);
   
    
    btnGuardar = new JButton("Guardar");
    btnAgregar = new JButton("Agregar");
    
    btnModificar = new JButton("Modificar");
    
    scroll = new JScrollPane();
    Tabla = new JTable();
   
    //agragando componentes en JPanel
   add(lblAsueto);
   add(txtAsueto);
   
   add(lblDia);
   add(txtDia);
   
   add(lblFecha);
   add(txtFecha);
   
   add(btnGuardar);
   add(btnAgregar);
   
   add(btnModificar);

   modelo.addColumn("Asueto");
   modelo.addColumn("Dia");
   modelo.addColumn("Fecha");
   
   //posicionando los componentes en el contenedor
   lblAsueto.reshape(10, 10, 50, 20);
   txtAsueto.reshape(70, 10, 150, 20);
   
   lblDia.reshape(10, 40, 50, 20);
   txtDia.reshape(70, 40, 150, 20);
 
   lblFecha.reshape(10, 70, 50, 20);
   txtFecha.reshape(70, 70, 150, 20);
   
   //Guardar el archivo con el nombre del usaurio y leerlo con el nombre del usaurio
   
   btnGuardar.reshape(10,130,80,50);
   btnAgregar.reshape(100,130,80,50);
   
   btnModificar.reshape(230,415,140,30);
   
   //Eventos a botones
   btnGuardar.addActionListener(this);
   btnAgregar.addActionListener(this);
   btnModificar.addActionListener(this);
   
   
   
//   Tabla.reshape(230,10,320,400);
   scroll.reshape(230,10,320,400);
    
   scroll.setViewportView(Tabla);
   Tabla.setModel(modelo);
   
   add(scroll);
      
   
   }//fin del constructor
    
    
    
       public void paintComponent(Graphics g){
    Dimension dmsTamaño = getSize();
    ImageIcon Image = new ImageIcon("src\\Imagen\\DiaF.png");
    g.drawImage(Image.getImage(),0,0,dmsTamaño.width,dmsTamaño.height,null);
    setOpaque(false);
    super.paintComponent(g);
    } //fin de metodo de fondo
    
       
    /**
     * Metodo Guauardar los cambios que se hayan echo en el boton modificar
     */
    public void Guardar(){
    
     String []datos=new String[4];
    datos[0]=txtAsueto.getText();
    datos[1]= txtDia.getText();
    datos[2]= txtFecha.getText();
    
    for(int i=0;i<Tabla.getColumnCount();i++){
        modelo.setValueAt(datos[i], fila, i);
    
    }
    txtAsueto.setText("");
    txtDia.setText("");
    txtFecha.setText("");
        
    }
    
    
    
    /**
     * agregar metodo para agregar los datos en la tabla
     * @return gresara la informacion ingresada en la matriz
     */
    public void agregar(){
    if(txtAsueto.getText().equals("")&&txtDia.getText().equals("")
    && txtFecha.getText().equals("")){
    
    JOptionPane.showMessageDialog(null,"Debe llenar los datos");
    
    }//fin de primer if
    
   
   
 if(!(txtAsueto.getText().equals("")&&txtDia.getText().equals("")&&txtFecha.getText().equals(""))){
    
    Datos[0]= txtAsueto.getText();
    Datos[1]= txtDia.getText();
    Datos[2]= txtFecha.getText();
    
    modelo.addRow(Datos);
    
    
    txtAsueto.setText("");
    txtDia.setText("");
    txtFecha.setText("");
        }
   
    
    //txtNombre.requestFocusInWindow();
    }   //find e metodo
    /**
     * Metodo Modificar los contenidos en una tabla
     */
    
    public void Modificar(){
        
      int filaSel = Tabla.getSelectedRow();
      
    System.out.println("El numero de fila es:"+filaSel);
        
    txtAsueto.setText(Tabla.getValueAt(filaSel, 0).toString());//getValue at obtine el valor de la infocrcaicon en fila y columna
    txtDia.setText(Tabla.getValueAt(filaSel, 1).toString());
    txtFecha.setText(Tabla.getValueAt(filaSel, 2).toString());
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

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource()==btnGuardar){
            System.out.println("Hola soy el boton guardar");
            this.Guardar();
         
        }if(e.getSource()==btnAgregar){
        this.agregar();
        
        }if(e.getSource()==btnModificar){
        this.Modificar();
        
        }if(e.getSource()==btnEliminar){
        this.Eliminar();
       
        }
        
    }//fin de boton de acciones
    
  public  static Object GetData(JTable table, int row_index, int col_index){
  return table.getModel().getValueAt(row_index, col_index);
 }
    
    
    
    
    
}//fin de clase
