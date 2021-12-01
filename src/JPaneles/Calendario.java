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
import javax.swing.JPanel;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;


/**
 *
 * @author JosDark
 */
public class Calendario extends JPanel implements ActionListener {
    /**
     * Los componententes de JPanel
     */
    JCalendar calendario;
    
    JLabel lblAsunto,lblHora,lblFecha,lblLugar,lblDia;
   public JTextField txtAsunto,txtLugar;
    JComboBox jbxHora,jbxDia;
    JButton btnGuardar,btnAgregar,btnModificar,btnEliminar;
    
   public static JTable calenDatos;
    public static DefaultTableModel agreTabla;
    JScrollPane scroll;
    
    
    String Datos[];
    int fila;
    
    
    public Calendario(){
    //Confiigurando los layouts
    setLayout(null);
    
    
    
    //Inicializando los compomentes de JPanel
    calendario = new JCalendar();
    
    lblAsunto = new JLabel("Asunto");
    lblHora= new JLabel("Hora");
    lblFecha= new JLabel("Fecha");
    lblLugar=new JLabel("Lugar");
    lblDia= new JLabel("Dia");
    
    txtAsunto=new JTextField(20);
    txtLugar= new JTextField(20);
    
    jbxHora= new JComboBox();
    jbxDia= new JComboBox();
    
    btnGuardar= new JButton("Guardar");
    btnAgregar= new JButton("Agregar");
    btnModificar= new JButton("Modificar");
    btnEliminar = new JButton("Eliminar");
    Datos=new String[4];
      
    agreTabla= new DefaultTableModel();
    
    //String encabezado[]= {"Asunto","Hora","Lugar","Dia"};
    agreTabla.addColumn("Asunto");
    agreTabla.addColumn("Hora");
    agreTabla.addColumn("Lugar");
    agreTabla.addColumn("Dia");
    
    
    calenDatos=new JTable();
    calenDatos.setModel(agreTabla);
    scroll= new JScrollPane(calenDatos);
    
   //Agendando Horas Y dias en Combobox
   jbxHora.addItem("1");jbxHora.addItem("2");jbxHora.addItem("3");jbxHora.addItem("4");jbxHora.addItem("5");
   jbxHora.addItem("6");jbxHora.addItem("7");jbxHora.addItem("8");jbxHora.addItem("9");jbxHora.addItem("10");
   jbxHora.addItem("11");jbxHora.addItem("12");jbxHora.addItem("13");jbxHora.addItem("14");jbxHora.addItem("15");
   jbxHora.addItem("16");jbxHora.addItem("17");jbxHora.addItem("18");jbxHora.addItem("19");jbxHora.addItem("20");
   jbxHora.addItem("21");jbxHora.addItem("22");jbxHora.addItem("23");jbxHora.addItem("24");
   
   jbxDia.addItem("Lunes");jbxDia.addItem("Martes");jbxDia.addItem("Miercoles");jbxDia.addItem("Jueves");jbxDia.addItem("Viernes");
   jbxDia.addItem("Sabado");jbxDia.addItem("Domingo");
    
   
   //Colocandolo las posicones y tamaño los componentes del JPanel 
    lblAsunto.reshape(10, 20, 40, 25);
    txtAsunto.reshape(60,20,150,25);
    lblDia.reshape(220,20,40,25);
    jbxDia.reshape(265,20 ,150 ,25 );
    
    lblLugar.reshape(10,55,40,25);
    txtLugar.reshape(60,55,150,25);
    lblHora.reshape(220,55,40,25);
    jbxHora.reshape(265,55,150,25);  // aqui jboxCOmb
    
    //.reshape(10,90,40,25);
    //.reshape(60,90,150,25); cambie los datos
    
    scroll.reshape(10,125,400,250);
    
    btnGuardar.reshape(10,385,100,30);
    btnAgregar.reshape(120,385,100,30);
    btnModificar.reshape(230,385,100,30);
    btnEliminar.reshape(340,385,100,30);
    
    btnGuardar.addActionListener(this);
    btnAgregar.addActionListener(this);
    btnModificar.addActionListener(this);
    btnEliminar.addActionListener(this);
    
    //Agregando los componenstes a JPanel
    add(lblAsunto);
    add(txtAsunto);
    add(lblFecha);
    add(lblLugar);
    add(txtLugar);
    add(lblDia);
    add(jbxDia);
    add(lblHora);
    add(jbxHora);
    
    add(scroll);
    
    add(btnGuardar);
    add(btnAgregar);
    add(btnModificar);
    add(btnEliminar);
  
    //configurando las posiciones del y tamaños de los componentes
    setBounds(0, 0,752, 655);
    calendario.setBounds(442, 20, 300, 200);
    setBorder(BorderFactory.createLineBorder(Color.black));
     
    //Agregando componentes a JPanel
    
    add(calendario);
    
    }//fin del constructor
    
    
    
    public void paintComponent(Graphics g){
    Dimension dmsTamaño = getSize();
    ImageIcon Image = new ImageIcon("src\\Imagen\\Calendario.png");
    g.drawImage(Image.getImage(),0,0,dmsTamaño.width,dmsTamaño.height,null);
    setOpaque(false);
    super.paintComponent(g);
    } //fin de metodo de fondo

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
        
        
        
        
        
    }//fin de evento
    
    /**
     * Metodo Guauardar los cambios que se hayan echo en el boton modificar
     */
    public void Guardar(){
    
     String []datos=new String[4];
    datos[0]=txtAsunto.getText();
    datos[1]=(String)jbxHora.getSelectedItem();
    datos[2]= txtLugar.getText();
    datos[3]=(String) jbxDia.getSelectedItem();//Hacer un casting con label
    
    for(int i=0;i<calenDatos.getColumnCount();i++){
        agreTabla.setValueAt(datos[i], fila, i);
    
    }
    txtAsunto.setText("");
    txtLugar.setText("");
        
    }
    
    
    
    /**
     * agregar metodo para agregar los datos en la tabla
     * @return gresara la informacion ingresada en la matriz
     */
    public void agregar(){
    if(txtAsunto.getText().equals("")&&txtLugar.getText().equals("")){
    
    JOptionPane.showMessageDialog(null,"Debe llenar los datos");
    
    }//fin de primer if
    
   
   
 if(!(txtAsunto.getText().equals("")&&txtLugar.getText().equals(""))){
    
    Datos[0]= txtAsunto.getText();
    Datos[1]= (String)jbxHora.getSelectedItem();//hacer un castind
    Datos[2]= txtLugar.getText();
    Datos[3]= (String) jbxDia.getSelectedItem();
    
    agreTabla.addRow(Datos);
    
    
    txtAsunto.setText("");
    txtLugar.setText("");
    
        }
   
    
    //txtNombre.requestFocusInWindow();
    }   //find e metodo
    /**
     * Metodo Modificar los contenidos en una tabla
     */
    
    public void Modificar(){
        
      int filaSel = calenDatos.getSelectedRow();
      
        System.out.println("El numero de fila es:"+filaSel);
        
      txtAsunto.setText(calenDatos.getValueAt(filaSel, 0).toString());//getValue at obtine el valor de la infocrcaicon en fila y columna
    txtLugar.setText(calenDatos.getValueAt(filaSel, 2).toString());
    jbxDia.setSelectedItem(calenDatos.getValueAt(filaSel, 3).toString());
      fila=filaSel;
        
    
    
    }//fin de mostrar
    /**
     * Metodo eliminar filas de la tabla
     */
    public void Eliminar(){
    // TODO add your handling code here:
    int filaselecionada= calenDatos.getSelectedRow();
    
    if(filaselecionada>=0){
        
            agreTabla.removeRow(filaselecionada);
            
    }
    else{
        JOptionPane.showMessageDialog(null, "tabla vacia o no seleciono ninguna fila");
    }
    
    
    
    }
    
    
    
    
    
}//fin de clase
