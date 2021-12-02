
package agenda;

import JPaneles.Calendario;
import JPaneles.Contacto;
import JPaneles.DiasFestivo;
import JPaneles.FechaImportante;
import JPaneles.ListadoMese;
import JPaneles.Marcadores;
import JPaneles.MesActual;
import JPaneles.NotaGeneral;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.util.Date;
/**
 *
 * @author JosDark
 */
//implementar actionListener
public class actividad implements ActionListener {
    /**
     * Los compontente de Cominezo de Actividade(Pricipal)
     * 
     */
    JFrame jfPrincipal;
    JPanel jpNumImportante,contenedor;
    JScrollPane scrol,scrol1,scrol2,scrol3,scrol4,scrol5;
    
    //Llamado a los componentes
    JButton btnNumImportante,btnCalendario,btnListadoMeses,btnDiaFestivo,
            btnFechaImportante,btnMesActual,btnNotaGeneral,btnContacto,btnMarcador,btnHorario,Guardar;
    JLabel lblEscuela,lblPsicologo,lblDentista,lblHospital,lblBombero,lblPolicia,lblContenedor;
public  static  JTextArea taEscuela,taPsicologo,taDentista,taHospital,taBombero,taPolicia;
public static Date fechaSalida;
    
    /**El btnGuara y btnModifar y btnEliminar
     * aggregarlo al JPanel Numeros
     */
    
    JButton btnGuardar,btnModificar,btnEliminar;
    JButton btnCerrarSesion,btnSalir;
    JButton btnInicio;
    JButton btnReporte;
    
    //Importando y refenciando los paneles a cambiar
     Calendario calendario ;
     DiasFestivo diasFestivo;
     ListadoMese listado;
     FechaImportante fechaImportante;
     MesActual  mesActual;
     NotaGeneral notaGeneral;
     Contacto contacto;
     Marcadores marcador;
     Documentos doc;
     
     
    
    public actividad(){
       
//Inicializando todos los componentes y los metodos llamados desde la otra clase  
    jfPrincipal = new JFrame("***ACTIVIADES***");
    jpNumImportante = new JPanel();
    contenedor = new JPanel();
    
    //Instanciado los paneles a cambias****************************+
    calendario = new Calendario();
    diasFestivo = new DiasFestivo();
    listado = new ListadoMese();
    fechaImportante = new FechaImportante();
    mesActual=new MesActual();
    notaGeneral = new NotaGeneral();
    contacto = new Contacto();
    marcador = new Marcadores();
    doc = new Documentos();
     
    btnNumImportante=new JButton("Numero Importante");
    btnCalendario=new JButton("Calendario");
    btnListadoMeses= new JButton("Lista de Meses");
    btnDiaFestivo= new JButton("Dias Festivos");
    btnFechaImportante= new JButton("Fecha Importante");
    btnMesActual = new JButton("Mes Actual");
    btnNotaGeneral=new JButton("Nota General");
    btnContacto=new JButton("Contacto");
    btnMarcador= new JButton("Marcador");
    btnHorario= new JButton("Horario");
    
    btnCerrarSesion= new JButton("Cerrar Sesion");
    btnSalir=new JButton("Salir");
    
    btnGuardar= new JButton("Guardar");
    btnModificar = new JButton("Moficar");
    btnEliminar = new JButton("Eliminar");
    
    Guardar = new JButton("Guardar");
    btnReporte= new JButton("Generar Reporte");
    
    
    //configurando los Layouts de JPanel y JFrame
    jfPrincipal.setLayout(null);
    jpNumImportante.setLayout(null);
    contenedor.setLayout(null);
   
    
    
    //agragando eventos en botones
    btnNumImportante.addActionListener(this);
    btnCalendario.addActionListener(this);
    btnListadoMeses.addActionListener(this);
    btnDiaFestivo.addActionListener(this);
    btnFechaImportante.addActionListener(this);
    btnMesActual.addActionListener(this);
    btnNotaGeneral.addActionListener(this);
    btnContacto.addActionListener(this);
    btnMarcador.addActionListener(this);
    //btnHorario.addActionListener(this);
    btnCerrarSesion.addActionListener(this);
    btnSalir.addActionListener(this);
    
    btnGuardar.addActionListener(this);
    btnModificar.addActionListener(this);
    btnEliminar.addActionListener(this);
    
    Guardar.addActionListener(this);
    btnReporte.addActionListener(this);
    
    //Tamaño y posiciones de los componentes JFrame
    jfPrincipal.setSize(950, 700);
    
     
    //inicia componentes de JPanel
    lblEscuela= new JLabel("Escuela");
    lblPsicologo=new JLabel("Psicologo");
    lblDentista=new JLabel("Dentista");
    lblHospital= new JLabel("Hospital");
    lblBombero=new JLabel("Bombero");
    lblPolicia= new JLabel("Policia");
    
    Icon icoContenedor = new ImageIcon("src\\Imagen\\Label.png");
    lblContenedor= new JLabel(icoContenedor);
    lblContenedor.reshape(0,0,752,655);
    lblContenedor.setBorder(BorderFactory.createLineBorder(Color.black));
    
    taEscuela= new JTextArea(5,1);
    taPsicologo=new JTextArea(5,1);
    taDentista = new JTextArea(5,1);
    taHospital= new JTextArea(5,1);
    taBombero= new JTextArea(5,1);
    taPolicia= new JTextArea(5,1);
    
    
    scrol= new JScrollPane(taEscuela);
    scrol1= new JScrollPane(taPsicologo);
    scrol2= new JScrollPane(taDentista);
    scrol3= new JScrollPane(taHospital);
    scrol4= new JScrollPane(taBombero);
    scrol5= new JScrollPane(taPolicia);
   
    
    //confifuracionde  las posicones de los componentes de JPanel y JPanel
    contenedor.reshape(181, 10, 752, 655);
    jpNumImportante.reshape(0, 0,752, 655);//en esta posicion del primer panel su posicion en x y y es 0
    jpNumImportante.setBorder(BorderFactory.createLineBorder(Color.black));
    contenedor.setBorder(BorderFactory.createLineBorder(Color.black));
    
    btnNumImportante.reshape(10, 10, 160, 30);
    btnCalendario.reshape(10, 50, 160, 30);
    btnListadoMeses.reshape(10,90 , 160, 30);
    btnDiaFestivo.reshape(10, 130, 160, 30);
    btnFechaImportante.reshape(10, 170, 160, 30);
    btnMesActual.reshape(10, 210, 160, 30);
    btnNotaGeneral.reshape(10, 250, 160, 30);
    btnContacto.reshape(10, 290, 160, 30);
    btnMarcador.reshape(10, 330, 160, 30);
    btnHorario.reshape(10, 370, 160, 30);
    
    Guardar.reshape(10,410,160,30);
    btnReporte.reshape(10,450,160,30);
    btnCerrarSesion.reshape(10, 490, 160, 30);
    btnSalir.reshape(10, 530, 160, 30);
    
    btnGuardar.reshape(571, 213, 130, 40);
    btnModificar.reshape(571, 273, 130, 40);
    btnEliminar.reshape(571,333,130,40);
    
    lblEscuela.reshape(10, 10, 100, 30);//sin no es asi 150 entonces es 10 porque esta en el panel
    taEscuela.reshape(10, 53, 261, 150);
    scrol.reshape(10, 53, 261, 150);
    
    lblPsicologo.reshape(281,10,100,30);
    taPsicologo.reshape(281,53 , 261, 150);
    scrol1.reshape(281,53 , 261, 150);
    
    lblDentista.reshape(10,213,100,50);//la primera x no camnia
    taDentista.reshape(10,273,261,150);
    scrol2.reshape(10,273,261,150);
    
    lblHospital.reshape(281,213,100,50);
    taHospital.reshape(281,273,261,150);
    scrol3.reshape(281,273,261,150);
    
    lblBombero.reshape(10,433,100,50);//la primera x no cambia
    taBombero.reshape(10, 493, 261, 150);
    scrol4.reshape(10, 493, 261, 150);
    
    lblPolicia.reshape(281,433,100,50);
    taPolicia.reshape(281,493,261,150);
    scrol5.reshape(281,493,261,150);
    
    
    //Agregando los componentes en JPanel
   jpNumImportante.setBackground(Color.cyan);
    
   jpNumImportante.add(lblEscuela);
   jpNumImportante.add(scrol);
   
   jpNumImportante.add(lblPsicologo);
   jpNumImportante.add(scrol1);
   
   jpNumImportante.add(lblDentista);
   jpNumImportante.add(scrol2);
   
   jpNumImportante.add(lblHospital);
   jpNumImportante.add(scrol3);
   
   jpNumImportante.add(lblBombero);
   jpNumImportante.add(scrol4);
   
   jpNumImportante.add(lblPolicia);
   jpNumImportante.add(scrol5);
   
   jpNumImportante.add(btnGuardar);
   jpNumImportante.add(btnModificar);
   jpNumImportante.add(btnEliminar);
   
    
    contenedor.add(lblContenedor);
    //agregando los componentes a jFrame
    jfPrincipal.add(btnNumImportante);
    jfPrincipal.add(btnCalendario);
    jfPrincipal.add(btnListadoMeses);
    jfPrincipal.add(btnDiaFestivo);
    jfPrincipal.add(btnFechaImportante);
    jfPrincipal.add(btnMesActual);
    jfPrincipal.add(btnNotaGeneral);
    jfPrincipal.add(btnContacto);
    jfPrincipal.add(btnMarcador); 
    jfPrincipal.add(btnHorario);
    jfPrincipal.add(btnCerrarSesion);
    jfPrincipal.add(btnSalir);
    jfPrincipal.add(Guardar);
    jfPrincipal.add(btnReporte);
    //Agregando los paneles a cambiar en JFrame
    //jfPrincipal.add(jpNumImportante);
    jfPrincipal.add(contenedor);
    
    //configruracion final del componente JFrame
    jfPrincipal.setLocationRelativeTo(null);
    jfPrincipal.setResizable(false);
    jfPrincipal.setVisible(true);
    jfPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
   
    
    }//fin de constructor
   
   public void actionPerformed(ActionEvent e){
   
   if(e.getSource()==btnCalendario){
    
//    jfPrincipal.add(act);
//    act.setVisible(true);
//    jpNumImportante.setVisible(false);
        contenedor.removeAll();
        contenedor.add(calendario);
        //calendario.setVisible(true);
        contenedor.revalidate();
        contenedor.repaint();

   
   }
   if(e.getSource()==btnNumImportante){
//       jpNumImportante.setVisible(true);
//       jfPrincipal.add(act);
//       act.setVisible(false);

        contenedor.removeAll();
        contenedor.add(jpNumImportante);
        //jpNumImportante.setVisible(true);
        contenedor.revalidate();
        contenedor.repaint();
   }
   if(e.getSource()==btnDiaFestivo){
//       jfPrincipal.add(diasFestivo);
//       diasFestivo.setVisible(true);
//       jpNumImportante.setVisible(false);
//          
        contenedor.removeAll();
        contenedor.add(diasFestivo);
        //diasFestivo.setVisible(true);
        contenedor.revalidate();
        contenedor.repaint();
   }if(e.getSource()==btnFechaImportante){
        contenedor.removeAll();
        contenedor.add(fechaImportante);
        //diasFestivo.setVisible(true);
        contenedor.revalidate();
        contenedor.repaint();
   }if(e.getSource()==btnMesActual){
        contenedor.removeAll();
        contenedor.add(mesActual);
        //diasFestivo.setVisible(true);
        contenedor.revalidate();
        contenedor.repaint();
    }if(e.getSource()==btnNotaGeneral){
        contenedor.removeAll();
        contenedor.add(notaGeneral);
        //diasFestivo.setVisible(true);
        contenedor.revalidate();
        contenedor.repaint();
    
    }if(e.getSource()==btnContacto){
        contenedor.removeAll();
        contenedor.add(contacto);
        //diasFestivo.setVisible(true);
        contenedor.revalidate();
        contenedor.repaint();
    
    }if(e.getSource()==btnMarcador){
        contenedor.removeAll();
        contenedor.add(marcador);
        //diasFestivo.setVisible(true);
        contenedor.revalidate();
        contenedor.repaint();
    
    
    }if(e.getSource()==btnHorario){
    //LIsta mes
//    btnHorario.reshape(10, 555, 160, 50);
    }if(e.getSource()==btnCerrarSesion){
      //Fecha Salida
    
   // Reporte.reportSesion();
    
    jfPrincipal.setVisible(false);
    Login log = new Login();
        
    }if(e.getSource()==btnSalir){
   
        System.exit(0);
    
    }if(e.getSource()==Guardar){
        doc.crearDocumento();
        
    }if(e.getSource()==btnReporte){
     
     fechaSalida= new Date();    
     Reporte.obtenerInformacion();
     jfPrincipal.setVisible(false);
     Reporte rep = new Reporte();
     Reporte.cargarArchivo();
     //cuando instancio al objeto se carga perfecrtmamente
     //cuando colo rep.cargarArchivo funciona perfectamente
    }

 
   
   }//fin de boton evento

   
   /**
    * metodo para Guardar los datos en el panel
    */
   public void Guardar(){
    try{   
   FileWriter enviar = new FileWriter("Agenda\\Contenidos");
    
   //Idea uno hacer un metodo para cada archivo y guardar con el nombre del usuario y llamar a los metodos
   //construir para cada clase un archivo
    
   // ************************************
    //btnGuardar Archivo
    //
    //
    
    
    }catch(IOException e){}
   }
   
   /**
    * Muestra los datos guardados
    */
   public void Mostrar(){
   
   
   }
   /**
    * Elimina todo el coontenido de los textArea
    */
   public void Eliminar(){
   
   
   }
   
   
    
    
    
}//fin de clase
