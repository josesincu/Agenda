/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import JPaneles.Calendario;
import JPaneles.Contacto;
import JPaneles.DiasFestivo;
import JPaneles.FechaImportante;
import JPaneles.Marcadores;
import JPaneles.MesActual;
import JPaneles.NotaGeneral;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JosDark
 */
public class Documentos {
  public static  File url,link;
  FileWriter crearArchivo;
  BufferedWriter  escribArchivo;
  public static  FileReader leerArchivo;
  public static  BufferedReader leerInformacion;
    
    //Instancian los recursos necesarios llamando a los crease y creando clase objeto
    //Usamos las variables estaticas ya que queremos el mismo valor para los demas y no crear un nueve espacio o objeto
   
    public Documentos(){
        
    }
    
  public void crearDocumento(){
     
      url = new File("src\\Contenidos\\"+Login.nombArchivo+".p2");
  try{
     crearArchivo = new FileWriter(url);
     escribArchivo = new BufferedWriter(crearArchivo);
     
      //escribiendo los archivos de actividad numeros importantes Contacto
   escribArchivo.write("&"+actividad.taBombero.getText()+","+actividad.taDentista.getText()+","+actividad.taEscuela.getText()+","+
           actividad.taHospital.getText()+","+actividad.taPolicia.getText()+","+actividad.taPsicologo.getText());
   escribArchivo.newLine();
   
  
//Escribiendo los archivos calendario es un JTable
// *************************************************

  for (int i = 0 ; i < Calendario.calenDatos.getRowCount(); i++) //realiza un barrido por filas.
            {
                escribArchivo.write("$");
                for(int j = 0 ; j < Calendario.calenDatos.getColumnCount();j++) //realiza un barrido por columnas.
                {
                    escribArchivo.write((String)(Calendario.calenDatos.getValueAt(i,j)));
                    if (j < Calendario.calenDatos.getColumnCount() -1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        escribArchivo.write(",");
                    }
                }
                escribArchivo.newLine(); //inserta nueva linea.
  }//fin de linea for
 


//****************************************************
 //Escribiendo los archivos de  Contacnto es JTable
 
  for (int i = 0 ; i < Contacto.Tabla.getRowCount(); i++) //realiza un barrido por filas.
            {
              escribArchivo.write(":");
                for(int j = 0 ; j < Contacto.Tabla.getColumnCount();j++) //realiza un barrido por columnas.
                {
                    escribArchivo.write((String)(Contacto.Tabla.getValueAt(i,j)));
                    if (j < Contacto.Tabla.getColumnCount() -1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        escribArchivo.write(",");
                    }
                }
                escribArchivo.newLine(); //inserta nueva linea.
  }//fin de linea for
 
 
 //Escribiendo los archivos de DiasFestivo  es un JTable
 //*****************************************************
 for (int i = 0 ; i < DiasFestivo.Tabla.getRowCount(); i++) //realiza un barrido por filas.
            {
               escribArchivo.write("|");
                for(int j = 0 ; j < DiasFestivo.Tabla.getColumnCount();j++) //realiza un barrido por columnas.
                {
                    escribArchivo.write((String)(DiasFestivo.Tabla.getValueAt(i,j)));
                    if (j < DiasFestivo.Tabla.getColumnCount() -1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        escribArchivo.write(",");
                    }
                }
                escribArchivo.newLine(); //inserta nueva linea.
  }//fin de linea for
 
 //Escribiendo los archvio de Fecha Importante  es JTexArea
 
  escribArchivo.write("!"+FechaImportante.enero.getText()+","+FechaImportante.febrero.getText()+","+FechaImportante.marzo.getText()+
          ","+FechaImportante.abril.getText()+","+FechaImportante.mayo.getText()+","+FechaImportante.junio.getText()+","+
          FechaImportante.julio.getText()+","+FechaImportante.agosto.getText()+","+FechaImportante.septiembre.getText()+","+
          FechaImportante.octubre.getText()+","+FechaImportante.noviembre.getText()+","+FechaImportante.diciembre.getText());
  escribArchivo.newLine();
  
  //Escribiendo las actividades de listas Mese es no se sabe aun//no existe el formato
  
  //Escribiend los archivos de las actividades de Marcadores es un JTable
 //*****************************************************
 for (int i = 0 ; i < Marcadores.Tabla.getRowCount(); i++) //realiza un barrido por filas.
            {
                escribArchivo.write("-");
                for(int j = 0 ; j < Marcadores.Tabla.getColumnCount();j++) //realiza un barrido por columnas.
                {
                    escribArchivo.write((String)(Marcadores.Tabla.getValueAt(i,j)));
                    if (j < Marcadores.Tabla.getColumnCount() -1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        escribArchivo.write(",");
                    }
                }
                escribArchivo.newLine(); //inserta nueva linea.
  }//fin de linea for
  
  
  //Escribeindo los archivos de las Actividades de MesActual es un JTextArea
  escribArchivo.write("#"+MesActual.nota1.getText()+","+MesActual.nota2.getText()+","+MesActual.nota3.getText()+","+
          MesActual.nota4.getText()+","+MesActual.mesNotas.getText());
  escribArchivo.newLine();
  
//Escribiendo los Archivos de las actividades de 
  escribArchivo.write("%"+NotaGeneral.notaGeneral.getText());
  escribArchivo.newLine();
  
  escribArchivo.close();
  crearArchivo.close();
  
  }catch(IOException e){
      
  JOptionPane.showMessageDialog(null, "El error se encuentra en " +e);
  
  }
  
  
  
  }//fin de metodo crearDocumento
  
    /**
     * Me lee todos los archvios escritos para cada usuario
     */
 public static void leerArchivo(){
   try{
 // System.out.println("Entro en al archivo");  
  //C:\\Users\\JosDark\\Documents\\NetBeansProjects\\appMusica *todo esto antes del asterisco
  link = new File("src\\Contenidos\\"+Login.nombArchivo+".p2");
  //System.out.println("Paso el file");
  leerArchivo = new FileReader(link);
  
  leerInformacion = new BufferedReader(leerArchivo);
//System.out.println("Paso el bufeerReader");
    
    
    String linea;
    
    while((linea=leerInformacion.readLine())!=null){

        if(linea.charAt(0)=='&'){
           //linea.substring(1); //sirve para quitarle la & a la palabra esperemos que funcione
           
   //String valores[]=linea.split(","); Numeros Importantes
   String valores[]=linea.substring(1).split(",");// esta line me funciona para quitae la "&" en la palabra
   actividad.taBombero.setText(valores[0]);
   actividad.taDentista.setText(valores[1]);
   actividad.taEscuela.setText(valores[2]);
   actividad.taHospital.setText(valores[3]);
   actividad.taPolicia.setText(valores[4]);
   actividad.taPsicologo.setText(valores[5]);
      //fin de numeros importantes  
    }if(linea.charAt(0)=='$'){
              
              String Linea[]=linea.substring(1).split(",");
               Calendario.agreTabla.addRow(Linea);
               Calendario.calenDatos.setModel(Calendario.agreTabla); 
         //fin de calendario
     }if(linea.charAt(0)==':'){
         String Linea[]=linea.substring(1).split(",");
               Contacto.modelo.addRow(Linea);
               Contacto.Tabla.setModel(Contacto.modelo);
         //COntacto
         
     }if(linea.charAt(0)=='|'){
     
     String Linea[]=linea.substring(1).split(",");
               DiasFestivo.modelo.addRow(Linea);
               DiasFestivo.Tabla.setModel(DiasFestivo.modelo);
               //Dias Festivo
     }if(linea.charAt(0)=='!'){
     
     String Linea[]=linea.substring(1).split(",");
               
   FechaImportante.enero.setText(Linea[0]);
   FechaImportante.febrero.setText(Linea[1]);
   FechaImportante.marzo.setText(Linea[2]);
   FechaImportante.abril.setText(Linea[3]);
   FechaImportante.mayo.setText(Linea[4]);
   FechaImportante.junio.setText(Linea[5]);
   FechaImportante.julio.setText(Linea[6]);
   FechaImportante.agosto.setText(Linea[7]);
   FechaImportante.septiembre.setText(Linea[8]);
   FechaImportante.octubre.setText(Linea[9]);
   FechaImportante.noviembre.setText(Linea[10]);
   FechaImportante.diciembre.setText(Linea[11]);
   //fin Fecha Importante
     }if(false){
     
     
     
     //fin del lista nese
     }if(linea.charAt(0)=='-'){
     
     String Linea[]=linea.substring(1).split(",");
     Marcadores.modelo.addRow(Linea);
     Marcadores.Tabla.setModel(Marcadores.modelo);
     //fin del Marcadores
     }if(linea.charAt(0)=='#'){
         
     String Linea[]=linea.substring(1).split(",");
     //Escribeindo los archivos de las Actividades de MesActual es un JTextArea
     MesActual.nota1.append(Linea[0]);
     MesActual.nota2.setText(Linea[1]);
     MesActual.nota3.setText(Linea[2]);
     MesActual.nota4.setText(Linea[3]);
     MesActual.mesNotas.setText(Linea[4]);
    // fin de dato en mes actual
     }if(linea.charAt(0)=='%'){}
     String Linea[]=linea.substring(1).split(",");
     NotaGeneral.notaGeneral.setText(Linea[0]);
         
    }//fin de while
  System.out.println("Se ha cargado correctamento los archivos del usuario");
  
  
  //cerrando el flujo de datos que entra
  leerInformacion.close();
  leerArchivo.close();
      
  }catch(IOException e){
  
  }
 
 }//fin del metodo cde leerArchivo
 
     
}//Fin de clase documento
