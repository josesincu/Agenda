/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import JPaneles.Contacto;

import static JPaneles.Contacto.GetData;
//import static JPaneles.DiasFestivo.GetData;

import JPaneles.DiasFestivo;
import JPaneles.Marcadores;
import JPaneles.MesActual;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static agenda.Login.nombArchivo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 *
 * @author JosDark
 */
public class Reporte implements ActionListener{
 JFrame jfReporte;
 JButton btnReportA,btnReportMs,btnReportC,btnReportF,btnReportM,btnRegresar;
 public static JTextArea areaReporte;
 JScrollPane scrollArea;
 
public Reporte(){
//Configurando los componentes del JFrame
jfReporte = new JFrame("Reporte");
//Confiurando los componetes de jFrame
jfReporte.setLayout(null);
jfReporte.setSize(650, 600);

btnReportA = new JButton("Reporte Agenda");
btnReportMs = new JButton("Reporte Mes");
btnReportC = new JButton("Reporte Contacto");
btnReportF = new JButton("Reporte Festivos");
btnReportM = new JButton("Reporte Marcadores");
btnRegresar= new JButton("Regresar");
areaReporte = new JTextArea(5,5);
scrollArea = new JScrollPane(areaReporte);

//Agregando eventos en los botones
btnReportA.addActionListener(this);
btnReportMs.addActionListener(this);
btnReportC.addActionListener(this);
btnReportF.addActionListener(this);
btnReportM.addActionListener(this);
btnRegresar.addActionListener(this);

//Configurando la posicion de los componenrtes
areaReporte.reshape(0,0,440,550);
scrollArea.reshape(180,10,440,550);


btnReportA.reshape(10, 10, 160, 30);
btnReportMs.reshape(10, 50, 160, 30);
btnReportC.reshape(10,90 , 160, 30);
btnReportF.reshape(10, 130, 160, 30);
btnReportM.reshape(10, 170, 160, 30);
btnRegresar.reshape(10, 210, 160, 30);

//Agregando los componentes a JFrame
jfReporte.add(btnReportA);
jfReporte.add(btnReportMs);
jfReporte.add(btnReportC);
jfReporte.add(btnReportF);
jfReporte.add(btnReportM);
jfReporte.add(btnRegresar);
jfReporte.add(scrollArea);


jfReporte.setResizable(false);
jfReporte.setLocationRelativeTo(null);
jfReporte.setVisible(true);
jfReporte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
 
 public static void obtenerInformacion(){
 try{
 File url = new File("src\\Reporte\\Report.p2");
 /**
  * Obtiene la direccion del archivo para enviarla
  */
 
 FileWriter escribir = new FileWriter(url,true);
 
 /**
  * Sirve para escribir los datos en el archivo
  */
     BufferedWriter tecInfor = new BufferedWriter(escribir);
     tecInfor.write("******************************************************");
     tecInfor.newLine();
     tecInfor.write("Usuario: " +Login.nombArchivo);
     tecInfor.newLine();
     tecInfor.write("Hora Inicio: "+Login.horaEntrada);
     tecInfor.newLine();
     tecInfor.write("Hora Salida: "+actividad.fechaSalida);
     tecInfor.newLine();
     tecInfor.write("*****************************************************");
     tecInfor.newLine();
     
     tecInfor.close();
     escribir.close();
     
 }catch(IOException e){
 
     System.out.println("No se puede imprimir");}
 
 
 }
 public static void cargarArchivo(){
 try {
            File linkCarpeta = new File("src\\Reporte\\Report.p2");
           FileReader verLink = new FileReader(linkCarpeta);
            BufferedReader leerDatos = new BufferedReader(verLink);
           
            String Linea=leerDatos.readLine();
            
            while(Linea!=null){
               
              areaReporte.append(Linea+"\n");
//Apanead sirve para lleer los datos que el usaurio crea en un archivo de txt o cualquier extensio
//en cambio set tet no funciona asi
            Linea=leerDatos.readLine();
           
             
                }
 
 }catch(IOException e){}
 }
 
public  void reportSesion() throws FileNotFoundException, IOException, DocumentException{
    Font fontContenido = FontFactory.getFont(FontFactory.TIMES_ROMAN.toString(), 11, Font.NORMAL, BaseColor.DARK_GRAY);
    Font fontTitulos = FontFactory.getFont(FontFactory.COURIER, 35, Font.UNDERLINE, BaseColor.RED);
    try{
     // Document document = new Document();
 FileOutputStream link = new FileOutputStream("src\\Reporte\\Reporte_sesion.pdf"); 
                // Document document = new Document();
                Document document = new Document(PageSize.A4, 35, 30, 50, 50);
                PdfWriter.getInstance(document, link);
                
                
                document.open();
                
                Paragraph titulo = new Paragraph();
                titulo.add(new Phrase("Registro de Sesiones",fontTitulos));
                titulo.add(new Phrase(Chunk.NEWLINE));
                titulo.add(new Phrase(Chunk.NEWLINE));
                document.add(titulo);
               
                document.addAuthor("Jose Castro");
                
                String sesiones = areaReporte.getText();
                document.addTitle("Inision de sesion");
                
             document.add(new Paragraph(sesiones));
                JOptionPane.showMessageDialog(null,"Se Ha Creado Perfectamente el Reporte" );
               document.close();
               link.close();
           
    }catch(IOException e){}
    

        } 
    

//fin de reporte 

                @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btnRegresar){
         
          Documentos.leerArchivo();
           jfReporte.setVisible(false);
           //actividad act = new actividad();
           Login log = new Login();
      } if(e.getSource()==btnReportA){
          try {
              System.out.println("Estoy aqui en reportSesion");
              this.reportSesion();
              
          }catch (IOException |DocumentException ex) {
              Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
          }
          //fin del metodo if
          
          //fin del metodo if
      }if(e.getSource()==btnReportMs){
       this.actMes();
      //fin del boton
      }if(e.getSource()==btnReportC){
      this.repoortContactos();
      
      }if(e.getSource()==btnReportF){
      this.reporFestivos();
      
      }if(e.getSource()==btnReportM){
      this.reportMarcadores();
      }
      
        
    }//fin del metodo de eventos
    
    public void actMes(){
     Font fontContenido = FontFactory.getFont(FontFactory.TIMES_ROMAN.toString(), 11, Font.NORMAL, BaseColor.DARK_GRAY);
    Font fontTitulos = FontFactory.getFont(FontFactory.COURIER, 25, Font.UNDERLINE, BaseColor.CYAN);
    try{
     // Document document = new Document();
 FileOutputStream direccion = new FileOutputStream("src\\Reporte\\ActividadPorMes"+Login.nombArchivo+".pdf"); 
                // Document document = new Document();
                Document document = new Document(PageSize.A4, 35, 30, 50, 50);
                PdfWriter.getInstance(document,direccion);
                
                
                document.open();
                
                Paragraph titulo = new Paragraph();
                titulo.add(new Phrase("Historial De ACtividades Por Mes",fontTitulos));
                titulo.add(new Phrase(Chunk.NEWLINE));
                titulo.add(new Phrase(Chunk.NEWLINE));
                document.add(titulo);
               
                Paragraph semana1 = new Paragraph();
                semana1.add(new Phrase("*"+MesActual.nota1.getText(),fontContenido));
                semana1.add(new Phrase(Chunk.NEWLINE));
                semana1.add(new Phrase(Chunk.NEWLINE));
                document.add(semana1);
                
                Paragraph semana2 = new Paragraph();
                semana2.add(new Phrase("*"+MesActual.nota2.getText(),fontContenido));
                semana2.add(new Phrase(Chunk.NEWLINE));
                semana2.add(new Phrase(Chunk.NEWLINE));
                document.add(semana2);
                
                Paragraph semana3 = new Paragraph();
                semana3.add(new Phrase("*"+MesActual.nota3.getText(),fontContenido));
                semana3.add(new Phrase(Chunk.NEWLINE));
                semana3.add(new Phrase(Chunk.NEWLINE));
                document.add(semana3);
                
                Paragraph semana4 = new Paragraph();
                semana4.add(new Phrase("*"+MesActual.nota4.getText(),fontContenido));
                semana4.add(new Phrase(Chunk.NEWLINE));
                semana4.add(new Phrase(Chunk.NEWLINE));
                document.add(semana4);
                
                Paragraph mes = new Paragraph();
                mes.add(new Phrase("*"+MesActual.mesNotas.getText(),fontContenido));
                mes.add(new Phrase(Chunk.NEWLINE));
                mes.add(new Phrase(Chunk.NEWLINE));
                document.add(mes);
               
                JOptionPane.showMessageDialog(null,"Se Ha Creado Perfectamente el Reporte" );
               document.close();
               direccion.close();
           
    }catch(IOException |DocumentException e){}
   
    }//Fin del reporte Historial del mes
    
    
    public void repoortContactos(){
        
    Font fontContenido = FontFactory.getFont(FontFactory.TIMES_ROMAN.toString(), 11, Font.NORMAL, BaseColor.DARK_GRAY);
    Font fontTitulos = FontFactory.getFont(FontFactory.COURIER, 25, Font.UNDERLINE, BaseColor.BLUE);
        
        
         try{
             FileOutputStream url2 = new FileOutputStream("src\\Reporte\\Contactos"+Login.nombArchivo+".pdf");
             
            
   int count=Contacto.Tabla.getRowCount();
   //Inicializand el documento de pdf
   Document document=new Document();
         PdfWriter.getInstance(document,url2);
          
    document.open();
    Paragraph titulo = new Paragraph();
    titulo.add(new Phrase("Historial De Contacntos",fontTitulos));
    titulo.add(new Phrase(Chunk.NEWLINE));
    titulo.add(new Phrase(Chunk.NEWLINE));
    titulo.add(new Phrase(Chunk.NEWLINE));
    titulo.add(new Phrase(Chunk.NEWLINE));
    document.add(titulo);     
         
         
    PdfPTable tab=new PdfPTable(3);//Fijar bien cuantas columnas tien
          
    tab.addCell("Nombre");
    tab.addCell("Numero");
    tab.addCell("Direccion");//Aqui empezo
          
   for(int i=0;i<count;i++){
   Object obj1 = GetData(Contacto.Tabla, i, 0);//modificar
   Object obj2 = GetData(Contacto.Tabla, i, 1);//modificar
   Object obj3 = GetData(Contacto.Tabla, i, 2);
   
   
   String value1=obj1.toString();
   String value2=obj2.toString();
   String value3=obj3.toString();//aqui empexo el camio
   
   tab.addCell(value1);
   tab.addCell(value2);
   tab.addCell(value3);
   
    
   }
   
   JOptionPane.showMessageDialog(null, "Creado Correctamente");
   document.add(tab);
   document.close();
       }
       catch(Exception e){
           System.out.println("ERROR");
       }

         
    
    }//fin de reporte contacto
    
    /**
     * Reportes de dias fertivos
     */
    public void reporFestivos(){
        
     Font fontContenido = FontFactory.getFont(FontFactory.TIMES_ROMAN.toString(), 11, Font.NORMAL, BaseColor.DARK_GRAY);
    Font fontTitulos = FontFactory.getFont(FontFactory.COURIER, 25, Font.UNDERLINE, BaseColor.GREEN);
        
        
         try{
             //FileOutputStream url2 = new FileOutputStream("C:\\Users\\JosDark\\Documents\\NetBeansProjects"
               //     + "\\inicioAgenda\\DiasFestivo"+Login.nombArchivo+".pdf");
             
             FileOutputStream url2 = new FileOutputStream("src\\Reporte\\DiasFestivo"+Login.nombArchivo+".pdf");
             
            
   int count=DiasFestivo.Tabla.getRowCount();
   //Inicializand el documento de pdf
   Document document=new Document();
         PdfWriter.getInstance(document,url2);
          
    document.open();
    Paragraph titulo = new Paragraph();
    titulo.add(new Phrase("Historial De Dias Festivos",fontTitulos));
    titulo.add(new Phrase(Chunk.NEWLINE));
    titulo.add(new Phrase(Chunk.NEWLINE));
    titulo.add(new Phrase(Chunk.NEWLINE));
    titulo.add(new Phrase(Chunk.NEWLINE));
    document.add(titulo);     
         
         
    PdfPTable tab=new PdfPTable(3);//Fijar bien cuantas columnas tien
          
    tab.addCell("Asueto");
    tab.addCell("Dia");
    tab.addCell("Fecha");//Aqui empezo
          
   for(int i=0;i<count;i++){
   Object obj1 = GetData(DiasFestivo.Tabla, i, 0);//modificar
   Object obj2 = GetData(DiasFestivo.Tabla, i, 1);//modificar
   Object obj3 = GetData(DiasFestivo.Tabla, i, 2);
   
   
   String value1=obj1.toString();
   String value2=obj2.toString();
   String value3=obj3.toString();//aqui empexo el camio
   
   tab.addCell(value1);
   tab.addCell(value2);
   tab.addCell(value3);
   }
   
   JOptionPane.showMessageDialog(null, "Creado Correctamente");
   document.add(tab);
   document.close();
       }
       catch(Exception e){
           System.out.println("ERROR");
       }
    
    }//fin de boton reporte Marcadores
    
    public void reportMarcadores(){
    
      Font fontContenido = FontFactory.getFont(FontFactory.TIMES_ROMAN.toString(), 11, Font.NORMAL, BaseColor.DARK_GRAY);
    Font fontTitulos = FontFactory.getFont(FontFactory.COURIER, 25, Font.UNDERLINE, BaseColor.YELLOW);
        
        
         try{
            // FileOutputStream url2 = new FileOutputStream("C:\\Users\\JosDark\\Documents\\NetBeansProjects"
             //       + "\\inicioAgenda\\Marcadores"+Login.nombArchivo+".pdf");
             
             FileOutputStream url2 = new FileOutputStream("src\\Reporte\\Marcadores"+Login.nombArchivo+".pdf");
             
            
   int count=Marcadores.Tabla.getRowCount();
   //Inicializand el documento de pdf
   Document document=new Document();
         PdfWriter.getInstance(document,url2);
          
    document.open();
    Paragraph titulo = new Paragraph();
    titulo.add(new Phrase("Historial De Marcadores",fontTitulos));
    titulo.add(new Phrase(Chunk.NEWLINE));
    titulo.add(new Phrase(Chunk.NEWLINE));
    titulo.add(new Phrase(Chunk.NEWLINE));
    titulo.add(new Phrase(Chunk.NEWLINE));
    document.add(titulo);     
         
         
    PdfPTable tab=new PdfPTable(2);//Fijar bien cuantas columnas tien
          
    tab.addCell("Links");
    tab.addCell("Correo");
   // tab.addCell("Fecha");//Aqui empezo
          
   for(int i=0;i<count;i++){
   Object obj1 = GetData(Marcadores.Tabla, i, 0);//modificar
   Object obj2 = GetData(Marcadores.Tabla, i, 1);//modificar
  // Object obj3 = GetData(DiasFestivo.Tabla, i, 2);
   
   
   String value1=obj1.toString();
   String value2=obj2.toString();
  // String value3=obj3.toString();//aqui empexo el camio
   
   tab.addCell(value1);
   tab.addCell(value2);
   //tab.addCell(value3);
   }
   
   JOptionPane.showMessageDialog(null, "Creado Correctamente");
   document.add(tab);
   document.close();
       }
       catch(Exception e){
           System.out.println("ERROR");
       }
    
    
    
    }//
    
    
        
}//fin de la clase reporte
