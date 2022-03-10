/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlpoo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author RAFAEL TRECEÑO RODRÍGUEZ (rafa13o - rafaeltreceno.es)
 */
public class CuentaBancaria {

    private String codigoCuentaCliente;
    private Cliente titular;
    private double saldo;
    private LocalDate fechaApertura;

    /**
     * Método constructor. Pido la entidad y la cuenta para calcular el CCC y
     * crearlo desde aquí. El titular (Cliente) se crea en el método main.
     *
     * @param entidad Número de la entidad bancaria del titular
     * @param cuenta Número de cuenta corriente del titular
     * @param titular Titular de la cuenta bancaria
     */
    public CuentaBancaria(String entidad, String cuenta, Cliente titular) {
        this.codigoCuentaCliente = crearCCC(entidad, cuenta);
        this.titular = titular;
        this.saldo = 0.0d;
        this.fechaApertura = LocalDate.now();
    }

    public String getCodigoCuentaCliente() {
        return codigoCuentaCliente;
    }

    public void setCodigoCuentaCliente(String codigoCuentaCliente) {
        this.codigoCuentaCliente = codigoCuentaCliente;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    // METODOS
    /**
     * Ingresa dinero en la cuenta bancaria
     *
     * @param cantidad Cantidad que se desea ingresar
     */
    public void ingresar(double cantidad) {
        setSaldo(this.getSaldo() + cantidad);
    }

    /**
     * Retira una determinada cantidad de dinero de la cuenta bancaria Si esa
     * cantidad es menor que el dinero que hay en la cuenta (es decir, la cuenta
     * tiene suficientes fondos para afrontar esa retirada), retira el dinero.
     * Si no, no hace nada
     *
     * @param cantidad
     * @return TRUE si ha podido hacer la retirada, FALSE en caso contrario
     */
    public boolean retirar(double cantidad) {
        if (cantidad < this.getSaldo()) {
            setSaldo(this.getSaldo() - cantidad);
            return true;
        }
        return false;
    }

    /**
     * El día 15 de cada mes, el banco ingresa unos intereses en función del
     * saldo. Comprobamos si el día de hoy es igual al día de paga y, si es así,
     * se ingresan los intereses. Sino, no hace nada.
     */
    public void incrementar() {
        int diaDePaga = 15;
        if (LocalDate.now().getDayOfMonth() == diaDePaga) {
            double intereses = (this.getSaldo()) * 0.02;
            double saldoFinal = this.getSaldo() + intereses;
            setSaldo(saldoFinal);
        }
    }

    /**
     * Calcula el Código de Cuenta de Cliente (CCC) y sus Dígitos de Control (DC)
     * cumpliendo los siguientes parámetros: 
     *      - Ambos números deben tener 10 cifras
     *      - Se hace el sumatorio multiplicando cada número por sus pesos
     *      - Se hace la división entre 11 y se recoge el resto. Ese resto 
     * luego se resta a 11 y se recoge el número. Si es 10, el DC será 1. Si es 
     * 11, será 0
     *      
     *
     * @param entidad Entidad bancaria del cliente
     * @param ccc Número de cuenta del cliente
     * @return El CCC completo del cliente
     */
    public static String crearCCC(String entidad, String ccc) {
        int digitoEntidad, digitoCCC;
        int sumatorioEntidad = 0;
        int sumatorioCCC = 0;
        int[] pesos = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6}; // Pasos por los que hay que multiplicar los números

        String entidad2 = entidad;
        String ccc2 = ccc;

        // Paso 1: Comprobar si hay 10 cifras. Sino, se agregan 0 al principio
        while (entidad2.length() < 10) {
            entidad2 = "0" + entidad2;
        }

        while (ccc.length() < 10) {
            ccc2 = "0" + ccc2;
        }

        // Paso 2: Hacer el sumatorio multiplicando por los pesos
        for (int i = 0; i < pesos.length; i++) {
            int numEntidad = entidad2.charAt(i);
            int numCCC = ccc2.charAt(i);

            sumatorioEntidad += pesos[i] * numEntidad;
            sumatorioCCC += pesos[i] * numCCC;
        }

        // Paso 3: Recoger los restos y comprobar el DC
        int restoDigitoEntidad = sumatorioEntidad % 11;
        int restoDigitoCCC = sumatorioCCC % 11;

        digitoEntidad = 11 - restoDigitoEntidad;
        digitoCCC = 11 - restoDigitoCCC;

        switch (digitoEntidad) {
            case 10:
                digitoEntidad = 1;
                break;
            case 11:
                digitoEntidad = 0;
                break;
        }

        switch (digitoCCC) {
            case 10:
                digitoCCC = 1;
                break;
            case 11:
                digitoCCC = 0;
                break;
        }

        return entidad.substring(0, 4) + "-" + entidad.substring(4, 8) + "-" + digitoEntidad + digitoCCC + "-" + ccc;
    }

    /**
     * Crea una cadena de texto con formato dd-mm-yyyy sobre la fecha de
     * apertura
     *
     * @return La fecha de apertura como cadena de texto
     */
    public String fechaAperturaCadena() {

        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String cadena = outputFormat.format(this.getFechaApertura());

        return cadena;
    }

    @Override
    public String toString() {
        return "-CCC: " + this.getCodigoCuentaCliente()
                + "\n-FECHA DE APERTURA: " + this.fechaAperturaCadena()
                + "\n-SALDO: " + this.getSaldo()
                + "\n-DATOS DEL TITULAR: " + this.getTitular();
    }

}
