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
public class Select {

    private String rutaArchivo;
    private ArrayList<Condicion> condicones;
    private ArrayList<Columna> columnas;
    private String tipo;

    public Select() {
    }

    public Select(String rutaArchivo, ArrayList<Condicion> condicones, ArrayList<Columna> columnas) {
        this.rutaArchivo = rutaArchivo;
        this.condicones = condicones;
        this.columnas = columnas;
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

    /**
     * @return the columnas
     */
    public ArrayList<Columna> getColumnas() {
        return columnas;
    }

    /**
     * @param columnas the columnas to set
     */
    public void setColumnas(ArrayList<Columna> columnas) {
        this.columnas = columnas;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
