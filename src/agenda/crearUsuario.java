/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author JosDark
 */
public class crearUsuario{
    
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    
    public crearUsuario(){//String nombre,String apellido,String correo,String contraseña){
this.nombre="";
this.apellido="";
this.correo="";
this.contraseña="";

}
    
    
    
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
     /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    
     /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

   /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }


    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    
    
 
}// fin de la clase usaurio
