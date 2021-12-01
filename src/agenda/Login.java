/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author JosDark
 */
public class Login {
     /**
      *Componentes de Login 
      * 
      */
 
public static Date horaEntrada;  
JFrame login;
JPanel jpLogin;
JLabel lblUsuario,lblContraseña,lblRegistrarse,lblNombre,lblApellido,lblCorreo,lblContras;
JTextField txtUsuario;
JTextField txtRegistrarte,txtNombre,txtApellido,txtCorreo,txtContras;
JPasswordField passContraseña;
JButton btnSesion,btnRegistrar;
Font font;
static FileWriter crear;  //una variable tiene que ser estatico y global
static BufferedWriter bw;
static BufferedReader textoArchivo;
static FileReader  leerArchivo;
File direccion;
File url;
public static String nombArchivo;
/**
 * Arreglo de objejetos
 * 
 */
public static crearUsuario crearUs[];

/**
 * Los variables para almacenar los valores
 * de Strin
 */




/**
 * Inicializando los componetes
 * 
 */
public Login(){
    
 crearUs= new crearUsuario[25];
 
  
   

login = new JFrame("***AGENDA***");
jpLogin= new JPanel();

lblUsuario=new JLabel("Correo");
lblContraseña= new JLabel("Contraseña");
btnSesion = new JButton("Iniciar sesion");

lblRegistrarse = new JLabel("REGISTRARSE");

lblNombre= new JLabel("Nombre");
lblApellido= new JLabel("Apellido");
lblCorreo=new JLabel("Correo");
lblContras= new JLabel("Contraseña");

txtUsuario=new JTextField(10);


txtNombre= new JTextField(10);
txtApellido= new JTextField(10);
txtCorreo=new JTextField(10);
txtContras= new JTextField(10);

passContraseña = new JPasswordField();


btnRegistrar= new JButton("Registrarse");

font = new Font("Comic Sans MS", Font.PLAIN, 35);

////////////////////
//this.mostrar();

/**
 * Posicion de los componetes
 */
//Posiciones de los componentes
login.setLayout(null);
jpLogin.setLayout(null);

//letras de los componenter
lblRegistrarse.setFont(font);

//Tamaño de los componentes
login.setSize(750, 360);
jpLogin.setSize(740, 350);

lblUsuario.reshape(30, 20, 50,23);// posion en x, posicion en y, ancho , altura
txtUsuario.reshape(80, 20, 170, 23);
lblContraseña.reshape(300, 20, 125, 23);
passContraseña.reshape(370, 20, 170, 23);

lblRegistrarse.reshape(30, 50, 300, 100);

lblNombre.reshape(30,160 , 75, 23);
txtNombre.reshape(80, 160,170 , 23);
lblApellido.reshape(300, 160, 75, 23);
txtApellido.reshape(370,160,170,23);


lblCorreo.reshape(30, 225, 75, 23);
txtCorreo.reshape(80, 225, 170, 23);
lblContras.reshape(300, 225, 75, 23);
txtContras.reshape(370, 225, 170, 23);

btnSesion.reshape(580, 20, 125, 23);
btnRegistrar.reshape(30,280,125,23);

//agregando los componentesa a su contenedor
jpLogin.add(lblUsuario);
jpLogin.add(lblContraseña);
jpLogin.add(lblRegistrarse);
jpLogin.add(lblNombre);
jpLogin.add(lblApellido);
jpLogin.add(lblCorreo);
jpLogin.add(lblContras);

jpLogin.add(txtUsuario);

jpLogin.add(txtNombre);
jpLogin.add(txtApellido);
jpLogin.add(txtCorreo);
jpLogin.add(txtContras);

jpLogin.add(passContraseña);

jpLogin.add(btnSesion);
jpLogin.add(btnRegistrar);

login.add(jpLogin);

//configuracion de JFrane Login
login.setResizable(false);
login.setLocationRelativeTo(null);
login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
login.setVisible(true);

//inicializando las variables


//Agregando eventos a  los botones
btnRegistrar.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){

btnRegistrarActionPerformed(event);

}
});//fin del evento

btnSesion.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){

btnSesionActionPerformed(event);

}});//fin del boton


}//fin de constructor

/**
 * Metodo del btnRegistrar
 */
public void btnRegistrarActionPerformed(ActionEvent event ){
   //try{
    //direccion = new File("C:\\Users\\JosDark\\Documents\\NetBeansProjects\\inicioAgenda\\src\\Archivos\\Usuarios.p2");
 direccion = new File("src\\Archivos\\Usuarios.p2");    
    if (txtNombre.getText().equals("")&&txtApellido.getText().equals("")&&
              txtCorreo.getText().equals("")&&txtContras.getText().equals("")) {
        //passContraseña.getText().equals("")
        
          JOptionPane.showMessageDialog(null, "Tiene que llenar los campos");
    }else{
        
        
        
          for (int i = 0; i <crearUs.length; i++) {
       // nombre=txtNombre.getText();
       
       //Creando Usuarios
       if(crearUs[i]==null){
           //ho si no solo crearUsuario[i].setTex(txtNombre.getText());
           //pero se necesita inicializar la variable en vacio para poder acceder a ella
      
        crearUs[i]=new crearUsuario();
        crearUs[i].setNombre(txtNombre.getText());
        crearUs[i].setApellido(txtApellido.getText());
        crearUs[i].setCorreo(txtCorreo.getText());
        crearUs[i].setContraseña(txtContras.getText());
      
        try{
         //crear = new FileWriter("C:\\Users\\JosDark\\Documents\\NetBeansProjects\\inicioAgenda\\src\\Archivos\\Usuarios.p2",true);
         crear = new FileWriter("src\\Archivos\\Usuarios.p2",true);
         ///para dar  o escribir muchav veces el appellido y ingreso de daros agregarle ,true al filewrite,,solo un archivo
         ///+txtCorreo.getText()+".p2"
        
        bw = new BufferedWriter(crear);
        bw.write(crearUs[i].getNombre()+"&"+crearUs[i].getApellido()+"&"+crearUs[i].getCorreo()+ "&"+crearUs[i].getContraseña());
        bw.newLine();//para hacer salto de linea
       
        bw.close();
       crear.close();
       }catch(IOException e){}
        
       txtNombre.setText("");
       txtApellido.setText("");
       txtCorreo.setText("");
       txtContras.setText("");
       
        
       System.out.println("Usuario creado correctamente en la pisicion ["+i+"]: "+crearUs[i].getApellido()
                        +" "+crearUs[i].getNombre()+" "+crearUs[i].getCorreo()+" "+crearUs[i].getContraseña() );
       break;
        
      }else{
           System.out.println("Esta posicion esta llena");
    }
       
   
          } //fin del else del for
}//fin del boton registrar
}
public void btnSesionActionPerformed(ActionEvent event){ 
   try{    
    this.cargarArchivo();
   nombArchivo = txtUsuario.getText();
   this.sesion();
   horaEntrada = new Date();
    Documentos.leerArchivo();
   //Reporte.reportSesion();
    }catch(Exception e){
   
   }
   
   
}//fin del metodo sesion

public void cargarArchivo(){
    
     //url = new File("C:\\Users\\JosDark\\Documents\\NetBeansProjects\\inicioAgenda\\src\\Archivos\\Usuarios.p2");
     url = new File("src\\Archivos\\Usuarios.p2");
  
    if(url.exists()){
        
          
     try{
     leerArchivo= new FileReader(url);
     //+txtUsuario.getText()+".p2"
    textoArchivo = new BufferedReader(leerArchivo);
    
    int casilla=0;
    String linea;
    
    while((linea=textoArchivo.readLine())!=null){
         String valores[]=linea.split("&");
        crearUs[casilla]=new crearUsuario();
        crearUs[casilla].setNombre(valores[0]);
        crearUs[casilla].setApellido(valores[1]);
        crearUs[casilla].setCorreo(valores[2]);
        crearUs[casilla].setContraseña(valores[3]);
        
        
        System.out.println(crearUs[casilla].getNombre()+" "+crearUs[casilla].getApellido()+" "+
                crearUs[casilla].getCorreo()+" "+crearUs[casilla].getContraseña());
    casilla++;
    
    }//fin de while

    }catch(IOException e){
    JOptionPane.showMessageDialog(null, "NO funcion el error es"+e.getMessage());
    }
        System.out.println("Se ha carga el Archivo correctamente");
    
    }else{
        
       JOptionPane.showMessageDialog(null,"Ese registro no existe,Debes Crear Uno");
        txtUsuario.setText("");
        passContraseña.setText("");
        
        }//fin del if adentro


}


public  void sesion(){
    
    boolean sesion=false;
    
    if((txtUsuario.getText().equals(""))&&(passContraseña.getText().equals(""))){
    
   JOptionPane.showMessageDialog(null, "Debe llenar los datos");
    
    }else{
    
        
    int i; 
  
    for (i = 0; i <crearUs.length; i++){
        if(crearUs[i]==null){
        break;
        }
         
        if ( ( (crearUs[i].getCorreo().equals(txtUsuario.getText())) 
                &&(crearUs[i].getContraseña().equals(new String(passContraseña.getPassword())))) ) {
            sesion=true;
            
             System.out.println(crearUs[i].getNombre()+" "+crearUs[i].getApellido()+" "+
                crearUs[i].getCorreo()+" "+crearUs[i].getContraseña()+"  Posicion:"+ i);
             
            txtUsuario.setText("");
            passContraseña.setText("");
            login.setVisible(false);
            
            actividad Actividades = new actividad();
            
           
        
            System.out.println("Se encontro contraseña");
           
   }
      
    }//fin de for
   if(!sesion){
    txtUsuario.setText("");
    passContraseña.setText("");
   JOptionPane.showMessageDialog(null, "El Usuario No existe");
   }
   
    }//fin del else
  
}//fin de metodo sesion

}//segun esto es fin de la clase login

