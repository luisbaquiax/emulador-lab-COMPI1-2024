/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisbaquiax.emuladordb.parser;

import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class Delete {

    private String rutaArchivo;
    private ArrayList<Condicion> condicones;

    /**
     *
     * @param rutaArchivo
     * @param condicones
     */
    public Delete(String rutaArchivo, ArrayList<Condicion> condicones) {
        this.rutaArchivo = rutaArchivo;
        this.condicones = condicones;
    }

    public Delete() {
    }

    /**
     * @return the rutaArchivo
     */
    public String getRutaArchivo() {
        return rutaArchivo;
    }

    /**
     * @param rutaArchivo the rutaArchivo to set
     */
    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * @return the condicones
     */
    public ArrayList<Condicion> getCondicones() {
        return condicones;
    }

    /**
     * @param condicones the condicones to set
     */
    public void setCondicones(ArrayList<Condicion> condicones) {
        this.condicones = condicones;
    }

}
