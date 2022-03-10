/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlpoo;

/**
 *
 * @author RAFAEL TRECEÑO RODRÍGUEZ (rafa13o - rafaeltreceno.es)
 */
public class Cliente {
    private int codCliente;
    private String DNI;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;

    public Cliente(int codCliente, String DNI, String nombre, String apellidos, String direccion, String telefono) {
        this.codCliente = codCliente;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
}
