/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisbaquiax.emuladordb.parser;

/**
 *
 * @author Luis
 */
public class ErrorSintactico {

    private String lexema;
    private int row;
    private int col;
    private String descripcion;

    /**
     *
     * @param lexema
     * @param row
     * @param col
     * @param descripcion
     */
    public ErrorSintactico(String lexema, int row, int col, String descripcion) {
        this.lexema = lexema;
        this.row = row;
        this.col = col;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Error: Lexema:" + lexema
                + " Linea: " + row
                + " Columna: " + col
                + " Descripcion: " + descripcion + "\n";
    }

    /**
     * @return the lexema
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * @param lexema the lexema to set
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * @return the descripcion
     */
    public String getDescription() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
